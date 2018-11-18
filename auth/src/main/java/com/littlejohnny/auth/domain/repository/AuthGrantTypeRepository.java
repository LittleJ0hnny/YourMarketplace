package com.littlejohnny.auth.domain.repository;

import com.littlejohnny.auth.domain.model.entity.AuthGrantType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthGrantTypeRepository extends JpaRepository<AuthGrantType, Long> {
}
