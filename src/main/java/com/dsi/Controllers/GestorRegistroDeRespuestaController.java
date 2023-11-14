package com.dsi.Controllers;

import com.dsi.Dtos.*;
import com.dsi.Entities.*;
import com.dsi.services.GestorRegistroDeRespuestaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class GestorRegistroDeRespuestaController
{
    private final GestorRegistroDeRespuestaService gestorRegistroDeRespuestaService;

    public GestorRegistroDeRespuestaController(GestorRegistroDeRespuestaService gestorRegistroDeRespuestaService) {
        this.gestorRegistroDeRespuestaService = gestorRegistroDeRespuestaService;
    }

    @GetMapping("datos-llamada")
    public LlamadaDTO mostrarDatosLlamada()
    {
        return this.gestorRegistroDeRespuestaService.mostrarDatosLlamada();
    }

    @PostMapping("validacion")
    public boolean tomarRespuestaValidacion(@RequestBody ValidacionesDTO validacion)
    {
        return this.gestorRegistroDeRespuestaService.tomarRespuestaValidacion(validacion);
    }

    @PostMapping("descripcion-operador")
    public boolean tomarDescripcionRespuesta(@RequestBody ValidacionesDTO operador)
    {
        return this.gestorRegistroDeRespuestaService.tomarDescripcionRespuesta(operador);
    }

    @GetMapping("acciones")
    public List<String> mostrarAcciones()
    {
        return this.gestorRegistroDeRespuestaService.mostrarAcciones();
    }

    @PostMapping("accion-requerida")
    public boolean tomarAccionRequerida(@RequestBody ValidacionesDTO accion)
    {
        return this.gestorRegistroDeRespuestaService.tomarAccionRequerida(accion);
    }

    @PostMapping("confirmacion")
    public boolean tomarConfirmacionOperador(@RequestBody ConfirmacionDTO confirmacion)
    {
        return this.gestorRegistroDeRespuestaService.tomarConfirmacionOperador(confirmacion);
    }
}