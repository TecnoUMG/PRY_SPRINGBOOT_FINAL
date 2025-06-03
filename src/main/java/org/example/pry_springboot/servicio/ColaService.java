package org.example.pry_springboot.servicio;

import org.example.pry_springboot.Tarea;
import org.example.pry_springboot.estructuras.ColaTareasProgramadas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaService {
    private final ColaTareasProgramadas cola = new ColaTareasProgramadas();

    public void programarTarea(Long usuarioId, Tarea tarea) {
        cola.agregarTarea(usuarioId, tarea);
    }

    public Tarea verSiguiente(Long usuarioId) {
        return cola.obtenerSiguienteTarea(usuarioId);
    }

    public Tarea ejecutarTarea(Long usuarioId) {
        return cola.ejecutarSiguienteTarea(usuarioId);
    }

    public List<Tarea> listarTareasProgramadas(Long usuarioId) {
        return cola.listarTodas(usuarioId);
    }
}
