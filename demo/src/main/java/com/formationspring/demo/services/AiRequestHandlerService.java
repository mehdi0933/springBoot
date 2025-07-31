package com.formationspring.demo.services;

import com.formationspring.demo.DTOia.AbstractAiSearch;
import com.formationspring.demo.DTO.AiDto;
import com.formationspring.demo.tools.AiSearchFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AiRequestHandlerService {

    private final AiSearchFactory aiSearchFactory;
    private final CacheManager cacheManager;

    public AiRequestHandlerService(AiSearchFactory aiSearchFactory, CacheManager cacheManager) {
        this.aiSearchFactory = aiSearchFactory;
        this.cacheManager = cacheManager;
    }

    @Cacheable(cacheNames = "aiResponse", key = "#input.promptMsg()")
    public String sendAiAPIRequest(AiDto.PostInput input) throws IOException, InterruptedException {
        System.out.println("Appel API effectué pour la clé : " + input.promptMsg());
        AbstractAiSearch aiSearch = aiSearchFactory.getAiSearch(input.model());
        return aiSearch.callAip(input);
    }

    @Scheduled(cron = "0 0 3 * * *") // purge cache à 3h du matin
    @CacheEvict(value = "aiResponse", allEntries = true)
    public void clearCache() {
        System.out.println("Cache vidé à 3h du matin");
    }

    public Object getFromCache()
    {
        if(cacheManager.getCache("aiResponse") == null){
            return null;
        }
        return cacheManager.getCache("aiResponse");

    }
}

