package com.formationspring.demo.controllers;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.IUserDataAcces;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserControllers {

    private final IUserDataAcces userService;

    public UserControllers(IUserDataAcces userService) {
        this.userService = userService;
    }

    @GetMapping("/users/get")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users/post")
    public ResponseEntity<List<UserEntity>> saveAllUsers(@RequestBody List<UserEntity> users) {
        List<UserEntity> savedUsers = userService.saveAllUsers(users);
        return ResponseEntity.ok(savedUsers);
    }

}

