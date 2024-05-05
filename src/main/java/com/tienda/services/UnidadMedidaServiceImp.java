package com.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tienda.entities.UnidadMedida;
import com.tienda.repositories.IUnidadMedidaDao;

@Service
public class UnidadMedidaServiceImp implements IUnidadMedidaService {

	@Autowired
	private IUnidadMedidaDao unidadMedidaDao;

	@Override
	public List<UnidadMedida> getUnidadesMedida() {
		return unidadMedidaDao.findAll();
	}

	@Override
	public UnidadMedida save(UnidadMedida medida) {
		return unidadMedidaDao.save(medida);
	}

	@Override
	public Optional<UnidadMedida> findUnidadMedida(int id) {
		return unidadMedidaDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		unidadMedidaDao.deleteById(id);

	}

	@Override
	public Page<UnidadMedida> findAll(Pageable pageable) {
		return unidadMedidaDao.findAll(pageable);
	}

}
