package com.example.boardgamenightinventoryservice;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="game_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "group_games",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Games> groupGames = new HashSet<>();

    public Group() {

    }

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Games> getGroupGames() {
        return groupGames;
    }

    public void setGroupGames(Set<Games> groupGames) {
        this.groupGames = groupGames;
    }
}
