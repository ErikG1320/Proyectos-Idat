package com.example.demo.Entity;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
// import javax.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tienda_virtual_de_micas")
public class TiendaMicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;

    @Size(min = 8, max = 100)
    @Column(name = "contraseña",length = 100)
    private String contraseña;

    @Size(max = 50)
    @Column(name = "tipo_mica", length = 50 )
    private String tipoMica;

    @Size(max = 50)
    @Column(name = "nombre_modelo", length = 50)
    private String nombreModelo;

    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "cantidad_en_stock", nullable = false)
    private int cantidadEnStock;

    @Size(max = 100)
    @Column(name = "fabricante", length = 100)
    private String fabricante;

    @Size(max = 100)
    @Column(name = "direccion", length = 100)
    private String direccion;

    @Email
    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @Size(max = 15)
    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    @Size(max = 50)
    @Column(name = "rol", length = 50)
    private String rol;

    public TiendaMicas() {
        this.fecha = LocalDate.now();
        this.activo = true;
    }

    public TiendaMicas(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public TiendaMicas(Integer id, @Size(max = 50) String tipoMica, @Size(max = 50) String nombreModelo,
            @Size(max = 255) String descripcion, double precio, int cantidadEnStock, @Size(max = 100) String fabricante,
            @Size(max = 100) String direccion, @Email @Size(max = 50) String email, @Size(max = 15) String telefono,
            LocalDate fecha) {
        this.id = id;
        this.tipoMica = tipoMica;
        this.nombreModelo = nombreModelo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.fabricante = fabricante;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    

    public TiendaMicas(Integer id, @Size(min = 2, max = 50) String nombre, @Size(min = 8, max = 100) String contraseña,
            @Size(max = 100) String direccion, @Email @Size(max = 50) String email, @Size(max = 15) String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public TiendaMicas(Integer id, boolean activo, @Size(max = 50) String rol) {
        this.id = id;
        this.activo = activo;
        this.rol = rol;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoMica() {
        return tipoMica;
    }

    public void setTipoMica(String tipoMica) {
        this.tipoMica = tipoMica;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    @Override
    public String toString() {
        return "TiendaProductos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", tipoMica='" + tipoMica + '\'' +
                ", nombreModelo='" + nombreModelo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidadEnStock=" + cantidadEnStock +
                ", fabricante='" + fabricante + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fecha=" + fecha +
                ", activo=" + activo +
                ", rol='" + rol + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TiendaMicas that = (TiendaMicas) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
