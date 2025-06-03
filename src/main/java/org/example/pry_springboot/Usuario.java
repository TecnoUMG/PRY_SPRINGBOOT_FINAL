package org.example.pry_springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private String email;
}
