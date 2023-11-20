package com.dsi.utils;

import com.dsi.Entities.*;
import com.dsi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneradorDatos {
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CategoriaLlamadaRepository categoriaLlamadaRepository;
    @Autowired
    private CambioEstadoRepository cambioEstadoRepository;

    @Autowired
    private OpcionValidacionRepository opcionValidacionRepository;
    @Autowired
    private ValidacionRepository validacionRepository;
    @Autowired
    private InformacionClienteRepository informacionClienteRepository;
    @Autowired
    private LlamadaRepository llamadaRepository;

    @Autowired
    private SubOpcionLlamadaRepository subOpcionLlamadaRepository;

    @Autowired
    private OpcionLlamadaRepository opcionLlamadaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Llamada agregarLlamada (){
        Estado estado = estadoRepository.findByNombre("Iniciada");

        CambioEstado cambioEstado = new CambioEstado(LocalDateTime.now(), estado);
        cambioEstadoRepository.save(cambioEstado);

        OpcionValidacion opcionValidacion1 = new OpcionValidacion(true, "1991");
        OpcionValidacion opcionValidacion2 = new OpcionValidacion(false, "1997");
        OpcionValidacion opcionValidacion3 = new OpcionValidacion(false, "1999");

        opcionValidacionRepository.save(opcionValidacion1);
        opcionValidacionRepository.save(opcionValidacion2);
        opcionValidacionRepository.save(opcionValidacion3);

        OpcionValidacion opcionValidacion4 = new OpcionValidacion(true, "5000");
        OpcionValidacion opcionValidacion5 = new OpcionValidacion(false, "5001");
        OpcionValidacion opcionValidacion6 = new OpcionValidacion(false, "5016");

        opcionValidacionRepository.save(opcionValidacion4);
        opcionValidacionRepository.save(opcionValidacion5);
        opcionValidacionRepository.save(opcionValidacion6);

        OpcionValidacion opcionValidacion7 = new OpcionValidacion(true, "1");
        OpcionValidacion opcionValidacion8 = new OpcionValidacion(false, "2");
        OpcionValidacion opcionValidacion9 = new OpcionValidacion(false, "0");

        opcionValidacionRepository.save(opcionValidacion7);
        opcionValidacionRepository.save(opcionValidacion8);
        opcionValidacionRepository.save(opcionValidacion9);

        OpcionValidacion opcionValidacion10 = new OpcionValidacion(true, "jose.pereyra@gmail.com");
        OpcionValidacion opcionValidacion11 = new OpcionValidacion(false, "jose.l@gmail.com");
        OpcionValidacion opcionValidacion12 = new OpcionValidacion(false, "juan.pereyra@gmail.com");

        opcionValidacionRepository.save(opcionValidacion10);
        opcionValidacionRepository.save(opcionValidacion11);
        opcionValidacionRepository.save(opcionValidacion12);

        List<OpcionValidacion> opcionValidaciones1 = new ArrayList<OpcionValidacion>();

        opcionValidaciones1.add(opcionValidacion1);
        opcionValidaciones1.add(opcionValidacion2);
        opcionValidaciones1.add(opcionValidacion3);

        Validacion validacion1 = new Validacion("Audio Validacion", "¿Año de nacimiento?", 1, opcionValidaciones1);

        validacionRepository.save(validacion1);

        List<OpcionValidacion> opcionValidaciones2 = new ArrayList<OpcionValidacion>();
        opcionValidaciones2.add(opcionValidacion4);
        opcionValidaciones2.add(opcionValidacion5);
        opcionValidaciones2.add(opcionValidacion6);

        Validacion validacion2 = new Validacion("Audio Validacion", "¿Codigo postal?", 2, opcionValidaciones2);

        validacionRepository.save(validacion2);

        List<OpcionValidacion> opcionValidaciones3 = new ArrayList<OpcionValidacion>();
        opcionValidaciones3.add(opcionValidacion7);
        opcionValidaciones3.add(opcionValidacion8);
        opcionValidaciones3.add(opcionValidacion9);

        Validacion validacion3 = new Validacion("Audio Validacion", "¿Cantidad de hijos?", 3, opcionValidaciones3);

        validacionRepository.save(validacion3);

        List<OpcionValidacion> opcionValidaciones4 = new ArrayList<OpcionValidacion>();
        opcionValidaciones4.add(opcionValidacion10);
        opcionValidaciones4.add(opcionValidacion11);
        opcionValidaciones4.add(opcionValidacion12);

        Validacion validacion4 = new Validacion("Audio Validacion", "¿Correo electronico?", 4, opcionValidaciones4);

        validacionRepository.save(validacion4);

        List<Validacion> validaciones1 = new ArrayList<Validacion>();
        validaciones1.add(validacion1);
        validaciones1.add(validacion2);

        SubOpcionLlamada subOpcionLlamada1 = new SubOpcionLlamada("Solicitar una nueva tarjeta", 1, validaciones1);
        subOpcionLlamadaRepository.save(subOpcionLlamada1);

        List<Validacion> validaciones2 = new ArrayList<Validacion>();
        validaciones1.add(validacion3);
        validaciones1.add(validacion4);

        SubOpcionLlamada subOpcionLlamada2 = new SubOpcionLlamada("Anular tarjeta", 2, validaciones2);
        subOpcionLlamadaRepository.save(subOpcionLlamada2);

        List<SubOpcionLlamada> subOpcionLlamadas1 = new ArrayList<SubOpcionLlamada>();
        subOpcionLlamadas1.add(subOpcionLlamada1);
        subOpcionLlamadas1.add(subOpcionLlamada2);

        OpcionLlamada opcionLlamada = new OpcionLlamada("Audio opcion", "Mensaje opcion", "Robo de tarjeta", 1, subOpcionLlamadas1);
        opcionLlamadaRepository.save(opcionLlamada);

        CategoriaLlamada categoriaLlamada = new CategoriaLlamada("Audio Categoria", "Mensaje Categoria", "Informar un robo", 1);
        categoriaLlamadaRepository.save(categoriaLlamada);

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

        for (InformacionCliente informacionCliente: informacionClientes1) {
            informacionClienteRepository.save(informacionCliente);
        }

        Cliente cliente = new Cliente(29232323, "Jose Pereyra", 351232324, informacionClientes1);
        clienteRepository.save(cliente);

        List<CambioEstado> cambioEstados = new ArrayList<CambioEstado>();
        cambioEstados.add(cambioEstado);

        List<SubOpcionLlamada> subOpcionLlamadas = new ArrayList<>();
        subOpcionLlamadas.add(subOpcionLlamada1);
        subOpcionLlamadas.add(subOpcionLlamada2);

        Llamada llamada = new Llamada(cliente, cambioEstados, categoriaLlamada, opcionLlamada, subOpcionLlamadas, null);

        return llamadaRepository.save(llamada);
    }
}
