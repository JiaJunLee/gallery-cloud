package com.oocl.ita.gallery.auth.center;

import com.oocl.ita.gallery.auth.center.feign.RoleServiceClient;
import com.oocl.ita.gallery.auth.center.feign.UserServiceClient;
import com.oocl.ita.gallery.common.model.Role;
import com.oocl.ita.gallery.common.model.SimplePermission;
import com.oocl.ita.gallery.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 在UserDetailService中自定义加载用户信息，并将用户角色role相关的所有Permissions设置到Authentication的authorities中以供PermissionEvaluator对用户权限进行判断。
 * 注意这里使用了resourceId-privilege的形式进行了拼接后存放。这里用户信息是存放在MongoDB数据库中的，也可以换成其他的数据库。
 */
@Service
public class GalleryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceClient userService;
    @Autowired
    private RoleServiceClient roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username).getBody();
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username: %s", username));
        }
        SecurityUser securityUser = new SecurityUser(user);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = user.getRoles();
        for (String roleName : roles) {
            Role role = roleService.findByRoleName(roleName).getBody();
            if (role == null) {
                continue;
            }
            for (SimplePermission permission : role.getPermissions()) {
                for (String privilege : permission.getPrivileges().keySet()) {
                    authorities.add(new SimpleGrantedAuthority(String.format("%s-%s", permission.getResource(), privilege)));
                }
            }
        }
        return new org.springframework.security.core.userdetails.User(securityUser.getUsername(), securityUser.getPassword(), securityUser.isEnabled(), securityUser.isAccountNonExpired(), securityUser.isCredentialsNonExpired(), securityUser.isAccountNonLocked(), authorities);
    }
}