package com.dsi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubOpcionDTO {
    private String nombre;
    private int nroOrden;
    private List<ValidacionDTO> validacionDTOS;
}
