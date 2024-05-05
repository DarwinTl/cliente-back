package com.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tienda.entities.Marca;


public interface IMarcaService {

	public List<Marca> getMarcas();

	public Marca save(Marca marca);

	public Optional<Marca> findMarca(int id);

	public void deleteById(int id);
	
	public Page<Marca> findAll(Pageable pageable);

}
