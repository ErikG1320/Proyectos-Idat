/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.idat.dao;

import com.idat.entity.Persona;
import java.util.List;

/**
 *
 * @author IDAT
 */
public interface IPersonaDao {
    
    // INSERT, DELETE, UPDATE
    public int operacionesEscritura(String indicador, Persona p);
    // SELECT 
    public List<Persona> operacionesLectura(String indicador, Persona p);
    
   
}
