package com.f1api.repository;

import com.f1api.models.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Long> {

}
