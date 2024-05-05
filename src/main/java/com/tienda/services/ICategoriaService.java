package com.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tienda.entities.Categoria;


public interface ICategoriaService {

	public List<Categoria> findAll();

	public Categoria save(Categoria categoria);

	public  Optional<Categoria> findById(int id);

	public void deleteById(int id);
	
	public Page<Categoria> findAll(Pageable pageable);

}
