package com.littlejohnny.auth.domain.model.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "oauth2_clients")
public class OAuth2Client implements ClientDetails {
    @Transient
    @Value("token.access.default_time")
    public final Integer DEFAULT_ACCESS_TOKEN_VALIDITY = 1800;

    @Transient
    @Value("token.refresh.default_time")
    public final Integer DEFAULT_REFRESH_TOKEN_VALIDITY = 86400;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clientId;

    @Column(nullable = false)
    private String clientSecret;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "oAuth2Clients")
    private Set<Resource> resources;

    @Column
    private boolean isSecretRequired;

    @Column
    private boolean isScoped;

    @ElementCollection
    private Set<String> scope;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "oAuth2Clients")
    private Set<AuthGrantType> grantTypes;

    @ElementCollection
    private Set<String> registeredRedirectUri;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "oAuth2Clients")
    private List<Authority> authorities;

    @Column
    private Integer accessTokenValiditySeconds;

    @Column
    private Integer refreshTokenValiditySeconds;

    @Column
    private boolean isAutoApprove;

    public OAuth2Client() {
        this.accessTokenValiditySeconds = DEFAULT_ACCESS_TOKEN_VALIDITY;
        this.refreshTokenValiditySeconds = DEFAULT_REFRESH_TOKEN_VALIDITY;
        this.isAutoApprove = true;
    }

    public OAuth2Client(String clientId, String clientSecret, Set<AuthGrantType> grantTypes) {
        this();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantTypes = grantTypes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return resources.stream().map(Resource::getResourceId).collect(Collectors.toSet());
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
        resources.forEach(element -> element.addOAuth2Client(this));
    }

    @Override
    public boolean isSecretRequired() {
        return isSecretRequired;
    }

    public void setSecretRequired(boolean secretRequired) {
        isSecretRequired = secretRequired;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public boolean isScoped() {
        return isScoped;
    }

    public void setScoped(boolean scoped) {
        isScoped = scoped;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    public void setScope(Set<String> scope) {
        this.scope = scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return grantTypes.stream().map(AuthGrantType::getGrantType).collect(Collectors.toSet());
    }

    public void setGrantTypes(Set<AuthGrantType> grantTypes) {
        this.grantTypes = grantTypes;
        grantTypes.forEach(element -> element.addOAuth2Client(this));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities.stream().map(element -> (GrantedAuthority) element).collect(Collectors.toList());
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
        authorities.forEach(element -> element.addOAuth2Client(this));
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return isAutoApprove;
    }

    public void setAutoApprove(boolean autoApprove) {
        isAutoApprove = autoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
