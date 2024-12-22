package com.mentorat_virtuel.projet_mentorat_virtuel.controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.User;
import com.mentorat_virtuel.projet_mentorat_virtuel.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "user/add")
    ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.status(201).body(this.userService.addUser(user));
    }
}
