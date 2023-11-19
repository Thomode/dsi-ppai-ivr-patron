package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Llamada" )
@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Llamada {
    @Id
    @Column(name = "idLlamada")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLlamada;

    @Column(name = "descripcionOperador")
    private String descripcionOperador = "";

    @Column(name = "detalleAccionRequerida")
    private String detalleAccionRequerida = "";

    @Column(name = "duracion")
    private int duracion = 0;

    @ManyToMany
    @JoinColumn(name = "cambiosEstados")
    private List<CambioEstado> cambiosEstados;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "opcionSeleccionada")
    private OpcionLlamada opcionSeleccionada;

    @ManyToMany
    @JoinColumn(name = "subOpcionSeleccionada")
    private List<SubOpcionLlamada> subOpcionSeleccionada;

    @ManyToOne
    @JoinColumn(name = "categoriaLlamada")
    private CategoriaLlamada categoriaLlamada;

    @ManyToOne
    @JoinColumn(name = "accionRequerida")
    private Accion accionRequerida;

    public Llamada(Cliente cliente, List<CambioEstado> cambiosEstados, CategoriaLlamada categoriaLlamada, OpcionLlamada opcionSeleccionada, List<SubOpcionLlamada> subOpcionSeleccionada, Accion accionRequerida)
    {
        this.cliente = cliente;
        this.cambiosEstados = cambiosEstados;
        this.categoriaLlamada = categoriaLlamada;
        this.opcionSeleccionada = opcionSeleccionada;
        this.subOpcionSeleccionada = subOpcionSeleccionada;
        this.accionRequerida = accionRequerida;
    }

    public int calcularDuracion()
    {
        LocalDateTime fechaHoraIniciada = LocalDateTime.now();
        LocalDateTime fechaHoraFinalizada = LocalDateTime.now();
        for (CambioEstado cambio : cambiosEstados)
        {
            if (cambio.esEstadoInicial())
            {
                fechaHoraIniciada = cambio.getFechaHoraInicio();
            }
            if (cambio.esEstadoFinalizada())
            {
                fechaHoraFinalizada = cambio.getFechaHoraInicio();
            }
        }

        Duration duracion = Duration.between(fechaHoraIniciada, fechaHoraFinalizada);

        return (int) duracion.toMinutes();
    }

    public void setDuracion(int duracion)
    {
        this.duracion = duracion;
    }

    public boolean esDePeriodo(LocalDateTime fechaInicio, LocalDateTime fechaFinal)
    {
        LocalDateTime fechaHoraIniciada = LocalDateTime.now();
        LocalDateTime fechaHoraFinalizada = LocalDateTime.now();

        for (CambioEstado cambio : cambiosEstados)
        {
            if (cambio.esEstadoInicial())
            {
                fechaHoraIniciada = cambio.getFechaHoraInicio();
            }
            if (cambio.esEstadoFinalizada())
            {
                fechaHoraFinalizada = cambio.getFechaHoraInicio();
            }
        }

        return fechaHoraIniciada.compareTo(fechaInicio) >= 0 && fechaHoraFinalizada.compareTo(fechaFinal) <= 0;
    }

    public int getDuracion()
    {
        return this.duracion;
    }

    public String getNombreClienteDeLlamada()
    {
        return this.cliente.getNombreCompleto();
    }

    // Que tiene que retornar (creo que para este caso de uso no aplica)
    public String getRespuesta()
    {
        return "";
    }

    public void setDescripcionOperador(String descripcionOperador)
    {
        this.descripcionOperador = descripcionOperador;
    }

    public void setEstadoActual(List<CambioEstado> cambioEstado)
    {
        this.cambiosEstados = cambioEstado;
    }

    public void setOpcion(OpcionLlamada opcion)
    {
        this.opcionSeleccionada = opcion;
    }

    public void setSubOpcion(SubOpcionLlamada subOpcion)
    {
        this.subOpcionSeleccionada.add(subOpcion);
    }

    public boolean esEstadoInicial()
    {
        boolean esInicial = false;

        for (CambioEstado cambio : this.cambiosEstados)
        {
            if (cambio.esEstadoInicial())
            {
                esInicial = true;
                break;
            }
        }

        return esInicial;
    }

    public boolean esEstadoFinalizada()
    {
        boolean esFinalizada = false;

        for (CambioEstado cambio : this.cambiosEstados)
        {
            if (cambio.esEstadoFinalizada())
            {
                esFinalizada = true;
                break;
            }
        }

        return esFinalizada;
    }

    public void setCategoriaLlamada(CategoriaLlamada categoria)
    {
        this.categoriaLlamada = categoria;
    }

    public CategoriaLlamada getCategoriaLlamada()
    {
        return this.categoriaLlamada;
    }

    public List<SubOpcionLlamada> getSubOpcionSeleccionada()
    {
        return this.subOpcionSeleccionada;
    }

    public void setOpcionSeleccionada(OpcionLlamada opcionLlamada)
    {
        this.opcionSeleccionada = opcionLlamada;
    }
    public void setSubOpcionesSeleccionada(List<SubOpcionLlamada> subOpcionSeleccionada)
    {
        this.subOpcionSeleccionada = subOpcionSeleccionada;
    }
    public OpcionLlamada getOpcionSeleccionada()
    {
        return this.opcionSeleccionada;
    }

    public Cliente getCliente()
    {
        return this.cliente;
    }

    public Accion getAccionRequerida()
    {
        return this.accionRequerida;
    }

    public void setAccionRequerida(Accion accionRequerida)
    {
        this.accionRequerida = accionRequerida;
    }
}