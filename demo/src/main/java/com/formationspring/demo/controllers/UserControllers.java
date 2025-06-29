package com.formationspring.demo.controller;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/")
public class UserControllers {

    private final UserService userService;

    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/true")
    public boolean vrai() {
        return true;
    }


    @GetMapping("/user")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/random")
    public ResponseEntity<Map<String, UserEntity>> getUserRandom() {
        Random random = new Random();
        List<UserEntity> users = userService.findAll();

        UserEntity randomUser = users.get(random.nextInt(users.size()));
        return ResponseEntity.ok(Map.of("user", randomUser));
    }

}
