package com.example.kello_demo_app.controller;

import com.example.kello_demo_app.model.User;
import com.example.kello_demo_app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    // Get user
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<User> getAll(@RequestParam(required = false) String team) {
        if (team == null || team.equalsIgnoreCase("ALL")) {
            return userService.findAll();
        }
        return userService.findByTeam(team);
    }

    // Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saved = userService.createUser(user);
        return ResponseEntity.created(URI.create("/api/users/" + saved.getId()))
                .body(saved);
    }
}
