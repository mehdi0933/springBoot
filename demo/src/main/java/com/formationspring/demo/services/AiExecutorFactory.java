package com.formationspring.demo.services;

import com.formationspring.demo.AiDpFactory.HunyuanDpFactory;
import com.formationspring.demo.AiDpFactory.MistralDpFacory;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.services.GenericAiExecutor;
import org.springframework.stereotype.Service;

@Service
public class AiExecutorFactory {

    private final MistralDpFacory mistralFactory;
    private final HunyuanDpFactory hunyuanFactory;

    public AiExecutorFactory(MistralDpFacory mistralFactory, HunyuanDpFactory hunyuanFactory) {
        this.mistralFactory = mistralFactory;
        this.hunyuanFactory = hunyuanFactory;
    }

    public GenericAiExecutor getExecutor(AiModel model) {
        return switch (model) {
            case MISTRAL -> new GenericAiExecutor(mistralFactory, model);
            case HUNYUAN -> new GenericAiExecutor(hunyuanFactory, model);
            default -> throw new IllegalArgumentException("Modèle inconnu : " + model);
        };
    }
}
