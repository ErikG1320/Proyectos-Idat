package com.crud.practica.Servicio;

import java.util.List;
import com.crud.practica.entidad.Estudiante;

public interface EstudianteServicio {
    public List<Estudiante> getEstudiantes();
    public Estudiante getEstudianteById(Long id);
    public Estudiante saveEstudiante(Estudiante estudiante);
    public void deleteEstudiante(Long id);
    // Otros métodos adicionales según sea necesario
    // Por ejemplo, buscar por nombre, filtros
    
}
