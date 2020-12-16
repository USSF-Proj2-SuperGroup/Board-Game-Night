package com.supergroup.groupvote;

import javax.persistence.*;

@Entity
@Table(name = "Game_Pool")
public class GroupVote {
    //Pool_ID | Game_Group_ID | Game_ID | Game_votes
    @Id
    @Column(name = "Pool_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Game_Group_ID")
    int gameGroupID;

    @Column(name = "Game_ID")
    int gameID;

    @Column(name = "Game_votes")
    int gameVotes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGameGroupID() {
        return gameGroupID;
    }

    public void setGameGroupID(int gameGroupID) {
        this.gameGroupID = gameGroupID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getGameVotes() {
        return gameVotes;
    }

    public void setGameVotes(int gameVotes) {
        this.gameVotes = gameVotes;
    }


}
