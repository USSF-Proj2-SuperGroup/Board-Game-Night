package com.example.boardgamenightinventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//TODO: get current userID
// user ID will likely be passed in via HTTP response...

@RestController
@RequestMapping("/inventory")
public class UserGamesController {

    @Autowired
    private final UserGamesRepository repository;

    private Integer currentUserID = 4; // read local storage on client-side with JS, then pass it back to the server-side

    public UserGamesController(UserGamesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all") //Get Games by User:
    public Iterable<Object[]> all() {
        return this.repository.findUserGames(currentUserID);
    }

    @GetMapping("/sort") //Sort Inventory Alphabetically by Game Name:
    public Iterable<Object[]> sort() {
        return this.repository.sortUserGames(currentUserID);
    }

//    @GetMapping("/filter") //Filter Inventory By In_Game_Pool:
//    public Iterable<UserGames> filter() {
//        return this.repository.filterUserGames(currentUserID);
//    }

//    @DeleteMapping("/delete/{gameID}") //Delete Inventory Item By Game ID:
//    public void delete(@PathVariable("gameID") Integer gameID) {
//        this.repository.deleteInventoryItem(currentUserID, gameID);
//    }
}

//to change view based on header reference project: spring-json-endpoints-checkpoint
//to pass in json reference project: spring-json-endpoints
//for mysql reference project: mysql

// to connect in MySQL SQL Shell > \connect root@localhost:3309
// use mydb to connect to the game db
// show tables; to see a list of all tables in mydb
// describe <table name>; to see all of the columns in <table name>