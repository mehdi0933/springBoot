package com.formationspring.demo.DTO;

import com.formationspring.demo.entity.enums.AiModel;
import java.time.LocalDateTime;

public record LlmAiDto(
        String promptMsg,
        String apiKey,
        String url,
        AiModel model,
        long durationMs,
        LocalDateTime searchDateTime
) {

    public record Input(
            String promptMsg,
            String apiKey,
            String url,
            AiModel model,
            long durationMs,
            LocalDateTime searchDateTime
    ) {}

    public record Output(
            String promptMsg,
            String apiKey,
            String url,
            AiModel model,
            long durationMs,
            LocalDateTime searchDateTime
    ) {}

}
