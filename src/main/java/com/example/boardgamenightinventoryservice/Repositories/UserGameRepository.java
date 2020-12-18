package com.example.boardgamenightinventoryservice.Repositories;

import com.example.boardgamenightinventoryservice.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGameRepository extends JpaRepository<UserGame, Integer> {
}
