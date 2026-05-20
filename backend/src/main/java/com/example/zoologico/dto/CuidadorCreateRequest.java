package com.example.zoologico.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class CuidadorCreateRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 80)
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 120)
    private String apellidos;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    @Size(max = 120)
    private String email;

    @Size(max = 20)
    private String telefono;

    @NotBlank(message = "La especialidad es obligatoria")
    @Size(max = 80)
    private String especialidad;

    @NotBlank(message = "El turno es obligatorio")
    @Size(max = 40)
    private String turno;

    @NotNull(message = "La fecha de alta es obligatoria")
    private LocalDate fechaAlta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
