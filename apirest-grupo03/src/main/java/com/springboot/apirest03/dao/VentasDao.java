package com.springboot.apirest03.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.apirest03.entity.Cliente;
import com.springboot.apirest03.entity.Venta;

public interface VentasDao extends CrudRepository<Venta, Long>{

	@Query("from Cliente")
	public List<Cliente> getClientes();
	
	

}
