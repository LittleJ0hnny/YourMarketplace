package com.littlejohnny.auth.domain.repository;

import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuth2ClientRepository extends JpaRepository<OAuth2Client, Long> {
    OAuth2Client findOAuth2ClientByClientId(String clientId);
}
