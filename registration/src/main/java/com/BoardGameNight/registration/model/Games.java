package com.BoardGameNight.registration.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="games")
public class Games {
    @Id
    private String id;

    @NotBlank
    private String game_api_id;

    @NotBlank
    private String game_name;

    public Games() {
    }

    public Games(@NotBlank String game_api_id, @NotBlank String game_name) {
        this.game_api_id = game_api_id;
        this.game_name = game_name;
    }

    public String getId() {
        return id;
    }

    public String getGame_api_id() {
        return game_api_id;
    }

    public void setGame_api_id(String game_api_id) {
        this.game_api_id = game_api_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }
}
