package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import java.util.List;

public interface IUserDataAcces {
    List<UserEntity> getAllUsers();
}
