package com.cartcraft.controller;

import com.cartcraft.entity.User;
import com.cartcraft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // -------------------- JSP ROUTES --------------------

    @GetMapping("/jsp/users")
    public String listUsers(Model model,
                            @RequestParam(defaultValue = "") String keyword,
                            @RequestParam(defaultValue = "id") String sortField,
                            @RequestParam(defaultValue = "asc") String sortDir) {

        model.addAttribute("users", userService.getAllUsers(keyword, sortField, sortDir));
        model.addAttribute("keyword", keyword);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "user-list";
    }


    @GetMapping("/jsp/users/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }


    @PostMapping("/jsp/users")
    public String createUserFromJsp(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/jsp/users";
    }

    @GetMapping("/jsp/users/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<User> userOpt = userService.getUserById(id);
        if (userOpt.isPresent()) {
            model.addAttribute("user", userOpt.get());
            return "user-edit";
        }
        return "redirect:/jsp/users";
    }

    @PostMapping("/jsp/users/update/{id}")
    public String updateUserFromJsp(@PathVariable Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/jsp/users";
    }

    @GetMapping("/jsp/users/delete/{id}")
    public String deleteUserFromJsp(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/jsp/users";
    }

    // -------------------- REST API ROUTES --------------------

    @GetMapping("/api/users")
    @ResponseBody
    public List<User> getAllUsersApi() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserByIdApi(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/users")
    @ResponseBody
    public User createUserApi(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/api/users/{id}")
    @ResponseBody
    public ResponseEntity<User> updateUserApi(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/api/users/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteUserApi(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
