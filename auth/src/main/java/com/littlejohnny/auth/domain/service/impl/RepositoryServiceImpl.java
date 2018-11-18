package com.littlejohnny.auth.domain.service.impl;

import com.littlejohnny.auth.domain.model.entity.Resource;
import com.littlejohnny.auth.domain.repository.ResourceRepository;
import com.littlejohnny.auth.domain.service.AbstractService;
import com.littlejohnny.auth.domain.service.ResourceService;

public class RepositoryServiceImpl extends AbstractService<Resource, Long, ResourceRepository> implements ResourceService {
    protected RepositoryServiceImpl(ResourceRepository repository) {
        super(repository);
    }
}
