package com.supergroup.groupvote;

import javax.persistence.*;

@Entity
@Table(name = "Games")
public class Game {
    //Game_ID | User_ID | game_api_ID | Game_Name                         | In_Game_Pool | In_Wishlist
    @Id
    @Column(name = "Game_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "User_ID")
    int userID;

//    @Column(name = "game_api_ID")
//    String gameApiID;
    @Column(columnDefinition = "TEXT", name = "Game_Name")
    String gameName;

    @Column(name = "In_Game_Pool")
    boolean inGamePool;

    @Column(name = "In_Wishlist")
    boolean inWishlist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

//    public String getGameApiID() {
//        return gameApiID;
//    }
//
//    public void setGameApiID(String gameApiID) {
//        this.gameApiID = gameApiID;
//    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public boolean isInGamePool() {
        return inGamePool;
    }

    public void setInGamePool(boolean inGamePool) {
        this.inGamePool = inGamePool;
    }

    public boolean isInWishlist() {
        return inWishlist;
    }

    public void setInWishlist(boolean inWishlist) {
        this.inWishlist = inWishlist;
    }





}
