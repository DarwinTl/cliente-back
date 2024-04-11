package com.tienda.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ttunid_medi")
public class UnidadMedida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unid_medi")
	private int id;
	@Column(name = "de_unid_medi")
	private String descripcion;

	@OneToMany(mappedBy = "medida")
	private List<Producto> productos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public UnidadMedida() {
	}

	public UnidadMedida(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

}
