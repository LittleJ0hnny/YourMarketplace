package com.littlejohnny.resourceserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class TestController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/message")
    @PreAuthorize("hasRole('ADMIN')")
    public String getMessage() {
        return "Hello World !";
    }
}
