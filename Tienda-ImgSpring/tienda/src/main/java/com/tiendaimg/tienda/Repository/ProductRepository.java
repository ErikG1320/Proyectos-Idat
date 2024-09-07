package com.tiendaimg.tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendaimg.tienda.Entity.Product;

public interface ProductRepository extends JpaRepository <Product,Integer> {
}
