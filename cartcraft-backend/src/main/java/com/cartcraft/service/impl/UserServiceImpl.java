package com.cartcraft.service.impl;

import com.cartcraft.entity.User;
import com.cartcraft.repository.UserRepository;
import com.cartcraft.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing User entities.
 * Handles business logic and delegates DB operations to UserRepository.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create a new user.
     * The createdAt and updatedAt timestamps are automatically set by the entity.
     */
    @Override
    public User createUser(User user) {
        user.setId(null); // Let DB handle ID generation
        return userRepository.save(user);
    }

    /**
     * Get a user by ID.
     */
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Get all users.
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Update an existing user.
     * Only name, email, and password are updated.
     * createdAt is ignored even if provided in request.
     */
    @Override
    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            // updatedAt is automatically updated by @PreUpdate
            return userRepository.save(existingUser);
        });
    }

    /**
     * Delete a user by ID.
     * Returns true if user existed and was deleted.
     */
    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
