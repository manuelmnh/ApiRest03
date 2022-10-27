package com.springboot.apirest03.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apirest03.entity.Cliente;
import com.springboot.apirest03.service.ClienteService;



@RestController
@RequestMapping("/api")
public class ClientesController {

	@Autowired
	private ClienteService clienteService;
	
	//forma antigua seria: @RequestMapping(value="clientes",method=RequestMethod.GET)
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findClients();
	}

	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String,Object> response = new HashMap<>();
		try {
			cliente = clienteService.findClientById(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta a la base de datos");
			response.put("error", e.getMessage().concat("::").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (cliente == null) {
			response.put("mensaje", "El cliente con el ID:" + id.toString()+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
		
		Cliente clienteNew = null;
		Map<String,Object> response = new HashMap<>();
		try {
			clienteNew= clienteService.saveClient(cliente);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción a la base de datos");
			response.put("error", e.getMessage().concat("::").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteUpdate = clienteService.findClientById(id) ;
		Map<String,Object> response = new HashMap<>();
		if (clienteUpdate==null) {
			response.put("mensaje", "Error:no se puede editar, el cliente con id:"+id.toString()+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			clienteUpdate.setNombre(cliente.getNombre());
			clienteUpdate.setApellidos(cliente.getApellidos());
			clienteUpdate.setSexo(cliente.getSexo());
			clienteUpdate.setTelefono(cliente.getTelefono());
			clienteService.saveClient(clienteUpdate);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la actualización a la base de datos");
			response.put("error", e.getMessage().concat("::").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido actualizado con éxito!");
		response.put("cliente", clienteUpdate);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}	
	@DeleteMapping("/Cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Cliente clienteBorrado = clienteService.findClientById(id);
		Map<String,Object> response = new HashMap<>();
		if (clienteBorrado==null) {
			response.put("mensaje", "Error:no se puede eliminar el cliente con id:"+id.toString()+" ya que no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			clienteService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el borrado a la base de datos");
			response.put("error", e.getMessage().concat("::").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
		
		
		response.put("mensaje", "El cliente ha sido borrado con éxito!");
		response.put("cliente", clienteBorrado);		
		return  new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}	
}
