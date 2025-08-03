package com.formationspring.demo.services;

import com.formationspring.demo.dto.dtoentity.ArticleDto;
import com.formationspring.demo.entity.ArticleEntity;
import com.formationspring.demo.services.Interface.ArticleInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ArticleService implements ArticleInterface {

    private final WebClient webClient;

    public ArticleService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public ArticleDto.Output findPostById(int id) {
        ArticleEntity entity = webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(ArticleEntity.class)
                .block();
        return new ArticleDto.Output(
                entity.getUserId(),
                entity.getId(),
                entity.getTitle(),
                entity.getBody()
        );
    }

    @Override
    public ArticleDto.Output createPost(ArticleDto articleDto) {
        ArticleEntity created = webClient.post()
                .uri("/posts")
                .bodyValue(articleDto)
                .retrieve()
                .bodyToMono(ArticleEntity.class)
                .block();

        return new ArticleDto.Output(
                created.getUserId(),
                created.getId(),
                created.getTitle(),
                created.getBody()
        );
    }

}
