package com.example.boardgamenightinventoryservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GamesRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByName(String name);
    Boolean existsByName(String name);

}