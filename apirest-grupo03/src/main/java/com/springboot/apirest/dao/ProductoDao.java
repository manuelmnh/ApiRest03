package com.springboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.apirest.entity.Productos;



@Repository
public interface ProductoDao extends CrudRepository<Productos, Long>  {

}
