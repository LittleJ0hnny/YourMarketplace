package com.littlejohnny.auth.domain.model;

public enum Resources {
    IMAGE_SERVICE("image-service"),
    GATEWAY_SERVICE("gateway");

    private String value;

    Resources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
