package com.example.demo.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tienda_virtual_de_micas")
public class TiendaProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50)
    private String nombre;

    @Size(min = 8, max = 100)
    private String contraseña;
    @Size(max = 50)
    private String TipoMica;
    @Size(max = 50)
    private String nombreModelo;
    @Size(max = 255)
    private String descripcion;

    private double precio;

    private int cantidadEnStock;

    @Size(max = 100)
    private String fabricante;

    @Size(max = 100)
    private String direccion;

    @Email
    @Size(max = 50)
    private String email;

    @Size(max = 15)
    private String telefono;

    private LocalDate fecha;

    private boolean activo;

    // Nuevo campo para rol
    @Size(max = 50)
    private String rol;

    // Constructor sin parámetros (requerido por JPA)
    public TiendaProductos() {
        this.fecha = LocalDate.now();
        this.activo = true;
    }
    

    public TiendaProductos(@Size(min = 2, max = 50) String nombre, @Size(min = 8, max = 100) String password) {
        this.nombre = nombre;
        this.contraseña = password;
    }


    // Constructor con parámetros
    public TiendaProductos(Long id, @Size(min = 2, max = 50) String nombre, @Size(min = 8, max = 100) String password,
            @Size(max = 50) String tipoMica, @Size(max = 50) String nombreModelo, @Size(max = 255) String descripcion,
            double precio, int cantidadEnStock, @Size(max = 100) String fabricante, @Size(max = 100) String direccion,
            @Email @Size(max = 50) String email, @Size(max = 15) String telefono, LocalDate fechaCreacion,
            boolean activo, @Size(max = 50) String rol) {
        this.id = id;
        TipoMica = tipoMica;
        this.nombreModelo = nombreModelo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.fabricante = fabricante;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.fecha = fechaCreacion;
        this.activo = activo;
        this.rol = rol;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return contraseña;
    }

    public void setPassword(String password) {
        this.contraseña = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFechaCreacion(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getTipoMica() {
        return TipoMica;
    }

    public void setTipoMica(String tipoMica) {
        this.TipoMica = tipoMica;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    // Sobrescribe el método toString
    @Override
    public String toString() {
        return "TiendaProductos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", activo=" + activo +
                ", rol='" + rol + '\'' + // Añadir rol en toString
                ", nombreModelo='" + nombreModelo + '\'' +
                ", tipoMica='" + TipoMica + '\'' +
                ", precio=" + precio +
                ", cantidadEnStock=" + cantidadEnStock +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }

    // Sobrescribe los métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TiendaProductos productos = (TiendaProductos) o;

        return id != null ? id.equals(productos.id) : productos.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    // public static TiendaProductos registerproduct(TiendaProductos usuario) {
    //     // Implementa el método para registrar la tienda, incluyendo encriptar la contraseña
    //     usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
    //     // Guarda el producto en la base de datos (asegúrate de tener el repositorio para esto)
    //     return usuario;
    }
