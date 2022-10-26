//package com.springboot.apirest.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springboot.apirest.entity.Cliente;
//import com.springboot.apirest.service.VentasService;
//
//@RestController
//@RequestMapping("/apirest")
//public class ventasController {
//
//	@Autowired 
//	VentasService ventasService;
//	
//	@GetMapping("/folios/{folios}")
//	public ResponseEntity<?> findFolios(@RequestParam String folios){
//		Map<String,Object> response = new HashMap<>();
//		
//		try {
//			Cliente clienteUpdate = ventasService.findFolios(folios);
//			
//			clienteUpdate.setNombre(cliente.getNombre());
//			clienteUpdate.setApellido(cliente.getApellido());
//			clienteUpdate.setEmail(cliente.getEmail());
//			clienteUpdate.setTelefono(cliente.getTelefono());
//			clienteUpdate.setRegion(cliente.getRegion());
//		}catch (DataAccessException e){
//			response.put("mensaje", "Error al realizar la insercion en base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		response.put("mensaje", "El cliente creado con exito");
//		response.put("cliente", cliente);
//		
//		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
//	}
//
//}
