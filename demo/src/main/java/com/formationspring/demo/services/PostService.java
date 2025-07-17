package com.formationspring.demo.services;

import com.formationspring.demo.DTO.PostDto;
import com.formationspring.demo.entity.ArticleEntity;
import com.formationspring.demo.services.Interface.PostInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PostService implements PostInterface {

    private final WebClient webClient;

    public PostService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public PostDto.PostOutputDto findPostById(int id) {
        ArticleEntity entity = webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(ArticleEntity.class)
                .block();

        return PostDto.PostOutputDto.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .title(entity.getTitle())
                .body(entity.getBody())
                .build();
    }

    @Override
    public PostDto.PostOutputDto createPost(PostDto postDto) {
        ArticleEntity created = webClient.post()
                .uri("/posts")
                .bodyValue(postDto)
                .retrieve()
                .bodyToMono(ArticleEntity.class)
                .block();

        return PostDto.PostOutputDto.builder()
                .id(created.getId())
                .userId(created.getUserId())
                .title(created.getTitle())
                .body(created.getBody())
                .build();
    }


}
