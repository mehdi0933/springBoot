package com.formationspring.demo;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.IUserRepositoryJpa;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final IUserRepositoryJpa userRepository;

    public DataInitializer(IUserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        UserEntity user = new UserEntity();
        user.setFirstName("nom 1");
        user.setLastName("prenom 1");

        userRepository.save(user);

        List<UserEntity> users = userRepository.findAll();
    }
}
