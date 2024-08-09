package com.example.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tienda_virtual_de_micas")
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nombre;

    @Size(min = 8, max = 100)
    private String password;

    @Size(max = 100)
    private String direccion;

    @Email
    @Size(max = 50)
    private String email;

    @Size(max = 15)
    private String telefono;

    @Size(max = 255)
    private String descripcion;

    private LocalDate fechaCreacion;

    private boolean activo;

    // Nuevos campos
    @NotNull
    @Size(max = 50)
    private String nombreModelo;

    @NotNull
    @Size(max = 50)
    private String tipoMica;

    private double precio;

    private int cantidadEnStock;

    @Size(max = 100)
    private String fabricante;

    // Constructor sin parámetros (requerido por JPA)
    public Tienda() {
        this.fechaCreacion = LocalDate.now();
        this.activo = true;
    }

    // Constructor con parámetros
    public Tienda(String nombre, String password, String direccion, String email, String telefono, String descripcion, String nombreModelo, String tipoMica, double precio, int cantidadEnStock, String fabricante) {
        this.nombre = nombre;
        this.password = password;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDate.now();
        this.activo = true;
        this.nombreModelo = nombreModelo;
        this.tipoMica = tipoMica;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.fabricante = fabricante;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getTipoMica() {
        return tipoMica;
    }

    public void setTipoMica(String tipoMica) {
        this.tipoMica = tipoMica;
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
        return "Tienda{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", activo=" + activo +
                ", nombreModelo='" + nombreModelo + '\'' +
                ", tipoMica='" + tipoMica + '\'' +
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

        Tienda tienda = (Tienda) o;

        return id != null ? id.equals(tienda.id) : tienda.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
