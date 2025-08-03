package com.formationspring.demo.dto.dtoia;

import com.formationspring.demo.dto.dtoentity.AiDto;
import com.formationspring.demo.entity.enums.AiModel;

import java.io.IOException;

public abstract class AbstractAiSearch {

    public abstract String callApi(AiDto.PostInput postInput) throws IOException, InterruptedException;

    public abstract AiModel getModel();
}
