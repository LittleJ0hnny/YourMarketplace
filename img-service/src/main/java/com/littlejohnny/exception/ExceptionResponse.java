package com.littlejohnny.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Optional;

public class ExceptionResponse {
    private String timestamp;
    private int status;
    private String error;
    private String message;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Exception e, HttpStatus httpStatus) {
        this.timestamp = LocalDateTime.now().toString();
        this.status = httpStatus.value();
        this.error = httpStatus.name();
        this.message = Optional.of(e.getMessage()).orElse(e.getClass().getSimpleName());
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
