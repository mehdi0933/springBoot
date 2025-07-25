package com.formationspring.demo.tools;

import com.formationspring.demo.AiDpFactory.HunyuanDpFactory;
import com.formationspring.demo.AiDpFactory.MistralDpFacoryy;
import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;

import java.io.IOException;

public interface AIHTTPAccessor {


    String aiReponse();
    String promptMsg();

    String callAiAndStoreResult(LlmAiDto.PostInput postInput)
            throws IOException, InterruptedException;

    static AIHTTPAccessor create(AiModel model,
                                 HunyuanDpFactory hunyuan,
                                 MistralDpFacoryy mistral) {
        return switch (model) {
            case HUNYUAN -> hunyuan;
            case MISTRAL -> mistral;
            default -> throw new IllegalArgumentException("Modèle inconnu ? : " + model);
        };
    }

}