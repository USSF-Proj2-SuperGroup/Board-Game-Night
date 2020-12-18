package com.BoardGameNight.registration.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="game_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 80)
    private String name;

    @Size(max = 255)
    private String description;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<GroupGames> groupGames = new HashSet<>();

    public Group() {

    }

    public Group(@NotBlank @Size(max = 80) String name, @Size(max = 255) String description) {
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

    public Set<GroupGames> getGroupGames() {
        return groupGames;
    }

    public void setGroupGames(Set<GroupGames> groupGames) {
        this.groupGames = groupGames;
    }
}

