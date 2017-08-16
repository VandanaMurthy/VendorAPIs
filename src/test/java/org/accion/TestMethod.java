package org.accion;

import static org.assertj.core.api.Assertions.assertThat;


import org.accion.entity.Vendor;
import org.accion.service.VendorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMethod   {

	@Autowired
    VendorService vendorService;
	
	
	
	//Functional Test Case
	@Test
	public void whenValidName_thenVendorShouldBeFound() {
	    String expectedResult = "Flywood";
	    //Vendor v1=new Vendor(2000,"Nature Basket","Food");
	    
	    Vendor vendor = vendorService.findVendorByName(expectedResult);
	    //System.out.println("Res= "+  expectedResult);
	  
	     assertThat(vendor.getName())
	      .isEqualTo(expectedResult);
	 }
}

