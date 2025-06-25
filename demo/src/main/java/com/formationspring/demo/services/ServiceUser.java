package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
        users.put("1", new UserEntity(1L, "prenom 1", "nom 1"));
        users.put("2", new UserEntity(2L, "prenom 2", "nom 2"));
        users.put("3", new UserEntity(3L, "prenom 3", "nom 3"));
        return users;
    }

    @Override
    public Map<String, UserEntity> getAllUser() {
        List<UserEntity> userList = userRepositoryJpa.findAll();
        Map<String, UserEntity> users = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            UserEntity user = userList.get(i);
            users.put(String.valueOf(user.getId()), user);
        }
        return users;
    }
}
