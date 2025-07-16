package com.formationspring.demo.controllers;

import com.formationspring.demo.services.IMistralAiRepository;
import com.formationspring.demo.services.ISaveMistralAi;
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

   private ISaveMistralAi saveMistralAi;

    public ControllersMistralAi(ISaveMistralAi saveMistralAi) {
        this.saveMistralAi = saveMistralAi;
    }

    @GetMapping("/ai")
    public ResponseEntity<String> search(@RequestParam String url,   @RequestParam String apiKey ) throws IOException, InterruptedException {

       // String apiKey = "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";

        String promptMsg = """
        {
            "model": "mistralai/mistral-7b-instruct:free",
            "messages": [
                { "role": "user", "content": "qui a gagne le plus de fois le grand prix de monaco en F1 ?" }
            ]
        }
        """;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization" , apiKey.trim())
                .POST(HttpRequest.BodyPublishers.ofString(promptMsg))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String apiResponse = response.body();

        saveMistralAi.save(promptMsg,apiKey, url);
        System.out.println(" la reponse de AI "+apiResponse);
        return ResponseEntity.ok(apiResponse + "\n" + LocalDateTime.now());
    }
}
