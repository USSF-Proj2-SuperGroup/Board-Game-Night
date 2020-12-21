package com.supergroup.groupvote;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_games")
public class GroupVote {
    //Pool_ID | Game_Group_ID | Game_ID | Game_votes
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @Column(name = "group_id")
    int groupId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "group_id", insertable = false, updatable = false)
//    private GameGroup gameGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "games_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Game game;

    @Column(name = "votes")
    int gameVotes;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGameVotes() {
        return gameVotes;
    }

    public void setGameVotes(int gameVotes) {
        this.gameVotes = gameVotes;
    }
//    public GameGroup getGameGroup() {
//        return gameGroup;
//    }
//
//    public void setGameGroup(GameGroup gameGroup) {
//        this.gameGroup = gameGroup;
//    }
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


}
