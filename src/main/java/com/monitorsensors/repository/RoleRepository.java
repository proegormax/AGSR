package com.monitorsensors.repository;

import com.monitorsensors.model.Role;
import com.monitorsensors.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}
