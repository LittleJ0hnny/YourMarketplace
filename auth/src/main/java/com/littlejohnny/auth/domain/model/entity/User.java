package com.littlejohnny.auth.domain.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Authority> authorities;

    @Column(nullable = false)
    private boolean isExpired;

    @Column(nullable = false)
    private boolean isLocked;

    @Column(nullable = false)
    private boolean isCredentialsExpired;

    @Column(nullable = false)
    private boolean isEnabled;

    public User(String username, String password, List<Authority> authorities) {
        this();
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
        authorities.forEach(element -> element.addUser(this));
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired;
    }
}
