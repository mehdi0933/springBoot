package com.formationspring.demo.services;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.services.Interface.AiModelExecutor;
import com.formationspring.demo.tools.AIHTTPAccessor;
import com.formationspring.demo.AiDpFactory.HunyuanDpFactory;
import com.formationspring.demo.AiDpFactory.MistralDpFacory;

import java.io.IOException;

public class GenericAiExecutor implements AiModelExecutor {

    private final AiModel model;
    private final AIHTTPAccessor aiAccessor;

    public GenericAiExecutor(AiModel model, HunyuanDpFactory hunyuanFactory, MistralDpFacory mistralFactory) {
        this.model = model;
        this.aiAccessor = AIHTTPAccessor.create(model, hunyuanFactory, mistralFactory);
    }

    @Override
    public String execute(LlmAiDto.PostInput input) {
        try {
            return aiAccessor.callAiAndStoreResult(input);
        } catch (IOException | InterruptedException e) {
            return "Erreur lors de l'appel AI : " + e.getMessage();
        }
    }

    public AIHTTPAccessor getAccessor() {
        return this.aiAccessor;
    }
}
