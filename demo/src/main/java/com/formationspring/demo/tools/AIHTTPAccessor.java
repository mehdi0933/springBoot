package com.formationspring.demo.tools;

import com.formationspring.demo.AiDpFactory.HunyuanDpFactory;
import com.formationspring.demo.AiDpFactory.MistralDpFacory;
import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;

import java.io.IOException;

public interface AIHTTPAccessor {

    String url();
    String apiKey();
    AiModel model();
    String promptMsg();
    String aiReponse();

    String callAiAndStoreResult(LlmAiDto.PostInput postInput)
            throws IOException, InterruptedException;

    static AIHTTPAccessor create(AiModel model,
                                 HunyuanDpFactory hunyuan,
                                 MistralDpFacory mistral) {
        return switch (model) {
            case HUNYUAN -> hunyuan;
            case MISTRAL -> mistral;
            default -> throw new IllegalArgumentException("Modèle inconnu : " + model);
        };
    }
}
