package com.f1api.controller;

import com.f1api.models.Escuderia;
import com.f1api.repository.EscuderiaRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escuderia")
public class EscuderiaController {

    private EscuderiaRepository repository;

    public EscuderiaController(EscuderiaRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Escuderia> listar(){

        return repository.findAll();
    }

    @PostMapping
    public Escuderia agregar(@Valid @RequestBody Escuderia escuderia){
       return repository.save(escuderia);
    }


}

