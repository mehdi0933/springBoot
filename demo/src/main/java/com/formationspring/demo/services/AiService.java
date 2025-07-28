package com.formationspring.demo.services;

import com.formationspring.demo.DtoIa.AbstractAiSearch;
import com.formationspring.demo.DTO.LlmAiDto;
import com.formationspring.demo.tools.AiSearchFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AiService {

    private final AiSearchFactory aiSearchFactory;

    public AiService(AiSearchFactory aiSearchFactory) {
        this.aiSearchFactory = aiSearchFactory;
    }

    public String sendAiAPIRequest( LlmAiDto.PostInput input) throws IOException, InterruptedException {
        AbstractAiSearch aiSearch = aiSearchFactory.getAiSearch(input.model());
        return aiSearch.callAip(input);
    }

    @CacheEvict(value = "aiResponse", allEntries = true)
    public void clearCache() {
    }
}
