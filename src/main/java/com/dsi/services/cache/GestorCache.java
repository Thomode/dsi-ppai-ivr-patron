package com.dsi.services.cache;

import com.dsi.Entities.Llamada;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Gestor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GestorCache {
    @Id
    private Long idGestor;

    @ManyToMany
    @JoinColumn(name = "llamadas")
    private List<Llamada> llamadas;

    @ManyToOne
    @JoinColumn(name = "llamadaCliente")
    private Llamada llamadaCliente;

    @Basic
    private LocalDateTime fechaHoraActual;

    @Basic
    private String descripcionOperador = "";

    @Basic
    private String accionRequerida = "";
}
