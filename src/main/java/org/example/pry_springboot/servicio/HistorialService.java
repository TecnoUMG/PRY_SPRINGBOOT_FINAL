package org.example.pry_springboot.servicio;

import org.example.pry_springboot.Historial;
import org.example.pry_springboot.estructuras.PilaAcciones;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Stack;

@Service
public class HistorialService {
    private final PilaAcciones pilaAcciones = new PilaAcciones();

    public void registrarAccion(Long usuarioId, String descripcion) {
        Historial historial = new Historial();
        historial.setAccion(descripcion);
        historial.setFecha(LocalDateTime.now());
        pilaAcciones.registrarAccion(usuarioId, historial);
    }

    public Historial deshacer(Long usuarioId) {
        return pilaAcciones.deshacerUltimaAccion(usuarioId);
    }

    public Stack<Historial> obtenerHistorial(Long usuarioId) {
        return pilaAcciones.obtenerHistorial(usuarioId);
    }
}
