package com.formationspring.demo.services;

import com.formationspring.demo.DAL.LlmAiRepository;
import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.LlmAiRecordEntity;
import com.formationspring.demo.services.Interface.LlmAiInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LlmAiService implements LlmAiInterface {

    private final LlmAiRepository mistralAiRepository;

    public LlmAiService(LlmAiRepository mistralAiRepository) {
        this.mistralAiRepository = mistralAiRepository;
    }

    @Override
    public void save(LlmAiDto.InputDto inputDto) {
        LlmAiRecordEntity entity = new LlmAiRecordEntity();
        entity.setPromptMsg(inputDto.getPromptMsg());
        entity.setApiKey(inputDto.getApiKey());
        entity.setUrl(inputDto.getUrl());
        entity.setModel(inputDto.getModel());
        entity.setSearchDateTime(LocalDateTime.now());

        mistralAiRepository.save(entity);
    }
}
