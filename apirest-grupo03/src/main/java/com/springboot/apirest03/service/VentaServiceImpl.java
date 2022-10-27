package com.springboot.apirest03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apirest03.dao.VentasDao;
import com.springboot.apirest03.entity.Cliente;
import com.springboot.apirest03.entity.Venta;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	private VentasDao ventasDao;



	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return ventasDao.getClientes();
	}



	@Override
	public List<Venta> findVenta() {
		// TODO Auto-generated method stub
		return (List<Venta>)ventasDao.findAll();
	}



	@Override
	public Venta findVentaById(Long id) {
		// TODO Auto-generated method stub
		return ventasDao.findById(id).get();
	};







	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ventasDao.deleteById(id);
	}



	@Override
	public Venta saveVenta(Venta venta) {
		// TODO Auto-generated method stub
		return ventasDao.save(venta);
	}







	
	

}
