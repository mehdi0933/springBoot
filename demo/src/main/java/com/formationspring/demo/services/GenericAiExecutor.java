package com.formationspring.demo.services;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.services.Interface.AiModelExecutor;

public class GenericAiExecutor implements AiModelExecutor {

    private final AiModel model;

    public GenericAiExecutor(LlmAiService llmAiService, AiModel model) {
        this.model = model;
    }

    @Override
    public String execute(LlmAiDto.PostInput input) {
        switch (model) {
            case MISTRAL:
                return executeMistral(input.promptMsg());
            case HUNYUAN:
                return executeHunyuan(input.promptMsg());
            default:
                return "Modèle inconnu : " + model;
        }
    }

    private String executeMistral(String promptMsg) {
        return "Mistral répond à : " + promptMsg;
    }

    private String executeHunyuan(String promptMsg) {
        return "Hunyuan répond à : " + promptMsg;
    }
}
