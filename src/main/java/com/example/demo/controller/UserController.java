package com.example.demo.controller;
import com.example.demo.model.PollManager;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final PollManager pollManager;

    // Constructor-based injection
    public UserController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return pollManager.getUser(username);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return pollManager.getAllUsers();  // Ensure PollManager has a getAllUsers method
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return pollManager.addUser(user);
    }

    @PutMapping("/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        // Update logic
        return pollManager.addUser(user); // Assuming username is unchanged
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        // Delete logic
    }
}
