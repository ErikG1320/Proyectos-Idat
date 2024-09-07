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
    public String registerTienda(@ModelAttribute TiendaMicas usuario, Model model) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        // Guardar usuario en la base de datos
        tiendaServicio.guardarProducto(usuario);
        model.addAttribute("message", "Producto registrado exitosamente!");
        return "Home";
    }

    @PostMapping("/inicio")
    public String loginTienda(@ModelAttribute TiendaMicas usuario, Model model) {
        // Obtén el usuario de la base de datos usando el nombre de usuario proporcionado
        TiendaMicas storedUser = tiendaServicio.existsByNombreUsuario(usuario.getNombreUsuario());
        
        // Verifica si el usuario existe y si la contraseña es correcta
        if (storedUser != null && passwordEncoder.matches(usuario.getContrasena(), storedUser.getContrasena())) {
            // Agrega un atributo de éxito de inicio de sesión
            model.addAttribute("message", "Inicio de sesión exitoso!");
            
            // Agrega el usuario autenticado al modelo, si necesitas mostrar sus detalles
            model.addAttribute("usuario", storedUser);
            
            // Redirige a la página "Listado" (ajusta la ruta según sea necesario)
            return "redirect:/listado";
        } else {
            // Si las credenciales no son correctas, muestra un mensaje de error
            model.addAttribute("error", "Correo o contraseña incorrectos.");
            return "Inicio";
        }
    }
    

    @PostMapping("/busqueda")
    public String buscarProducto(@RequestParam("busqueda") String busqueda, Model model) {
        if (busqueda == null || busqueda.isEmpty()) {
            return "Error"; // Redirige a la página de error si la búsqueda es vacía
        } else {
            TiendaMicas resultados = tiendaServicio.getProductoPorModelo(busqueda);
            if (resultados == null) {
                try {
                    int id = Integer.parseInt(busqueda);
                    TiendaMicas productoPorId = tiendaServicio.getProductobyId(id);
                    if (productoPorId != null) {
                        resultados = productoPorId;
                    }
                } catch (NumberFormatException e) {
                    resultados = tiendaServicio.getProductoPorModelo(busqueda);
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
