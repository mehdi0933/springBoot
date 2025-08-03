package com.formationspring.demo.services;

import com.formationspring.demo.dto.dtoia.AbstractAiSearch;
import com.formationspring.demo.dto.dtoentity.AiDto;
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
import java.util.Map;

@Service
public class AiRequestHandlerService {

    private final AiSearchFactory aiSearchFactory;
    private final CacheManager cacheManager;

    private static final Logger logger = LoggerFactory.getLogger(AiRequestHandlerService.class);

    public AiRequestHandlerService(AiSearchFactory aiSearchFactory, CacheManager cacheManager) {
        this.aiSearchFactory = aiSearchFactory;
        this.cacheManager = cacheManager;
    }

    public String sendAiAPIRequest(AiDto.PostInput input) throws IOException, InterruptedException {
        AbstractAiSearch aiSearch = aiSearchFactory.getAiSearch(input.model());
        return aiSearch.callApi(input);
    }

    public String getFromCache(AiDto.PostInput input) throws IOException, InterruptedException {

        String cacheKey = input.promptMsg() + "_" + input.model();
        Cache inCache = cacheManager.getCache("aiResponse");
        String aiResponse = sendAiAPIRequest(input);


        if (cacheKey != null && inCache != null) {
            Cache.ValueWrapper wrapper = inCache.get(cacheKey);
            if (wrapper != null) {
                System.out.println("The information is in the cache.\n");
                return (String) wrapper.get();
            }
        }

        System.out.println("The information is in the cache.\n");
        if (inCache != null) {
            inCache.put(cacheKey, aiResponse);
            logger.info(" Cached response for key: {}", cacheKey);
        }

        return aiResponse;
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