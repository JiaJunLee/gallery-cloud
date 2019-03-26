package com.oocl.ita.gallery.auth.center;

import com.oocl.ita.gallery.auth.center.feign.RoleServiceClient;
import com.oocl.ita.gallery.auth.center.feign.UserServiceClient;
import com.oocl.ita.gallery.common.model.Role;
import com.oocl.ita.gallery.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GalleryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceClient userService;

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
            authorities.add(new SimpleGrantedAuthority(roleName));
        }
        return new org.springframework.security.core.userdetails.User(securityUser.getUsername(), securityUser.getPassword(), securityUser.isEnabled(), securityUser.isAccountNonExpired(), securityUser.isCredentialsNonExpired(), securityUser.isAccountNonLocked(), authorities);
    }
}