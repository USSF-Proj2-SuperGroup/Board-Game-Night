package com.BoardGameNight.registration.repository;

import com.BoardGameNight.registration.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {
    Boolean existsByGameApiId(String game_api_id);
}