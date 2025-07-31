
package com.formationspring.demo.mapper;

import com.formationspring.demo.DTO.AiDto;
import org.springframework.stereotype.Component;

@Component
public class AiMapper {

    public static AiDto fromInput(AiDto.PostInput postInput) {
        return new AiDto(
                postInput.promptMsg(),
                postInput.apiKey(),
                postInput.url(),
                postInput.model(),
                postInput.durationMs(),
                postInput.searchDateTime()
        );
    }

    public static AiDto.PostOutput toOutput(AiDto dto) {
        return new AiDto.PostOutput(
                dto.promptMsg(),
                dto.apiKey(),
                dto.url(),
                dto.model(),
                dto.durationMs(),
                dto.searchDateTime()
        );
    }
}
