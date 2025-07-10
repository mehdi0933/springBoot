package com.formationspring.demo.services;
import com.formationspring.demo.entity.ApiEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;

@Service
public class ServiceApi implements IApi {
    private final WebClient webClient;

    public ServiceApi(WebClient webClient) {
        this.webClient = webClient;
    }



    public ApiEntity getPostById(int id) {
        return webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(ApiEntity.class)
                .block();
    }
    @Override
    public ApiEntity createPost(ApiEntity post) {
        return (ApiEntity) webClient.post()
                .uri("/posts")
                .bodyValue(post)
                .retrieve()
                .bodyToMono(ApiEntity.class)
                .block();
    }
}
