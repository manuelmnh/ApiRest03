package com.springboot.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.apirest.dao.ProductoDao;
import com.springboot.apirest.entity.Productos;


@Service
public class ProductosServiceImpl implements ProductosService{

	
	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Productos> findProducts() {
		return (List<Productos>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Productos findProductstById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Productos saveProducts(Productos productos) {
			return productoDao.save(productos);
	}

	@Transactional
	public void delete(Long id) {
		productoDao.deleteById(id);
		
	}

}
