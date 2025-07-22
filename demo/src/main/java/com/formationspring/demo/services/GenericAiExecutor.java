package com.formationspring.demo.services;

import com.formationspring.demo.AiDpFactory.AiGeneriqueDpFactory;
import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.services.Interface.AiModelExecutor;

public class GenericAiExecutor implements AiModelExecutor {

    private final AiModel model;
    private final AiGeneriqueDpFactory aiFactory;

    public GenericAiExecutor(AiGeneriqueDpFactory aiFactory, AiModel model) {
        this.aiFactory = aiFactory;
        this.model = model;
    }

    @Override
    public String execute(LlmAiDto.PostInput input) {
        try {
            return aiFactory.search(input);
        } catch (Exception e) {
            return "Erreur lors de l'appel AI : " + e.getMessage();
        }
    }

    public AiGeneriqueDpFactory getFactory() {
        return this.aiFactory;
    }
}
