package org.accion.controller;

import java.util.Arrays;


import java.util.List;
import org.accion.entity.Vendor;
import org.accion.service.VendorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;





@RestController
//@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/vendor")

public class VendorController {
	
	final static Logger logger = Logger.getLogger(VendorController.class);
	@Autowired
	private VendorService vs;
	

	
	@RequestMapping(value="/add",method=RequestMethod.POST,headers = {"content-type=application/json"})
	public ResponseEntity<Vendor> add(@RequestBody Vendor ven){
			vs.save(ven);
			logger.debug("Added: " + ven);
			return new ResponseEntity<Vendor>(ven,HttpStatus.CREATED);
			
		}
	
	
	@PutMapping("/updateByName/{name}")
	//@RequestMapping(value="/updateByName/{name}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Void> updateVendorByName(@RequestBody Vendor ven,@PathVariable("name")String name){
	Vendor vendor=vs.findVendorByName(ven.getName());
	if(vendor == null){
		logger.debug("Vendor with name " + ven.getName() + " does not exists");
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	else{
		vs.save(ven);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	}
	
	@GetMapping("/getByName/{name}")
	//@RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Vendor> getVendorByName(@PathVariable("name") String name) {
		Vendor ven1 = vs.findVendorByName(name);
		if (ven1 == null) {
			logger.debug("Vendor with name " + name + " does not exists");
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Vendor:: " + ven1);
		return new ResponseEntity<Vendor>(ven1, HttpStatus.OK);
	}
	
	@GetMapping("/getByCategory/{category}")
	//@RequestMapping(value = "/getByCategory/{category}", method = RequestMethod.GET)
	public ResponseEntity<Vendor> getVendorByCategory(@PathVariable("category") String category) {
		Vendor ven2 = vs.findByCategory(category);
		if (ven2 == null) {
			logger.debug("Vendor associated with category  " + category + " does not exists");
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Vendor:: " + ven2);
		return new ResponseEntity<Vendor>(ven2, HttpStatus.OK);
	}
	@GetMapping("/getAllVendors")
	//@RequestMapping(value = "/getAllVendors",method = RequestMethod.GET)
	public ResponseEntity<List<Vendor>> getAllVendors() {
		List<Vendor> vendors = vs.findAll();
		if (vendors.isEmpty()) {
			logger.debug("Vendors does not exists");
			return new ResponseEntity<List<Vendor>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + vendors.size() + " vendors");
		logger.debug(vendors);
		logger.debug(Arrays.toString(vendors.toArray()));
		return new ResponseEntity<List<Vendor>>(vendors, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByName/{name}")
	//@RequestMapping(value = "/deleteByName/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVendor(@PathVariable("name") String name) {
		Vendor v1 = vs.findVendorByName(name);
		if (v1 == null) {
			logger.debug("Vendor with name " + name + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			vs.delete(v1);
			logger.debug("Vendor with name" + name + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
