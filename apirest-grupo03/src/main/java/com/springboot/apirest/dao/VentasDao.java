package com.springboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.apirest.entity.Cliente;
import com.springboot.apirest.entity.Ventas;

public interface VentasDao extends CrudRepository<Ventas, Long>{

	public String findFolios(String folios);
	
	public Cliente getClientes(Cliente clientes);
	
	//public Clave getClaves(Clave claves);
	
	public int getCantidad();
	
	public int getSubtotal();
	
	public int getIva();
	
	public int getTotal();
}
