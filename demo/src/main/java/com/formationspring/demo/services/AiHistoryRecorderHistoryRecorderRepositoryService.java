package com.formationspring.demo.services;

import com.formationspring.demo.dal.AiRepository;
import com.formationspring.demo.dto.dtoentity.AiDto;
import com.formationspring.demo.entity.AiRecordEntity;
import com.formationspring.demo.services.Interface.AiHistoryRecorderInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AiHistoryRecorderHistoryRecorderRepositoryService implements AiHistoryRecorderInterface {

    private final AiRepository mistralAiRepository;

    public AiHistoryRecorderHistoryRecorderRepositoryService(AiRepository mistralAiRepository) {

        this.mistralAiRepository = mistralAiRepository;
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
        mistralAiRepository.save(entity);
    }




}
