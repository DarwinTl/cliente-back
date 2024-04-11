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

import com.tienda.entities.Marca;
import com.tienda.services.IMarcaService;

@RestController
@RequestMapping("/tienda")
public class MarcaController {

	@Autowired
	private IMarcaService marcaService;

	@GetMapping("/marcas")
	public List<Marca> getMarcas() {
		return marcaService.getMarcas();
	}

	@GetMapping("/marcas/{id}")
	public ResponseEntity<?> findMarca(@PathVariable int id) {
		Optional<Marca> marca = null;
		Map<String, Object> response = new HashMap<>();

		try {
			marca = marcaService.findMarca(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (!marca.isPresent()) {
			response.put("mensaje", "La marca con ID " + id + " no existe en la BD");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Marca>(marca.get(), HttpStatus.OK);
	}

	@PostMapping("/marcas")
	public ResponseEntity<?> save(@RequestBody Marca marca) {
		Marca marcaNueva = null;
		Map<String, Object> response = new HashMap<>();

		try {
			marcaNueva = marcaService.save(marca);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Marca creada con exito");
		response.put("marca", marcaNueva);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/marcas/{id}")
	public ResponseEntity<?> update(@RequestBody Marca marca, @PathVariable int id) {
		Marca marcaActual = (Marca) marcaService.findMarca(id).get();
		Map<String, Object> response = new HashMap<>();
		Marca marcaActualizada = null;

		if (marcaActual == null) {
			response.put("mensaje", "Error al actualizar, la marca con id  " + id + " no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			marcaActual.setNombre(marca.getNombre());
			marcaActual.setDetalle(marca.getDetalle());

			marcaActualizada = marcaService.save(marcaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Marca actualizada con exito");
		response.put("marca", marcaActualizada);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("marcas/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		Marca marcaActual = (Marca) marcaService.findMarca(id).get();
		Map<String, Object> response = new HashMap<>();

		if (marcaActual == null) {
			response.put("mensaje", "Error al eliminar, la marca con id  " + id + " no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			marcaService.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la BD");
			response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Marca borrada con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
