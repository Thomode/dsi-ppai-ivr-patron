package com.dsi.Entities;

public class OpcionValidacion
{
    private boolean correcta;
    private String descripcion;

    public OpcionValidacion(boolean correcta, String descripcion)
    {
        this.correcta = correcta;
        this.descripcion = descripcion;
    }

    public boolean esCorrecta()
    {
        return this.correcta;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }
}