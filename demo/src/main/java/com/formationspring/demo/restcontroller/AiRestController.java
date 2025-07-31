package com.formationspring.demo.restcontroller;

import com.formationspring.demo.DTO.AiDto;
import com.formationspring.demo.services.AiRequestHandlerService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class AiRestController {

    private final AiRequestHandlerService aiRequestHandlerService;

    public AiRestController(AiRequestHandlerService aiRequestHandlerService) {
        this.aiRequestHandlerService = aiRequestHandlerService;
    }

    @PostMapping("/search")
    public String search( @RequestBody AiDto.PostInput input) throws IOException, InterruptedException  {
        return aiRequestHandlerService.sendAiAPIRequest(input);
    }

    @GetMapping("/cache")
    public Object getCacheValue() {
        Object cachedValue = aiRequestHandlerService.getFromCache();
        if (cachedValue == null) {
            return "Pas de cache pour la clé : ";
        }
        return cachedValue;
    }

    @DeleteMapping("/clear-cache")
    public String clearCache() {
        aiRequestHandlerService.clearCache();
        return "Cache vidé";
    }
}


/**
 * URL http://localhost:8080/ai/cache
 * le resutat de de la console quand on met URL, get sur postman
 * {"id":"gen-1753922482-w1gVvANyacEKFQDzJvI4","provider":"DeepInfra",
 * "model":"mistralai/mistral-7b-instruct:free","object":"chat.completion","created":1753922482,"choices":
 * [{"logprobs":null,"finish_reason":"stop","native_finish_reason":"stop",
 * "index":0,"message":
 * {"role":"assistant","content":" La capitale des États-Unis est Washington, D.C. Cependant, Washington,
 * D.C. n'est pas un штат des États-Unis, mais un territoire fédéral,
 * même si elle est située dans l'État de Maryland pour les questions non-fédérales
 * (comme le vote présidentiel électoral ou les lois du congrès sur les impots et les droits de douane).
 * Elle est nommée ainsi en l'honneur de George Washington, le premier Président des États-Unis.","refusal":null,
 * "reasoning":null}}],
 * "usage":{"prompt_tokens":15,"completion_tokens":117,"total_tokens":132,"prompt_tokens_details":null}}
 */