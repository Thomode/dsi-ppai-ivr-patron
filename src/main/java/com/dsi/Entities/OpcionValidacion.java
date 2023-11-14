package com.dsi.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// hola
@Data
@Entity
@NoArgsConstructor
@Table(name = "OpcionValidacion")
@Getter
@Setter
public class OpcionValidacion
{
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