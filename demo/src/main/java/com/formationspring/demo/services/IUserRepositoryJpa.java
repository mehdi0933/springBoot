package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepositoryJpa extends JpaRepository <UserEntity,Long> {
   
}
