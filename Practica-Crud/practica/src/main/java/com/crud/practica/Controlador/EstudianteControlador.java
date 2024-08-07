package com.crud.practica.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.practica.Servicio.EstudianteServicio;


@Controller
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio servicio;
    @GetMapping({"/Estudiantes","/"})
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", servicio.getEstudiantes());
        return "estudiantes";
    }
}