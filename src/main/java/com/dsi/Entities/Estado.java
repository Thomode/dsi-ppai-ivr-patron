package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Estado")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Getter
@Setter
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

    public CambioEstado asignarEnCurso(LocalDateTime fechaHoraActual){
        return null;
    }

    public CambioEstado crearEstado(Integer idEstado, String nombre, LocalDateTime fechaHoraActual){
        return null;
    }

    public CambioEstado asignarFinalizada(LocalDateTime fechaHoraActual){
        return null;
    }
}