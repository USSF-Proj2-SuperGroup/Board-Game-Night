package com.example.boardgamenightinventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Collectors;

//TODO: get current userID
// user ID will likely be passed in via HTTP response...

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private final InventoryRepository repository;

    private Long currentUserID;

    public InventoryController(InventoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-cookies")
    public String readAllCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
        }
        return "No cookies";
    }

    @GetMapping("")
    public void readCookie(@CookieValue(value = "userID", defaultValue = "1") Long userID) {
        currentUserID = userID;
    }

    @GetMapping("/all") //Get Games by User:
    public Iterable<Game> all() {
        return this.repository.findUserGames(currentUserID);
    }

    @GetMapping("/sort") //Sort Inventory Alphabetically by Game Name:
    public Iterable<Game> sort() {
        return this.repository.sortUserGames(currentUserID);
    }

    @GetMapping("/filter") //Filter Inventory By In_Game_Pool:
    public Iterable<Game> filter() {
        return this.repository.filterUserGames(currentUserID);
    }

    @DeleteMapping("/delete/{gameID}") //Delete Inventory Item By Game ID:
    public void delete(@PathVariable("gameID") Long gameID) {
        this.repository.deleteInventoryItem(currentUserID, gameID);
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