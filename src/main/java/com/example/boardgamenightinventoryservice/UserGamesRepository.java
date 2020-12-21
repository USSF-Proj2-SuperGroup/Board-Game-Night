package com.example.boardgamenightinventoryservice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called InventoryRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserGamesRepository extends CrudRepository<UserGames, Integer>{

    @Query(value=
            "SELECT games.game_api_id, games.game_name " +
            "FROM user_games i " +
            "INNER JOIN games g " +
            "ON g.id = i.games_id " +
            "WHERE i.user_id = ?1",
            nativeQuery = true) //Custom Query - get User's Inventory
    List<UserGames> findUserGamesByUserId(Integer userID);

//    @Query(value=
//            "SELECT Games.apiId, Games.name " +
//            "FROM UserGames i " +
//            "INNER JOIN Games " +
//            "ON UserGames.gamesId = Games.id " +
//            "WHERE UserGames.userId = ?1") //Custom Query - sort User's Inventory
//    List<UserGames> sortUserGames(Integer userID, Sort sort);
//
//    @Query(value="SELECT i FROM UserGames i WHERE userId = ?1 AND In_Game_Pool=True") //Custom Query - get User's Games That Are In Game Pool
//    List<UserGames> filterUserGames(Integer userID); //join user_groups, user_games, group_games, games
//
//    @Modifying
//    @Query(value="DELETE FROM UserGames WHERE userId = ?1 AND Game_ID = ?2") //Custom Query - delete User's Game from User's Inventory
//    void deleteInventoryItem(Integer userID, Integer gameID);
}
