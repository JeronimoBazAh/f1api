package com.f1api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Escuderia {

    @Id
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String nacionalidad;

    private Long campeonatos;

    public Escuderia() {
    }

    public Escuderia(Long id, String nombre, String nacionalidad, Long campeonatos) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.campeonatos = campeonatos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(Long campeonatos) {
        this.campeonatos = campeonatos;
    }
}
