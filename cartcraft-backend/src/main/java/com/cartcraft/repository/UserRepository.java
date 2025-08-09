package com.cartcraft.repository;

import com.cartcraft.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // Marks this interface as a Spring repository component
public interface UserRepository extends JpaRepository<User, Long> {

    // Finds a user by their email, used in authentication or profile lookups
    Optional<User> findByEmail(String email);
}

