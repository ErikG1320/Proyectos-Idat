package com.idat.api.entity;

public class Usuario {
    private String id;
    private String nombrecompleto;
    private int edad;
    private String email;
    private boolean status;
    private String tipousuario;
    private int idpadre;
    private int idsuscripcion;
    private int telefono;
    // Getters and setters
    //Constructor con id
    public Usuario(String id, String nombrecompleto, int edad, String email, boolean status, String tipousuario,
            int idpadre, int idsuscripcion, int telefono) {
        this.id = id;
        this.nombrecompleto = nombrecompleto;
        this.edad = edad;
        this.email = email;
        this.status = status;
        this.tipousuario = tipousuario;
        this.idpadre = idpadre;
        this.idsuscripcion = idsuscripcion;
        this.telefono = telefono;
    }
    //Constructor sin id
    public Usuario(String nombrecompleto, int edad, String email, boolean status, String tipousuario, int idpadre,
            int idsuscripcion, int telefono) {
        this.nombrecompleto = nombrecompleto;
        this.edad = edad;
        this.email = email;
        this.status = status;
        this.tipousuario = tipousuario;
        this.idpadre = idpadre;
        this.idsuscripcion = idsuscripcion;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombrecompleto() {
        return nombrecompleto;
    }
    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getTipousuario() {
        return tipousuario;
    }
    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
    public int getIdpadre() {
        return idpadre;
    }
    public void setIdpadre(int idpadre) {
        this.idpadre = idpadre;
    }
    public int getIdsuscripcion() {
        return idsuscripcion;
    }
    public void setIdsuscripcion(int idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
