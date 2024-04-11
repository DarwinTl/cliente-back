package com.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entities.Categoria;

@Repository
public interface ICategoriaDao extends JpaRepository<Categoria, Integer> {

}
