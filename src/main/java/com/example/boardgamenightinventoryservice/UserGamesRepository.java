package com.example.boardgamenightinventoryservice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

// This will be AUTO IMPLEMENTED by Spring into a Bean called InventoryRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserGamesRepository extends JpaRepository<UserGames, Integer>{

    @Query(value=
            "SELECT games.game_api_id, games.game_name " +
            "FROM user_games " +
            "INNER JOIN games " +
            "ON games.id = user_games.games_id " +
            "WHERE user_games.user_id = ?1",
            nativeQuery = true) //Custom Query - get User's Inventory
    List<Object[]> findUserGames(Integer userID);

    @Query(value=
            "SELECT games.game_api_id, games.game_name " +
            "FROM user_games " +
            "INNER JOIN games " +
            "ON games.id = user_games.games_id " +
            "WHERE user_games.user_id = ?1 " +
            "ORDER BY games.game_name",
            nativeQuery = true) //Custom Query - sort User's Inventory
    List<Object[]> sortUserGames(Integer userID);

//    @Query(value="SELECT i FROM UserGames i WHERE userId = ?1 AND In_Game_Pool=True") //Custom Query - get User's Games That Are In Game Pool
//    List<UserGames> filterUserGames(Integer userID); //join user_groups, user_games, group_games, games
//
//    @Modifying
//    @Query(value="DELETE FROM UserGames WHERE userId = ?1 AND Game_ID = ?2") //Custom Query - delete User's Game from User's Inventory
//    void deleteInventoryItem(Integer userID, Integer gameID);
}
