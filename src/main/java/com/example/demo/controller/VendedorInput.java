package com.example.demo.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class VendedorInput{
    @NotNull(message = "Nombre is null")
    @NotBlank(message = "Nombre is empty")
    private String nombre;
    @NotNull(message = "Direccion is null")
    @NotBlank(message = "Direccion is empty")
    private String direccion;
    @NotNull(message = "Dni is null")
    @NotBlank(message = "Dni is empty")
    private String dni;
    @Positive(message = "telefono is negative")
    private int telefono;

    public VendedorInput(String nombre, String direccion, String dni, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }
    public VendedorInput(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

