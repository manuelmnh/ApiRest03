package com.springboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.apirest.entity.Ventas;

public interface VentasDao extends CrudRepository<Ventas, Long>{

}
