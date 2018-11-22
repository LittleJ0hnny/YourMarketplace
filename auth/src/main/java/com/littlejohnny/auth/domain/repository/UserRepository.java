package com.littlejohnny.auth.domain.repository;

import com.littlejohnny.auth.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    void deleteById(Long id);
}
