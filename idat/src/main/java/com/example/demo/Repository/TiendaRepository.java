package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.TiendaMicas;

public interface TiendaRepository extends JpaRepository<TiendaMicas, Integer> {
    TiendaMicas findByNombre(String nombre);
    TiendaMicas findByNombreModelo(String nombreModelo);
    Optional<TiendaMicas> findById(int id);
}
