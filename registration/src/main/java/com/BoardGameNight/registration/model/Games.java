package com.BoardGameNight.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="games")
public class Games {
    @Id
    private String id;

    @NotBlank
    private String game_api_id;

    @NotBlank
    private String game_name;

    @OneToMany(mappedBy = "gamesU")
    private Set<UserGames> userGames = new HashSet<>();

    @OneToMany(mappedBy = "gamesW")
    private Set<UserWishlist> userWishlist = new HashSet<>();

    @OneToMany(mappedBy = "gamesG")
    private Set<GroupGames> groupGames = new HashSet<>();

    public Games() {
    }

    public Games(@NotBlank String game_api_id, @NotBlank String game_name) {
        this.game_api_id = game_api_id;
        this.game_name = game_name;
    }

    public String getId() {
        return id;
    }

    public String getGame_api_id() {
        return game_api_id;
    }

    public void setGame_api_id(String game_api_id) {
        this.game_api_id = game_api_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public Set<UserGames> getUserGames() {
        return userGames;
    }

    public void setUserGames(Set<UserGames> userGames) {
        this.userGames = userGames;
    }

    public Set<UserWishlist> getUserWishlist() {
        return userWishlist;
    }

    public void setUserWishlist(Set<UserWishlist> userWishlist) {
        this.userWishlist = userWishlist;
    }

    public Set<GroupGames> getGroupGames() {
        return groupGames;
    }

    public void setGroupGames(Set<GroupGames> groupGames) {
        this.groupGames = groupGames;
    }
}
