package com.littlejohnny.auth.domain.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthGrantType {
    private String grantType;

    public AuthGrantType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString() {
        return grantType;
    }
}
