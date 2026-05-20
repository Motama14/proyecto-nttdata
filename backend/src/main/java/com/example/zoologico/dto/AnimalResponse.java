package com.example.zoologico.dto;

import java.time.LocalDate;

public class AnimalResponse {

    private Long id;
    private String nombre;
    private String especie;
    private String habitat;
    private Integer edad;
    private String estadoSalud;
    private LocalDate fechaIngreso;
    private Long cuidadorId;
    private String nombreCuidador;

    public AnimalResponse(Long id, String nombre, String especie, String habitat, Integer edad, String estadoSalud, LocalDate fechaIngreso, Long cuidadorId, String nombreCuidador) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.habitat = habitat;
        this.edad = edad;
        this.estadoSalud = estadoSalud;
        this.fechaIngreso = fechaIngreso;
        this.cuidadorId = cuidadorId;
        this.nombreCuidador = nombreCuidador;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getHabitat() {
        return habitat;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Long getCuidadorId() {
        return cuidadorId;
    }

    public String getNombreCuidador() {
        return nombreCuidador;
    }
}
