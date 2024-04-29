package com.tienda.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tienda.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {

	public Optional<Usuario> findByUsuario(String usuario);

}
