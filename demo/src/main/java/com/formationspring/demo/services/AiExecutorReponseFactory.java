package com.formationspring.demo.services;

import com.formationspring.demo.AiDpFactory.AiGeneriqueDpFactory;

public class AiExecutorReponseFactory {

    private final AiGeneriqueDpFactory aiGenerique;

    public AiExecutorReponseFactory(AiGeneriqueDpFactory aiGenerique) {
        this.aiGenerique = aiGenerique;
    }

    public GenericAiReponse getExecutorReponse() {
        String reponse = aiGenerique.aiReponse();
        return new GenericAiReponse(reponse);
    }
}
