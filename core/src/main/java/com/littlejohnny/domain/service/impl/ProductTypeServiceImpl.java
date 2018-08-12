package com.littlejohnny.domain.service.impl;

import com.littlejohnny.domain.model.entity.ProductType;
import com.littlejohnny.domain.repository.ProductTypeRepository;
import com.littlejohnny.domain.service.AbstractService;
import com.littlejohnny.domain.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl extends AbstractService<ProductType, Long, ProductTypeRepository> implements ProductTypeService {

    private ProductTypeRepository productTypeRepository;

    @Autowired
    protected ProductTypeServiceImpl(ProductTypeRepository repository) {
        super(repository);
        this.productTypeRepository = repository;
    }
}
