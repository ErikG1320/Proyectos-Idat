package com.crud.practica.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.practica.entidad.Estudiante;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante,Long> {
}