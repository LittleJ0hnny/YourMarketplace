package com.littlejohnny.domain.repository;

import com.littlejohnny.domain.model.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
