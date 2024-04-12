package com.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entities.Producto;

@Repository
public interface IProductoDao extends JpaRepository<Producto, Integer> {

}
