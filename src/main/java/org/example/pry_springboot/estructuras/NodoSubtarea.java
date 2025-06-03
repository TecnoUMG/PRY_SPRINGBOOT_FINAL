package org.example.pry_springboot.estructuras;

import org.example.pry_springboot.Tarea;

import java.util.ArrayList;
import java.util.List;

public class NodoSubtarea {
    private Tarea tarea;
    private List<NodoSubtarea> subtareas;

    public NodoSubtarea(Tarea tarea) {
        this.tarea = tarea;
        this.subtareas = new ArrayList<>();
    }

    public void agregarSubtarea(NodoSubtarea subtarea) {
        subtareas.add(subtarea);
    }

    public Tarea getTarea() {
        return tarea;
    }

    public List<NodoSubtarea> getSubtareas() {
        return subtareas;
    }
}
