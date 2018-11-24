package com.littlejohnny.auth.domain.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String resourceId;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "resource_oauth2client",
            joinColumns = { @JoinColumn(name = "resource_id") },
            inverseJoinColumns = { @JoinColumn(name = "oauth2client_id") }
    )
    private List<OAuth2Client> oauth2Clients;

    public Resource(String resourceId) {
        this.resourceId = resourceId;
    }

    public void addOAuth2Client(OAuth2Client oAuth2Client) {
        oauth2Clients.add(oAuth2Client);
    }


}
