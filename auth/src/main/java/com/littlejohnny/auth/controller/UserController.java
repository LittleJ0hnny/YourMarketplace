package com.littlejohnny.auth.controller;

import com.littlejohnny.auth.model.Person;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/person")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public @ResponseBody Person personInfo() {
        return new Person("abir", "Dhaka", "Bangladesh", 29, "Male");
    }

}
