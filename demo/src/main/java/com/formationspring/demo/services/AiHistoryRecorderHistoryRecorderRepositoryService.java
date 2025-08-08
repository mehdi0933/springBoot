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
    public void save(AiDto.PostInput input) {
        AiRecordEntity entity = new AiRecordEntity();
        entity.setPromptMsg(input.promptMsg());
        entity.setApiKey(input.apiKey());
        entity.setUrl(input.url());
        entity.setModel(input.model());
        entity.setSearchDateTime(LocalDateTime.now());
        entity.setDurationMs(input.durationMs());
        mistralAiRepository.save(entity);
    }




}
