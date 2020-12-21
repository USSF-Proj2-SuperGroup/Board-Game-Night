package com.supergroup.groupvote;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/games")
public class GamesController {
    private final GameRepository repository;

    public GamesController(GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    @CrossOrigin
    public Iterable<Game> list() {
        return this.repository.findAll();
    }
}
