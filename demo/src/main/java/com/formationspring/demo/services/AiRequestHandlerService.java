package com.formationspring.demo.services;

import com.formationspring.demo.dto.dtoia.AbstractAiSearch;
import com.formationspring.demo.dto.dtoentity.AiDto;
import com.formationspring.demo.mapper.AiMapper;
import com.formationspring.demo.services.Interface.AiHistoryRecorderInterface;
import com.formationspring.demo.tools.AiSearchFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class AiRequestHandlerService {

    private final AiSearchFactory aiSearchFactory;
    private final CacheManager cacheManager;
    private final AiHistoryRecorderInterface llmAi;


    private static final Logger logger = LoggerFactory.getLogger(AiRequestHandlerService.class);

    public AiRequestHandlerService(AiSearchFactory aiSearchFactory, CacheManager cacheManager, AiHistoryRecorderInterface llmAi) {
        this.aiSearchFactory = aiSearchFactory;
        this.cacheManager = cacheManager;
        this.llmAi = llmAi;
    }

    public String sendAiAPIRequest(AiDto.PostInput input) throws IOException, InterruptedException {
        AbstractAiSearch aiSearch = aiSearchFactory.getAiSearch(input.model());

        String cacheKey = input.promptMsg();
        Cache cache = cacheManager.getCache("aiResponse");

        if (cache != null) {
            Cache.ValueWrapper wrapper = cache.get(cacheKey);
            if (wrapper != null) {
                String cachedValue = (String) wrapper.get();
                System.out.println("Cache hit for prompt: " + cacheKey);
                System.out.println("Cached value: " + cachedValue + " date de la requête " + LocalDateTime.now());
                return cachedValue;
            }
        }
        System.out.println(input.promptMsg());
        long start = System.currentTimeMillis();
        String response = aiSearch.callApi(input);
        long end = System.currentTimeMillis();
        long duration = end - start;


        AiDto fullDto = AiMapper.fromInput(input);
        llmAi.save(input);

        System.out.println("Durée de la requête API : " + duration + "ms" + " date de la requête " + LocalDateTime.now());

        return response;
    }


    @Scheduled(cron = "0 0 3 * * *") // purge cache à 3h du matin
    @CacheEvict(value = "aiResponse", allEntries = true)
    public void clearCache() {
        System.out.println("Cache vidé à 3h du matin");
    }

    public Object getFromDataCache() {
        Cache cache = cacheManager.getCache("aiResponse");

        if (cache instanceof ConcurrentMapCache concurrentMapCache) {
            return concurrentMapCache.getNativeCache();
        }

        return Map.of();
    }
}