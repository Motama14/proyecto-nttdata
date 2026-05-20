package com.example.zoologico.dto;

import java.time.LocalDate;

public class CuidadorResponse {

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String especialidad;
    private String turno;
    private LocalDate fechaAlta;
    private int numeroAnimales;

    public CuidadorResponse(Long id, String nombre, String apellidos, String email, String telefono, String especialidad, String turno, LocalDate fechaAlta, int numeroAnimales) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.turno = turno;
        this.fechaAlta = fechaAlta;
        this.numeroAnimales = numeroAnimales;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public int getNumeroAnimales() {
        return numeroAnimales;
    }
}
