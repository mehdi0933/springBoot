package com.formationspring.demo.services.Interface;
import com.formationspring.demo.DTO.ArticleDto;

public interface ArticleInterface {

    ArticleDto.Output findPostById(int id);
    ArticleDto.Output createPost(ArticleDto articleDto);
}
