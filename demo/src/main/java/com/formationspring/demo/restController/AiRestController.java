package com.formationspring.demo.restController;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.services.AiExecutorFactory;
import com.formationspring.demo.services.AiExecutorReponseFactory;
import com.formationspring.demo.services.GenericAiExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AiRestController {

    private final AiExecutorFactory aiExecutorFactory;

    public AiRestController(AiExecutorFactory aiExecutorFactory) {
        this.aiExecutorFactory = aiExecutorFactory;
    }

    @PostMapping("/search")
    public String search(@RequestBody LlmAiDto.PostInput input) {
        System.out.println(" promptMsg : " + input.promptMsg());
        try {
            String result = aiExecutorFactory.executeAi(input.model(), input);

            return result;
        } catch (IllegalArgumentException e) {
            return ("Modèle inconnu !");
        } catch (Exception e) {
            return ("Erreur serveur : " + e.getMessage());
        }
    }

}
/**
 *
 * http://localhost:8080/ai/search
 * {
 *   "promptMsg": "Quelle est la capitale de la USA ?",
 *   "apiKey": "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",
 *   "url": "https://openrouter.ai/api/v1/chat/completions",
 *   "model": "MISTRAL"
 * }
 * {
 *   "promptMsg": "Quelle est la capitale de la France ? reponse en francais",
 *   "apiKey": "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",
 *   "url": "https://openrouter.ai/api/v1/chat/completions",
 *   "model":  "HUNYUAN"
 * }
 */