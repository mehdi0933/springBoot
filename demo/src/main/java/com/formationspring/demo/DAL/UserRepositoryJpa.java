package com.formationspring.demo.DAL;

import com.formationspring.demo.entity.UserDataAccesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository <UserDataAccesEntity,Long> {

}
