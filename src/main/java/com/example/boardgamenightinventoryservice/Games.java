package com.example.boardgamenightinventoryservice;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="games")
public class Games {
    @Id
    private String id;


    private String game_api_id;


    private String game_name;

    public Games() {
    }

    public Games(String game_api_id, String game_name) {
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
}

//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "Games")
//public class Game {
//
//    @Id //Specifying Primary Key of the Game Entity
//    @Column(name = "Game_Api_ID")
//    private String gameID;
//
//    @OneToMany (mappedBy = "game")
//    Set<Inventory> user_games;
//
//    @Column(columnDefinition = "TEXT",
//            name = "Game_Name")
//    private String name;
//
//    public String getGameID() {
//        return gameID;
//    }
//    public void setGameID(String id) {
//        this.gameID = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<Inventory> getUser_games() {
//        return user_games;
//    }
//    public void setUser_games(Set<Inventory> user_games) {
//        this.user_games = user_games;
//    }
//}