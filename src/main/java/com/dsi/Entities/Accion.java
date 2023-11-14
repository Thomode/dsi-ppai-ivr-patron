package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Accion")
@Getter
@Setter
@AllArgsConstructor
public class Accion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAccion;

    @Column(name = "descripcion")
    private String descripcion;

    public Accion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }
}