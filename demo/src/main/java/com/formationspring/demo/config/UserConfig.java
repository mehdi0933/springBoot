package com.formationspring.demo.config;

import com.formationspring.demo.entity.UserEntity;
import com.formationspring.demo.services.IUserDataAcces;
import com.formationspring.demo.services.IUserRepositoryJpa;
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
        return new IUserDataAcces() {

            private final Map<String, UserEntity> users;

            {
                this.users = new HashMap<>();
                users.put("1", new UserEntity(1L, "prenom 1", "nom 1"));
                users.put("2", new UserEntity(2L, "prenom 2", "nom 2"));
                users.put("3", new UserEntity(3L, "prenom 3", "nom 3"));
            }

            @Override
            public Map<String, UserEntity> getAllUsers() {
                return users;
            }
        };
    }

    @Bean
    public CommandLineRunner userSave() {
        return args -> {
            UserEntity user = new UserEntity(null, "prenom 1", "nom 1");
            userRepository.save(user);
        };
    }
}
