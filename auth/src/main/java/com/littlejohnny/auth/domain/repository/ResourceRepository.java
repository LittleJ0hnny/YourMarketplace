package com.littlejohnny.auth.domain.repository;

import com.littlejohnny.auth.domain.model.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
