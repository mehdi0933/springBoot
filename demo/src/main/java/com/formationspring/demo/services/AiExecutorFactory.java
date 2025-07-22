package com.formationspring.demo.services;

import com.formationspring.demo.entity.enums.AiModel;
import org.springframework.stereotype.Service;

@Service
public class AiExecutorFactory {

    private final LlmAiService llmAiService;

    public AiExecutorFactory(LlmAiService llmAiService) {
        this.llmAiService = llmAiService;
    }

    public GenericAiExecutor getExecutor(AiModel model) {
        return new GenericAiExecutor(llmAiService, model);
    }
}
