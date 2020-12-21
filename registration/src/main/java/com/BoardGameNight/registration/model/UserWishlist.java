package com.BoardGameNight.registration.model;

import javax.persistence.*;

@Entity
@Table(name = "user_wishlist")
public class UserWishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User userWishlist;

    @ManyToOne
    @JoinColumn(name = "games_id")
    Games gamesW;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getWishlistUser() {
        return userWishlist;
    }

    public void setWishlistUser(User userWishlist) {
        this.userWishlist = userWishlist;
    }

    public Games getGamesWishlist() {
        return gamesW;
    }

    public void setGamesWishlist(Games gamesW) {
        this.gamesW = gamesW;
    }
}
