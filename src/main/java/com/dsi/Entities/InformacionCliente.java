package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "InformacionCliente" )
@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class InformacionCliente
{

    @Id
    @Column(name = "idInformacionCliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idInformacionCliente;

    @Column(name = "datoAValidar")
    private String datoAValidar;

    @ManyToOne
    @JoinColumn(name = "validacion")
    private Validacion validacion;

    @ManyToOne
    @JoinColumn(name = "opcionCorrecta")
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