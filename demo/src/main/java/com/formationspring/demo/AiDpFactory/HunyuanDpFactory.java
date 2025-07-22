package com.formationspring.demo.AiDpFactory;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.mapper.LlmAiMapper;
import com.formationspring.demo.services.Interface.LlmAiInterface;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
@Component
public class HunyuanDpFactory extends AiGeneriqueDpFactory {

    private final LlmAiInterface llmAi;

    public String url;
    public String apiKey;
    public AiModel model;
    public String promptMsg;
    public String aiReponse;

    public HunyuanDpFactory(LlmAiInterface llmAi) {
        this.llmAi = llmAi;
    }

    @Override
    public String url() {
        return this.url;
    }

    @Override
    public String apiKey() {
        return this.apiKey;
    }

    @Override
    public AiModel model() {
        return this.model;
    }

    @Override
    public String promptMsg() {
        return this.promptMsg;
    }
    @Override
    public String aiReponse() {
        return this.aiReponse;
    }

    @Override
    public String search(LlmAiDto.PostInput postInput) throws IOException, InterruptedException {

        String url = postInput.url();
        String apiKey = postInput.apiKey();
        AiModel model = postInput.model();
        String promptMsg = postInput.promptMsg();

        String requestBody = """
        {
            "model": "%s",
            "messages": [
                { "role": "user", "content": "%s" }
            ]
        }
        """.formatted(model.toString(), promptMsg);

        long start = System.currentTimeMillis();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey.trim())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
         this.aiReponse = response.body();

        long end = System.currentTimeMillis();
        long duration = end - start;

        LlmAiDto fullDto = LlmAiMapper.fromInput(postInput);
        llmAi.save(fullDto);

        System.out.println("La réponse de AI : " + this.aiReponse);
        System.out.println("Durée de la requête : " + duration + "ms");

        return this.aiReponse + "\n" + LocalDateTime.now();
    }
}
