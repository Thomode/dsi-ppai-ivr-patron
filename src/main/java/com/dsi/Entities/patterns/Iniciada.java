package com.dsi.Entities.patterns;

import com.dsi.Entities.CambioEstado;
import com.dsi.Entities.Estado;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Iniciada extends Estado {

    public Iniciada(){

    }

    @Override
    public CambioEstado asignarEnCurso(LocalDateTime fechaHoraActual) {
        return this.crearEstado(2,"EnCurso", fechaHoraActual);
    }

    @Override
    public CambioEstado crearEstado(Integer idEstado, String nombre, LocalDateTime fechaHoraActual) {
        EnCurso estadoEnCurso = new EnCurso();
        estadoEnCurso.setIdEstado(idEstado);
        estadoEnCurso.setNombre(nombre);

        CambioEstado cambioEstado = new CambioEstado(fechaHoraActual, estadoEnCurso);

        return cambioEstado;
    }
}
