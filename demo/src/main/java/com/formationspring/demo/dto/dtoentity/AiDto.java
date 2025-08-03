package com.formationspring.demo.dto.dtoentity;

import com.formationspring.demo.entity.enums.AiModel;
import lombok.NonNull;

import java.time.LocalDateTime;

public record AiDto(
        String promptMsg,
        String apiKey,
        String url,
        AiModel model,
        long durationMs,
        LocalDateTime searchDateTime
) {

    public record PostInput(
            @NonNull
            String promptMsg,
            @NonNull
            String apiKey,
            @NonNull
            String url,
            @NonNull
            AiModel model,
            long durationMs,
            LocalDateTime searchDateTime
    ) {


    }

    public record PostOutput(
            String promptMsg,
            String apiKey,
            String url,
            AiModel model,
            long durationMs,
            LocalDateTime searchDateTime
    ) {}

}
