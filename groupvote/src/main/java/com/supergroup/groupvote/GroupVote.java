package com.supergroup.groupvote;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Game_ID", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Game game;

    @Column(name = "Game_votes")
    int gameVotes;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

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

    public int getGameVotes() {
        return gameVotes;
    }

    public void setGameVotes(int gameVotes) {
        this.gameVotes = gameVotes;
    }


}
