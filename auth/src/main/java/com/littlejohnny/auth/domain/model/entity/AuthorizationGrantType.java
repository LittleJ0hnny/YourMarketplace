package com.littlejohnny.auth.domain.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "grant_types")
public class AuthorizationGrantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String grantType;

    public AuthorizationGrantType() {
    }

    public AuthorizationGrantType(String grantType) {
        this.grantType = grantType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
