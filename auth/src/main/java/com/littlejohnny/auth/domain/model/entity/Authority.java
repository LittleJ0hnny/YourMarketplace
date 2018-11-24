package com.littlejohnny.auth.domain.model.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String authority;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "authority_user",
            joinColumns = { @JoinColumn(name = "authority_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> users;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "authority_oauth2client",
            joinColumns = { @JoinColumn(name = "authority_id") },
            inverseJoinColumns = { @JoinColumn(name = "oauth2client_id") }
    )
    private List<OAuth2Client> oauth2Clients;

    public Authority(String authority) {
        this.authority = authority;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addOAuth2Client(OAuth2Client oAuth2Client) {
        oauth2Clients.add(oAuth2Client);
    }
}
