package com.littlejohnny.auth.domain.model.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String authority;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "authority_user",
            joinColumns = { @JoinColumn(name = "authority_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "authority_oauth2client",
            joinColumns = { @JoinColumn(name = "authority_id") },
            inverseJoinColumns = { @JoinColumn(name = "oauth2client_id") }
    )
    private List<OAuth2Client> oAuth2Clients;

    public Authority() {
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addOAuth2Client(OAuth2Client oAuth2Client) {
        oAuth2Clients.add(oAuth2Client);
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<OAuth2Client> getoAuth2Clients() {
        return oAuth2Clients;
    }

    public void setoAuth2Clients(List<OAuth2Client> oAuth2Clients) {
        this.oAuth2Clients = oAuth2Clients;
    }
}
