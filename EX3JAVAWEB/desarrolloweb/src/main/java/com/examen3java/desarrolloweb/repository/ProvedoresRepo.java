package com.examen3java.desarrolloweb.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examen3java.desarrolloweb.Entity.Provedores;

public interface ProvedoresRepo extends JpaRepository<Provedores,Integer> {
    List<Provedores> findByPais(String pais);
    List<Provedores> findByTipoProveedor(String tipoProveedor);
    List<Provedores> findByEstado(String estado);
}
