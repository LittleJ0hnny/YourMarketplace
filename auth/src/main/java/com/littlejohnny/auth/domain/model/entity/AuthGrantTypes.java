package com.littlejohnny.auth.domain.model.entity;

public enum AuthGrantTypes {
    PASSWORD("password"),
    REFRESH_TOKEN("refresh_token");

    private String authGrantType;

    AuthGrantTypes(String authGrantType) {
        this.authGrantType = authGrantType;
    }

    public String getAuthGrantType() {
        return authGrantType;
    }
}
