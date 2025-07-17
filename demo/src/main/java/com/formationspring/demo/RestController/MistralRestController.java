package com.formationspring.demo.RestController;

import com.formationspring.demo.DTO.MistralDto;
import com.formationspring.demo.services.Interface.MistralInterface;
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

    private final MistralInterface mistralService;

    public MistralRestController(MistralInterface mistralService) {
        this.mistralService = mistralService;
    }

    @GetMapping("ai")
    public ResponseEntity<String> search(
            @RequestParam String url,
            @RequestParam String apiKey,
            @RequestParam String promptMsg
    ) throws IOException, InterruptedException {

        String model = "mistralai/mistral-7b-instruct:free";

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

        MistralDto.MistralInputDto inputDto = new MistralDto.MistralInputDto(promptMsg, apiKey, url, model);
        mistralService.save(inputDto);


        System.out.println("La réponse de AI : " + apiResponse);
        return ResponseEntity.ok(apiResponse + "\n" + LocalDateTime.now());
    }

}
