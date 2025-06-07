package org.example.pry_springboot.estructuras;

import org.example.pry_springboot.Tarea;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ListaTareas {
    private final Map<Long, List<Tarea>> tareasPorUsuario = new ConcurrentHashMap<>();

    public void agregarTarea(Long usuarioId, Tarea tarea) {
        tareasPorUsuario.computeIfAbsent(usuarioId, k -> new ArrayList<>()).add(tarea);
    }

    public List<Tarea> obtenerTareas(Long usuarioId) {
        return tareasPorUsuario.getOrDefault(usuarioId, new ArrayList<>());
    }

    public boolean eliminarTarea(Long usuarioId, String tareaId) {
        List<Tarea> tareas = tareasPorUsuario.get(usuarioId);
        if (tareas != null) {
            return tareas.removeIf(t -> t.getId().equals(tareaId));
        }
        return false;
    }
    public boolean editarTarea(Long usuarioId, String tareaId, Tarea nuevatarea) {
        List<Tarea> tareas = tareasPorUsuario.get(usuarioId);
        if (tareas != null) {
            for (int i = 0; i < tareas.size(); i++) {
                if (tareas.get(i).getId().equals(tareaId)) {
                tareas.set(i, nuevatarea);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean completarTarea(Long usuarioId, String tareaId) {
        List<Tarea> tareas = tareasPorUsuario.get(usuarioId);
        if (tareas != null) {
            for (Tarea tarea : tareas) {
                if (tarea.getId().equals(tareaId)) {
                    tarea.setEstado("Completada");
                    return true;
                }
            }
        }
        return false;
    }




    public void limpiarTareas(Long usuarioId) {
        tareasPorUsuario.remove(usuarioId);
    }

    public Map<Long, List<Tarea>> obtenerMapaCompleto() {
        return tareasPorUsuario;
    }
}