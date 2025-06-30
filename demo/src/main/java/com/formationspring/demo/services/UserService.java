package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.IUserDataAcces;
import com.formationspring.demo.services.IUserRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserDataAcces {

    private final IUserRepositoryJpa userRepositoryJpa;
    private final IUserDataAcces userDataAcces;


    public UserService(IUserRepositoryJpa userRepositoryJpa, IUserDataAcces userDataAcces){
        this.userRepositoryJpa = userRepositoryJpa;
        this.userDataAcces = userDataAcces;
    }

    public List<UserEntity> findAll() {
        return userRepositoryJpa.findAll();
    }

    @Override
    public Map<String, UserEntity> getAllUsers() {
        return userDataAcces.getAllUsers();
    }
}
