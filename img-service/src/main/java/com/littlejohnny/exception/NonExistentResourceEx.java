package com.littlejohnny.exception;

public class NonExistentResourceEx extends RuntimeException {
    public NonExistentResourceEx() {
    }

    public NonExistentResourceEx(String message) {
        super(message);
    }

    public NonExistentResourceEx(Throwable cause) {
        super(cause);
    }
}
