package com.example.boardgamenightinventoryservice;

import javax.persistence.*;

@Entity
@Table(name = "Games")
public class Game {  //needs work

    @Id
    @Column(name = "Game_ID") //renaming to match init.sql
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
