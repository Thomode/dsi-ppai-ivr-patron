package com.dsi.Entities;

import jakarta.persistence.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CategoriaLlamada")
public class CategoriaLlamada
{
    @Column(name = "audioMensajeOpciones")
    private String audioMensajeOpciones;

    @Column(name = "mensajeOpciones")
    private String mensajeOpciones;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nroOrden")
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