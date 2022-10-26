package com.springboot.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.apirest.entity.Cliente;

public interface ClientesDao extends CrudRepository<Cliente, Long>{ 

}
