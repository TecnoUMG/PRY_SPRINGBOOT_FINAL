package org.example.pry_springboot.servicio;

import org.example.pry_springboot.Repositorio.TareaMongoRepository;
import org.example.pry_springboot.Tarea;
import org.example.pry_springboot.estructuras.ListaTareas;
import org.example.pry_springboot.mensajeria.TareaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TareaService {

    private final ListaTareas listaTareas = new ListaTareas();
       @Autowired
    private TareaProducer tareaProducer;
    @Autowired
    private HistorialService historialService;
    @Autowired
    private TareaMongoRepository tareaMongoRepository;


    // Crear tarea
    public void agregarTarea(Long usuarioId, Tarea tarea) {
        listaTareas.agregarTarea(usuarioId, tarea);
        tareaProducer.enviarTareaCreada(tarea);
        tarea.setUsuarioId(usuarioId);
        tareaMongoRepository.save(tarea);
        historialService.registrarAccion(usuarioId, "Tarea creada: " + tarea.getTitulo());
    }

    // Listar tareas
    public List<Tarea> listarTareas(Long usuarioId) {
        return listaTareas.obtenerTareas(usuarioId);
    }

    // Eliminar tarea
    public boolean eliminarTarea(Long usuarioId, String tareaId) {
        boolean eliminado = listaTareas.eliminarTarea(usuarioId,tareaId);
        if (eliminado) {
            tareaMongoRepository.deleteById(tareaId);
            historialService.registrarAccion(usuarioId, "Tarea eliminada: ID " + tareaId);
        }
        return eliminado;

    }

    // Editar tarea
    public boolean editarTarea(Long usuarioId, String tareaId, Tarea nuevaTarea) {
        List<Tarea> tareas = listaTareas.obtenerTareas(usuarioId);
        for (Tarea tarea : tareas) {
            if (tarea.getId().equals(tareaId)) {
                tarea.setTitulo(nuevaTarea.getTitulo());
                tarea.setDescripcion(nuevaTarea.getDescripcion());
                tarea.setPrioridad(nuevaTarea.getPrioridad());
                tarea.setCategoria(nuevaTarea.getCategoria());
                tarea.setEstado(nuevaTarea.getEstado());
                tarea.setFechaProgramada(nuevaTarea.getFechaProgramada());

                tareaMongoRepository.save(tarea);
                historialService.registrarAccion(usuarioId, "Tarea modificada: ID" + tareaId);
                return true;
            }
        }
        return false;
    }

    // Marcar como completada
    public boolean completarTarea(Long usuarioId, String tareaId) {
        List<Tarea> tareas = listaTareas.obtenerTareas(usuarioId);
        for (Tarea tarea : tareas) {
            if (tarea.getId().equals(tareaId)) {
                tarea.setEstado("completada");
                tareaProducer.enviarTareaCompletada(tarea);
                tareaMongoRepository.save(tarea);
                historialService.registrarAccion(usuarioId, "Tarea completada: ID " + tareaId);
                return true;
            }
        }
        return false;
    }
}
