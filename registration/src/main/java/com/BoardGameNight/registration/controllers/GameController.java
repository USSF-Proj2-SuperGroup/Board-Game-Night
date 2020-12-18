package com.BoardGameNight.registration.controllers;

import com.BoardGameNight.registration.model.Games;
import com.BoardGameNight.registration.payload.request.GameRequest;
import com.BoardGameNight.registration.payload.response.MessageResponse;
import com.BoardGameNight.registration.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    GamesRepository gamesRepository;

    @PostMapping("/add")
    public ResponseEntity<?> newGame(@RequestBody GameRequest gameRequest){
        if(gamesRepository.existsByGameApiId(gameRequest.getGame_api_id())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Group name is already taken!"));
        }
        Games newGame = new Games(
                gameRequest.getGame_api_id(),
                gameRequest.getGame_name());
        gamesRepository.save(newGame);
        return ResponseEntity.ok(new MessageResponse("Game successfully added!"));
    }
}
