package com.dsi.patterns;

import java.util.List;

public class IteradorSubOpcion implements IIterador{
    private int posicion;
    private List<Object> elementos;

    public IteradorSubOpcion(List<Object> elementos) {
        this.elementos = elementos;
    }

    @Override
    public void primero() {
        this.posicion = 0;
    }

    @Override
    public void siguiente() {
        if (this.posicion < this.elementos.size() - 1) {
            this.posicion++;
        }
    }

    @Override
    public Object actual() {
        if (this.posicion >= 0 && this.posicion < this.elementos.size()) {
            return this.elementos.get(this.posicion);
        }
        return null;
    }

    @Override
    public boolean haTerminado() {
        return this.posicion >= this.elementos.size() - 1;
    }
}
