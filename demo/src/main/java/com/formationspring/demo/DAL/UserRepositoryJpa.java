package com.formationspring.demo.DAL;

import com.formationspring.demo.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJpa extends JpaRepository <UsersEntity,Long> {

}
