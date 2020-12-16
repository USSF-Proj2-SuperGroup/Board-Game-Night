package com.example.boardgamenightinventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//TODO: get current userID
// user ID will likely be passed in via HTTP response


@RestController
@RequestMapping("/inventory")
public class InventoryController {


    @Autowired
    private final InventoryRepository repository;

    public InventoryController(InventoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("") //Get Games by User:
    public Iterable<Game> all() {
        return this.repository.findUserGames(123);
    }

    @GetMapping("/sort") //Sort Inventory Alphabetically by Game Name:
    public Iterable<Game> sort() {
        return this.repository.sortUserGames(123);
    }

    @GetMapping("/filter") //Filter Inventory By In_Game_Pool:
    public Iterable<Game> filter() {
        return this.repository.filterUserGames(123);
    }

    @DeleteMapping("/delete") //Delete Inventory Items:
    public void delete() {
        this.repository.deleteInventoryItem(123, 123);
    }
}

//to change view based on header reference project: spring-json-endpoints-checkpoint
//to pass in json reference project: spring-json-endpoints
//for mysql reference project: mysql


// to connect in MySQL SQL Shell > \connect root@localhost:3309
// use mydb to connect to the game db
// show tables; to see a list of all tables in mydb
// describe <table name>; to see all of the columns in <table name>

//CREATE VIEW InventoryView AS
//SELECT ...
//FROM Games
//WHERE User_ID = <current user id>