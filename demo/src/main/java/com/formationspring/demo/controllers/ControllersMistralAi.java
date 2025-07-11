package com.formationspring.demo.controllers;

import com.formationspring.demo.services.ServiceMistralAi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@RestController
@RequestMapping("")
public class ControllersMistralAi {

    private final ServiceMistralAi serviceMistralAi;

    public ControllersMistralAi(ServiceMistralAi serviceMistralAi) {
        this.serviceMistralAi = serviceMistralAi;
    }

    @GetMapping("/ai")
    public ResponseEntity<String> search(@RequestParam String promptMsg,   @RequestParam String apiKey ) throws IOException, InterruptedException {

        String url = "https://openrouter.ai/api/v1/chat/completions";
       // String apiKey = "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";

        String requestBody = """
        {
            "model": "mistralai/mistral-7b-instruct:free",
            "messages": [
                { "role": "user", "content": "%s" }
            ]
        }
        """.formatted(promptMsg);
        System.out.println(promptMsg);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", apiKey.trim())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String apiResponse = response.body();
        serviceMistralAi.save(promptMsg,apiKey, url);



        return ResponseEntity.ok(apiResponse + "\n" + LocalDateTime.now());
    }
}
