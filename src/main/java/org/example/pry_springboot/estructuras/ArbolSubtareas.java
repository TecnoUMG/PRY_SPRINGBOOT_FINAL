package org.example.pry_springboot.estructuras;

import java.util.*;

public class ArbolSubtareas {
    private final Map<Long, NodoSubtarea> arbolPorUsuario = new HashMap<>();

    public void agregarRaiz(Long usuarioId, NodoSubtarea raiz) {
        arbolPorUsuario.put(usuarioId, raiz);
    }

    public NodoSubtarea obtenerRaiz(Long usuarioId) {
        return arbolPorUsuario.get(usuarioId);
    }

    public void eliminarArbol(Long usuarioId) {
        arbolPorUsuario.remove(usuarioId);
    }

    public Map<Long, NodoSubtarea> obtenerTodos() {
        return arbolPorUsuario;
    }
}
