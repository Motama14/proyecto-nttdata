package com.example.zoologico.repository;

import com.example.zoologico.model.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    boolean existsByEmailIgnoreCase(String email);
}
