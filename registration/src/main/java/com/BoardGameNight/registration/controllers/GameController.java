package com.BoardGameNight.registration.controllers;

import com.BoardGameNight.registration.model.Games;
import com.BoardGameNight.registration.model.UserGames;
import com.BoardGameNight.registration.payload.request.GameRequest;
import com.BoardGameNight.registration.payload.request.GroupGameRequest;
import com.BoardGameNight.registration.payload.request.UserGameRequest;
import com.BoardGameNight.registration.payload.response.MessageResponse;
import com.BoardGameNight.registration.repository.GamesRepository;
import com.BoardGameNight.registration.repository.GroupGamesRepository;
import com.BoardGameNight.registration.repository.UserGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    GamesRepository gamesRepository;

    @Autowired
    UserGamesRepository userGamesRepository;

    @Autowired
    GroupGamesRepository groupGamesRepository;

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
    @PostMapping("/add/user-game")
    public ResponseEntity<?> newUserGame(@RequestBody UserGameRequest userGameRequest){
        if(userGamesRepository.existsByGamesU(userGameRequest.getGameId())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: You already own this game!"));
        }
        UserGames newUserGame = new UserGames(
                userGameRequest.getUserId(),
                userGameRequest.getGameId());
        userGamesRepository.save(newUserGame);
        return ResponseEntity.ok(new MessageResponse("Game successfully added to your inventory!"));
    }
    @PostMapping("/add/group-game")
    public ResponseEntity<?> newGroupGame(@RequestBody GroupGameRequest groupGameRequest){
        if(groupGamesRepository.g(groupGameRequest.getGamesG())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: This game is already in the the game night pool!"));
        }
        UserGames newGroupGame = new UserGames(
                groupGameRequest.getGroupG(),
                groupGameRequest.getGamesG());
        userGamesRepository.save(newGroupGame);
        return ResponseEntity.ok(new MessageResponse("Game successfully added to your group game pool!"));
    }
}
