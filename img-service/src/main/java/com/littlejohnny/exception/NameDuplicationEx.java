package com.littlejohnny.exception;

public class NameDuplicationEx extends RuntimeException {
    public NameDuplicationEx() {
    }

    public NameDuplicationEx(String message) {
        super(message);
    }

    public NameDuplicationEx(Throwable cause) {
        super(cause);
    }
}
