package com.cartcraft.controller;

import com.cartcraft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.cartcraft.entity.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the REST controller for managing User-related HTTP requests.
 * It maps endpoints to appropriate service methods.
 */

@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserService userService;

    // Constructor-based dependency injection of UserService
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to create a new user.
     * HTTP POST /api/users
     */

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser); // Return 200 OK with created user
    }
        /**
         * Endpoint to get all users.
         * HTTP GET /api/users
         */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users); // Return 200 Ok with list of Users
        }

        /**
         * Endpoint to update a user.
         * HTTP PUT /api/users/{id}
         */
        @PutMapping("/{id}")
        public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
            return userService.updateUser(id, user)
                    .map(ResponseEntity::ok) // If updated, return 200 OK with updated user
                    .orElse(ResponseEntity.notFound().build()); // Else, 404
        }

    /**
     * Endpoint to delete a user.
     * HTTP DELETE /api/users/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        boolean deleted = userService.deleteUser(id);
        if(deleted){
            return  ResponseEntity.noContent().build();  // 204 no content
        }else{
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }



}
