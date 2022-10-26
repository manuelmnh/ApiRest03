package com.springboot.apirest.service;

import com.springboot.apirest.entity.Cliente;

public interface VentasService {

		public String findFolios(String folios);
		
		public Cliente getClientes(Cliente clientes);
		
		//public Clave getClaves(Clave claves);
		
		public int getCantidad();
		
		public int getSubtotal();
		
		public int getIva();
		
		public int getTotal();
}
