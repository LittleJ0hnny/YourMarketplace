package com.littlejohnny.auth.domain.controller;

import com.littlejohnny.auth.domain.model.dto.UserDTO;
import com.littlejohnny.auth.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO.asUser());
        return ResponseEntity.ok("Done!");
    }
}
