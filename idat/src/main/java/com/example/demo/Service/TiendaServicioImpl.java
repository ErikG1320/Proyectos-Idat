// Repositorio
package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.TiendaMicas;
import com.example.demo.Repository.TiendaRepository;

@Service
public class TiendaServicioImpl implements TiendaServicio {

    @Autowired
    private TiendaRepository tiendaRepositorio;

    @Override
    public List<TiendaMicas> getProductos() {
        return tiendaRepositorio.findAll();
    }

    @Override
    public TiendaMicas findByNombreMica(String nombreModelo) {
        return tiendaRepositorio.findByNombreModelo(nombreModelo);
    }

    @Override
    public TiendaMicas findByNombre(String nombre) {
        return tiendaRepositorio.findByNombre(nombre);
    }
    @Override
    public TiendaMicas getProductoById(int id) {
        return tiendaRepositorio.findById(id).orElse(null);
    }

    @Override
    public TiendaMicas saveProducto(TiendaMicas producto) {
        return tiendaRepositorio.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        tiendaRepositorio.deleteById(id);
    }

    @Override
    public boolean validarStock(TiendaMicas producto) {
        return producto.getCantidadEnStock() > 0;
    }

    @Override
    public boolean validarPrecio(TiendaMicas producto) {
        return producto.getPrecio() > 0;
    }

    @Override
    public TiendaMicas registrarUsuario(String nombre, String contraseña) {
        if (tiendaRepositorio.findByNombre(nombre) != null) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(contraseña);
        TiendaMicas usuario = new TiendaMicas(nombre, encryptedPassword);
        return tiendaRepositorio.save(usuario);
    }

    @Override
    public boolean verificarCredenciales(String nombre, String contraseña) {
        TiendaMicas usuario = tiendaRepositorio.findByNombre(nombre);
        if (usuario != null) {
            return new BCryptPasswordEncoder().matches(contraseña, usuario.getContraseña());
        }
        return false;
    }
}
