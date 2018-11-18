package com.littlejohnny.auth.domain.service.impl;

import com.littlejohnny.auth.domain.model.entity.Authority;
import com.littlejohnny.auth.domain.repository.AuthorityRepository;
import com.littlejohnny.auth.domain.service.AbstractService;
import com.littlejohnny.auth.domain.service.AuthorityService;

public class AuthorityServiceImpl extends AbstractService<Authority, Long, AuthorityRepository> implements AuthorityService {
    protected AuthorityServiceImpl(AuthorityRepository repository) {
        super(repository);
    }
}
