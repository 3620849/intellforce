package com.example.demo.configurations;

import com.example.demo.domain.User;
import lombok.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by UA C on 05.10.2017.
 */
public class UserAuth implements Authentication {
    public final User user;
    public boolean auth = true;
    public UserAuth(@NonNull User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return user.getPassword() ;
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return auth;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        auth= isAuthenticated;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }
}
