package com.littlejohnny.auth.domain.model;

import com.littlejohnny.auth.domain.model.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserBuilder {
    private User user;

    public UserBuilder() {
        user = new User();
    }

    public UserBuilder setId(Long id) {
        user.setId(id);
        return this;
    }

    public UserBuilder setAuthorities(List<GrantedAuthority> authorities) {
        user.setAuthorities(Optional.ofNullable(authorities).orElse(Arrays.asList(Authorities.USER)));
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder setUsername(String username) {
        user.setUsername(username);
        return this;
    }

    public UserBuilder setExpired(boolean expired) {
        user.setExpired(expired);
        return this;
    }

    public UserBuilder setLocked(boolean locked) {
        user.setLocked(locked);
        return this;
    }

    public UserBuilder setCredentialsExpired(boolean credentialsExpired) {
        user.setCredentialsExpired(credentialsExpired);
        return this;
    }

    public UserBuilder setEnabled(boolean enabled) {
        user.setEnabled(enabled);
        return this;
    }

    public User build() {
        return user;
    }
}
