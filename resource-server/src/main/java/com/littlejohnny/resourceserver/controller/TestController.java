package com.littlejohnny.resourceserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/message")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String getMessage() {
        return "Hello World !";
    }
}
