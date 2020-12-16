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

}
