package com.formationspring.demo.mapper;

import com.formationspring.demo.dto.dtoentity.ArticleDto;

public class ArticleMapper {

    public static ArticleDto fromInput(ArticleDto.Input input) {
        return new ArticleDto(
                0,
                0,
                input.title(),
                input.body()
        );
    }

    public static ArticleDto.Output toOutput(ArticleDto articleDto) {
        return new ArticleDto.Output(
                articleDto.userId(),
                articleDto.id(),
                articleDto.title(),
                articleDto.body()
        );
    }
}
