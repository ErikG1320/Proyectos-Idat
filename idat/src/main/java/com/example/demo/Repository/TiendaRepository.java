package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.TiendaProductos;

public interface TiendaRepository extends JpaRepository<TiendaProductos, Long> {
    
    List<TiendaProductos> findByNombreModelo(String nombreModelo);

    List<TiendaProductos> findByTipoMica(String tipoMica);

    List<TiendaProductos> findByPrecio(double precio);

    List<TiendaProductos> findByCantidad(int cantidad);
}
