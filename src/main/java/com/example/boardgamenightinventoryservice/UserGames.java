package com.example.boardgamenightinventoryservice;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_games")
public class UserGames implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userGamesId;

    @Column(name="games_id")
    private int gamesId;

    @Column(name="user_id")
    private int userId;

    public int getUserGamesId() {
        return userGamesId;
    }
    public void setUserGamesId(int userGamesId) {
        this.userGamesId = userGamesId;
    }

    public int getGamesId() {
        return gamesId;
    }
    public void setGamesId(int gamesId) {
        this.gamesId = gamesId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

}


//     -- GET ALL GAMES FOR ALL USERS
//    SELECT username, game_name
//    FROM user_games
//    JOIN users
//    ON users.id = user_games.user_id
//    JOIN games
//    ON games.id = user_games.games_id;


//     -- GET ALL GAMES FOR ONE USER
//    SELECT games.game_name
//    FROM games
//    INNER JOIN user_games
//    ON games.id = user_games.games_id
//    WHERE user_games.user_id = 1;