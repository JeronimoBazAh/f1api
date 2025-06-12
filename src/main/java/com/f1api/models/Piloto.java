package com.f1api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Piloto {

    @Id
    private Long id;
    @NotBlank(message = "Esta vacio culiau")
    private String nombre;

    @NotBlank
    private String nacionalidad;

    @ManyToOne
    private Escuderia escuderia;

    
    public Piloto() {
    }

    public Piloto(Long id,String nombre, String nacionalidad, String escuderia) {
        this.id =id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.escuderia = escuderia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
