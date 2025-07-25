package com.formationspring.demo.services;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.tools.AIHTTPAccessor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AiService {

    private final Map<String, AIHTTPAccessor> accessorMap;

    // Spring injecte automatiquement tous les beans AIHTTPAccessor sous forme d'une Map <nomBean, bean>
    public AiService(Map<String, AIHTTPAccessor> accessorMap) {
        // On convertit les clés en majuscules (ou autre logique) pour matcher AiModel.name()
        this.accessorMap = accessorMap.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey().toUpperCase(),
                        Map.Entry::getValue
                ));
    }

    public String callAi(AiModel model, LlmAiDto.PostInput input) {
        AIHTTPAccessor accessor = accessorMap.get(model.name());
        if (accessor == null) {
            return "Modèle inconnu !";
        }
        try {
            return accessor.callAiAndStoreResult(input);
        } catch (Exception e) {
            return "Erreur serveur : " + e.getMessage();
        }
    }
}
