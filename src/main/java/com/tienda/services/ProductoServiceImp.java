package com.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entities.Producto;
import com.tienda.repositories.IProductoDao;

@Service
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private IProductoDao productoDao;

	@Override
	public List<Producto> getProductos() {
		return productoDao.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public Optional<Producto> findById(int id) {
		return productoDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		productoDao.deleteById(id);

	}

	@Override
	public List<Producto> getProductos(String categoria) {
		return productoDao.listByCategoria(categoria);
	}

}
