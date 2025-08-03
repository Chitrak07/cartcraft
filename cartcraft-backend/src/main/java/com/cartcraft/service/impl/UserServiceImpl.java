package com.cartcraft.service.impl;

import com.cartcraft.entity.User;
import com.cartcraft.repository.UserRepository;
import com.cartcraft.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UserService interface.
 * Handles business logic and interacts with the repository.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Constructor injection of UserRepository.
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Save a new user to the database.
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Find a user by ID using Optional.
     */
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Return a list of all users from the database.
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Update an existing user.
     * If a user with a given ID doesn't exist, throw an exception.
     */
    @Override
    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            // Update fields manually
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setUpdatedAt(LocalDateTime.now());

            return userRepository.save(existingUser);
        });
    }


    /**
     * Delete a user by ID.
     *
     * @return
     */
    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return false;
    }
}
