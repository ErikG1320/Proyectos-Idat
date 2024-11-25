package com.examen3java.desarrolloweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen3java.desarrolloweb.Entity.Provedores;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProveedoresRepository extends JpaRepository<Provedores, Long> {
    List<Provedores> findByNombredistribuidorContaining(String nombredistribuidor);
    List<Provedores> findByPais(String pais);
    List<Provedores> findByEstado(String estado);
    List<Provedores> findByMontoCreditoGreaterThanEqual(BigDecimal monto);
    List<Provedores> findByNombredistribuidorContainingAndPais(String nombredistribuidor, String pais);
}
