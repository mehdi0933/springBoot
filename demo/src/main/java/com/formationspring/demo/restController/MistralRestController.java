package com.formationspring.demo.restController;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.mapper.LlmAiMapper;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.services.Interface.LlmAiInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class MistralRestController {

    private final LlmAiInterface LlmAi;

    public MistralRestController(LlmAiInterface LlmAi) {

        this.LlmAi = LlmAi;
    }

    @PostMapping("mistralai")
    public ResponseEntity<String> search (@RequestBody LlmAiDto.PostInput postInput) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();

        String url = postInput.url();
        String apiKey = postInput.apiKey();
        AiModel model = postInput.model();
        String promptMsg = postInput.promptMsg();


        String requestBody = """
    {
        "model": "mistralai/mistral-7b-instruct:free",
        "messages": [
            { "role": "user", "content": "%s" }
        ]
    }
    """.formatted(model.toString(), promptMsg);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey.trim())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String apiResponse = response.body();

        long end = System.currentTimeMillis();
        long duration = end - start;

        LlmAiDto fullDto = LlmAiMapper.fromInput(postInput);
        LlmAi.save(fullDto);


        System.out.println("La réponse de AI : " + apiResponse);
        return ResponseEntity.ok(apiResponse + "\n" + LocalDateTime.now());
    }

}
/**
 * {
 *   "promptMsg": "Quelle est la capitale de la France ?",
 *   "apiKey": "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",
 *   "url": "https://openrouter.ai/api/v1/chat/completions",
 *   "model": "MISTRAL_7B"
 * }
 */