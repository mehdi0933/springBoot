/**package com.formationspring.demo.services;

import com.formationspring.demo.entity.EntityMistialAi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class TestRunner implements CommandLineRunner {
    private final ServiceMistralAi service;
    private final EntityMistialAi entity;

    public TestRunner(ServiceMistralAi service, EntityMistialAi entity) {
        this.service = service;
        this.entity = entity;
    }

    @Override
    public void run(String... args) {
        service.save(String.valueOf(entity));

        System.out.println("Save done");
    }
}
*/