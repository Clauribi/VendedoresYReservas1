package com.example.demo.domain;

import com.example.demo.controller.VendedorUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Concesionario {
    private HashMap<String, Reserva> listadoReservas = new HashMap<>();
    private static HashMap<String, Vendedor> listadoVendedores = new HashMap<>();

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
    public static void addVendedor(Vendedor vendedor) throws ExisteExcepcion {
        if (listadoVendedores.get(vendedor.getDni()) != null) {
            throw new ExisteExcepcion("el vendedor.");
        } else {
            listadoVendedores.put(vendedor.getDni(), vendedor);
        }
    }

    public static void deleteVendedor(String dni) throws NoExisteExcepcion {
        if (!listadoVendedores.containsKey(dni)) {
            throw new NoExisteExcepcion("el vendedor con dni: " + dni);
        } else {
            listadoVendedores.remove(dni);
        }
    }

    public static void updateVendedor(String dni, Vendedor vendedor) throws NoExisteExcepcion {
        if (!listadoVendedores.containsKey(dni)) {
            throw new NoExisteExcepcion("el vendedor con dni: " + dni);
        } else {
            listadoVendedores.put(dni, vendedor);
        }
    }

    public static List<Vendedor> getAllVendedores() throws NoExisteExcepcion {
        if (listadoVendedores.isEmpty()) {
            throw new NoExisteExcepcion("listado de vendedores está vacía.");
        }
        return new ArrayList<>(listadoVendedores.values());
    }
}
