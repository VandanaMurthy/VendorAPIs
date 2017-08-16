package org.accion.service;

import java.util.List;



import org.accion.entity.Vendor;

import org.accion.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
	@Autowired
	private VendorRepository venResp;

	
	public List<Vendor> findAll(){
		return venResp.findAll();
	}
	
	 public Vendor save(Vendor ven){
		 return venResp.save(ven);
	 }
	public void delete(Vendor ven){
		venResp.delete(ven);
	}
	
	
	public Vendor findVendorByName(String name){
		return venResp.findByName(name);
	}
	public Vendor findByCategory(String category){
		return venResp.findByCategory(category);
	}
	 
	
}
