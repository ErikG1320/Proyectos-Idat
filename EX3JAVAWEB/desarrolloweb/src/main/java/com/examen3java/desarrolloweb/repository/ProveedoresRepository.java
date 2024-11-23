package com.examen3java.desarrolloweb.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen3java.desarrolloweb.Entity.Provedores;

@Repository
public interface ProveedoresRepository extends JpaRepository<Provedores, Integer> {
    // Buscar proveedores por país
    List<Provedores> findByPais(String pais);
    
    // Buscar proveedores por estado (por ejemplo: "activo")
    List<Provedores> findByEstado(String estado);

    // Buscar proveedores con monto de crédito mayor o igual a un valor específico
    List<Provedores> findByMontoCreditoGreaterThanEqual(BigDecimal monto);
}
