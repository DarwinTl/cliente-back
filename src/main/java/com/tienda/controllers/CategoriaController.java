package com.tienda.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.entities.Categoria;
import com.tienda.services.ICategoriaService;

@RestController
@RequestMapping("/tienda")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping("/categorias")
	public List<Categoria> getCategorias() {
		return categoriaService.findAll();
	}

	@GetMapping("/categorias/{id}")
	public ResponseEntity<?> find(@PathVariable int id) {
		Optional<Categoria> categoria = null;
		Map<String, Object> response = new HashMap<>();
		try {
			categoria = categoriaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (!categoria.isPresent()) {
			response.put("mensaje", "La categoria con ID " + id + " no existe en la BD");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Categoria>(categoria.get(), HttpStatus.OK);
	}

	@PostMapping("/categorias")
	public ResponseEntity<?> save(@RequestBody Categoria categoria) {
		Categoria categoriaNueva = null;
		Map<String, Object> response = new HashMap<>();

		try {
			categoriaNueva = categoriaService.save(categoria);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Categoría creada con exito");
		response.put("categoria", categoriaNueva);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/categorias/{id}")
	public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable int id) {

		Categoria categoriaActual = categoriaService.findById(id).get();
		Map<String, Object> response = new HashMap<>();
		Categoria categoriaNueva = null;

		if (categoriaActual == null) {
			response.put("mensaje", "La categoria con ID " + id + " no existe en la BD");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			categoriaActual.setDetalle(categoria.getDetalle());
			categoriaNueva = categoriaService.save(categoriaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Categoria creada con exito");
		response.put("categoria", categoriaNueva);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		Categoria categoria = categoriaService.findById(id).get();
		Map<String, Object> response = new HashMap<>();

		if (categoria == null) {
			response.put("mensaje", "La categoria con ID " + id + " no existe en la BD");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			categoriaService.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Categoria eliminada");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
