package com.BoardGameNight.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"userGames","wishlist","groups"})
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "userGames")
    @JsonIgnoreProperties("userGames")
    private Set<UserGames> userGames = new HashSet<>();

    @OneToMany(mappedBy = "userWishlist")
    @JsonIgnoreProperties("wishlist")
    private Set<UserWishlist> wishlist = new HashSet<>();

    @OneToMany(mappedBy = "userGroup")
    @JsonIgnoreProperties("groups")
    private Set<UserGroups> groups = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<UserGames> getGames() {
        return userGames;
    }

    public void setGames(Set<UserGames> userGames) {
        this.userGames = userGames;
    }

    public Set<UserWishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(Set<UserWishlist> wishlist) {
        this.wishlist = wishlist;
    }

    public Set<UserGroups> getGroups() {
        return groups;
    }

    public void setGroups(Set<UserGroups> groups) {
        this.groups = groups;
    }
}
