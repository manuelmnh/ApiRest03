package com.springboot.apirest03.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.apirest03.entity.Cliente;

public interface ClientesDao extends CrudRepository<Cliente, Long>{ 

}
