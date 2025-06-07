package org.example.pry_springboot.controlador;

import org.example.pry_springboot.Tarea;
import org.example.pry_springboot.servicio.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Crear tarea
    @PostMapping("/{usuarioId}")
    public void crearTarea(@PathVariable Long usuarioId, @RequestBody Tarea tarea) {
        tareaService.agregarTarea(usuarioId, tarea);
    }

    // Listar tareas por usuario
    @GetMapping("/{usuarioId}")
    public List<Tarea> listarTareas(@PathVariable Long usuarioId) {
        return tareaService.listarTareas(usuarioId);
    }

    // Eliminar tarea
    @DeleteMapping("/{usuarioId}/{tareaId}")
    public void eliminarTarea(@PathVariable Long usuarioId, @PathVariable String  tareaId) {
        tareaService.eliminarTarea(usuarioId, tareaId);
    }

    // Editar tarea
    @PutMapping("/{usuarioId}/{tareaId}")
    public ResponseEntity<String> editarTarea(
            @PathVariable Long usuarioId,
            @PathVariable String tareaId,
            @RequestBody Tarea tareaActualizada) {

        boolean editada = tareaService.editarTarea(usuarioId,  tareaId, tareaActualizada);
        if (editada) {
            return ResponseEntity.ok("Tarea editada correctamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Marcar tarea como completada
    @PatchMapping("/{usuarioId}/{tareaId}/completar")
    public ResponseEntity<String> completarTarea(
            @PathVariable Long usuarioId,
            @PathVariable String tareaId) {

        boolean completada = tareaService.completarTarea(usuarioId, tareaId);
        if (completada) {
            return ResponseEntity.ok("Tarea marcada como completada.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

