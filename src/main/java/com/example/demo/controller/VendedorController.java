package com.example.demo.controller;

import com.example.demo.domain.Concesionario;
import com.example.demo.domain.ExisteExcepcion;
import com.example.demo.domain.NoExisteExcepcion;
import com.example.demo.domain.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        } catch (Exception e1){
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
    public void modificarVendedores(@PathVariable String dni, @Valid @RequestBody VendedorUpdate vendedorUpdate) {
        try {
             Vendedor vendedor = new Vendedor(vendedorUpdate.getNombre(), vendedorUpdate.getDireccion(), dni, vendedorUpdate.getTelefono());
            Concesionario.updateVendedor(vendedor);
        } catch (NoExisteExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/vendedores")
    public ResponseEntity<List<Vendedor>> getVendedores() {
        return ResponseEntity.ok(Concesionario.getAllVendedores());
    }
}
