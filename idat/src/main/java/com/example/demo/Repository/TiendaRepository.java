package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.TiendaProductos;
// import com.example.demo.Entity.TiendaProductos;
public interface TiendaRepository extends JpaRepository <TiendaProductos,Long>{

}
