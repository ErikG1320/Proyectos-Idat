package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.TiendaProductos;
import com.example.demo.Service.TiendaServicio;

@Controller
@RequestMapping("/users")
public class InicioController {

    @Autowired
    private TiendaServicio tiendaServicio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuario", new TiendaProductos());
        return "register";
    }

    @PostMapping("/register")
    public String registerTienda(@RequestBody @ModelAttribute TiendaProductos usuario, Model model) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        tiendaServicio.save(usuario); // Asegúrate de tener un método para guardar la tienda en el servicio
        model.addAttribute("message", "Usuario registrado exitosamente!");
        return "home"; // Redirige a una página de éxito o de inicio
    }

    @PostMapping("/login")
    public String loginTienda(@RequestBody @ModelAttribute TiendaProductos usuario, Model model) {
        TiendaProductos storedProducto = tiendaServicio.findByNombre(usuario.getNombre());
        if (storedProducto != null && passwordEncoder.matches(usuario.getPassword(), storedProducto.getPassword())) {
            model.addAttribute("message", "Inicio de sesión exitoso!");
            return "Listado"; // Redirigimos a la página de inicio después de iniciar sesión exitosamente
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "login"; // Mantente en la página de login en caso de error
        }
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
