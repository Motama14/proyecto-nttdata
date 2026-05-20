package com.example.zoologico.config;

import com.example.zoologico.model.Animal;
import com.example.zoologico.model.Cuidador;
import com.example.zoologico.repository.AnimalRepository;
import com.example.zoologico.repository.CuidadorRepository;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarDatosIniciales(CuidadorRepository cuidadorRepository, AnimalRepository animalRepository) {
        return args -> {
            Cuidador ana = cuidadorRepository.save(new Cuidador(
                    "Ana",
                    "Martín López",
                    "ana.martin@zoo.com",
                    "600111222",
                    "Mamíferos",
                    "Mañana",
                    LocalDate.of(2023, 9, 1)
            ));

            Cuidador david = cuidadorRepository.save(new Cuidador(
                    "David",
                    "García Ruiz",
                    "david.garcia@zoo.com",
                    "600333444",
                    "Reptiles",
                    "Tarde",
                    LocalDate.of(2024, 1, 15)
            ));

            animalRepository.save(new Animal("Nala", "León", "Sabana africana", 5, "Sana", LocalDate.of(2022, 5, 12), ana));
            animalRepository.save(new Animal("Kibo", "Elefante", "Zona de grandes mamíferos", 12, "En revisión", LocalDate.of(2021, 3, 20), ana));
            animalRepository.save(new Animal("Rango", "Iguana", "Terrario tropical", 3, "Sana", LocalDate.of(2023, 11, 8), david));
        };
    }
}
