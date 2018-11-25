package com.littlejohnny.auth.domain.model;

public enum Resources {
    RESOURCE("resourceId");

    private String value;

    Resources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
