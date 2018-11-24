package com.littlejohnny.auth.domain.model.entity;

import com.littlejohnny.auth.util.CollectionMapper;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Data
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

    @Column(unique = true, nullable = false)
    private String clientId;

    @Column(unique = true, nullable = false)
    private String clientSecret;

    @Column
    private String resourceIds;

    @Column
    private boolean isSecretRequired;

    @Column
    private boolean isScoped;

    @ElementCollection
    private Set<String> scope;

    @Column(nullable = false)
    private String authorizedGrantTypes;

    @ElementCollection
    private Set<String> registeredRedirectUri;

    @Column
    private String authorities;

    @Column(nullable = false)
    private Integer accessTokenValiditySeconds;

    @Column(nullable = false)
    private Integer refreshTokenValiditySeconds;

    @Column
    private boolean isAutoApprove;

    public OAuth2Client() {
        this.accessTokenValiditySeconds = DEFAULT_ACCESS_TOKEN_VALIDITY;
        this.refreshTokenValiditySeconds = DEFAULT_REFRESH_TOKEN_VALIDITY;
        this.isAutoApprove = true;
    }

    public OAuth2Client(String clientId, String clientSecret, String authorizedGrantTypes) {
        this();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    @Override
    public Set<String> getResourceIds() {
        return CollectionMapper.stringToSet(resourceIds);
    }

    public void setResourceIds(Set<Resource> resources) {
        this.resourceIds = CollectionMapper.collectionToString(resources);
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return CollectionMapper.stringToSet(authorizedGrantTypes);
    }

    public void setAuthorizedGrantTypes(Set<AuthGrantType> authGrantTypes) {
        this.authorizedGrantTypes = CollectionMapper.collectionToString(authGrantTypes);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return CollectionMapper.stringToSet(authorities).stream().map(Authority::new).collect(Collectors.toSet());
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = CollectionMapper.collectionToString(authorities);
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return isAutoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<>();
    }
}
