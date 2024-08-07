package com.crud.practica.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.practica.Repositorio.EstudianteRepositorio;
import com.crud.practica.entidad.Estudiante;

@Service

public class EstudianteServicioImpl implements EstudianteServicio{
    @Autowired
    private EstudianteRepositorio Repositorio;
    @Override
    public List<Estudiante> getEstudiantes() {
        return Repositorio.findAll();
    }
    @Override
    public Estudiante getEstudianteById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getEstudianteById'");
    }
    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        throw new UnsupportedOperationException("Unimplemented method 'saveEstudiante'");
    }
    @Override
    public void deleteEstudiante(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteEstudiante'");
    }
}
