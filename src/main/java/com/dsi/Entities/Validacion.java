package com.dsi.Entities;

import java.util.List;

public class Validacion
{
    private String audioMensajeValidacion;
    private String nombre;
    private int nroOrden;
    private List<OpcionValidacion> opcionValidacion;

    public Validacion(String audioMensajeValidacion, String nombre, int nroOrden, List<OpcionValidacion> opcionValidacion)
    {
        this.audioMensajeValidacion = audioMensajeValidacion;
        this.nombre = nombre;
        this.nroOrden = nroOrden;
        this.opcionValidacion = opcionValidacion;
    }

    public String getAudioMensajeValidacion()
    {
        return this.audioMensajeValidacion;
    }

    public String getMensajeValidacion()
    {
        return this.nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    // Que tiene que retornar
    public String getValidacion()
    {
        return "";
    }

    public int getNroOrden()
    {
        return this.nroOrden;
    }
    public void setOpcionValidacion(List<OpcionValidacion> opcionValidacion)
    {
        this.opcionValidacion = opcionValidacion;
    }

    public List<OpcionValidacion> getOpcionValidacion()
    {
        return this.opcionValidacion;
    }
}