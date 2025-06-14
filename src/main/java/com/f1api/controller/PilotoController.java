package com.f1api.controller;

import com.f1api.Service.PilotoService;
import com.f1api.dto.PilotoDTO;
import com.f1api.dto.PilotoRequestDTO;
import com.f1api.models.Piloto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.f1api.repository.PilotoRepository;

import org.springframework.data.domain.Pageable; // ✅ ESTA SÍ VA
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {

    private PilotoRepository repository;
    private PilotoService pilotoService;

    public PilotoController(PilotoRepository repository,PilotoService pilotoService) {
        this.repository = repository;
        this.pilotoService = pilotoService;
    }

    @GetMapping
    public Page<PilotoDTO> listarPilotos(Pageable pageable) {
        return pilotoService.listarPilotos(pageable);
    }
    @PostMapping
    public ResponseEntity<PilotoDTO> crearPiloto(@RequestBody @Valid PilotoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pilotoService.crearPiloto(dto));
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
