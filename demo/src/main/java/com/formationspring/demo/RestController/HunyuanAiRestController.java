package com.formationspring.demo.RestController;
import com.formationspring.demo.DTO.LlmAiDto;
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
    private LlmAiInterface mistralService;

    public HunyuanAiRestController (LlmAiInterface mistralService) {
        this.mistralService = mistralService;
    }

    @GetMapping("Hunyuan")
    public ResponseEntity<String> search(
            @RequestParam String url,
            @RequestParam String apiKey,
            @RequestParam String promptMsg,
            @RequestParam String model
    ) throws IOException, InterruptedException {

        //String model = "https://openrouter.ai/api/v1/chat/completions";
        //String apiKey = "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";

        String requestBody = """
    {
        "model": "%s",
        "messages": [
            { "role": "user", "content": "%s" }
        ]
    }
    """.formatted(model, promptMsg);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", apiKey.trim())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String apiResponse = response.body();

        LlmAiDto.InputDto inputDto = new LlmAiDto.InputDto(promptMsg, apiKey, url, model);
        mistralService.save(inputDto);


        System.out.println("La réponse de AI : " + apiResponse);
        return ResponseEntity.ok(apiResponse + "\n" + LocalDateTime.now());
    }
}
