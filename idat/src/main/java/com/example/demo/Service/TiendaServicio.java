package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.TiendaMicas;

public interface TiendaServicio {
    
    // Método para obtener todos los productos
    public List<TiendaMicas> getProductos();

    // Método para encontrar un producto por nombre de mica
    public TiendaMicas findByNombreMica(String nombreModelo);

    // Método para encontrar un producto por nombre
    public TiendaMicas findByNombre(String nombre);

    // Método para obtener un producto por su ID
    public TiendaMicas getProductoById(int id);

    // Método para guardar un producto
    public TiendaMicas saveProducto(TiendaMicas producto);

    // Método para eliminar un producto por su ID
    public void deleteProducto(Long id);

    // Métodos adicionales para validar stock y precio
    public boolean validarStock(TiendaMicas producto);
    public boolean validarPrecio(TiendaMicas producto);

    // Método para registrar un usuario y encriptar la contraseña
    public TiendaMicas registrarUsuario(String nombre, String contraseña);

    // Método para verificar credenciales del usuario
    public boolean verificarCredenciales(String nombre, String contraseña);
}
