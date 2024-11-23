package com.examen3java.desarrolloweb.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen3java.desarrolloweb.Entity.Provedores;
import com.examen3java.desarrolloweb.service.ProveedoresService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<List<Provedores>> getAllProveedores() {
        List<Provedores> proveedores = proveedoresService.findAll();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    // Obtener proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Provedores> getProveedorById(@PathVariable Integer id) {
        Provedores proveedor = proveedoresService.findById(id);
        if (proveedor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }

    // Crear un nuevo proveedor
    @PostMapping
    public ResponseEntity<Provedores> createProveedor(@RequestBody Provedores proveedor) {
        return new ResponseEntity<>(proveedoresService.save(proveedor), HttpStatus.CREATED);
    }

    // Actualizar un proveedor existente
    @PutMapping("/{id}")
    public ResponseEntity<Provedores> updateProveedor(@PathVariable Integer id, @RequestBody Provedores updatedProveedor) {
        Provedores proveedor = proveedoresService.findById(id);
        if (proveedor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Actualizar campos
        proveedor.setNombredistribuidor(updatedProveedor.getNombredistribuidor());
        proveedor.setContacto(updatedProveedor.getContacto());
        proveedor.setEmail(updatedProveedor.getEmail());
        proveedor.setTelefono(updatedProveedor.getTelefono());
        proveedor.setPais(updatedProveedor.getPais());
        proveedor.setTipoproveedor(updatedProveedor.getTipoproveedor());
        proveedor.setRuc(updatedProveedor.getRuc());
        proveedor.setEstado(updatedProveedor.getEstado());
        proveedor.setFechaRegistro(updatedProveedor.getFechaRegistro());
        proveedor.setMontoCredito(updatedProveedor.getMontoCredito());

        Provedores updated = proveedoresService.save(proveedor);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Eliminar un proveedor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Integer id) {
        Provedores proveedor = proveedoresService.findById(id);
        if (proveedor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        proveedoresService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Obtener proveedores por país
    @GetMapping("/pais/{pais}")
    public ResponseEntity<List<Provedores>> getProveedoresByPais(@PathVariable String pais) {
        List<Provedores> proveedores = proveedoresService.findByPais(pais);
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    // Obtener proveedores activos
    @GetMapping("/activos")
    public ResponseEntity<List<Provedores>> getProveedoresActivos() {
        List<Provedores> proveedores = proveedoresService.findByEstado("activo");
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    // Obtener proveedores con un monto de crédito mayor o igual al especificado
    @GetMapping("/creditos/{monto}")
    public ResponseEntity<List<Provedores>> getProveedoresConCreditos(@PathVariable BigDecimal monto) {
        List<Provedores> proveedores = proveedoresService.findByMontoCredito(monto);
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }
}
