package com.littlejohnny.auth.domain.service;

import com.littlejohnny.auth.domain.model.entity.User;
import com.littlejohnny.auth.domain.repository.UserRepository;

public interface UserService extends Service<User, Long, UserRepository> {
    void deleteById(Long id);
}
