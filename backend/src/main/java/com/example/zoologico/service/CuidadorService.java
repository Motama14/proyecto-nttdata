package com.example.zoologico.service;

import com.example.zoologico.dto.AnimalResponse;
import com.example.zoologico.dto.CuidadorCreateRequest;
import com.example.zoologico.dto.CuidadorResponse;
import com.example.zoologico.exception.DuplicateResourceException;
import com.example.zoologico.exception.ResourceNotFoundException;
import com.example.zoologico.model.Animal;
import com.example.zoologico.model.Cuidador;
import com.example.zoologico.repository.AnimalRepository;
import com.example.zoologico.repository.CuidadorRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuidadorService {

    private final CuidadorRepository cuidadorRepository;
    private final AnimalRepository animalRepository;

    public CuidadorService(CuidadorRepository cuidadorRepository, AnimalRepository animalRepository) {
        this.cuidadorRepository = cuidadorRepository;
        this.animalRepository = animalRepository;
    }

    @Transactional(readOnly = true)
    public List<CuidadorResponse> listarCuidadores() {
        return cuidadorRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public CuidadorResponse obtenerCuidador(Long id) {
        return toResponse(buscarCuidadorPorId(id));
    }

    @Transactional
    public CuidadorResponse crearCuidador(CuidadorCreateRequest request) {
        if (cuidadorRepository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new DuplicateResourceException("Ya existe un cuidador con ese email");
        }

        Cuidador cuidador = new Cuidador(
                request.getNombre(),
                request.getApellidos(),
                request.getEmail(),
                request.getTelefono(),
                request.getEspecialidad(),
                request.getTurno(),
                request.getFechaAlta()
        );

        Cuidador guardado = cuidadorRepository.save(cuidador);
        return toResponse(guardado);
    }

    @Transactional
    public CuidadorResponse actualizarCuidador(Long id, CuidadorCreateRequest request) {
        Cuidador cuidador = buscarCuidadorPorId(id);

        cuidador.setNombre(request.getNombre());
        cuidador.setApellidos(request.getApellidos());
        cuidador.setEmail(request.getEmail());
        cuidador.setTelefono(request.getTelefono());
        cuidador.setEspecialidad(request.getEspecialidad());
        cuidador.setTurno(request.getTurno());
        cuidador.setFechaAlta(request.getFechaAlta());

        return toResponse(cuidadorRepository.save(cuidador));
    }

    @Transactional
    public void eliminarCuidador(Long id) {
        Cuidador cuidador = buscarCuidadorPorId(id);
        cuidadorRepository.delete(cuidador);
    }

    @Transactional(readOnly = true)
    public List<AnimalResponse> listarAnimalesDeCuidador(Long cuidadorId) {
        buscarCuidadorPorId(cuidadorId);
        return animalRepository.findByCuidadorId(cuidadorId).stream()
                .map(this::toAnimalResponse)
                .toList();
    }

    private Cuidador buscarCuidadorPorId(Long id) {
        return cuidadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe ningún cuidador con id " + id));
    }

    private CuidadorResponse toResponse(Cuidador cuidador) {
        return new CuidadorResponse(
                cuidador.getId(),
                cuidador.getNombre(),
                cuidador.getApellidos(),
                cuidador.getEmail(),
                cuidador.getTelefono(),
                cuidador.getEspecialidad(),
                cuidador.getTurno(),
                cuidador.getFechaAlta(),
                cuidador.getAnimales().size()
        );
    }

    private AnimalResponse toAnimalResponse(Animal animal) {
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
