/**
 * 
 */
package com.example.demo.configuration.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.auth.DemoUser;
import com.example.demo.enums.DemoPermission;

/**
 * @since Apr 4, 2023
 *
 */
public class DemoUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private final DemoUser user;
    private final Set<DemoPermission> permissions;

    public DemoUserDetails(DemoUser user, Set<DemoPermission> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(DemoPermission::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // more information for user if needed - default true
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isActivated();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // more information for user if needed - default true
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !user.isDeleted();
    }

}
