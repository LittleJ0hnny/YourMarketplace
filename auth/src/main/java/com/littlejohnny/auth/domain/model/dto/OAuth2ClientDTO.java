package com.littlejohnny.auth.domain.model.dto;

import com.littlejohnny.auth.domain.model.OAuth2ClientBuilder;
import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

public class OAuth2ClientDTO {
    private String clientId;
    private String clientSecret;
    private Set<String> resourceIds;
    private Set<String> scope;
    private Set<String> authorizedGrantTypes;
    private Set<String> registeredRedirectUri;
    private List<GrantedAuthority> authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;

    public OAuth2ClientDTO() {
    }

    public OAuth2ClientDTO(OAuth2Client oAuth2Client) {
        this.clientId = oAuth2Client.getClientId();
        this.clientSecret = oAuth2Client.getClientSecret();
        this.resourceIds = oAuth2Client.getResourceIds();
        this.scope = oAuth2Client.getScope();
        this.authorizedGrantTypes = oAuth2Client.getAuthorizedGrantTypes();
        this.registeredRedirectUri = oAuth2Client.getRegisteredRedirectUri();
        this.authorities = (List) oAuth2Client.getAuthorities();
        this.accessTokenValiditySeconds = oAuth2Client.getAccessTokenValiditySeconds();
        this.refreshTokenValiditySeconds = oAuth2Client.getRefreshTokenValiditySeconds();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Set<String> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(Set<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Set<String> getScope() {
        return scope;
    }

    public void setScope(Set<String> scope) {
        this.scope = scope;
    }

    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public OAuth2Client asOAuth2Client() {
        return new OAuth2ClientBuilder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setResourceIds(resourceIds)
                .setScope(scope)
                .setAuthorizedGrantTypes(authorizedGrantTypes)
                .setRegisteredRedirectUri(registeredRedirectUri)
                .setAuthorities(authorities)
                .setAccessTokenValiditySeconds(accessTokenValiditySeconds)
                .setRefreshTokenValiditySeconds(refreshTokenValiditySeconds)
                .build();
    }
}
