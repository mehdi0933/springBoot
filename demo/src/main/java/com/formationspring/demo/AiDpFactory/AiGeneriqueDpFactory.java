package com.formationspring.demo.AiDpFactory;

import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.entity.enums.AiModel;
import lombok.NoArgsConstructor;

import java.io.IOException;
@NoArgsConstructor
public abstract class AiGeneriqueDpFactory {



    public abstract String url();
    public abstract String apiKey();
    public abstract AiModel model();
    public abstract String promptMsg();
    public abstract String aiReponse();

    public abstract String search(LlmAiDto.PostInput postInput) throws IOException, InterruptedException;
}
