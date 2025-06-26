package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final IUserRepositoryJpa userRepositoryJpa;


    public UserService(IUserRepositoryJpa userRepositoryJpa){
        this.userRepositoryJpa = userRepositoryJpa;
    }


    public UserEntity save(UserEntity user) {
        return userRepositoryJpa.save(user);
    }

    public List<UserEntity> findAll() {
        return userRepositoryJpa.findAll();
    }

    public void run(String... args) {
        UserEntity user = new UserEntity();
        user.setFirstName("prenom 1");
        user.setLastName("nom 1");

        userRepositoryJpa.save(user);

    }

}
