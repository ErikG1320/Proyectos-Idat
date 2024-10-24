package com.crud.practica.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.practica.Servicio.EstudianteServicio;
import com.crud.practica.entidad.Estudiante;


@Controller
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio servicio;
    @GetMapping({"/Estudiantes","/"})
    public String listarEstudiantes(Model model)
    {
        model.addAttribute("estudiantes", servicio.getEstudiantes());
        return "estudiantes";
    }
    @GetMapping ({"/estudiantes/nuevo"})
    public String crearEstudiante(Model model)
    {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante",estudiante);
        return "Registro";
    }
}