package com.springboot.apirest03.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String descripcion;
	private Float punitario;
	private Integer existencias;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public Float getPunitario() {
		return punitario;
	}


	public void setPunitario(Float punitario) {
		this.punitario = punitario;
	}


	public Integer getExistencias() {
		return existencias;
	}


	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
