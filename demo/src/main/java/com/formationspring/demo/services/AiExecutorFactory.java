package com.formationspring.demo.services;

import com.formationspring.demo.AiDpFactory.HunyuanDpFactory;
import com.formationspring.demo.AiDpFactory.MistralDpFacory;
import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.tools.AIHTTPAccessor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AiExecutorFactory {

    private final HunyuanDpFactory hunyuanFactory;
    private final MistralDpFacory mistralFactory;


    public AiExecutorFactory(HunyuanDpFactory hunyuanFactory, MistralDpFacory mistralFactory) {
        this.hunyuanFactory = hunyuanFactory;
        this.mistralFactory = mistralFactory;
    }

    public String executeAi(AiModel model, LlmAiDto.PostInput postInput) throws IOException, InterruptedException {
        AIHTTPAccessor accessor = AIHTTPAccessor.create(model, hunyuanFactory, mistralFactory);
        return accessor.callAiAndStoreResult(postInput);
    }
}
