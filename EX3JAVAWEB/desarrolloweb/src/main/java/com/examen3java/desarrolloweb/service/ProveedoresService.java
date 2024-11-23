package com.examen3java.desarrolloweb.service;

import java.math.BigDecimal;
import java.util.List;

import com.examen3java.desarrolloweb.Entity.Provedores;

public interface ProveedoresService {
    List<Provedores> findAll();
    Provedores findById(Integer id);
    Provedores save(Provedores proveedor);
    void deleteById(Integer id);
    List<Provedores> findByPais(String pais);
    List<Provedores> findByEstado(String estado);
    List<Provedores> findByMontoCredito(BigDecimal monto);
}
