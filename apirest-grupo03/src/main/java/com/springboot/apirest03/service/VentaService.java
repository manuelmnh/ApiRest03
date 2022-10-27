package com.springboot.apirest03.service;

import java.util.List;

import com.springboot.apirest03.entity.Cliente;
import com.springboot.apirest03.entity.Venta;

public interface VentaService {

	//metodo para buscar todos los clientes
	public List<Venta> findVenta();
	//metodo para buscar un cliente por id
	public Venta findVentaById(Long id);
	//metodo para registrar un cliente
	public Venta saveVenta(Venta Venta);
	//metodo para borrar una venta
	public void delete(Long id);
		
	public List<Cliente> getClientes();
		
		//public Clave getClaves(Clave claves);
		

}
