package com.dsi.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidacionDTO {
    private String nombre;
    private List<OpcionValidacionDTO> opcionValidacionDTOS;
}
