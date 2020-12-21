package com.supergroup.groupvote;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    //Game_ID | User_ID | game_api_ID | Game_Name                         | In_Game_Pool | In_Wishlist
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "game_api_id")
    String gameApiID;

    @Column(name = "game_name")
    String gameName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameApiID() {
        return gameApiID;
    }

    public void setGameApiID(String gameApiID) {
        this.gameApiID = gameApiID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

}
