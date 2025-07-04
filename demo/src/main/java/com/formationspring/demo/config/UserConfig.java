package com.formationspring.demo.config;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.IUserDataAcces;
import com.formationspring.demo.services.IUserRepositoryJpa;
import com.formationspring.demo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class UserConfig {
    private final IUserRepositoryJpa userRepository;

    public UserConfig(IUserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public IUserDataAcces userDataAcces() {
        return new UserService(userRepository);
    }

    @Bean
    public CommandLineRunner userSave() {
        return args -> {
            userRepository.save(new UserEntity(null, "prenom 1", "nom 1"));
            userRepository.save(new UserEntity(null, "prenom 2", "nom 2"));
            userRepository.save(new UserEntity(null, "prenom 3", "nom 3"));
        };
    }

}
