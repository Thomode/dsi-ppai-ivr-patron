package com.dsi.services;

import com.dsi.Dtos.*;
import com.dsi.Entities.*;
import com.dsi.repositories.AccionRepository;
import com.dsi.repositories.CambioEstadoRepository;
import com.dsi.repositories.EstadoRepository;
import com.dsi.repositories.LlamadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GestorRegistroDeRespuestaService{
    private List<Llamada> llamadas;
    private Llamada llamadaCliente;
    private LocalDateTime fechaHoraActual;

    private final LlamadaRepository llamadaRepository;
    private final EstadoRepository estadoRepository;
    private final AccionRepository accionRepository;
    private final CambioEstadoRepository cambioEstadoRepository;

    private List<Estado> estados = Arrays.asList(
            new Estado("Iniciada"),
            new Estado("EnCurso"),
            new Estado("Finalizada"),
            new Estado("Cancelada")
    );


    private List<Accion> acciones = Arrays.asList (
            new Accion("Denunciar"),
            new Accion("Bloquear"),
            new Accion("Solicitar nueva tarjeta")
    );

    private String descripcionOperador = "";
    private String accionRequerida = "";

    public GestorRegistroDeRespuestaService(LlamadaRepository llamadaRepository, EstadoRepository estadoRepository, AccionRepository accionRepository, CambioEstadoRepository cambioEstadoRepository)
    {
        this.llamadaRepository = llamadaRepository;
        this.estadoRepository = estadoRepository;
        this.accionRepository = accionRepository;
        this.cambioEstadoRepository = cambioEstadoRepository;
    }

    private void iniciar(){
        this.llamadas = this.tomarOpcionOperador();
        this.llamadaCliente = this.buscarLlamada(this.llamadas);
        this.getFechaHoraActual();
        this.asignarEstadoEnCurso();
    }

    public LlamadaDTO mostrarDatosLlamada() {
        this.iniciar();

        String nombreCliente = this.llamadaCliente.getNombreClienteDeLlamada();
        String categoria = this.llamadaCliente.getCategoriaLlamada().getNombre();
        String opcion = this.llamadaCliente.getOpcionSeleccionada().getNombre();

        List<SubOpcionDTO> subOpciones = this.buscarSubOpcionYValidaciones();
        List<SubOpcionDTO> subOpcionesOrdenadas = this.ordenarSubOpciones(subOpciones);

        LlamadaDTO llamadaDTO = new LlamadaDTO();
        llamadaDTO.setNombreCliente(nombreCliente);
        llamadaDTO.setCategoria(categoria);
        llamadaDTO.setOpcion(opcion);
        llamadaDTO.setSubOpcionDTOS(subOpcionesOrdenadas);

        return llamadaDTO;
    }

    private List<Llamada> tomarOpcionOperador()
    {
        return this.llamadaRepository.findAll();
    }

    public Llamada buscarLlamada(List<Llamada> llamadas)
    {
        Llamada llamadaEncontrada = new Llamada();

        for (Llamada llamada : llamadas)
        {
            if (llamada.esEstadoInicial() && !llamada.esEstadoFinalizada())
            {
                llamadaEncontrada = llamada;
            }
        }

        return llamadaEncontrada;
    }

    public void asignarEstadoEnCurso()
    {
        Estado estadoEnCurso = new Estado();

        List<Estado> estadoList = this.estadoRepository.findAll();

        for (Estado estado : estadoList)
        {
            if (estado.esEstadoEnCurso())
            {
                estadoEnCurso = estado;
            }
        }

        CambioEstado cambio = new CambioEstado(this.fechaHoraActual, estadoEnCurso);
        CambioEstado cambioEstadoSave = this.cambioEstadoRepository.save(cambio);

        List<CambioEstado> cambioEstados = this.llamadaCliente.getCambiosEstados();
        cambioEstados.add(cambioEstadoSave);

        this.llamadaCliente.setEstadoActual(cambioEstados);

        this.llamadaRepository.save(this.llamadaCliente);
    }

    public void getFechaHoraActual()
    {
        this.fechaHoraActual = LocalDateTime.now();
    }

    public List<SubOpcionDTO> buscarSubOpcionYValidaciones()
    {
        List<SubOpcionDTO> subOpcionDTOS = new ArrayList<SubOpcionDTO>();

        for (SubOpcionLlamada subOpcion : this.llamadaCliente.getSubOpcionSeleccionada())
        {
            List<ValidacionDTO> validacionDTOS = new ArrayList<ValidacionDTO>();

            for (Validacion validacionRequerida : subOpcion.getValidacionRequerida())
            {
                List<OpcionValidacionDTO> opcionValidacionDTOS = new ArrayList<OpcionValidacionDTO>();

                for (OpcionValidacion opcionValidacion : validacionRequerida.getOpcionValidacion())
                {
                    OpcionValidacionDTO validacionDTO = new OpcionValidacionDTO();
                    validacionDTO.setDescripcion(opcionValidacion.getDescripcion());

                    opcionValidacionDTOS.add(validacionDTO);
                }

                ValidacionDTO validacionDTO = new ValidacionDTO();
                validacionDTO.setNombre(validacionRequerida.getMensajeValidacion());
                validacionDTO.setOpcionValidacionDTOS(opcionValidacionDTOS);

                validacionDTOS.add(validacionDTO);
            }

            SubOpcionDTO subOpcionDTO = new SubOpcionDTO();
            subOpcionDTO.setNombre((subOpcion.getNombre()));
            subOpcionDTO.setNroOrden(subOpcion.getNroOrden());
            subOpcionDTO.setValidacionDTOS(validacionDTOS);

            subOpcionDTOS.add(subOpcionDTO);
        }
        return subOpcionDTOS;
    }

    public List<SubOpcionDTO> ordenarSubOpciones(List<SubOpcionDTO> subOpcionesYValidaciones)
    {
        return subOpcionesYValidaciones
                .stream()
                .sorted(Comparator.comparingInt(SubOpcionDTO::getNroOrden))
                .collect(Collectors.toList());
    }

    public void ingresarRespuestasValidaciones()
    {

    }

    public boolean tomarRespuestaValidacion(ValidacionesDTO validacion)
    {
        String descripcion = validacion.getDescripcion();
        return this.validarRespuestaIngresada(descripcion);
    }

    public boolean validarRespuestaIngresada(String descripcionOpcionV)
    {
        return this.llamadaCliente.getCliente().esInformacionCorrecta(descripcionOpcionV);
    }

    public void ingresarDescripcionRespuesta()
    {

    }

    public boolean tomarDescripcionRespuesta(ValidacionesDTO operador)
    {
        boolean esValido = false;

        if (operador.descripcion != "")
        {
            this.descripcionOperador = operador.descripcion;
            esValido = true;
        }

        return esValido;
    }

    public List<String> mostrarAcciones()
    {
        List<String> acciones = new ArrayList<String>();

        List<Accion> accionList = accionRepository.findAll();

        for (Accion accion : accionList)
        {
            acciones.add(accion.getDescripcion());
        }

        return acciones;
    }

    public void registrarAccion()
    {

    }

    public boolean tomarAccionRequerida(ValidacionesDTO accion)
    {
        boolean esValido = false;

        if (accion.descripcion != "")
        {
            this.accionRequerida = accion.descripcion;
            esValido = true;
        }

        return esValido;
    }

    public void confirmarOperacion()
    {

    }

    public boolean tomarConfirmacionOperador(ConfirmacionDTO confirmacion)
    {
        boolean registroRealizado = false;

        if (confirmacion.confirmacion)
        {
            this.registrarFinalizacionLlamada();
            registroRealizado = true;
        }

        return registroRealizado;
    }

    public void registrarFinalizacionLlamada()
    {
        this.llamadaCliente.setDescripcionOperador(this.descripcionOperador);

        Accion accionRequerida = new Accion(this.accionRequerida);

        Accion accionRequeridaSave = this.accionRepository.save(accionRequerida);

        this.llamadaCliente.setAccionRequerida(accionRequeridaSave);

        this.getFechaHoraActual();
        this.asignarEstadoFinalizado();

        int duracion = this.llamadaCliente.calcularDuracion();
        this.llamadaCliente.setDuracion(duracion);

        this.llamadaRepository.save(this.llamadaCliente);
    }

    public void asignarEstadoFinalizado()
    {
        Estado estadoEnCurso = new Estado();

        List<Estado> estadoList = estadoRepository.findAll();

        for (Estado estado : estadoList)
        {
            if (estado.esFinalizada())
            {
                estadoEnCurso = estado;
            }
        }
        CambioEstado cambio = new CambioEstado(this.fechaHoraActual, estadoEnCurso);
        CambioEstado cambioEstadoSave = this.cambioEstadoRepository.save(cambio);

        List<CambioEstado> cambioEstados = this.llamadaCliente.getCambiosEstados();
        cambioEstados.add(cambioEstadoSave);

        this.llamadaCliente.setEstadoActual(cambioEstados);

        this.llamadaRepository.save(this.llamadaCliente);
    }

    public void finCU()
    {

    }
}
