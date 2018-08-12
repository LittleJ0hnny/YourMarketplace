package com.littlejohnny.domain.repository;

import com.littlejohnny.domain.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
