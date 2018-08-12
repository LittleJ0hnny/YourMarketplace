package com.littlejohnny.domain.service.impl;

import com.littlejohnny.domain.model.entity.Product;
import com.littlejohnny.domain.repository.ProductRepository;
import com.littlejohnny.domain.service.AbstractService;
import com.littlejohnny.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService<Product, Long, ProductRepository> implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    protected ProductServiceImpl(ProductRepository repository) {
        super(repository);
        this.productRepository = repository;
    }



}
