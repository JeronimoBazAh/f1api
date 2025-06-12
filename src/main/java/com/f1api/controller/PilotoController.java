package com.f1api.controller;

import com.f1api.models.Piloto;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.f1api.repository.PilotoRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {

    private PilotoRepository repository;

    public PilotoController(PilotoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Piloto> listar(Pageable pageable){
        return  repository.findAll(pageable);
    }
    @PostMapping
    public Piloto agregar(@Valid @RequestBody Piloto piloto) {
        return repository.save(piloto);
    }

    @PutMapping("/{id}")
    public Piloto actualizar(@PathVariable Long id, @RequestBody Piloto datos){
        Optional<Piloto> pilotoOpcional = repository.findById(id);
        if(pilotoOpcional.isPresent()){
            Piloto piloto = pilotoOpcional.get();
            piloto.setNombre(datos.getNombre());
            piloto.setEscuderia(datos.getEscuderia());
            piloto.setNacionalidad(datos.getNacionalidad());
            return repository.save(piloto);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Piloto no encontrado");
        }
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        repository.deleteById(id);

    }
}
