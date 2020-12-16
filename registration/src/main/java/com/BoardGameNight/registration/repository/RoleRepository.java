package com.BoardGameNight.registration.repository;

import com.BoardGameNight.registration.model.ERole;
import com.BoardGameNight.registration.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}