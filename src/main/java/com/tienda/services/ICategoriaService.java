package com.tienda.services;

import java.util.List;
import java.util.Optional;

import com.tienda.entities.Categoria;

public interface ICategoriaService {

	public List<Categoria> findAll();

	public Categoria save(Categoria categoria);

	public  Optional<Categoria> findById(int id);

	public void deleteById(int id);

}
