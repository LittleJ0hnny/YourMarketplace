package com.littlejohnny.auth.domain.service.impl;

import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import com.littlejohnny.auth.domain.repository.OAuth2ClientRepository;
import com.littlejohnny.auth.domain.service.AbstractService;
import com.littlejohnny.auth.domain.service.OAuth2ClientService;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class OAuth2ClientServiceImpl extends AbstractService<OAuth2Client, Long, OAuth2ClientRepository> implements OAuth2ClientService, ClientDetailsService {

    protected OAuth2ClientServiceImpl(OAuth2ClientRepository repository) {
        super(repository);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return repository.findOAuth2ClientByClientId(clientId);
    }
}
