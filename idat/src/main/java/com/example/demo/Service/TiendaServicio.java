package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.TiendaMicas;
public interface TiendaServicio {
    List<TiendaMicas> getProductos();
    TiendaMicas getProductobyId(int id);
    boolean existsByNombreUsuario(String nombre_usuario);
    TiendaMicas getProductoPorModelo(String nombreModelo);
    void guardarProducto(TiendaMicas producto);
    void eliminarProducto(int id);
    List<TiendaMicas> getProductosPorPrecio(double min, double max);
    List<TiendaMicas> getProductosPorCantidad(int min, int max);
    List<TiendaMicas> getProductosPorFabricante(String fabricante);
    List<TiendaMicas> getProductosPorCategoria(String categoria);
    List<TiendaMicas> getProductosPorMarca(double min, double max);
    boolean validarStock (TiendaMicas producto);
    boolean validarPrecio (TiendaMicas producto);
    TiendaMicas registrarUsuario(String user, String contraseña);
    boolean verificarCredenciales(String user, String contraseña);
}
