package com.examen3java.desarrolloweb.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedidos")
public class Provedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    @Column(name = "nombredistribuidor", length = 50, nullable = false)
    @NotNull
    private String nombredistribuidor;
    
    @Column(name = "contacto", length = 50, nullable = false)
    @NotNull
    private String contacto;

    @Column(name = "email", length = 50, nullable = false)
    @NotNull
    private String email;

    @Column(name = "telefono", length = 50, nullable = false)
    @NotNull
    private Integer telefono;
    
    @Column (name = "direccion" , length = 50 , nullable = false)
    @NotNull
    private String direccion;

    @Column (name = "pais" , length = 50 , nullable = false)
    @NotNull
    private String pais;

    @Column(name = "tipoproveedor", length = 50 ,nullable = false)
    @NotNull
    private String tipoproveedor;

    @Column (name = "ruc" , length = 50 , nullable =false)
    @NotNull
    private String ruc;

    @Column (name = "estado", length = 50 , nullable = false)
    private String estado = "activo";
    
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro = LocalDate.now();

    @Column(name = "monto_credito", precision = 15, scale = 2, nullable = false)
    private BigDecimal montoCredito;
    
    // Getters and Setters
    public Long getIdProveedor() {
        return idProveedor;
    }
    
    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombredistribuidor() {
        return nombredistribuidor;
    }
    
    public void setNombredistribuidor(String nombredistribuidor) {
        this.nombredistribuidor = nombredistribuidor;
    }
    
    public String getContacto() {
        return contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String getTipoproveedor() {
        return tipoproveedor;
    }
    
    public void setTipoproveedor(String tipoproveedor) {
        this.tipoproveedor = tipoproveedor;
    }
    
    public String getRuc() {
        return ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public BigDecimal getMontoCredito() {
        return montoCredito;
    }

    public void setMontoCredito(BigDecimal montoCredito) {
        this.montoCredito = montoCredito;
    }

}
