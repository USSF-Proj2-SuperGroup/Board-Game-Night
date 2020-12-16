package com.example.boardgamenightinventoryservice;

import javax.persistence.*;

@Entity
@Table(name = "Games")
public class Game {

    @Id //Specifying Primary Key of the Game Entity
    @Column(columnDefinition = "INTEGER",
            name = "Game_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameID;

    @Column(columnDefinition = "TEXT",
            name = "Game_Name")
    private String name;

    @Column(columnDefinition = "INTEGER",
            name = "User_ID")
    private Long userID;

    @Column(columnDefinition = "TEXT",
            name = "Game_api_ID")
    private String apiID;

    @Column(columnDefinition = "BOOLEAN",
            name = "In_Game_Pool")
    private Boolean inGamePool;

    @Column(columnDefinition = "BOOLEAN",
            name = "In_Wishlist")
    private Boolean inWishlist;

    public Long getGameID() {
        return gameID;
    }
    public void setGameID(Long id) {
        this.gameID = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getUserID() {
        return userID;
    }
    public void setUserID(Long id) {
        this.userID = id;
    }

    public String getApiID(){
        return apiID;
    }
    public void setApiID(String id) {
        this.apiID = id;
    }

    public Boolean getInGamePool() {
        return inGamePool;
    }
    public void setInGamePool(Boolean bool) {
        this.inGamePool = bool;
    }

    public Boolean getInWishlist() {
        return inWishlist;
    }
    public void setInWishlist(Boolean bool) {
        this.inWishlist = bool;
    }
}
