package com.tienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tmprod")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prod")
	private int id;
	@Column(name = "no_prod")
	private String nombre;
	@Column(name = "de_prod")
	private String descripcion;
	@Column(name = "de_ruta_imag")
	private String ruta;
	@Column(name = "id_esta")
	private int estado;
	@ManyToOne
	private Marca marca;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private UnidadMedida medida;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public UnidadMedida getMedida() {
		return medida;
	}

	public void setMedida(UnidadMedida medida) {
		this.medida = medida;
	}

	public Producto() {

	}

	public Producto(int id, String nombre, String descripcion, String ruta, int estado, Marca marca,
			Categoria categoria, UnidadMedida medida) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ruta = ruta;
		this.estado = estado;
		this.marca = marca;
		this.categoria = categoria;
		this.medida = medida;
	}

}
