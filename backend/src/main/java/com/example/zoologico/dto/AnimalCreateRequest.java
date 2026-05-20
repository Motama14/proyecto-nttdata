package com.example.zoologico.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class AnimalCreateRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 80)
    private String nombre;

    @NotBlank(message = "La especie es obligatoria")
    @Size(max = 80)
    private String especie;

    @Size(max = 80)
    private String habitat;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer edad;

    @NotBlank(message = "El estado de salud es obligatorio")
    @Size(max = 120)
    private String estadoSalud;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    private LocalDate fechaIngreso;

    @NotNull(message = "El cuidador es obligatorio")
    private Long cuidadorId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Long getCuidadorId() {
        return cuidadorId;
    }

    public void setCuidadorId(Long cuidadorId) {
        this.cuidadorId = cuidadorId;
    }
}
