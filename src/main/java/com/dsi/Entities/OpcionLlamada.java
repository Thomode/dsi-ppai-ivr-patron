package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "OpcionLlamada")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpcionLlamada
{

    @Id
    @Column(name = "idOpcionLlamada")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOpcionLlamada;


    @Column(name = "audioMensjeOpciones")
    private String audioMensajeOpciones;

    @Column(name = "mensajeSubOpciones")
    private String mensajeSubOpciones;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nroOrden")
    private int nroOrden;
    private List<SubOpcionLlamada> subOpcionLlamada;
    private List<Validacion> validacionRequerida = new ArrayList<Validacion>();

    public OpcionLlamada(String audioMensajeOpciones, String mensajeSubOpciones, String nombre, int nroOrden, List<SubOpcionLlamada> subOpcionLlamada)
    {
        this.audioMensajeOpciones = audioMensajeOpciones;
        this.mensajeSubOpciones = mensajeSubOpciones;
        this.nombre = nombre;
        this.nroOrden = nroOrden;
        this.subOpcionLlamada = subOpcionLlamada;
    }

    public String getAudioMensajeOpciones()
    {
        return this.audioMensajeOpciones;
    }

    public String getDescripcionConSubOpcion()
    {
        return this.mensajeSubOpciones;
    }

    // Que tiene que retornar?
    public String getOpcion()
    {
        return "";
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setSubOpcion(List<SubOpcionLlamada> subOpcion)
    {
        this.subOpcionLlamada = subOpcion;
    }

    public List<String> getNombreSubOpciones()
    {   
        List<String> nombreSubOpciones = new ArrayList<String>();

        for(SubOpcionLlamada subOpcion : subOpcionLlamada)
        {
            nombreSubOpciones.add(subOpcion.getNombre());
        }

        return nombreSubOpciones;
    }
}