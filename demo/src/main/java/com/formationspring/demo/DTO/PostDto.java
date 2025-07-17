package com.formationspring.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private int userId;
    private int id;
    private String title;
    private String body;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PostInputDto {
        private String title;
        private String body;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PostOutputDto {
        private int userId;
        private int id;
        private String title;
        private String body;
    }

    public static PostDto fromInput(PostInputDto inputDto) {
        return PostDto.builder()
                .title(inputDto.getTitle())
                .body(inputDto.getBody())
                .build();
    }


    public static PostOutputDto toOutput(PostDto postDto) {
        return PostOutputDto.builder()
                .userId(postDto.getUserId())
                .id(postDto.getId())
                .title(postDto.getTitle())
                .body(postDto.getBody())
                .build();
    }



}
