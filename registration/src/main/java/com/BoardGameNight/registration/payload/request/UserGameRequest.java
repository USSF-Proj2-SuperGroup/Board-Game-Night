package com.BoardGameNight.registration.payload.request;

import com.BoardGameNight.registration.model.Games;
import com.BoardGameNight.registration.model.User;

import javax.validation.constraints.NotBlank;

public class UserGameRequest {
    @NotBlank
    private Games gameId;

    @NotBlank
    private User userId;

    public Games getGameId() {
        return gameId;
    }

    public void setGameId(Games gameId) {
        this.gameId = gameId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
