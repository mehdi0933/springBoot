package com.formationspring.demo.services.Interface;

import com.formationspring.demo.DTO.LlmAiDto;

public interface AiModelExecutor {

    String execute(LlmAiDto.PostInput input);
}
