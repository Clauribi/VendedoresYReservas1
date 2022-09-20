package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CocheController {
    @GetMapping("/coches/{matricula}/clientes/{dni}")
        public void reservarCoches(@PathVariable String matricula, @PathVariable String dni) {
            System.out.println("Se reserva el coche con matricula: "+ matricula +" " +"al cliente con dni: "+ dni);
        }
    @DeleteMapping("/coches/{matricula}")
        public void cancelarReservaCoches(@PathVariable String matricula) {
        System.out.println("Se cancela reserva del coche con matricula: "+matricula);
    }
}


