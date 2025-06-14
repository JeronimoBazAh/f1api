package com.f1api.dto;

import com.f1api.models.Escuderia;

public record PilotoRequestDTO(
        String nombre,
        Escuderia escuderia,
        String nacionalidad
) {}
