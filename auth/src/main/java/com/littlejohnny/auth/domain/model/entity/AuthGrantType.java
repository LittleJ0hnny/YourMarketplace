package com.littlejohnny.auth.domain.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
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
            inverseJoinColumns = { @JoinColumn(name = "oAuth2Client_id") }
    )
    private List<OAuth2Client> oAuth2Clients;

    public AuthGrantType(String grantType) {
        this.grantType = grantType;
    }

    public void addOAuth2Client(OAuth2Client oAuth2Client) {
        oAuth2Clients.add(oAuth2Client);
    }
}
