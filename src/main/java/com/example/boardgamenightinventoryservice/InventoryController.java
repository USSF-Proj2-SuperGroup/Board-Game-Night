package com.example.boardgamenightinventoryservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryRepository repository;

    public InventoryController(InventoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")//get all items in inventory for current user
    public Iterable<Inventory> all() {
        return this.repository.findAll();
    }

    //Sort Inventory Alphabetically by Game Name:
    //SELECT * FROM InventoryView ORDER BY Game_Name;

    //Filter Inventory By In_Game_Pool
    //SELECT * FROM InventoryView WHERE In_Game_Pool=1;

    //Delete Inventory Items
    //DELETE FROM Games WHERE User_ID = <current user> AND Game_ID = <selected game>;
}


//to change view based on header reference project: spring-json-endpoints-checkpoint
//to pass in json reference project: spring-json-endpoints
//for mysql reference project: mysql


// to connect in MySQL SQL Shell > \connect root@localhost:3309
// \use mydb to connect to the game db
// show tables; to see a list of all tables in mydb
// describe <table name>; to see all of the columns in <table name>

//CREATE VIEW InventoryView AS
//SELECT ...
//FROM Games
//WHERE User_ID = <current user id>