package com.littlejohnny.auth.domain.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Resource {
    private String resourceId;

    public Resource(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return resourceId;
    }
}
