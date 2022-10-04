package com.example.demo.controller;

import com.example.demo.domain.Reserva;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReservaController {
    private ArrayList<Reserva> listadoReservas = new ArrayList<>();

    @PostMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public void reservasByMatriculaByDni(@PathVariable String matricula, @PathVariable String dni) {
        Reserva reserva = new Reserva(matricula, dni);
        listadoReservas.add(reserva);


    }
    @DeleteMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public void cancelarReservaCoches(@PathVariable String matricula, @PathVariable String dni) {
        Reserva reserva = new Reserva(matricula, dni);
        listadoReservas.remove(reserva);

    }
}


