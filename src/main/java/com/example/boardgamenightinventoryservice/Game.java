package com.example.boardgamenightinventoryservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="games")
public class Game {

    @Id
    private String id;

    private String game_api_id;

    private String game_name;

    @OneToMany(mappedBy = "gamesU")
    private Set<UserGame> userGames = new HashSet<>();

    public Game(String game_api_id, String game_name) {
        this.game_api_id = game_api_id;
        this.game_name = game_name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    public Set<UserGame> getUserGames() {
        return userGames;
    }
    public void setUserGames(Set<UserGame> userGames) {
        this.userGames = userGames;
    }
}
