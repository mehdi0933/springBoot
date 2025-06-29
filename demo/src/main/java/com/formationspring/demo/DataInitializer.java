package com.formationspring.demo;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.IUserRepositoryJpa;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final IUserRepositoryJpa userRepository;
    private final UserEntity UserEntity;

    public DataInitializer(IUserRepositoryJpa userRepository, UserEntity UserEntity) {
        this.userRepository = userRepository;
        this.UserEntity = UserEntity;
    }

    @Override
    public void run(String... args) {
        userRepository.save(UserEntity);
    }
}
