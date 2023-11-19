package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OpcionValidacion")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpcionValidacion
{
    @Id
    @Column(name = "idOpcionValidacion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOpcionValidacion;

    @Column(name = "correcta")
    private Boolean correcta;

    @Column(name = "descripcion")
    private String descripcion;

    public OpcionValidacion(Boolean correcta, String descripcion)
    {
        this.correcta = correcta;
        this.descripcion = descripcion;
    }

    public Boolean esCorrecta()
    {
        return this.correcta;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }
}