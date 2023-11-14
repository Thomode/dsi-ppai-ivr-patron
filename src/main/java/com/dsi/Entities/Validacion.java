package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Validacion")
@Getter
@Setter
@AllArgsConstructor
public class Validacion
{
    @Id
    @Column(name = "idValidacion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idValidacion;


    @Column(name = "audioMensajeValidacion")
    private String audioMensajeValidacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nroOrden")
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