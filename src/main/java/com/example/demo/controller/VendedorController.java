package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendedorController {
    @PostMapping("/vendedores")
    public void altaVendedores(@RequestBody VendedorInput vendedor) {
        System.out.println("El vendedor se ha dado de alta");
    }
}
