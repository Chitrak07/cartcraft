package com.cartcraft.service;

import com.cartcraft.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing User operations.
 */
public interface UserService {

    /**
     * Creates and saves a new user.
     *
     * @param user User object to save
     * @return Saved User
     */
    User createUser(User user);

    /**
     * Retrieves a user by ID.
     *
     * @param id ID of the user
     * @return Optional containing User if found
     */
    Optional<User> getUserById(Long id);

    /**
     * Retrieves all users.
     *
     * @return List of all users
     */
    List<User> getAllUsers();

    /**
     * Updates user details based on ID.
     *
     * @param id   ID of the user to update
     * @param user Updated user data
     * @return Updated User
     */
    Optional<User> updateUser(Long id, User user);

    /**
     * Deletes a user by ID.
     *
     * @param id ID of the user to delete
     * @return
     */
    boolean deleteUser(Long id);
}
