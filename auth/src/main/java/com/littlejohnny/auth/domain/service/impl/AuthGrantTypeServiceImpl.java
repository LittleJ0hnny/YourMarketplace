package com.littlejohnny.auth.domain.service.impl;

import com.littlejohnny.auth.domain.model.entity.AuthGrantType;
import com.littlejohnny.auth.domain.repository.AuthGrantTypeRepository;
import com.littlejohnny.auth.domain.service.AbstractService;
import com.littlejohnny.auth.domain.service.AuthGrantTypeService;
import org.springframework.stereotype.Service;

@Service
public class AuthGrantTypeServiceImpl extends AbstractService<AuthGrantType, Long, AuthGrantTypeRepository> implements AuthGrantTypeService {
    protected AuthGrantTypeServiceImpl(AuthGrantTypeRepository repository) {
        super(repository);
    }
}
