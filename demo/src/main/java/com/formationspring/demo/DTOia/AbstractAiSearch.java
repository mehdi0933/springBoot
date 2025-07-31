package com.formationspring.demo.DTOia;

import com.formationspring.demo.DTO.AiDto;
import com.formationspring.demo.entity.enums.AiModel;

import java.io.IOException;

public abstract class AbstractAiSearch {

    public abstract String callAip(AiDto.PostInput postInput) throws IOException, InterruptedException;

    public abstract AiModel getModel();
}
