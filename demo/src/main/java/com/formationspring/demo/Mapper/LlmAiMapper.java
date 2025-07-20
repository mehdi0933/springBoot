package com.formationspring.demo.Mapper;

import com.formationspring.demo.DTO.LlmAiDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LlmAiMapper {

    public static LlmAiDto fromInput(LlmAiDto.Input input, long durationMS) {
        return new LlmAiDto(
                input.promptMsg(),
                input.apiKey(),
                input.url(),
                input.model(),
                durationMS,
                LocalDateTime.MIN
        );
    }

    public static LlmAiDto.Output toOutput(LlmAiDto dto) {
        return new LlmAiDto.Output(
                dto.promptMsg(),
                dto.apiKey(),
                dto.url(),
                dto.model(),
                dto.durationMs(),
                dto.searchDateTime()
        );
    }
}
