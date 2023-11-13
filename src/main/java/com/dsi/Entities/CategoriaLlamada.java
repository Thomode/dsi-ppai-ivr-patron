package com.dsi.Entities;

public class CategoriaLlamada
{
    private String audioMensajeOpciones;
    private String mensajeOpciones;
    private String nombre;
    private int nroOrden;

    public CategoriaLlamada(String audioMensajeOpciones, String mensajeOpciones, String nombre, int nroOrden)
    {
        this.audioMensajeOpciones = audioMensajeOpciones;
        this.mensajeOpciones = mensajeOpciones;
        this.nombre = nombre;
        this.nroOrden = nroOrden;
    }

    public String getAudioMensajeOpciones()
    {
        return this.audioMensajeOpciones;
    }

    public String getNombre()
    {
        return this.nombre;
    }
}