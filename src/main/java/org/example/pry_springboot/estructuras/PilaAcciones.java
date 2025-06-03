package org.example.pry_springboot.estructuras;

import org.example.pry_springboot.Historial;

import java.util.*;

public class PilaAcciones {
    private final Map<Long, Stack<Historial>> accionesPorUsuario = new HashMap<>();

    public void registrarAccion(Long usuarioId, Historial historial) {
        accionesPorUsuario
                .computeIfAbsent(usuarioId, k -> new Stack<>())
                .push(historial);
    }

    public Historial deshacerUltimaAccion(Long usuarioId) {
        Stack<Historial> pila = accionesPorUsuario.get(usuarioId);
        if (pila != null && !pila.isEmpty()) {
            return pila.pop();
        }
        return null;
    }

    public Stack<Historial> obtenerHistorial(Long usuarioId) {
        return accionesPorUsuario.getOrDefault(usuarioId, new Stack<>());
    }
}
