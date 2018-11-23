package com.littlejohnny.auth.domain.model.entity;

public enum Authorities {
    ADMIN(1L),
    USER(2L);

    private Long id;

    Authorities(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
