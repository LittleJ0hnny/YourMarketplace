package com.littlejohnny.auth.domain.model.dto;

import com.littlejohnny.auth.domain.model.UserBuilder;
import com.littlejohnny.auth.domain.model.entity.User;

public class UserDTO {
    private String username;
    private String password;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User asUser() {
        return new UserBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}
