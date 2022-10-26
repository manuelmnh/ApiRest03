package com.springboot.apirest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.apirest.dao.VentasDao;
//import com.springboot.apirest.entity.Clave;
import com.springboot.apirest.entity.Cliente;
import com.springboot.apirest.service.VentasService;

public class VentasServiceImpl implements VentasService{

	@Autowired
	private VentasDao ventasDao;

	@Override
	public String findFolios(String folios) {
		
		return ventasDao.findFolios(folios);
		
	}

	@Override
	public Cliente getClientes(Cliente clientes) {

		return ventasDao.getClientes(clientes);
		
	}

	@Override
	public int getCantidad() {

		return ventasDao.getCantidad();
		
	}

	@Override
	public int getSubtotal() {

		return ventasDao.getSubtotal();
		
	}

	@Override
	public int getIva() {

		return ventasDao.getIva();
		
	}

	@Override
	public int getTotal() {

		return ventasDao.getTotal();
		
	}
	
	

}
