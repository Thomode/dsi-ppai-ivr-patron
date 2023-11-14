package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "SubOpcionLlamada")
@Getter
@Setter
@AllArgsConstructor
public class SubOpcionLlamada
{

    @Id
    @Column(name = "idSubOpcionLlamada")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSubOpcionLlamada;


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