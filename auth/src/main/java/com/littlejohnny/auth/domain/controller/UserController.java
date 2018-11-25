package com.littlejohnny.auth.domain.controller;

import com.littlejohnny.auth.domain.model.dto.UserDTO;
import com.littlejohnny.auth.domain.model.Authorities;
import com.littlejohnny.auth.domain.model.entity.User;
import com.littlejohnny.auth.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        Set<Authorities> authorities = new HashSet<>();
        authorities.add(Authorities.USER);
        User user = userDTO.asUser();
        user.setAuthorities(authorities);
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
