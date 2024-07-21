package com.copilot.codathon.challenge1.controllers;

import com.copilot.codathon.challenge1.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> fetchUsers() {
        String users = userService.fetchUsers();
        return ResponseEntity.ok(users);
    }
}