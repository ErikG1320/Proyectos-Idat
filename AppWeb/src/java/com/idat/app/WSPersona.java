/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idat.app;

import com.idat.entity.Persona;
import com.idat.service.ServicioPersona;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author IDAT
 */
@WebService(serviceName = "WSPersona")
public class WSPersona {

    @WebMethod(operationName = "ayuda")
    public String ayuda(@WebParam(name = "name") String nombre) {
        return "Autor " + nombre + " !";
    }
    
    @WebMethod(operationName = "listadoPersona")
    public List<Persona> listadoPersona(){
        System.out.println("....");
        ServicioPersona servicio = new ServicioPersona();
        Persona p= new Persona();
        p.setCodigo(0);
        p.setNombre("");
        p.setApellido("");
        List<Persona> lista = servicio.operacionesLectura("ConsultarTodo", p);
        return lista;
    }
    
}
