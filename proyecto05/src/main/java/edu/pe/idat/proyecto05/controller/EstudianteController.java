package edu.pe.idat.proyecto05.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import edu.pe.idat.proyecto05.model.Estudiante;

@Controller
public class EstudianteController {
    @GetMapping("/abrir")
    public String abrirE(Model modelo) {
        Estudiante obj = new Estudiante();
        modelo.addAttribute("estudiante", obj);
        return "formulario";
    }
    @PostMapping ("/registrar")
    public String registrar(Model modelo,Estudiante estudiante) {
        modelo.addAttribute("b_nombre", estudiante.getNombre());
        modelo.addAttribute("b_apellido", estudiante.getApellido());
        modelo.addAttribute("b_nota1", estudiante.getNota1());
        modelo.addAttribute("b_nota2", estudiante.getNota2());
        modelo.addAttribute("b_promedio", estudiante.Promedio());
        modelo.addAttribute("b_condicion", estudiante.Condicion());
        return "formulario";
    }
 }

