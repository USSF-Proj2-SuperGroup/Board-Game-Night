package com.example.boardgamenightinventoryservice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called InventoryRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long>{

    @Query(value="SELECT i FROM Inventory i WHERE User_ID = ?1") //Custom Query - get User's Inventory
    List<Inventory> findUserGames(Long userID);

    @Query(value="SELECT i FROM Inventory i WHERE User_ID = ?1 ORDER BY Game_Name") //Custom Query - sort User's Inventory
    List<Inventory> sortUserGames(Long userID);

    @Query(value="SELECT i FROM Inventory i WHERE User_ID = ?1 AND In_Game_Pool=True") //Custom Query - get User's Games That Are In Game Pool
    List<Inventory> filterUserGames(Long userID);

    @Modifying
    @Query(value="DELETE FROM Inventory WHERE User_ID = ?1 AND Game_ID = ?2") //Custom Query - delete User's Game from User's Inventory
    void deleteInventoryItem(Long userID, Long gameID);
}
