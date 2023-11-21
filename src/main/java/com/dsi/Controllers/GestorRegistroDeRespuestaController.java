package com.dsi.Controllers;

import com.dsi.Dtos.*;
import com.dsi.Entities.*;
import com.dsi.repositories.*;
import com.dsi.services.GestorRegistroDeRespuestaService;
import com.dsi.utils.GeneradorDatos;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final LlamadaRepository llamadaRepository;

    private final GeneradorDatos generadorDatos;

    @Autowired
    public GestorRegistroDeRespuestaController(GestorRegistroDeRespuestaService gestorRegistroDeRespuestaService, LlamadaRepository llamadaRepository, GeneradorDatos generadorDatos) {
        this.gestorRegistroDeRespuestaService = gestorRegistroDeRespuestaService;
        this.llamadaRepository = llamadaRepository;
        this.generadorDatos = generadorDatos;
    }

    @GetMapping("datos-llamada")
    public LlamadaDTO mostrarDatosLlamada() {
        this.gestorRegistroDeRespuestaService.iniciar();

        return this.gestorRegistroDeRespuestaService.mostrarDatosLlamada();
    }

    @PostMapping("validacion")
    public boolean tomarRespuestaValidacion(@RequestBody ValidacionesDTO validacion) {
        this.gestorRegistroDeRespuestaService.restaurarDatos();

        return this.gestorRegistroDeRespuestaService.tomarRespuestaValidacion(validacion);
    }

    @PostMapping("descripcion-operador")
    public boolean tomarDescripcionRespuesta(@RequestBody ValidacionesDTO operador) {
        this.gestorRegistroDeRespuestaService.restaurarDatos();

        return this.gestorRegistroDeRespuestaService.tomarDescripcionRespuesta(operador);
    }

    @GetMapping("acciones")
    public List<String> mostrarAcciones()
    {
        return this.gestorRegistroDeRespuestaService.mostrarAcciones();
    }

    @PostMapping("accion-requerida")
    public boolean tomarAccionRequerida(@RequestBody ValidacionesDTO accion) {
        this.gestorRegistroDeRespuestaService.restaurarDatos();

        return this.gestorRegistroDeRespuestaService.tomarAccionRequerida(accion);
    }

    @PostMapping("confirmacion")
    public boolean tomarConfirmacionOperador(@RequestBody ConfirmacionDTO confirmacion) {
        this.gestorRegistroDeRespuestaService.restaurarDatos();

        return this.gestorRegistroDeRespuestaService.tomarConfirmacionOperador(confirmacion);
    }

    @GetMapping("llamadas")
    public List<Llamada> getLlamadas(){
        return llamadaRepository.findAll();
    }

    @PostMapping("agregar-llamada")
    public Llamada agregarLlamada(){
        return this.generadorDatos.agregarLlamada();
    }
}