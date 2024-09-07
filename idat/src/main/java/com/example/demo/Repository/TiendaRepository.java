package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.TiendaMicas;

public interface TiendaRepository extends JpaRepository<TiendaMicas, Integer> {
    TiendaMicas findByNombre(String nombre);
    TiendaMicas findByNombreModelo(String nombreModelo);
    Optional<TiendaMicas> findById(int id);
    boolean existsByNombre(String nombre_usuario);
    List<TiendaMicas> findAllByPrecioBetweenAndFabricante(double min, double max, String string);
    List<TiendaMicas> findByTipoMica(String categoria);
    List<TiendaMicas> findByFabricante(String fabricante);
    List<TiendaMicas> findByCantidadEnStockBetween(int min, int max);
    List<TiendaMicas> findByPrecioBetween(double min, double max);
}
