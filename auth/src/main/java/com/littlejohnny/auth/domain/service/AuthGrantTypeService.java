package com.littlejohnny.auth.domain.service;

import com.littlejohnny.auth.domain.model.entity.AuthGrantType;
import com.littlejohnny.auth.domain.repository.AuthGrantTypeRepository;

public interface AuthGrantTypeService extends Service<AuthGrantType, Long, AuthGrantTypeRepository>{
    AuthGrantType findByGrantType(String grantType);
}
