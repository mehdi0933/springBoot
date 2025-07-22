
package com.formationspring.demo.mapper;

import com.formationspring.demo.DTO.LlmAiDto;
import org.springframework.stereotype.Component;

@Component
public class LlmAiMapper {

    public static LlmAiDto fromInput(LlmAiDto.PostInput postInput) {
        return new LlmAiDto(
                postInput.promptMsg(),
                postInput.apiKey(),
                postInput.url(),
                postInput.model(),
                postInput.durationMs(),
                postInput.searchDateTime()
        );
    }

    public static LlmAiDto.PostOutput toOutput(LlmAiDto dto) {
        return new LlmAiDto.PostOutput(
                dto.promptMsg(),
                dto.apiKey(),
                dto.url(),
                dto.model(),
                dto.durationMs(),
                dto.searchDateTime()
        );
    }
}
