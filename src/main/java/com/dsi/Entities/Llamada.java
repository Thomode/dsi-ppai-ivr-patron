package com.dsi.Entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Llamada
{
    private String descripcionOperador = "";
    private String detalleAccionRequerida = "";
    private int duracion = 0;
    private List<CambioEstado> cambiosEstados;
    private Cliente cliente;
    private OpcionLlamada opcionSeleccionada;
    private List<SubOpcionLlamada> subOpcionSeleccionada;
    private CategoriaLlamada categoriaLlamada;
    private Accion accionRequerida = null;

    public Llamada(Cliente cliente, List<CambioEstado> cambiosEstados, CategoriaLlamada categoriaLlamada, OpcionLlamada opcionSeleccionada, List<SubOpcionLlamada> subOpcionSeleccionada)
    {
        this.cliente = cliente;
        this.cambiosEstados = cambiosEstados;
        this.categoriaLlamada = categoriaLlamada;
        this.opcionSeleccionada = opcionSeleccionada;
        this.subOpcionSeleccionada = subOpcionSeleccionada;
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
        return cliente.getNombreCompleto();
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

    public void setEstadoActual(CambioEstado cambioEstado)
    {
        this.cambiosEstados.add(cambioEstado);
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

        for (CambioEstado cambio : cambiosEstados)
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

        for (CambioEstado cambio : cambiosEstados)
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