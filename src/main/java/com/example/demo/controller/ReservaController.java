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
    @PostMapping("/reservas/coches/{matricula}/clientes/{dni}")
        public String reservasByMatriculaByDni(@PathVariable String matricula, @PathVariable String dni) {
            try {
                ArrayList<Reserva> listaReservas = new ArrayList<>();
                for (Reserva reserva : concesionario.getListadoReservas().values()) {
                if(reserva.getDni()== dni&&reserva.getMatricula()== matricula){
                    listaReservas.add(reserva);
                }
                } return listaReservas.toString();

            } catch (Exception e) {
                e.getMessage();
            } return null;

        }
    @DeleteMapping("/reservas/coches/{matricula}")
        public void cancelarReservaCoches(@PathVariable String matricula) {
    }
}


