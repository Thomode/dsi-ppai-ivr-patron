package com.dsi.Entities;

public class InformacionCliente
{
    private String datoAValidar;
    private Validacion validacion;
    private OpcionValidacion opcionCorrecta;

    public InformacionCliente(String datoAValidar, Validacion validacion, OpcionValidacion opcionCorrecta)
    {
        this.datoAValidar = datoAValidar;
        this.validacion = validacion;
        this.opcionCorrecta = opcionCorrecta;
    }

    public boolean esInformacionCorrecta(String dato)
    {
        return opcionCorrecta != null && opcionCorrecta.esCorrecta() && opcionCorrecta.getDescripcion() == dato;
    }

    public boolean esValidacion()
    {
        return true;
    }

    public Validacion getValidacion()
    {
        return this.validacion;
    }

    public OpcionValidacion getOpcionCorrecta()
    {
        return this.opcionCorrecta;
    }
}