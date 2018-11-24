package com.littlejohnny.auth.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "grant_types")
public class AuthGrantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String grantType;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "grant_type_oauth2client",
            joinColumns = { @JoinColumn(name = "grant_type_id") },
            inverseJoinColumns = { @JoinColumn(name = "oauth2client_id") }
    )
    private List<OAuth2Client> oauth2Clients;

    public AuthGrantType(String grantType) {
        this.grantType = grantType;
    }

    public void addOAuth2Client(OAuth2Client oAuth2Client) {
        oauth2Clients.add(oAuth2Client);
    }
}
