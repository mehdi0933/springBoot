package com.formationspring.demo.services;

import com.formationspring.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceUser {

    @Bean
    public Map<String, UserEntity> getAllUsers() {
       Map<String, UserEntity> users = new HashMap<>();
       users.put("1", new UserEntity(1L, "prenom1", "nom1"));
       return users;
    }





}
