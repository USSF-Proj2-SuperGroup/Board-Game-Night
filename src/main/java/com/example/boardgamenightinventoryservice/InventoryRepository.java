//package com.example.boardgamenightinventoryservice;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//// This will be AUTO IMPLEMENTED by Spring into a Bean called InventoryRepository
//// CRUD refers Create, Read, Update, Delete
//@Repository
//public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
//
//    @Query(value="SELECT i FROM Inventory i WHERE Inventory.User.userID = ?1") //Custom Query - get User's Inventory
//    List<Inventory> findUserGames(Integer userID);
//
//    @Query(value="SELECT i FROM Inventory i WHERE User_ID = ?1 ORDER BY Game_Name") //Custom Query - sort User's Inventory
//    List<Inventory> sortUserGames(Integer userID);
//
////    @Query(value="SELECT i FROM User_Games i WHERE i.User_ID = ?1 AND i.In_Game_Pool = true", nativeQuery = true) //Custom Query - get User's Games That Are In Game Pool
////    List<Inventory> filterUserGames(Integer userID);
//
//    @Modifying
//    @Query(value="DELETE FROM Inventory WHERE User_ID = ?1 AND Game_Api_ID = ?2") //Custom Query - delete User's Game from User's Inventory
//    void deleteInventoryItem(Integer userID, String gameID);
//}
