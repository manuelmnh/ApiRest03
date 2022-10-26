package com.springboot.apirest.service;

import java.util.List;

import com.springboot.apirest.entity.Productos;


public interface ProductosService {

	public List <Productos> findProducts();
	public Productos findProductstById(Long id);
	public Productos saveProducts (Productos productos);
}
