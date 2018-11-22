package com.littlejohnny.auth.domain.service.impl;

import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import com.littlejohnny.auth.domain.repository.OAuth2ClientRepository;
import com.littlejohnny.auth.domain.service.AbstractService;
import com.littlejohnny.auth.domain.service.OAuth2ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class OAuth2ClientServiceImpl extends AbstractService<OAuth2Client, Long, OAuth2ClientRepository> implements OAuth2ClientService, ClientDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    protected OAuth2ClientServiceImpl(OAuth2ClientRepository repository) {
        super(repository);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return repository.findOAuth2ClientByClientId(clientId);
    }

    @Override
    public void save(OAuth2Client entity) {
        entity.setClientSecret(passwordEncoder.encode(entity.getClientSecret()));
        super.save(entity);
    }
}
