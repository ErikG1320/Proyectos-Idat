package com.examen3java.desarrolloweb.service;
import com.examen3java.desarrolloweb.Entity.Provedores;
import java.math.BigDecimal;
import java.util.List;

public interface ProveedoresService {
    List<Provedores> findAll();
    Provedores findById(Long id);
    Provedores save(Provedores proveedor);
    void deleteById(Long id);
    List<Provedores> findByPais(String pais);
    List<Provedores> findByEstado(String estado);
    List<Provedores> findByMontoCredito(BigDecimal monto);
    List<Provedores> buscarPorNombreYPais(String nombredistribuidor, String pais);
}
