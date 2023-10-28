package com.example.demo.repos;



import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value="SELECT u FROM User u JOIN UserRole r ON u.role.id = r.id WHERE u.isActive=true")
    List<User> getAllActiveClients();




}
