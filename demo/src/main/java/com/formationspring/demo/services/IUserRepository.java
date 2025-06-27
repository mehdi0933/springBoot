package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;

import java.util.Map;

public interface IUserRepository {
    Map<String, UserEntity> getAllUsers();
    Map<String, UserEntity> getAllUser();
}
