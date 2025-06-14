package com.f1api.mapper;

import com.f1api.dto.PilotoDTO;
import com.f1api.models.Piloto;
import org.springframework.stereotype.Component;

@Component
public class PilotoMapper {

    public PilotoDTO toDTO(Piloto piloto){
        return new PilotoDTO(
                piloto.getNombre(),
                piloto.getNacionalidad(),
                piloto.getEscuderia() != null ? String.valueOf(piloto.getEscuderia()) : null

        );
    }

}
