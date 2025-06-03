package org.example.pry_springboot.controlador;

import org.example.pry_springboot.Historial;
import org.example.pry_springboot.servicio.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @PostMapping("/{usuarioId}/registrar")
    public void registrarAccion(@PathVariable Long usuarioId,@RequestBody String descripcion) {
        historialService.registrarAccion(usuarioId, descripcion);
    }
        @GetMapping("/{usuarioId}/")
        public List<Historial> obtenerHistorial(@PathVariable Long usuarioId) {
        return historialService.obtenerHistorial(usuarioId);
        }
        @DeleteMapping("/{usuarioId}/deshacer")
        public Historial deshacerUltimaAccion(@PathVariable Long usuarioId) {
        return historialService.deshacer(usuarioId);
        }
}
