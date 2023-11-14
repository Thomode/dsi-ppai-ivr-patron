package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

// hola
@Data
@Entity
@NoArgsConstructor
@Table(name = "OpcionValidacion")
@Getter
@Setter
@AllArgsConstructor
public class OpcionValidacion
{

    @Id
    @Column(name = "idOpcionValidacion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOpcionValidacion;

    @Column(name = "correcta")
    private boolean correcta;

    @Column(name = "descripcion")
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