package com.formationspring.demo.services;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.tools.AIHTTPAccessor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Service
public class AiExecutorFactory {

    private final Map<String, AIHTTPAccessor> accessorMap;

     public AiExecutorFactory(Map<String, AIHTTPAccessor> accessorMap) {
        this.accessorMap = new HashMap<>();
        for (Map.Entry<String, AIHTTPAccessor> entry : accessorMap.entrySet()) {
            this.accessorMap.put(entry.getKey().toUpperCase(), entry.getValue());
        }
    }

    public String executeAi(AiModel model, LlmAiDto.PostInput input)
            throws IOException, InterruptedException {
        AIHTTPAccessor accessor = accessorMap.get(model.name());
        if (accessor == null) {
            throw new IllegalArgumentException("Modèle inconnu : " + model);
        }
        return accessor.callAiAndStoreResult(input);
    }
}
