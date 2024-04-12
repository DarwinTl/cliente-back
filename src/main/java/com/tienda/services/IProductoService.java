package com.tienda.services;

import java.util.List;
import java.util.Optional;

import com.tienda.entities.Producto;

public interface IProductoService {

	public List<Producto> getProductos();

	public Producto save(Producto producto);

	public Optional<Producto> findById(int id);

	public void deleteById(int id);

}
