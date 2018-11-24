package com.littlejohnny.auth.domain.model.entity;

public enum Authorities {
    ADMIN("ADMIN"),
    USER("USER");

    private String authority;

    Authorities(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
