package com.dsi.Entities;

import java.util.List;

public class Cliente
{
    private int dni;
    private String nombreCompleto;
    private int nroCelular;
    private List<InformacionCliente> info;

    public Cliente(int dni, String nombreCompleto, int nroCelular, List<InformacionCliente> info)
    {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.nroCelular = nroCelular;
        this.info = info;
    }

    public String getNombreCompleto()
    {
        return this.nombreCompleto;
    }

    public boolean esCliente(int dni)
    {
        return this.dni == dni;
    }

    public boolean esInformacionCorrecta(String dato)
    {
        boolean esInformacionCorrecta = false;

        for (InformacionCliente informacion : info)
        {
            if (informacion.esInformacionCorrecta(dato))
            {
                esInformacionCorrecta = true;
                break;
            }
        }
        return esInformacionCorrecta;
    }

    public List<InformacionCliente> getInfo()
    {
        return this.info;
    }
}