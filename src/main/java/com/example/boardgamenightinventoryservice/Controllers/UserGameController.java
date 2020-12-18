package com.example.boardgamenightinventoryservice.Controllers;

import com.example.boardgamenightinventoryservice.Repositories.UserGameRepository;
import com.example.boardgamenightinventoryservice.UserGame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class UserGameController {

    private final UserGameRepository repositoryI;

    public UserGameController(UserGameRepository repository) {
        this.repositoryI = repository;
    }

    @GetMapping("")
    public Iterable<UserGame> all() {
        return this.repositoryI.findAll();
    }

}
