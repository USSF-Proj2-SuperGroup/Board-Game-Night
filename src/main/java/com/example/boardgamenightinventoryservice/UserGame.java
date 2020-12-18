package com.example.boardgamenightinventoryservice;

import javax.persistence.*;

@Entity
@Table(name="user_games")
public class UserGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User userGames;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    Game gamesU;

    public String getGameApiId(){
        return gamesU.getGame_api_id();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserGames() {
        return userGames;
    }
    public void setUserGames(User userGames) {
        this.userGames = userGames;
    }

    public Game getGamesU() {
        return gamesU;
    }
    public void setGamesU(Game gamesU) {
        this.gamesU = gamesU;
    }
}
