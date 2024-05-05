package com.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tienda.entities.UnidadMedida;

public interface IUnidadMedidaService {

	public List<UnidadMedida> getUnidadesMedida();

	public UnidadMedida save(UnidadMedida medida);

	public Optional<UnidadMedida> findUnidadMedida(int id);

	public void deleteById(int id);
	
	public Page<UnidadMedida> findAll(Pageable pageable);
}
