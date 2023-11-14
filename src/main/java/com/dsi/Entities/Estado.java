package com.dsi.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Estado")
public class Estado
{
    @Column(name = "nombre")
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