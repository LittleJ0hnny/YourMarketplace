package com.littlejohnny.auth.domain.model.dto;

import com.littlejohnny.auth.domain.model.OAuth2ClientBuilder;
import com.littlejohnny.auth.domain.model.entity.Authority;
import com.littlejohnny.auth.domain.model.entity.AuthGrantType;
import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import com.littlejohnny.auth.domain.model.entity.Resource;

import java.util.*;
import java.util.stream.Collectors;

public class OAuth2ClientDTO {
    private String clientId;
    private String clientSecret;
    private Set<String> resourceIds;
    private Set<String> scopes;
    private Set<String> authorizedGrantTypes;
    private Set<String> registeredRedirectUri;
    private List<String> authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;

    public OAuth2ClientDTO() {
    }

    public OAuth2ClientDTO(OAuth2Client oAuth2Client) {
        this.clientId = oAuth2Client.getClientId();
        this.clientSecret = oAuth2Client.getClientSecret();
        this.resourceIds = oAuth2Client.getResourceIds();
        this.scopes = oAuth2Client.getScope();
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

    public Set<String> getScopes() {
        return scopes;
    }

    public void setScopes(Set<String> scopes) {
        this.scopes = scopes;
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

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
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
                .setResources(Optional.ofNullable(resourceIds).orElse(new HashSet<>()).stream().map(Resource::new).collect(Collectors.toSet()))
                .setScope(scopes)
                .setGrantTypes(Optional.ofNullable(authorizedGrantTypes).orElse(new HashSet<>()).stream().map(AuthGrantType::new).collect(Collectors.toList()))
                .setRegisteredRedirectUri(registeredRedirectUri)
                .setAuthorities(Optional.ofNullable(authorities).orElse(new ArrayList<>()).stream().map(Authority::new).collect(Collectors.toList()))
                .setAccessTokenValiditySeconds(accessTokenValiditySeconds)
                .setRefreshTokenValiditySeconds(refreshTokenValiditySeconds)
                .build();
    }
}
