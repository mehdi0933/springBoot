package com.formationspring.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LlmAiDto {
    private Long id;
    private String promptMsg;
    private String apiKey;
    private String url;
    private String model;
    private LocalDateTime searchDateTime;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class InputDto {
        private String promptMsg;
        private String apiKey;
        private String url;
        private String model;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class OutputDto {
        private Long id;
        private String promptMsg;
        private String apiKey;
        private String url;
        private String model;
        private LocalDateTime searchDateTime;
    }

    public static LlmAiDto fromInput(InputDto inputDto) {
        return LlmAiDto.builder()
                .promptMsg(inputDto.getPromptMsg())
                .apiKey(inputDto.getApiKey())
                .url(inputDto.getUrl())
                .model(inputDto.getModel())
                .build();
    }

    public static OutputDto toOutput(LlmAiDto mistralDto) {
        return OutputDto.builder()
                .id(mistralDto.getId())
                .promptMsg(mistralDto.getPromptMsg())
                .apiKey(mistralDto.getApiKey())
                .url(mistralDto.getUrl())
                .model(mistralDto.getModel())
                .searchDateTime(mistralDto.getSearchDateTime())
                .build();
    }
}
