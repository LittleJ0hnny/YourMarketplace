package com.littlejohnny.auth.domain.model.dto;

import com.littlejohnny.auth.domain.model.OAuth2ClientBuilder;
import com.littlejohnny.auth.domain.model.entity.AuthGrantType;
import com.littlejohnny.auth.domain.model.entity.Authority;
import com.littlejohnny.auth.domain.model.entity.OAuth2Client;
import com.littlejohnny.auth.domain.model.entity.Resource;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
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

    public OAuth2ClientDTO(OAuth2Client oAuth2Client) {
        this.clientId = oAuth2Client.getClientId();
        this.clientSecret = oAuth2Client.getClientSecret();
        this.resourceIds = oAuth2Client.getResourceIds();
        this.scopes = oAuth2Client.getScope();
        this.authorizedGrantTypes = oAuth2Client.getAuthorizedGrantTypes();
        this.registeredRedirectUri = oAuth2Client.getRegisteredRedirectUri();
        this.authorities = Optional.ofNullable(oAuth2Client.getAuthorities()).orElse(new ArrayList<>()).stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        this.accessTokenValiditySeconds = oAuth2Client.getAccessTokenValiditySeconds();
        this.refreshTokenValiditySeconds = oAuth2Client.getRefreshTokenValiditySeconds();
    }

    public OAuth2Client asOAuth2Client() {
        return new OAuth2ClientBuilder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setResources(Optional.ofNullable(resourceIds).orElse(new HashSet<>()).stream().map(Resource::new).collect(Collectors.toSet()))
                .setScope(scopes)
                .setGrantTypes(Optional.ofNullable(authorizedGrantTypes).orElse(new HashSet<>()).stream().map(AuthGrantType::new).collect(Collectors.toSet()))
                .setRegisteredRedirectUri(registeredRedirectUri)
                .setAuthorities(Optional.ofNullable(authorities).orElse(new ArrayList<>()).stream().map(Authority::new).collect(Collectors.toList()))
                .setAccessTokenValiditySeconds(accessTokenValiditySeconds)
                .setRefreshTokenValiditySeconds(refreshTokenValiditySeconds)
                .build();
    }
}
