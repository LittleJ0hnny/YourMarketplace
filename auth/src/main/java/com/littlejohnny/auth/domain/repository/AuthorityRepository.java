package com.littlejohnny.auth.domain.repository;

import com.littlejohnny.auth.domain.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
