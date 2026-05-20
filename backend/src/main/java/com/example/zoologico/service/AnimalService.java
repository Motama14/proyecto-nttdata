package com.example.zoologico.service;

import com.example.zoologico.dto.AnimalCreateRequest;
import com.example.zoologico.dto.AnimalResponse;
import com.example.zoologico.exception.ResourceNotFoundException;
import com.example.zoologico.model.Animal;
import com.example.zoologico.model.Cuidador;
import com.example.zoologico.repository.AnimalRepository;
import com.example.zoologico.repository.CuidadorRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final CuidadorRepository cuidadorRepository;

    public AnimalService(AnimalRepository animalRepository, CuidadorRepository cuidadorRepository) {
        this.animalRepository = animalRepository;
        this.cuidadorRepository = cuidadorRepository;
    }

    @Transactional(readOnly = true)
    public List<AnimalResponse> listarAnimales() {
        return animalRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public AnimalResponse obtenerAnimal(Long id) {
        return toResponse(buscarAnimalPorId(id));
    }

    @Transactional
    public AnimalResponse crearAnimal(AnimalCreateRequest request) {
        Cuidador cuidador = buscarCuidadorPorId(request.getCuidadorId());

        Animal animal = new Animal(
                request.getNombre(),
                request.getEspecie(),
                request.getHabitat(),
                request.getEdad(),
                request.getEstadoSalud(),
                request.getFechaIngreso(),
                cuidador
        );

        Animal guardado = animalRepository.save(animal);
        return toResponse(guardado);
    }

    @Transactional
    public AnimalResponse actualizarAnimal(Long id, AnimalCreateRequest request) {
        Animal animal = buscarAnimalPorId(id);
        Cuidador cuidador = buscarCuidadorPorId(request.getCuidadorId());

        animal.setNombre(request.getNombre());
        animal.setEspecie(request.getEspecie());
        animal.setHabitat(request.getHabitat());
        animal.setEdad(request.getEdad());
        animal.setEstadoSalud(request.getEstadoSalud());
        animal.setFechaIngreso(request.getFechaIngreso());
        animal.setCuidador(cuidador);

        return toResponse(animalRepository.save(animal));
    }

    @Transactional
    public void eliminarAnimal(Long id) {
        Animal animal = buscarAnimalPorId(id);
        animalRepository.delete(animal);
    }

    private Animal buscarAnimalPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ningún animal con id " + id));
    }

    private Cuidador buscarCuidadorPorId(Long id) {
        return cuidadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ningún cuidador con id " + id));
    }

    private AnimalResponse toResponse(Animal animal) {
        return new AnimalResponse(
                animal.getId(),
                animal.getNombre(),
                animal.getEspecie(),
                animal.getHabitat(),
                animal.getEdad(),
                animal.getEstadoSalud(),
                animal.getFechaIngreso(),
                animal.getCuidador().getId(),
                animal.getCuidador().getNombre() + " " + animal.getCuidador().getApellidos()
        );
    }
}
