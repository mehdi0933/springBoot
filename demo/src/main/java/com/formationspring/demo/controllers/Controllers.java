package com.formationspring.demo.controllers;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.IUserRepository;
import com.formationspring.demo.services.IUserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class Controllers {

    private final IUserRepository userRepository;
    private final IUserRepositoryJpa userRepositoryJpa;

    @Autowired
    public Controllers(IUserRepository userRepository, IUserRepositoryJpa userRepositoryJpa){
        this.userRepository = userRepository;
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @GetMapping("/true")
    public boolean vrai() {
        return true;
    }

    @GetMapping("/")
    public Map<String, UserEntity> getUserAll() {
        return userRepository.getAllUsers();
    }
    @GetMapping("/userRandom")
    public Map<String, UserEntity> getUserRandom() {
        Random random = new Random();
        List<UserEntity> users = List.of(
                new UserEntity(1L, "nom 1", "prenom 1"),
                new UserEntity(2L, "nom 2", "prenom 2"),
                new UserEntity(3L, "nom 3", "prenom 3")
        );

        UserEntity randomUser = users.get(random.nextInt(users.size()));
        return Map.of("user", randomUser);
    }

}
