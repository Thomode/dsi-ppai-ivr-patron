package com.dsi.patterns;

public interface IIterador {
    void primero();
    void siguiente();
    Object actual();
    boolean haTerminado();
}
