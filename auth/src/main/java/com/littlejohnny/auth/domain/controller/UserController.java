package com.littlejohnny.auth.domain.controller;

import com.littlejohnny.auth.domain.model.dto.UserDTO;
import com.littlejohnny.auth.domain.model.entity.Authorities;
import com.littlejohnny.auth.domain.model.entity.Authority;
import com.littlejohnny.auth.domain.model.entity.User;
import com.littlejohnny.auth.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority(Authorities.ADMIN.getAuthority()));
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
