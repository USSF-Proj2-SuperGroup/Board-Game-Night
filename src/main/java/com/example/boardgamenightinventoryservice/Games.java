package com.example.boardgamenightinventoryservice;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Games {

    @Id //Specifying Primary Key of the Game Entity
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gamesId;

    @Column(name = "game_name")
    private String name;

    @Column(name = "game_api_id")
    private String apiID;

    public int getGamesId() {
        return gamesId;
    }
    public void setGamesId(int gamesId) {
        this.gamesId = gamesId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getApiID() {
        return apiID;
    }
    public void setApiID(String apiID) {
        this.apiID = apiID;
    }
}