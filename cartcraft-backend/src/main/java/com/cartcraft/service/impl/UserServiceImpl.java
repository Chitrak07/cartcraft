package com.cartcraft.service.impl;

import com.cartcraft.entity.User;
import com.cartcraft.repository.UserRepository;
import com.cartcraft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // REPLACE the old getAllUsers() method with this one
    @Override
    public List<User> getAllUsers(String keyword, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();

        if (keyword != null && !keyword.isEmpty()) {
            return userRepository.search(keyword, sort);
        }
        return userRepository.findAll(sort);
    }

    // ... rest of the methods remain the same
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(existing -> {
            updatedUser.setId(id);
            updatedUser.setCreatedAt(existing.getCreatedAt());
            updatedUser.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(updatedUser);
        });
    }

    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return false;
    }
}