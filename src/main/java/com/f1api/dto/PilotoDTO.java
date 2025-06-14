package com.f1api.dto;

import jakarta.validation.constraints.NotBlank;

public record PilotoDTO(
        @NotBlank(message = "El nombre no debe estar vacio")
        String nombre,
        @NotBlank(message = "La escuderia no debe estar vacia")
        String nombreEscuderia,
        @NotBlank(message = "La nacionalidad no debe estar vacia")
        String nacionalidad
){}
