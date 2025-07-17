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

    public static OutputDto toOutput(LlmAiDto outputDto) {
        return OutputDto.builder()
                .id(outputDto.getId())
                .promptMsg(outputDto.getPromptMsg())
                .apiKey(outputDto.getApiKey())
                .url(outputDto.getUrl())
                .model(outputDto.getModel())
                .searchDateTime(outputDto.getSearchDateTime())
                .build();
    }
}
