package com.littlejohnny.domain.service.impl;

import com.littlejohnny.domain.model.entity.ProductAttribute;
import com.littlejohnny.domain.repository.ProductAttributeRepository;
import com.littlejohnny.domain.service.AbstractService;
import com.littlejohnny.domain.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAttributeServiceImpl extends AbstractService<ProductAttribute, Long, ProductAttributeRepository> implements ProductAttributeService {

    private ProductAttributeRepository productAttributeRepository;

    @Autowired
    protected ProductAttributeServiceImpl(ProductAttributeRepository repository) {
        super(repository);
        this.productAttributeRepository = repository;
    }
}
