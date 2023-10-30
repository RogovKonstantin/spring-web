package com.example.demo.repos;


import com.example.demo.constants.Enums.Role;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
    UserRole findByRole(Role role);
}
