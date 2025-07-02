package com.formationspring.demo.UserControllers;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

