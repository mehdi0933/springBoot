package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IUserRepository {
    Map<String, UserEntity> getAllUsers();
    Map<String, UserEntity> getAllUser();
}
