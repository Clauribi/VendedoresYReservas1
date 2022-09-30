package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import com.example.demo.domain.ExisteExcepcion;
import com.example.demo.domain.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class ReservaController {
    private Concesionario concesionario = new Concesionario();

    @PostMapping("/reservas")
    public ResponseEntity<String> altaReservas(@Valid @RequestBody Reserva reserva) {
        try {
            concesionario.hacerReserva(reserva);
        } catch (ExisteExcepcion e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public String reservasByMatriculaByDni(@PathVariable String matricula, @PathVariable String dni) {

        ArrayList<Reserva> listaReservas = new ArrayList<>();
        for (Reserva reserva : concesionario.getListadoReservas().values()) {
            if (matricula == reserva.getMatricula() && dni == reserva.getDni()) {
                listaReservas.add(reserva);
            }
        }
        return listaReservas.toString();

    }

    @DeleteMapping("/reservas/coche/{matricula}/cliente/{dni}")
    public void cancelarReservaCoches(@PathVariable String matricula) {
    }
}


