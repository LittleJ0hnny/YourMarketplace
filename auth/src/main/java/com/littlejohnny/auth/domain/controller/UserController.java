package com.littlejohnny.auth.domain.controller;

import com.littlejohnny.auth.domain.model.dto.UserDTO;
import com.littlejohnny.auth.domain.model.entity.Authority;
import com.littlejohnny.auth.domain.model.entity.User;
import com.littlejohnny.auth.domain.service.AuthorityService;
import com.littlejohnny.auth.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        User user = userDTO.asUser();
        Authority authority = authorityService.getOne(1L);
        user.setAuthorities(Arrays.asList(authority));
        authority.addUser(user);
        userService.save(user);
        return ResponseEntity.ok("Done!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    }
}
