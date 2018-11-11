package com.littlejohnny.auth.domain.model;

import org.springframework.security.core.GrantedAuthority;

public enum Authorities implements GrantedAuthority {
    USER("USER"),
    ADMIN("ADMIN");

    private String authority;

    Authorities(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
