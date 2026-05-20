package com.example.zoologico.controller;

import com.example.zoologico.dto.AnimalCreateRequest;
import com.example.zoologico.dto.AnimalResponse;
import com.example.zoologico.service.AnimalService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<AnimalResponse> listarAnimales() {
        return animalService.listarAnimales();
    }

    @GetMapping("/{id}")
    public AnimalResponse obtenerAnimal(@PathVariable Long id) {
        return animalService.obtenerAnimal(id);
    }

    @PostMapping
    public ResponseEntity<AnimalResponse> crearAnimal(@Valid @RequestBody AnimalCreateRequest request) {
        AnimalResponse response = animalService.crearAnimal(request);
        return ResponseEntity.created(URI.create("/api/animales/" + response.getId())).body(response);
    }

    @PutMapping("/{id}")
    public AnimalResponse actualizarAnimal(@PathVariable Long id, @Valid @RequestBody AnimalCreateRequest request) {
        return animalService.actualizarAnimal(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAnimal(@PathVariable Long id) {
        animalService.eliminarAnimal(id);
        return ResponseEntity.noContent().build();
    }
}
