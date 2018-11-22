package com.littlejohnny.auth.domain.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grant_types")
public class AuthGrantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String grantType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "grant_type_oauth2client",
            joinColumns = { @JoinColumn(name = "grant_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "oAuth2Client_id") }
    )
    private List<OAuth2Client> oAuth2Clients;

    public AuthGrantType() {
    }

    public void addOAuth2Client(OAuth2Client oAuth2Client) {
        oAuth2Clients.add(oAuth2Client);
    }

    public AuthGrantType(String grantType) {
        this.grantType = grantType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public List<OAuth2Client> getoAuth2Clients() {
        return oAuth2Clients;
    }

    public void setoAuth2Clients(List<OAuth2Client> oAuth2Clients) {
        this.oAuth2Clients = oAuth2Clients;
    }
}
