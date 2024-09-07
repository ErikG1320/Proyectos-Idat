package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.TiendaMicas;
import com.example.demo.Repository.TiendaRepository;

@Service
public class TiendaServicioImpl implements TiendaServicio {

    private final TiendaRepository tiendaRepositorio;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public TiendaServicioImpl(TiendaRepository tiendaRepositorio, BCryptPasswordEncoder passwordEncoder) {
        this.tiendaRepositorio = tiendaRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TiendaMicas registrarUsuario(String nombre, String contrasena) {
        if (tiendaRepositorio.existsByNombre(nombre)) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }
        String encryptedPassword = passwordEncoder.encode(contrasena);
        TiendaMicas usuario = new TiendaMicas(nombre, encryptedPassword);
        return tiendaRepositorio.save(usuario);
    }

    @Override
    public boolean verificarCredenciales(String nombre, String contraseña) {
        TiendaMicas usuario = tiendaRepositorio.findByNombre(nombre);
        return usuario != null && passwordEncoder.matches(contraseña, usuario.getContrasena());
    }

    @Override
    public List<TiendaMicas> getProductos() {
        return tiendaRepositorio.findAll();
    }

    @Override
    public TiendaMicas getProductobyId(int id) {
        return tiendaRepositorio.findById(id).orElse(null);
    }

    @Override
    public boolean existsByNombreUsuario(String nombre_usuario) {
        return tiendaRepositorio.existsByNombre(nombre_usuario);
    }

    @Override
    public TiendaMicas getProductoPorModelo(String nombreModelo) {
        return tiendaRepositorio.findByNombreModelo(nombreModelo);
    }

    @Override
    public void guardarProducto(TiendaMicas producto) {
        tiendaRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        tiendaRepositorio.deleteById(id);
    }

    @Override
    public List<TiendaMicas> getProductosPorPrecio(double min, double max) {
        return tiendaRepositorio.findByPrecioBetween(min, max);
    }

    @Override
    public List<TiendaMicas> getProductosPorCantidad(int min, int max) {
        return tiendaRepositorio.findByCantidadEnStockBetween(min, max);
    }

    @Override
    public List<TiendaMicas> getProductosPorFabricante(String fabricante) {
        return tiendaRepositorio.findByFabricante(fabricante);
    }

    @Override
    public List<TiendaMicas> getProductosPorCategoria(String categoria) {
        return tiendaRepositorio.findByTipoMica(categoria);
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
    public List<TiendaMicas> getProductosPorMarca(double min, double max) {
        // Suponiendo que "marca" es un atributo de la entidad que debe coincidir con un patrón de búsqueda
        return tiendaRepositorio.findAllByPrecioBetweenAndFabricante(min, max, "Marca");
    }
}
