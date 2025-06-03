package org.example.pry_springboot.servicio;

import org.example.pry_springboot.estructuras.ArbolSubtareas;
import org.example.pry_springboot.estructuras.NodoSubtarea;
import org.springframework.stereotype.Service;

@Service
public class ArbolService {
    private final ArbolSubtareas arbol = new ArbolSubtareas();

    public void crearArbol(Long usuarioId, NodoSubtarea raiz) {
        arbol.agregarRaiz(usuarioId, raiz);
    }

    public NodoSubtarea obtenerArbol(Long usuarioId) {
        return arbol.obtenerRaiz(usuarioId);
    }

    public void eliminarArbol(Long usuarioId) {
        arbol.eliminarArbol(usuarioId);
    }
}
