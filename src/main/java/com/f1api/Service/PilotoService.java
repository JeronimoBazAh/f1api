package com.f1api.Service;

import com.f1api.dto.PilotoDTO;
import com.f1api.dto.PilotoRequestDTO;
import com.f1api.mapper.PilotoMapper;
import com.f1api.models.Piloto;
import com.f1api.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PilotoService {

    @Autowired
    private PilotoRepository repository;

    @Autowired
    private PilotoMapper pilotoMapper;

    public Page<PilotoDTO> listarPilotos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(pilotoMapper::toDTO);
    }

    public PilotoDTO crearPiloto(PilotoRequestDTO dto){
        Piloto piloto = new Piloto();
        piloto.setNombre(dto.nombre());
        piloto.setEscuderia(dto.escuderia());
        piloto.setNacionalidad(dto.nacionalidad());
        repository.save(piloto);
        return pilotoMapper.toDTO(piloto);
    }

}
