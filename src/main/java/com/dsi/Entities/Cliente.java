package com.dsi.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Cliente")
@AllArgsConstructor
public class Cliente
{
    @Id
    @Column(name = "idCliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCliente;


    @Column(name = "dni")
    private int dni;

    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    @Column(name = "nroCelular")
    private int nroCelular;

    @OneToMany
    @JoinColumn(name = "info")
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