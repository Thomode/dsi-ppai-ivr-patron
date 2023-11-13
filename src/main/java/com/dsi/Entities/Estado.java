package com.dsi.Entities;

public class Estado
{
    private String nombre;

    public Estado(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public boolean esIniciada()
    {
        return this.nombre == "Iniciada";
    }
    public boolean esFinalizada()
    {
        return this.nombre == "Finalizada";
    }

    public boolean esEstadoEnCurso()
    {
        return this.nombre == "EnCurso";
    }

    public boolean esEstadoCancelado()
    {
        return this.nombre == "Cancelada";
    }
}