package com.BoardGameNight.registration.repository;

import com.BoardGameNight.registration.model.GroupGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupGamesRepository extends JpaRepository<GroupGames, Long> {

}
