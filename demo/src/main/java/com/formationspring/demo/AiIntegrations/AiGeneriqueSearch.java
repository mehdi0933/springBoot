package com.formationspring.demo.AiIntegrations;

import com.formationspring.demo.dto.dtoentity.AiDto;
import com.formationspring.demo.entity.enums.AiModel;

import java.io.IOException;

public abstract class AiGeneriqueSearch {


    public abstract String url();

    public abstract String apiKey();

    public abstract AiModel model();

    public abstract String promptMsg();

    public abstract String aiReponse();

    public abstract String search(AiDto.PostInput postInput) throws IOException, InterruptedException;
}
