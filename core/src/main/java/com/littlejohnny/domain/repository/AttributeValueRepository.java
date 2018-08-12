package com.littlejohnny.domain.repository;

import com.littlejohnny.domain.model.entity.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
}
