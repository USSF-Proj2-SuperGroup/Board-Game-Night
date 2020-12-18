package com.BoardGameNight.registration.repository;

import com.BoardGameNight.registration.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByName(String name);
    Boolean existsByName(String name);
}
