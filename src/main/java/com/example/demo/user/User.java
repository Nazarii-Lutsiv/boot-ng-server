package com.example.demo.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private CustomRole customRole = CustomRole.ROLE_USER;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customRole.name()));
        return authorities;
    }

    private boolean isAccountNonExpired = true;

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    private boolean isAccountNonLocked = true;

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    private boolean isCredentialsNonExpired = true;

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    private boolean isEnabled = true;

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}