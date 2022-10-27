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

import com.springboot.apirest03.entity.Venta;
import com.springboot.apirest03.service.VentaService;

@RestController
@RequestMapping("/api")
public class VentasController {
	
	@Autowired
	private VentaService ventaService;
	
	//forma antigua seria: @RequestMapping(value="ventas",method=RequestMethod.GET)
	@GetMapping("/ventas")
	public List<Venta> index(){
		return ventaService.findVenta();
	}

	
	@GetMapping("/ventas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Venta venta = null;
		Map<String,Object> response = new HashMap<>();
		try {
			venta = ventaService.findVentaById(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta a la base de datos");
			response.put("error", e.getMessage().concat("::").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (venta == null) {
			response.put("mensaje", "La venta con el ID:" + id.toString()+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Venta>(venta,HttpStatus.OK);
	}
	
	@PostMapping("/ventas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Venta venta) {
		
		Venta ventaNew = null;
		Map<String,Object> response = new HashMap<>();
		try {
			ventaNew= ventaService.saveVenta(venta);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción a la base de datos");
			response.put("error", e.getMessage().concat("::").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La venta ha sido creado con éxito!");
		response.put("venta", ventaNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("/ventas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Venta venta, @PathVariable Long id) {
		Venta ventaUpdate = ventaService.findVentaById(id) ;
		Map<String,Object> response = new HashMap<>();
		if (ventaUpdate==null) {
			response.put("mensaje", "Error:no se puede editar, la venta con id:"+id.toString()+" no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			ventaUpdate.setCantidad(venta.getCantidad());
			ventaUpdate.setCliente(venta.getCliente());
			ventaUpdate.setFolio(venta.getFolio());
			ventaUpdate.setIva(venta.getIva());
			ventaUpdate.setProducto(venta.getProducto());
			ventaUpdate.setSubtotal(venta.getSubtotal());
			ventaUpdate.setTotal(venta.getTotal());
			ventaService.saveVenta(ventaUpdate);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la actualización a la base de datos");
			response.put("error", e.getMessage().concat("::").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El venta ha sido actualizado con éxito!");
		response.put("venta", ventaUpdate);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}	
	@DeleteMapping("/venta/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Venta ventaBorrado = ventaService.findVentaById(id);
		Map<String,Object> response = new HashMap<>();
		if (ventaBorrado==null) {
			response.put("mensaje", "Error:no se puede eliminar el venta con id:"+id.toString()+" ya que no existe en la base de datos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			ventaService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el borrado a la base de datos");
			response.put("error", e.getMessage().concat("::").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
		
		
		response.put("mensaje", "El venta ha sido borrado con éxito!");
		response.put("venta", ventaBorrado);		
		return  new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}		
	
}
//
//	@Autowired 
//	VentasService ventasService;
//	
//	@GetMapping("/folios/{folios}")
//	public ResponseEntity<?> findFolios(@RequestParam String folios){
//		Map<String,Object> response = new HashMap<>();
//		
//		try {
//			venta ventaUpdate = ventasService.findFolios(folios);
//			
//			ventaUpdate.setNombre(venta.getNombre());
//			ventaUpdate.setApellido(venta.getApellido());
//			ventaUpdate.setEmail(venta.getEmail());
//			ventaUpdate.setTelefono(venta.getTelefono());
//			ventaUpdate.setRegion(venta.getRegion());
//		}catch (DataAccessException e){
//			response.put("mensaje", "Error al realizar la insercion en base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		response.put("mensaje", "El venta creado con exito");
//		response.put("venta", venta);
//		
//		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
//	}
//
//}
