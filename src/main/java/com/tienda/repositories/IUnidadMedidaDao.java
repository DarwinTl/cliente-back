package com.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entities.UnidadMedida;

@Repository
public interface IUnidadMedidaDao extends JpaRepository<UnidadMedida, Integer> {

}
