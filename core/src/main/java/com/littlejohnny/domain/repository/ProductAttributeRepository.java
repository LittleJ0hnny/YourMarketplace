package com.littlejohnny.domain.repository;

import com.littlejohnny.domain.model.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {

}
