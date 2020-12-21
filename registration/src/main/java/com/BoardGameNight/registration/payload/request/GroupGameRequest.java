package com.BoardGameNight.registration.payload.request;

import javax.validation.constraints.NotBlank;

public class GroupGameRequest {
    @NotBlank
    private String groupG;
    @NotBlank
    private String gamesG;

    public String getGroupG() {
        return groupG;
    }

    public void setGroupG(String groupG) {
        this.groupG = groupG;
    }

    public String getGamesG() {
        return gamesG;
    }

    public void setGamesG(String gamesG) {
        this.gamesG = gamesG;
    }
}
