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
public class HunyuanAiRestController {
    private LlmAiInterface LlmAi;

    public HunyuanAiRestController (LlmAiInterface LlmAi) {

        this.LlmAi = LlmAi;
    }

    @PostMapping("Hunyuan")
    public ResponseEntity<String> search (@RequestBody LlmAiDto.PostInput postInput) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();

        String url = postInput.url();
        String apiKey = postInput.apiKey();
        AiModel model = postInput.model();
        String promptMsg = postInput.promptMsg();



        String requestBody = """
    {
        "model": "%s",
        "messages": [
            { "role": "user", "content": "tencent/hunyuan-a13b-instruct:free" }
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
 *   "url": "https://openrouter.ai/api/v1/chat/completions",
 *   "model":  "HUNYUAN"
 * }
 */