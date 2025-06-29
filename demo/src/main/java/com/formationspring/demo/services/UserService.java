package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserDataAcces {

    private final IUserRepositoryJpa userRepositoryJpa;


    public UserService(IUserRepositoryJpa userRepositoryJpa){
        this.userRepositoryJpa = userRepositoryJpa;
    }



    public List<UserEntity> findAll() {
        return userRepositoryJpa.findAll();
    }


    @Override
    public Map<String, UserEntity> getAllUsers() {
        List<UserEntity> userList = userRepositoryJpa.findAll();
        Map<String, UserEntity> users = new HashMap<>();
        for (UserEntity user : userList) {
            users.put(String.valueOf(user.getId()), user);
        }
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
