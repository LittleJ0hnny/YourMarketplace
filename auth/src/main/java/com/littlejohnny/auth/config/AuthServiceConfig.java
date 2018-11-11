package com.littlejohnny.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

@Order(6)
@Configuration
@EnableAuthorizationServer
public class AuthServiceConfig extends AuthorizationServerConfigurerAdapter {
    @Value("${jwt.certificate.store.file}")
    private Resource keystore;

    @Value("${jwt.certificate.store.password}")
    private String keystorePassword;

    @Value("${jwt.certificate.key.alias}")
    private String keyAlias;

    @Value("${jwt.certificate.key.password}")
    private String keyPassword;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("authserver")
                .secret("{noop}passwordforauthserver")
                .redirectUris("http://localhost:8080/")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("myscope")
                .autoApprove(true)
                .accessTokenValiditySeconds(1000)
                .refreshTokenValiditySeconds(1800)
                .and()
                .withClient("authserver2")
                .secret("{noop}passwordforauthserver2")
                .redirectUris("http://localhost:8080/")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("myscope2")
                .autoApprove(true)
                .accessTokenValiditySeconds(1000)
                .refreshTokenValiditySeconds(1800);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .accessTokenConverter(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                keystore, keystorePassword.toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(
                keyAlias, keyPassword.toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair);
        return converter;
    }
}
