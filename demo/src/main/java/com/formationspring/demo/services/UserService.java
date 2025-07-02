package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
}

