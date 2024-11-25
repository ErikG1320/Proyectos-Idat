package com.examen3java.desarrolloweb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.examen3java.desarrolloweb.Entity.Provedores;
import com.examen3java.desarrolloweb.service.ProveedoresService;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<List<Provedores>> getAllProveedores() {
        try {
            List<Provedores> proveedores = proveedoresService.findAll();
            return new ResponseEntity<>(proveedores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Ruta para crear un proveedor
    @PostMapping("/crear")
    public ResponseEntity<Provedores> createProveedor(@RequestBody Provedores proveedor) {
        try {
            return new ResponseEntity<>(proveedoresService.save(proveedor), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Ruta para obtener proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Provedores> getProveedorById(@PathVariable Long id) {
        try {
            Provedores proveedor = proveedoresService.findById(id);
            if (proveedor == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar proveedor por ID
    @PutMapping("/{id}")
    public ResponseEntity<Provedores> updateProveedor(@PathVariable Long id, @RequestBody Provedores updatedProveedor) {
        try {
            Provedores proveedor = proveedoresService.findById(id);
            if (proveedor == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Actualizar campos
            proveedor.setNombredistribuidor(updatedProveedor.getNombredistribuidor());
            proveedor.setContacto(updatedProveedor.getContacto());
            proveedor.setEmail(updatedProveedor.getEmail());
            proveedor.setTelefono(updatedProveedor.getTelefono());
            proveedor.setDireccion(updatedProveedor.getDireccion());
            proveedor.setPais(updatedProveedor.getPais());
            proveedor.setTipoproveedor(updatedProveedor.getTipoproveedor());
            proveedor.setRuc(updatedProveedor.getRuc());
            proveedor.setEstado(updatedProveedor.getEstado());
            proveedor.setFechaRegistro(updatedProveedor.getFechaRegistro());
            proveedor.setMontoCredito(updatedProveedor.getMontoCredito());

            Provedores updated = proveedoresService.save(proveedor);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un proveedor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        try {
            Provedores proveedor = proveedoresService.findById(id);
            if (proveedor == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            proveedoresService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Manejar parámetros inválidos en la URL
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>("El ID debe ser un número válido.", HttpStatus.BAD_REQUEST);
    }
}
