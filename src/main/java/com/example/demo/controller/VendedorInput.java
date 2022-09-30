package com.example.demo.controller;

import com.example.demo.domain.Vendedor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class VendedorInput extends VendedorUpdate {
    private String dni;

    public VendedorInput(String nombre, String direccion, String dni, String telefono) {
        super(nombre, direccion, telefono);
        this.dni = dni;

    }

    public VendedorInput() {
    }

    public Vendedor createDomainObject() {
        return new Vendedor(this.nombre, this.direccion, this.dni, this.telefono);
    }

}

