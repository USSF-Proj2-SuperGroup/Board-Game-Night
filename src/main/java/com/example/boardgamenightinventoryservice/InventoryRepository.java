package com.example.boardgamenightinventoryservice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called InventoryRepository
// CRUD refers Create, Read, Update, Delete
public interface InventoryRepository extends CrudRepository<Inventory, Long>{

    @Query(value="SELECT * FROM Games WHERE User_ID = ?1") //Custom Query - get User's Inventory
    List<Game> findUserGames(int userID);

    @Query(value="SELECT * FROM Games WHERE User_ID = ?1 ORDER BY Game_Name") //Custom Query - sort User's Inventory
    List<Game> sortUserGames(int userID);

    @Query(value="SELECT * FROM Games WHERE User_ID = ?1 AND In_Game_Pool=1") //Custom Query - get User's Games That Are In Game Pool
    List<Game> filterUserGames(int userID);

    @Modifying
    @Query(value="DELETE FROM Games WHERE User_ID = ?1 AND Game_ID = ?2") //Custom Query - delete User's Game from User's Inventory
    void deleteInventoryItem(int userID, int gameID);
}
