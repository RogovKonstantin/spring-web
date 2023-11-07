package com.example.demo.repos;


import com.example.demo.models.User;
import com.example.demo.web.views.UserMV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT new com.example.demo.web.views.UserMV(u.firstName,u.lastName,u.username,u.imageUrl,r.role as role) FROM User u JOIN UserRole r ON u.role.id = r.id WHERE u.active=true")
    List<UserMV> findAllActiveUsers();

    @Query(value = "SELECT new com.example.demo.web.views.UserMV(u.firstName,u.lastName,u.username,u.imageUrl,r.role as role) FROM User u JOIN UserRole r ON u.role.id = r.id WHERE u.active=false")
    List<UserMV> findAllUnActiveUsers();


    void deleteUserByUsername(String username);

    User findByUsername(String username);




}
