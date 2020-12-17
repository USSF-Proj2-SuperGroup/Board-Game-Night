//package com.example.boardgamenightinventoryservice;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name="User_Games")
//public class Inventory {
//
//    @Id
//    @Column(name="Inventory_ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long inventoryID;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "User_ID")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Game_Api_ID")
//    private Game game;
//
//    @Column(name = "In_Inventory")
//    private Boolean inInventory;
//
//    @Column(name = "In_Game_Pool")
//    private Boolean inGamePool;
//
//    @Column(name = "In_Wishlist")
//    private Boolean inWishlist;
//
//    public Long getInventoryID(){
//        return this.inventoryID;
//    }
//    public void setInventoryID(Long id){
//        this.inventoryID = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Game getGame() {
//        return game;
//    }
//    public void setGame(Game game) {
//        this.game = game;
//    }
//
//    public Boolean getInInventory() {
//        return inInventory;
//    }
//    public void setInInventory(Boolean inInventory) {
//        this.inInventory = inInventory;
//    }
//
//    public Boolean getInGamePool() {
//        return inGamePool;
//    }
//    public void setInGamePool(Boolean inGamePool) {
//        this.inGamePool = inGamePool;
//    }
//
//    public Boolean getInWishlist() {
//        return inWishlist;
//    }
//    public void setInWishlist(Boolean inWishlist) {
//        this.inWishlist = inWishlist;
//    }
//}
