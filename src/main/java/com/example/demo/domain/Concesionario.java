package com.example.demo.domain;

import java.util.HashMap;

public class Concesionario {
    private HashMap<String, Reserva> listadoReservas = new HashMap<>();

    public Concesionario(HashMap<String, Reserva> listadoReservas) {
        this.listadoReservas = listadoReservas;
    }

    public Concesionario() {
    }

    public HashMap<String, Reserva> getListadoReservas() {
        return listadoReservas;
    }

    public void hacerReserva(Reserva reserva) throws ExisteExcepcion {
        if (listadoReservas.get(reserva.getMatricula()) != null) {
            throw new ExisteExcepcion("el coche.");
        } else {
            this.listadoReservas.put(reserva.getMatricula(), reserva);
        }
    }

    public void cancelarReserva(String matricula) {
        this.listadoReservas.remove(matricula);

    }
}
