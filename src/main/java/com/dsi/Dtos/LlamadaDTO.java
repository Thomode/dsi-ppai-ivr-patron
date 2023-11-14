package com.dsi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LlamadaDTO {
    private String nombreCliente;
    private String categoria;
    private String opcion;
    private List<SubOpcionDTO> subOpcionDTOS;
}
