package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.TiendaMicas;
import com.example.demo.Service.TiendaServicio;

@Controller
public class InicioController {

    @Autowired
    private TiendaServicio tiendaServicio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/Home")
    public String login() {
        return "Home";
    }

    @GetMapping("/Register")
    public String register(Model model) {
        model.addAttribute("usuario", new TiendaMicas());
        return "Register";
    }

    @PostMapping("/Register")
    public String registerTienda(@ModelAttribute TiendaMicas nombre, Model model) {
        nombre.setContraseña(passwordEncoder.encode(nombre.getContraseña()));
        tiendaServicio.saveProducto(nombre);
        model.addAttribute("message", "Usuario registrado exitosamente!");
        return "Home";
    }

    @PostMapping("/inicio")
    public String loginTienda(@ModelAttribute TiendaMicas nombre, Model model) {
        TiendaMicas storeduser = tiendaServicio.findByNombre(nombre.getNombre());
        if (storeduser != null && passwordEncoder.matches(nombre.getContraseña(), storeduser.getContraseña())) {
            model.addAttribute("message", "Inicio de sesión exitoso!");
            return "Listado";
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "Inicio";
        }
    }

    @PostMapping("/busqueda")
    public String buscarProducto(@RequestParam("busqueda") String busqueda, Model model) {
        if (busqueda == null || busqueda.isEmpty()) {
            return "Error"; // Redirige a la página de error si la búsqueda es vacía
        } else {
            TiendaMicas resultados = tiendaServicio.findByNombreMica(busqueda);
            if (resultados == null) {
                try {
                    int id = Integer.parseInt(busqueda);
                    TiendaMicas productoPorId = tiendaServicio.getProductoById(id);
                    if (productoPorId != null) {
                        resultados = productoPorId;
                    }
                } catch (NumberFormatException e) {
                    resultados = tiendaServicio.findByNombre(busqueda);
                    if (resultados == null) {
                        return "Error";
                    }
                }
            }
            model.addAttribute("listado", resultados);
            return "Busqueda";
        }
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
