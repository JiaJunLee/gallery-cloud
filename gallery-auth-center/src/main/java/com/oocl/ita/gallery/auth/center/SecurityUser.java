package com.oocl.ita.gallery.auth.center;

import com.oocl.ita.gallery.common.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

public class SecurityUser extends User implements UserDetails {

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(4);

    public SecurityUser(User user){
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setRealName(user.getRealName());
        this.setType(user.getType());
        this.setRoles(user.getRoles());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
