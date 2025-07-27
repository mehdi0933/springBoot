package com.formationspring.demo.DTO;

public record ArticleDto(
        int userId,
        int id,
        String title,
        String body
) {
    public record Input(
            String title,
            String body
    ) {}

    public record Output(
            int userId,
            int id,
            String title,
            String body
    ) {}
}
