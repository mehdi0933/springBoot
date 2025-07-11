package com.formationspring.demo.services;

import com.formationspring.demo.entity.EntityMistialAi;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServiceMistralAi implements ISaveMistralAi{

    final IMistralAiRepository mistralAiRepository;

    public ServiceMistralAi(IMistralAiRepository mistralAiRepository) {
        this.mistralAiRepository = mistralAiRepository;
    }

    @Override
    public void save (String promptMsg,String apiKey, String url) {
        EntityMistialAi entity = new EntityMistialAi();
        entity.setPromptMsg(promptMsg);
        LocalDateTime searchDateTime = null;
        entity.setSearchDateTime(searchDateTime != null ? searchDateTime : LocalDateTime.now());
        entity.setApiKey(apiKey);
        entity.setUrl(url);
        mistralAiRepository.save(entity);
    }

}
