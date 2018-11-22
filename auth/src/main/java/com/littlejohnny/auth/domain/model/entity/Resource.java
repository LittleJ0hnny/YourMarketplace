package com.littlejohnny.auth.domain.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String resourceId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "resource_oAuth2Client",
            joinColumns = { @JoinColumn(name = "resource_id") },
            inverseJoinColumns = { @JoinColumn(name = "oAuth2Client_id") }
    )
    private List<OAuth2Client> oAuth2Clients;

    public Resource() {
    }

    public void addOAuth2Client(OAuth2Client oAuth2Client) {
        oAuth2Clients.add(oAuth2Client);
    }

    public Resource(String resourceId) {
        this.resourceId = resourceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public List<OAuth2Client> getoAuth2Clients() {
        return oAuth2Clients;
    }

    public void setoAuth2Clients(List<OAuth2Client> oAuth2Clients) {
        this.oAuth2Clients = oAuth2Clients;
    }
}
