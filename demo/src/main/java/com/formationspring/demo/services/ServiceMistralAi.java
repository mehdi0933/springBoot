package com.formationspring.demo.services;

import com.formationspring.demo.entity.EntityMistialAi;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServiceMistralAi {

    final IMistralAiRepository mistralAiRepository;

    public ServiceMistralAi(IMistralAiRepository mistralAiRepository) {
        this.mistralAiRepository = mistralAiRepository;
    }
    public void save (String promptMsg) {
        System.out.println("Saving promptMsg: " + promptMsg);
        EntityMistialAi entity = new EntityMistialAi();
        entity.setPromptMsg(promptMsg);
        entity.setSearchDateTime(LocalDateTime.now());
        mistralAiRepository.save(entity);
    }
}
