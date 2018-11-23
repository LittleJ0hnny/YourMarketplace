package com.littlejohnny.auth.domain.model.entity;

public enum AuthGrantTypes {
    PASSWORD(1L),
    REFRESH_TOKEN(2L);

    private Long id;

    AuthGrantTypes(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
