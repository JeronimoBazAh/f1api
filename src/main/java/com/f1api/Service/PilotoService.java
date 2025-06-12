package com.f1api.Service;

import com.f1api.models.Piloto;
import com.f1api.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class PilotoService {

    @Autowired
    public PilotoRepository repository;

    public Page<Piloto> listarPilotos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(pilotoMapper::toDTO);
    }

}
