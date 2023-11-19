package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Estado")
@AllArgsConstructor
public class Estado
{
    @Id
    @Column(name = "idEstado")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEstado;

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
        return this.nombre.equals("Iniciada");
    }
    public boolean esFinalizada()
    {
        return this.nombre.equals("Finalizada");
    }

    public boolean esEstadoEnCurso()
    {
        return this.nombre.equals("EnCurso");
    }

    public boolean esEstadoCancelado()
    {
        return this.nombre.equals("Cancelada");
    }
}