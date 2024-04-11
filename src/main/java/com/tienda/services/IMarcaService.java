package com.tienda.services;

import java.util.List;
import java.util.Optional;

import com.tienda.entities.Marca;

public interface IMarcaService {

	public List<Marca> getMarcas();

	public Marca save(Marca marca);

	public Optional<Marca> findMarca(int id);

	public void deleteById(int id);

}
