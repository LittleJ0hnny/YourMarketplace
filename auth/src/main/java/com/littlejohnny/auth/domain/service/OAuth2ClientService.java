package com.littlejohnny.auth.domain.service;

import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import com.littlejohnny.auth.domain.repository.OAuth2ClientRepository;

public interface OAuth2ClientService extends Service<OAuth2Client, Long, OAuth2ClientRepository> {
}
