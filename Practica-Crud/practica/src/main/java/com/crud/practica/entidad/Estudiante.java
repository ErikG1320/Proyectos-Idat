package com.crud.practica.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombrecompleto", nullable = false, length = 100)
    private String Nombrecompleto;

    @Column(name = "edad", nullable = false)
    private int Edad;
    
    @Column(name = "telef", nullable = false, length = 100)
    private int Telefono;
    
    @Column(name = "email", nullable = false, length = 100)
    private String Email;
        
    @Column(name = "grado", nullable = false, unique = true)
    private String Grado;
    
    // Constructor vacio
    public Estudiante()
    {

    }
    
    // Constructor sin id
    public Estudiante(String nombrecompleto, int edad, int telefono, String email, String grado)
    {
        this.Nombrecompleto = nombrecompleto;
        this.Edad = edad;
        this.Telefono = telefono;
        this.Email = email;
        this.Grado = grado;
    }
    // Constructor con todos los atributos
    public Estudiante(Long id, String nombrecompleto, int edad, int telefono, String email, String grado)
    {
        this.id = id;
        this.Nombrecompleto = nombrecompleto;
        this.Edad = edad;
        this.Telefono = telefono;
        this.Email = email;
        this.Grado = grado;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombrecompleto() {
        return Nombrecompleto;
    }
    
    public void setNombrecompleto(String nombrecompleto) {
        this.Nombrecompleto = nombrecompleto;
    }
    
    public int getEdad() {
        return Edad;
    }
    
    public void setEdad(int edad) {
        this.Edad = edad;
    }
    
    public int getTelefono() {
        return Telefono;
    }
    
    public void setTelefono(int telefono) {
        this.Telefono = telefono;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String email) {
        this.Email = email;
    }
    
    public String getGrado() {
        return Grado;
    }
    
    public void setGrado(String grado) {
        this.Grado = grado;
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", Nombrecompleto=" + Nombrecompleto + ", Edad=" + Edad + ", Telefono="
                + Telefono + ", Email=" + Email + ", Grado=" + Grado + "]";
    }
}