package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concesionario {
    private HashMap<String, Reserva> listadoReservas = new HashMap<>();
    private HashMap<String, Vendedor> listadoVendedores = new HashMap<>();

    public Concesionario(HashMap<String, Reserva> listadoReservas, HashMap<String, Vendedor> listadoVendedores) {
        this.listadoReservas = listadoReservas;
        this.listadoVendedores = listadoVendedores;
    }
    public Concesionario() {
    }

    public HashMap<String, Reserva> getListadoReservas() {
        return listadoReservas;
    }

    public HashMap<String, Vendedor> getListadoVendedores() {
        return listadoVendedores;
    }

    //RESERVASSS
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
//VENDEDORESSS
    public void addVendedor(Vendedor vendedor) throws ExisteExcepcion {
        if (listadoVendedores.get(vendedor.getDni()) != null) {
            throw new ExisteExcepcion("el vendedor.");
        } else {
            this.listadoVendedores.put(vendedor.getDni(), vendedor);
        }
    }

    public void deleteVendedor(String dni) throws NoExisteExcepcion {
        if (!listadoVendedores.containsKey(dni)) {
            throw new NoExisteExcepcion("el vendedor con dni: " + dni);
        } else {
            this.listadoVendedores.remove(dni);
        }
    }

    public void updateVendedor(Vendedor vendedor) throws NoExisteExcepcion {
        if (!listadoVendedores.containsKey(vendedor.getDni())) {
            throw new NoExisteExcepcion("el vendedor.");
        } else {
            this.listadoVendedores.put(vendedor.getDni(), vendedor);
        }
    }

    public List<Vendedor> getAllVendedores() {
        return new ArrayList<>(listadoVendedores.values());
    }
}
