package com.springboot.apirest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Ventas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String folio;
	private Cliente cliente;
	private int Clave;
	private int cantidad;
	private int subtotal;
	private int iva;
	private int total;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public Cliente getClientes() {
		return cliente;
	}
	public void setClientes(Cliente nCliente) {
		this.cliente = nCliente;
	}
	public int getClave() {
		return Clave;
	}
	public void setClave(int clave) {
		Clave = clave;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
