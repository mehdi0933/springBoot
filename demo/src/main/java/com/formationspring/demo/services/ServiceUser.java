package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceUser implements IUserRepository {

    private final IUserRepositoryJpa userRepositoryJpa;

    public ServiceUser(IUserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public Map<String, UserEntity> getAllUsers() {
        Map<String, UserEntity> users = new HashMap<>();
        users.put("1", new UserEntity(1L, "prenom1", "nom1"));
        users.put("2", new UserEntity(2L, "prenom2", "nom2"));
        return users;
    }
}
