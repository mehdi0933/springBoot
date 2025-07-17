package com.formationspring.demo.services;

import com.formationspring.demo.DAL.MistralAiRepository;
import com.formationspring.demo.DTO.MistralDto;
import com.formationspring.demo.entity.MistralRecordEntity;
import com.formationspring.demo.services.Interface.MistralInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MistralService implements MistralInterface {

    private final MistralAiRepository mistralAiRepository;

    public MistralService(MistralAiRepository mistralAiRepository) {
        this.mistralAiRepository = mistralAiRepository;
    }

    @Override
    public void save(MistralDto.MistralInputDto inputDto) {
        MistralRecordEntity entity = new MistralRecordEntity();
        entity.setPromptMsg(inputDto.getPromptMsg());
        entity.setApiKey(inputDto.getApiKey());
        entity.setUrl(inputDto.getUrl());
        entity.setModel(inputDto.getModel());
        entity.setSearchDateTime(LocalDateTime.now());

        mistralAiRepository.save(entity);
    }
}
