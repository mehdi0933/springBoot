package com.formationspring.demo.aidpfactory;

import com.formationspring.demo.DTO.AiDto;
import com.formationspring.demo.entity.enums.AiModel;

import java.io.IOException;
public abstract class AiGeneriqueDpFactory {



    public abstract String url();
    public abstract String apiKey();
    public abstract AiModel model();
    public abstract String promptMsg();
    public abstract String aiReponse();

    public abstract String search(AiDto.PostInput postInput) throws IOException, InterruptedException;
}
