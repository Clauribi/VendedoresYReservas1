package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class VendedorController {
    @PostMapping("/vendedores")
    public void altaVendedores(@Valid @RequestBody VendedorInput vendedor) {
        System.out.println("El vendedor se ha dado de alta");
    }
    @PutMapping("/vendedores/{dni}")
    public void modificarVendedores(@Valid @PathVariable String dni, @RequestBody VendedorUpdate vendedor) {
        System.out.println("El vendedor se ha modificado");

    }
    @DeleteMapping("/vendedores/{dni}")
    public void bajaVendedores(@PathVariable String dni){
        System.out.println("El vendedor se ha dado de baja");
    }
}
