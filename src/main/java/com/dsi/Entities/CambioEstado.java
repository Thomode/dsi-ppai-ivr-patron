package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CambioEstado")
@Getter
@Setter
@AllArgsConstructor
public class CambioEstado
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCambioEstado")
    private Integer idCambioEstado;

    @Column(name = "fechaHoraInicio")
    private LocalDateTime fechaHoraInicio;

    @ManyToOne
    @JoinColumn(name = "estado")
    private Estado estado;

    public CambioEstado(LocalDateTime fechaHoraInicio, Estado estado)
    {
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    public LocalDateTime getFechaHoraInicio()
    {
        return this.fechaHoraInicio;
    }

    public boolean esEstadoInicial()
    {
        return estado.esIniciada();
    }

    // cambiar nombre en el diagrama
    public boolean esEstadoFinalizada()
    {
        return estado.esFinalizada();
    }

    public String getNombreEstado()
    {
        return this.estado.getNombre();
    }
}