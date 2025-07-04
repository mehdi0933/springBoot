package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserDataAcces {

    private final IUserRepositoryJpa userRepositoryJpa;

    public UserService(IUserRepositoryJpa userRepositoryJpa){
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepositoryJpa.findAll();
    }

    @Override
    public List<UserEntity> saveAllUsers(List<UserEntity> users) {
            return (List<UserEntity>) userRepositoryJpa.saveAll(users);
    }


}

