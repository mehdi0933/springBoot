package com.formationspring.demo.AiDpFactory;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import com.formationspring.demo.mapper.LlmAiMapper;
import com.formationspring.demo.services.Interface.LlmAiInterface;
import com.formationspring.demo.tools.AIHTTPAccessor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
@Component("mistral")
public class MistralDpFacoryy implements AIHTTPAccessor {

    private final LlmAiInterface llmAi;



    public MistralDpFacoryy(LlmAiInterface llmAi) {
        this.llmAi = llmAi;
    }


    public String aiReponse;

    @Override
    public String aiReponse() {
        return this.aiReponse;
    }

    public String promptMsg;
    @Override
    public String promptMsg() {
        return this.promptMsg;
    }
    @Override
    public String callAiAndStoreResult(LlmAiDto.PostInput postInput) throws IOException, InterruptedException {

        String apiKey = postInput.apiKey();
        String promptMsg = postInput.promptMsg();
        String url = postInput.url();
        String requestBody = """
        {
            "model": "mistralai/mistral-7b-instruct:free",
            "messages": [
                { "role": "user", "content": "%s" }
            ]
        }
        """.formatted( promptMsg);

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

        System.out.println(promptMsg);
        System.out.println("La réponse de AI : " + aiReponse);
        System.out.println("Durée de la requête : " + duration + "ms");

        return aiReponse + "\n" + LocalDateTime.now()  + "\n" + promptMsg;
    }
}
