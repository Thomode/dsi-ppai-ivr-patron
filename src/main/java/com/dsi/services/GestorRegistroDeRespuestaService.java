package com.dsi.services;

import com.dsi.Dtos.*;
import com.dsi.Entities.*;
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

    public GestorRegistroDeRespuestaService()
    {
        this.tomarOpcionOperador();
        this.buscarLlamada();
        this.getFechaHoraActual();
        this.asignarEstadoEnCurso();
    }

    public LlamadaDTO mostrarDatosLlamada() {
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

    private void tomarOpcionOperador()
    {
        Estado estado = new Estado("Iniciada");
        CambioEstado cambioEstado = new CambioEstado(LocalDateTime.now(), estado);

        OpcionValidacion opcionValidacion1 = new OpcionValidacion(true, "1991");
        OpcionValidacion opcionValidacion2 = new OpcionValidacion(false, "1997");
        OpcionValidacion opcionValidacion3 = new OpcionValidacion(false, "1999");

        OpcionValidacion opcionValidacion4 = new OpcionValidacion(true, "5000");
        OpcionValidacion opcionValidacion5 = new OpcionValidacion(false, "5001");
        OpcionValidacion opcionValidacion6 = new OpcionValidacion(false, "5016");

        OpcionValidacion opcionValidacion7 = new OpcionValidacion(true, "1");
        OpcionValidacion opcionValidacion8 = new OpcionValidacion(false, "2");
        OpcionValidacion opcionValidacion9 = new OpcionValidacion(false, "0");

        OpcionValidacion opcionValidacion10 = new OpcionValidacion(true, "jose.pereyra@gmail.com");
        OpcionValidacion opcionValidacion11 = new OpcionValidacion(false, "jose.l@gmail.com");
        OpcionValidacion opcionValidacion12 = new OpcionValidacion(false, "juan.pereyra@gmail.com");

        List<OpcionValidacion> opcionValidaciones1 = new ArrayList<OpcionValidacion>();
        opcionValidaciones1.add(opcionValidacion1);
        opcionValidaciones1.add(opcionValidacion2);
        opcionValidaciones1.add(opcionValidacion3);

        Validacion validacion1 = new Validacion("Audio Validacion", "¿Año de nacimiento?", 1, opcionValidaciones1);

        List<OpcionValidacion> opcionValidaciones2 = new ArrayList<OpcionValidacion>();
        opcionValidaciones2.add(opcionValidacion3);
        opcionValidaciones2.add(opcionValidacion4);
        opcionValidaciones2.add(opcionValidacion5);

        Validacion validacion2 = new Validacion("Audio Validacion", "¿Codigo postal?", 2, opcionValidaciones2);

        List<OpcionValidacion> opcionValidaciones3 = new ArrayList<OpcionValidacion>();
        opcionValidaciones3.add(opcionValidacion7);
        opcionValidaciones3.add(opcionValidacion8);
        opcionValidaciones3.add(opcionValidacion9);

        Validacion validacion3 = new Validacion("Audio Validacion", "¿Cantidad de hijos?", 3, opcionValidaciones3);

        List<OpcionValidacion> opcionValidaciones4 = new ArrayList<OpcionValidacion>();
        opcionValidaciones4.add(opcionValidacion10);
        opcionValidaciones4.add(opcionValidacion11);
        opcionValidaciones4.add(opcionValidacion12);

        Validacion validacion4 = new Validacion("Audio Validacion", "¿Correo electronico?", 4, opcionValidaciones4);

        List<Validacion> validaciones1 = new ArrayList<Validacion>();
        validaciones1.add(validacion1);
        validaciones1.add(validacion2);

        SubOpcionLlamada subOpcionLlamada1 = new SubOpcionLlamada("Solicitar una nueva tarjeta", 1, validaciones1);

        List<Validacion> validaciones2 = new ArrayList<Validacion>();
        validaciones1.add(validacion3);
        validaciones1.add(validacion4);

        SubOpcionLlamada subOpcionLlamada2 = new SubOpcionLlamada("Anular tarjeta", 2, validaciones2);

        List<SubOpcionLlamada> subOpcionLlamadas1 = new ArrayList<SubOpcionLlamada>();
        subOpcionLlamadas1.add(subOpcionLlamada1);
        subOpcionLlamadas1.add(subOpcionLlamada2);

        OpcionLlamada opcionLlamada = new OpcionLlamada("Audio opcion", "Mensaje opcion", "Robo de tarjeta", 1, subOpcionLlamadas1);

        CategoriaLlamada categoriaLlamada = new CategoriaLlamada("Audio Categoria", "Mensaje Categoria", "Informar un robo", 1);

        InformacionCliente info1 = new InformacionCliente("1991", validacion1, opcionValidacion1);
        InformacionCliente info2 = new InformacionCliente("1997", validacion1, null);
        InformacionCliente info3 = new InformacionCliente("1999", validacion1, null);

        InformacionCliente info4 = new InformacionCliente("5000", validacion2, opcionValidacion4);
        InformacionCliente info5 = new InformacionCliente("5001", validacion2, null);
        InformacionCliente info6 = new InformacionCliente("5016", validacion2, null);

        InformacionCliente info7 = new InformacionCliente("1", validacion3, opcionValidacion7);
        InformacionCliente info8 = new InformacionCliente("2", validacion3, null);
        InformacionCliente info9 = new InformacionCliente("0", validacion3, null);

        InformacionCliente info10 = new InformacionCliente("jose.pereyra@gmail.com", validacion4, opcionValidacion10);
        InformacionCliente info11 = new InformacionCliente("jose.l@gmail.com", validacion4, null);
        InformacionCliente info12 = new InformacionCliente("juan.pereyra@gmail.com", validacion4, null);

        List<InformacionCliente> informacionClientes1 = new ArrayList<InformacionCliente>();
        informacionClientes1.add(info1);
        informacionClientes1.add(info2);
        informacionClientes1.add(info3);
        informacionClientes1.add(info4);
        informacionClientes1.add(info5);
        informacionClientes1.add(info6);
        informacionClientes1.add(info7);
        informacionClientes1.add(info8);
        informacionClientes1.add(info9);
        informacionClientes1.add(info10);
        informacionClientes1.add(info11);
        informacionClientes1.add(info12);

        Cliente cliente = new Cliente(29232323, "Jose Pereyra", 351232324, informacionClientes1);

        List<CambioEstado> cambioEstados = new ArrayList<CambioEstado>();
        cambioEstados.add(cambioEstado);

        List<SubOpcionLlamada> subOpcionLlamadas = new ArrayList<>();
        subOpcionLlamadas.add(subOpcionLlamada1);
        subOpcionLlamadas.add(subOpcionLlamada2);

        Llamada llamada = new Llamada(cliente, cambioEstados, categoriaLlamada, opcionLlamada, subOpcionLlamadas);

        List<Llamada> llamadas = new ArrayList<Llamada>();
        llamadas.add(llamada);

        this.llamadas = llamadas;
    }

    public void buscarLlamada()
    {
        for (Llamada llamada : llamadas)
        {
            if (llamada.esEstadoInicial() && !llamada.esEstadoFinalizada())
            {
                this.llamadaCliente = llamada;
            }
        }
    }

    public void asignarEstadoEnCurso()
    {
        Estado estadoEnCurso = new Estado("Iniciada");

        for (Estado estado : estados)
        {
            if (estado.esEstadoEnCurso())
            {
                estadoEnCurso = estado;
            }
        }
        CambioEstado cambio = new CambioEstado(this.fechaHoraActual, estadoEnCurso);

        this.llamadaCliente.setEstadoActual(cambio);
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

        for (Accion accion : this.acciones)
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
        this.llamadaCliente.setAccionRequerida(accionRequerida);

        this.getFechaHoraActual();
        this.asignarEstadoFinalizado();

        int duracion = this.llamadaCliente.calcularDuracion();
        this.llamadaCliente.setDuracion(duracion);
    }

    public void asignarEstadoFinalizado()
    {
        Estado estadoEnCurso = new Estado("Iniciada");

        for (Estado estado : estados)
        {
            if (estado.esFinalizada())
            {
                estadoEnCurso = estado;
            }
        }
        CambioEstado cambio = new CambioEstado(this.fechaHoraActual, estadoEnCurso);

        this.llamadaCliente.setEstadoActual(cambio);
    }

    public void finCU()
    {

    }
}
