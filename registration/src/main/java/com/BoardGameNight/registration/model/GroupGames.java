package com.BoardGameNight.registration.model;

import javax.persistence.*;

@Entity
@Table(name = "group_games")
public class GroupGames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group groupG;

    @ManyToOne
    @JoinColumn(name = "games_id")
    Games gamesG;

    @Column
    private Integer votes;

    public GroupGames(Long id, Group groupG, Games gamesG, Integer votes) {
        this.id = id;
        this.groupG = groupG;
        this.gamesG = gamesG;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroupGames() {
        return groupG;
    }

    public void setGroupGames(Group groupGames) {
        this.groupG = groupGames;
    }

    public Games getGamesGroup() {
        return gamesG;
    }

    public void setGamesGroup(Games gamesGroup) {
        this.gamesG = gamesGroup;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }
}
