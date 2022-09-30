package com.example.demo.controller;

import com.example.demo.domain.Vendedor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VendedorInput extends VendedorUpdate {
    @NotNull(message = "dni is null")
    @NotBlank(message = "dni is empty")
    private String dni;

    public VendedorInput(String nombre, String direccion, String dni, String telefono) {
        super(nombre, direccion, telefono);
        this.dni = dni;

    }
    public VendedorInput() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Vendedor createDomainObject() {
        return new Vendedor(this.nombre, this.direccion, this.dni, this.telefono);
    }

}

