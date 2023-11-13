package com.dsi.Entities;

import java.time.LocalDateTime;
import java.util.Date;

public class CambioEstado
{
    private LocalDateTime fechaHoraInicio;
    private Estado estado;

    public CambioEstado(LocalDateTime fechaHoraInicio, Estado estado)
    {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    public LocalDateTime getFechaHoraInicio()
    {
        return this.fechaHoraInicio;
    }

    public boolean esEstadoInicial()
    {
        return estado.esIniciada();
    }

    // cambiar nombre en el diagrama
    public boolean esEstadoFinalizada()
    {
        return estado.esFinalizada();
    }

    public String getNombreEstado()
    {
        return this.estado.getNombre();
    }
}