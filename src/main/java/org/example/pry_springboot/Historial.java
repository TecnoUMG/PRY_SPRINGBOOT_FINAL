package org.example.pry_springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Historial {
    @Id @GeneratedValue
    private Long id;
    private String accion;
    private LocalDateTime fecha;

    @ManyToOne
    private Usuario usuario;

    public String getAccion() {
        return accion;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
