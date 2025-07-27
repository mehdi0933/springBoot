package com.formationspring.demo.DtoIa;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;

import java.io.IOException;

public abstract class AbstractAiSearch {

    public abstract String callAip(LlmAiDto.PostInput postInput) throws IOException, InterruptedException;

    public abstract AiModel getModel();
}
