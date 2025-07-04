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


    @Override
    public <Post> Post getPostById(int id) {
        return (Post) webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(ApiEntity.class)
                .block();
    }

    @Override
    public <Post> Post createPost(Post post) {
        return (Post) webClient.post()
                .uri("/posts")
                .bodyValue(post)
                .retrieve()
                .bodyToMono(ApiEntity.class)
                .block();
    }
}
