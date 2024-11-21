package com.examen3java.desarrolloweb.service;

import java.util.List;
import com.examen3java.desarrolloweb.Entity.Provedores;

public interface ProveedorService {
    List<Proveedor> findAll();
    Proveedor findById(Integer id);
    Proveedor save(Proveedor proveedor);
    void deleteById(Integer id);
}
