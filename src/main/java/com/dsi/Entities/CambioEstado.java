package com.dsi.Entities;

import com.dsi.Entities.patterns.EnCurso;
import com.dsi.Entities.patterns.Finalizada;
import com.dsi.Entities.patterns.Iniciada;
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

    public LocalDateTime getFechaHoraInicio() {

        return this.fechaHoraInicio;
    }

    public boolean esEstadoInicial()
    {
        return this.estado.esIniciada();
    }
    public boolean esEstadoEnCurso()
    {
        return this.estado.esEstadoEnCurso();
    }

    // cambiar nombre en el diagrama
    public boolean esEstadoFinalizada()
    {
        return this.estado.esFinalizada();
    }

    public String getNombreEstado()
    {
        return this.estado.getNombre();
    }

    public CambioEstado asignarEnCurso(LocalDateTime fechaHoraActual) {
        Iniciada iniciada = new Iniciada();

        iniciada.setIdEstado(this.getIdCambioEstado());
        iniciada.setNombre(this.getNombreEstado());

        return iniciada.asignarEnCurso(fechaHoraActual);
    }
    public CambioEstado asignarFinalizada(LocalDateTime fechaHoraActual) {
        EnCurso enCurso = new EnCurso();

        enCurso.setIdEstado(this.getIdCambioEstado());
        enCurso.setNombre(this.getNombreEstado());

        return enCurso.asignarFinalizada(fechaHoraActual);
    }
}