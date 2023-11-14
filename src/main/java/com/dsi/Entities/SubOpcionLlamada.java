package com.dsi.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "SubOpcionLlamada")
public class SubOpcionLlamada
{
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nroOrden")
    private int nroOrden;


    private List<Validacion> validacionRequerida = new ArrayList<Validacion>();

    public SubOpcionLlamada(String nombre, int nroOrden, List<Validacion> validacionRequerida)
    {
        this.nombre = nombre;
        this.nroOrden = nroOrden;
        this.validacionRequerida = validacionRequerida;
    }

    public boolean esNro(int nro)
    {
        return this.nroOrden == nro;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public int getNroOrden()
    {
        return this.nroOrden;
    }

    // Que tiene que retornar?
    public String getValidaciones()
    {
        return "";
    }

    // Que tiene que retornar?
    public String getSubOpcion()
    {
        return "";
    }
    public void setValidacion(List<Validacion> validacion)
    {
        this.validacionRequerida = validacion;
    }

    public List<Validacion> getValidacionRequerida ()
    {
        return this.validacionRequerida;
    }
}