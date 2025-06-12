package com.f1api.repository;

import com.f1api.models.Escuderia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EscuderiaRepository extends JpaRepository<Escuderia,Long> {
}
