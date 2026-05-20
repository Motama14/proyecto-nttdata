package com.example.zoologico.repository;

import com.example.zoologico.model.Animal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByCuidadorId(Long cuidadorId);
}
