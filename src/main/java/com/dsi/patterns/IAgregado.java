package com.dsi.patterns;

import java.util.List;

public interface IAgregado {
    IIterador crearIteradorSubOpcion(List<Object> elementos);
    IIterador crearIteradorOpcionValidacion(List<Object> elementos);
    IIterador crearIteradorValidacion(List<Object> elementos);
}
