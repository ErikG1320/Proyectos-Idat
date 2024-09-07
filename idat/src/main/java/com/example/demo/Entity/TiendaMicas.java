package com.example.demo.Entity;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
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

    @Column(name = "nombre_usuario", length = 50, nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String nombreUsuario;

    @Column(name = "contrasena", length = 100, nullable = false)
    @NotNull
    @Size(min = 8, max = 100)
    private String contrasena;

    @Column(name = "tipo_mica", length = 50)
    @Size(max = 50)
    private String tipoMica;

    @Column(name = "nombre_modelo", length = 50)
    @Size(max = 50)
    private String nombreModelo;

    @Column(name = "descripcion", length = 255)
    @Size(max = 255)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    @NotNull
    private double precio;

    @Column(name = "cantidad_en_stock", nullable = false)
    @NotNull
    private int cantidadEnStock;

    @Column(name = "fabricante", length = 100)
    @Size(max = 100)
    private String fabricante;

    @Column(name = "direccion", length = 100)
    @Size(max = 100)
    private String direccion;

    @Column(name = "email", length = 50)
    @Email
    @Size(max = 50)
    private String email;

    @Column(name = "telefono", length = 15)
    @Size(max = 15)
    private String telefono;

    @Column(name = "fecha", nullable = false)
    @NotNull
    @PastOrPresent
    private LocalDate fecha;

    @Column(name = "activo", nullable = false)
    @NotNull
    private boolean activo;

    @Column(name = "rol", length = 50)
    @Size(max = 50)
    private String rol;

    public TiendaMicas() {
        this.fecha = LocalDate.now();
        this.activo = true;
    }

    // Constructor para registrar usuario
    public TiendaMicas(String nombreUsuario, String contrasena) {
        this();
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    // Constructor con detalles completos del producto
    public TiendaMicas(Integer id, String tipoMica, String nombreModelo,
                       String descripcion, double precio, int cantidadEnStock,
                       String fabricante, String direccion,
                       String email, String telefono,
                       LocalDate fecha) {
        this();
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

    // Getters y Setters
    
    // Métodos adicionales pueden incluir lógica de negocio relevante

    @Override
    public String toString() {
        return "TiendaMicas{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
