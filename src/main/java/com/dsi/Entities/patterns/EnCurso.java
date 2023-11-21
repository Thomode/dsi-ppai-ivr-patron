package com.dsi.Entities.patterns;

import com.dsi.Entities.CambioEstado;
import com.dsi.Entities.Estado;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class EnCurso extends Estado {

    @Override
    public CambioEstado asignarFinalizada(LocalDateTime fechaHoraActual) {
        return this.crearEstado(3,"Finalizada", fechaHoraActual);
    }

    @Override
    public CambioEstado crearEstado(Integer idEstado, String nombre, LocalDateTime fechaHoraActual) {
        Finalizada estadoEnCurso = new Finalizada();

        estadoEnCurso.setIdEstado(idEstado);
        estadoEnCurso.setNombre(nombre);

        CambioEstado cambioEstado = new CambioEstado(fechaHoraActual, estadoEnCurso);

        return cambioEstado;
    }
}
