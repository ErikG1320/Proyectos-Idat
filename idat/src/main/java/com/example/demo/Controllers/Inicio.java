package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.Entity.Tienda;
import com.example.demo.Entity.TiendaProductos;
import com.example.demo.Service.TiendaServicio;
@RestController
@RequestMapping("/Inicio")
public class Inicio {
    @Autowired
    private TiendaServicio Service;
    @PostMapping("/register")
    public TiendaProductos registerTienda(@RequestBody TiendaProductos tienda) {
        return Service.registerTienda(tienda);
    }
}
