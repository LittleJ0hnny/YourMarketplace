package com.littlejohnny.domain.service.impl;

import com.littlejohnny.domain.model.entity.AttributeValue;
import com.littlejohnny.domain.repository.AttributeValueRepository;
import com.littlejohnny.domain.service.AbstractService;
import com.littlejohnny.domain.service.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeValueServiceImpl extends AbstractService<AttributeValue, Long, AttributeValueRepository> implements AttributeValueService {
    private AttributeValueRepository attributeValueRepository;

    @Autowired
    protected AttributeValueServiceImpl(AttributeValueRepository repository) {
        super(repository);
        this.attributeValueRepository = repository;
    }
}
