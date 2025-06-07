package org.example.pry_springboot.estructuras;

import org.example.pry_springboot.Tarea;

import java.util.*;

public class ColaTareasProgramadas {
    private final Map<Long, PriorityQueue<Tarea>> colaPorUsuario = new HashMap<>();

    public void agregarTarea(Long usuarioId, Tarea tarea) {
        colaPorUsuario
                .computeIfAbsent(usuarioId, k -> new PriorityQueue<>(Comparator.comparing(Tarea::getFechaProgramada)))
                .add(tarea);
    }

    public Tarea obtenerSiguienteTarea(Long usuarioId) {
        PriorityQueue<Tarea> cola = colaPorUsuario.get(usuarioId);
        if (cola != null && !cola.isEmpty()) {
            return cola.peek();
        }
        return null;
    }

    public Tarea ejecutarSiguienteTarea(Long usuarioId) {
        PriorityQueue<Tarea> cola = colaPorUsuario.get(usuarioId);
        if (cola != null && !cola.isEmpty()) {
            return cola.poll();
        }
        return null;
    }

    public List<Tarea> listarTodas(Long usuarioId) {
        PriorityQueue<Tarea> cola = colaPorUsuario.get(usuarioId);
        if (cola != null) {
            return new ArrayList<>(cola);
        }
        return Collections.emptyList();
    }

    public void limpiar(Long usuarioId) {
        colaPorUsuario.remove(usuarioId);
    }
}
