package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositoryJpa extends JpaRepository <UserEntity,Long> {

}
