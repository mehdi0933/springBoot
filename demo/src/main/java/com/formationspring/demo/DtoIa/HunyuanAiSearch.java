package com.formationspring.demo.DtoIa;

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

@Component("hunyuan")
public class HunyuanAiSearch extends AbstractAiSearch {

    private final LlmAiInterface llmAi;

    public HunyuanAiSearch(LlmAiInterface llmAi) {
        this.llmAi = llmAi;
    }
    @Override
    public AiModel getModel() {
        return AiModel.HUNYUAN;
    }

    @Override
    public String callAip(LlmAiDto.PostInput postInput) throws IOException, InterruptedException {

        String url = postInput.url();
        String apiKey = postInput.apiKey();
        String promptMsg = postInput.promptMsg();

        String requestBody = """
        {
            "model": "tencent/hunyuan-a13b-instruct:free",
            "messages": [
                { "role": "user", "content": "%s" }
            ]
        }
        """.formatted(promptMsg);

        long start = System.currentTimeMillis();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey.trim())
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String aiReponse = response.body();

        long end = System.currentTimeMillis();
        long duration = end - start;

        LlmAiDto fullDto = LlmAiMapper.fromInput(postInput);
        llmAi.save(fullDto);
        System.out.println(promptMsg);
        System.out.println("La réponse de AI : " + aiReponse);
        System.out.println("Durée de la requête : " + duration + "ms");

        return aiReponse + "\n" + LocalDateTime.now();
    }
}
