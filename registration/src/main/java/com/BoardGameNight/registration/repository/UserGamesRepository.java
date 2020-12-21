package com.BoardGameNight.registration.repository;

import com.BoardGameNight.registration.model.Games;
import com.BoardGameNight.registration.model.UserGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGamesRepository extends JpaRepository<UserGames, Long> {
    Boolean existsByGamesU(Games gameId);
}
