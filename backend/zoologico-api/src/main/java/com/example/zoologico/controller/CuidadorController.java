package com.example.zoologico.controller;

import com.example.zoologico.dto.AnimalResponse;
import com.example.zoologico.dto.CuidadorCreateRequest;
import com.example.zoologico.dto.CuidadorResponse;
import com.example.zoologico.service.CuidadorService;
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
@RequestMapping("/api/cuidadores")
public class CuidadorController {

    private final CuidadorService cuidadorService;

    public CuidadorController(CuidadorService cuidadorService) {
        this.cuidadorService = cuidadorService;
    }

    @GetMapping
    public List<CuidadorResponse> listarCuidadores() {
        return cuidadorService.listarCuidadores();
    }

    @GetMapping("/{id}")
    public CuidadorResponse obtenerCuidador(@PathVariable Long id) {
        return cuidadorService.obtenerCuidador(id);
    }

    @PostMapping
    public ResponseEntity<CuidadorResponse> crearCuidador(@Valid @RequestBody CuidadorCreateRequest request) {
        CuidadorResponse response = cuidadorService.crearCuidador(request);
        return ResponseEntity.created(URI.create("/api/cuidadores/" + response.getId())).body(response);
    }

    @PutMapping("/{id}")
    public CuidadorResponse actualizarCuidador(@PathVariable Long id, @Valid @RequestBody CuidadorCreateRequest request) {
        return cuidadorService.actualizarCuidador(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuidador(@PathVariable Long id) {
        cuidadorService.eliminarCuidador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/animales")
    public List<AnimalResponse> listarAnimalesDeCuidador(@PathVariable Long id) {
        return cuidadorService.listarAnimalesDeCuidador(id);
    }
}
