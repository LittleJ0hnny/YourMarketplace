package com.littlejohnny.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ExceptionResponse> error(final Exception e, final HttpStatus httpStatus) {
        return new ResponseEntity<>(new ExceptionResponse(e, httpStatus), httpStatus);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> illegalArgExHandler(final IllegalArgumentException e) {
        return error(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NonExistentResourceEx.class)
    public ResponseEntity<ExceptionResponse> nonExistentResourceExHandler(final NonExistentResourceEx e) {
        return error(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NameDuplicationEx.class)
    public ResponseEntity<ExceptionResponse> nameDuplicationExHandler(final NameDuplicationEx e) {
        return error(e, HttpStatus.CONFLICT);
    }
}
