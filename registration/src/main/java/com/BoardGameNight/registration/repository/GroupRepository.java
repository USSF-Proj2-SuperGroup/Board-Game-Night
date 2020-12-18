package com.BoardGameNight.registration.repository;

import com.BoardGameNight.registration.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByName(String name);
    Boolean existsByName(String name);
    @Query(value="INSERT INTRO users_groups(user_id, groups_id) VALUES(?1,?2)")
    Group joinGroup(String user_id, String groups_id);
}
