package com.dsi.services.cache;

import com.dsi.Entities.Llamada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GestorCacheService {
    private final GestorCacheRepository gestorCacheRepository;

    @Autowired
    public GestorCacheService(GestorCacheRepository gestorCacheRepository){
        this.gestorCacheRepository = gestorCacheRepository;
    }
    public void saveIniciar(List<Llamada> llamadas, Llamada llamadaCliente){
        GestorCache gestorCache = new GestorCache();
        gestorCache.setIdGestor(1L);
        gestorCache.setLlamadas(llamadas);
        gestorCache.setLlamadaCliente(llamadaCliente);
        this.gestorCacheRepository.save(gestorCache);
    }

    public void saveFechaHoraActual(LocalDateTime fechaHoraActual){
        GestorCache gestorCache = gestorCacheRepository.findById(1L).orElse(null);
        gestorCache.setFechaHoraActual(fechaHoraActual);
        this.gestorCacheRepository.save(gestorCache);
    }

    public void saveDescripcionRespuesta(String descripcionOperador) {
        GestorCache gestorCache = gestorCacheRepository.findById(1L).orElse(null);
        gestorCache.setDescripcionOperador(descripcionOperador);
        gestorCacheRepository.save(gestorCache);
    }

    public void saveAccionRequerida(String accionRequerida){
        GestorCache gestorCache = gestorCacheRepository.findById(1L).orElse(null);
        gestorCache.setAccionRequerida(accionRequerida);
        gestorCacheRepository.save(gestorCache);
    }

    public GestorCache obtenerDatos(){
        return this.gestorCacheRepository.findById(1L).orElse(null);
    }
}
