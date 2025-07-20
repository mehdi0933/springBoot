package com.formationspring.demo.entity.enums;

public enum AiModel {

    MISTRAL_7B("mistralai/mistral-7b-instruct:free"),
    HUNYUAN("tencent/hunyuan-a13b-instruct:free");

    private final String modelName;

    AiModel(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }


    public String toString() {
        return modelName;
    }
}
