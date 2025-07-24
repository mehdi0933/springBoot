package com.formationspring.demo.services;

import com.formationspring.demo.tools.AIHTTPAccessor;

public class AiExecutorReponseFactory {

    private final AIHTTPAccessor aiAccessor;

    public AiExecutorReponseFactory(AIHTTPAccessor aiAccessor) {
        this.aiAccessor = aiAccessor;
    }

    public GenericAiReponse getExecutorReponse() {
        String reponse = aiAccessor.aiReponse();
        return new GenericAiReponse(reponse);
    }
}
