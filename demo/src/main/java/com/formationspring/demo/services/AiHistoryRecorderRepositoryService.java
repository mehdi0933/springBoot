package com.formationspring.demo.services;

import com.formationspring.demo.DTO.AiDto;
import com.formationspring.demo.entity.AiRecordEntity;
import com.formationspring.demo.services.Interface.AiHistoryRecorderInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AiHistoryRecorderRepositoryService implements AiHistoryRecorderInterface {

    private final com.formationspring.demo.DAL.AiRepository AiRepository;

    public AiHistoryRecorderRepositoryService(com.formationspring.demo.DAL.AiRepository AiRepository) {

        this.AiRepository = AiRepository;
    }

    @Override
    public void save(AiDto inputDto) {
        AiRecordEntity entity = new AiRecordEntity();
        entity.setPromptMsg(inputDto.promptMsg());
        entity.setApiKey(inputDto.apiKey());
        entity.setUrl(inputDto.url());
        entity.setModel(inputDto.model());
        entity.setSearchDateTime(LocalDateTime.now());
        entity.setDurationMs(inputDto.durationMs());
        AiRepository.save(entity);
    }




}
