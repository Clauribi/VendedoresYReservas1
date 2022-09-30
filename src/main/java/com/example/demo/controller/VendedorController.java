package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import com.example.demo.domain.ExisteExcepcion;
import com.example.demo.domain.NoExisteExcepcion;
import com.example.demo.domain.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VendedorController {


    @PostMapping("/vendedores")
    public ResponseEntity<String> altaVendedores(@Valid @RequestBody VendedorInput vendedorInput) {
        try {
            Concesionario.addVendedor(vendedorInput.createDomainObject());
        } catch (ExisteExcepcion e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception e1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/vendedores/{dni}")
    public ResponseEntity<String> bajaVendedores(@PathVariable String dni) {
        try {
            Concesionario.deleteVendedor(dni);
        } catch (NoExisteExcepcion e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception e1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/vendedores/{dni}")
    public ResponseEntity<String> modificarVendedores(@PathVariable String dni, @Valid @RequestBody VendedorUpdate vendedorUpdate) {
        try {
            Vendedor vendedor = vendedorUpdate.createDomainObject(dni);
            Concesionario.updateVendedor(vendedor);
        } catch (NoExisteExcepcion e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception e1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/vendedores")
    public ResponseEntity<List<VendedorOutput>> getVendedores() {
        try {
            List<Vendedor> vendedores = Concesionario.getAllVendedores();
            List<VendedorOutput> vendedoresOut = new ArrayList<>();
            for (Vendedor vendedor : vendedores) {
                vendedoresOut.add(new VendedorOutput(vendedor.getNombre(), vendedor.getDni(), vendedor.getTelefono()));
            }
            return ResponseEntity.ok(vendedoresOut);
        } catch (NoExisteExcepcion e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
