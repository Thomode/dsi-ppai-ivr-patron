package com.dsi.services.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorCacheService {
    private final GestorCacheRepository gestorCacheRepository;

    @Autowired
    public GestorCacheService(GestorCacheRepository gestorCacheRepository){
        this.gestorCacheRepository = gestorCacheRepository;
    }
}
