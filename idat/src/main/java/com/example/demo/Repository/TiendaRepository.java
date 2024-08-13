package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.TiendaMicas;

public interface TiendaRepository extends JpaRepository<TiendaMicas, Long> {
    TiendaMicas findByNombre(String nombre);
    TiendaMicas findByNombreModelo(String nombreModelo);
}
