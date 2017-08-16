package org.accion;

import static org.hamcrest.Matchers.*;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.accion.controller.VendorController;
import org.accion.entity.Vendor;
import org.accion.service.VendorService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
@RunWith(SpringRunner.class)
@WebMvcTest(VendorController.class)

//Unit Testing with @WebMvcTest(With Mock objects)
public class TestMethod3 {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private VendorService vendorService;
	//SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public void givenVendors_whenGetVendors_thenReturnJsonArray()
	  throws Exception {
	     
	    Vendor vendor1 = new Vendor("Rackspace","Produts","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
	    Vendor vendor2 = new Vendor("Infoglen","Services","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
	 
	    ArrayList<Vendor> allVendors = new ArrayList<Vendor>();
	    allVendors.add(vendor1);
	    allVendors.add(vendor2);
	 
	    when(vendorService.findAll()).thenReturn((ArrayList<Vendor>) allVendors);
	 
	    mvc.perform(get("/vendor/getAllVendors")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(2)))
	      .andExpect(jsonPath("$[1].name", is(vendor2.getName())));
	 
}
	
	@Test
	public void givenVendor_whenGetByName_thenReturnVendor()
	  throws Exception{
		 Vendor vendor1 = new Vendor("Rackspace","Products","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		 when(vendorService.findVendorByName("Rackspace")).thenReturn(vendor1);
		 mvc.perform(get("/vendor/getByName/{name}","Rackspace")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.category", is("Products")))
			      .andExpect(jsonPath("$.name", is("Rackspace")));
		 
	}
	@Test
	public void givenVendor_whenGetByCategory_thenReturnVendor()
	  throws Exception{
		 Vendor vendor1 = new Vendor("Revive","Health Care","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		 when(vendorService.findByCategory("Health Care")).thenReturn(vendor1);
		 mvc.perform(get("/vendor/getByCategory/{category}","Health Care")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$.name", is("Revive")))
			      .andExpect(jsonPath("$.category", is("Health Care")));
		 
	}
	@Test
	public void givenVendor_CreateVendor()
	  throws Exception{
		 Vendor vendor1 = new Vendor("Revive","Health Care","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		 ObjectMapper mapperObj = new ObjectMapper();
         
		 when(vendorService.save(vendor1)).thenReturn(vendor1);
		 mvc.perform(post("/vendor/add")
			      .contentType(MediaType.APPLICATION_JSON)
			      .content(mapperObj.writeValueAsString(vendor1)))
			      .andExpect(status().isCreated());
			  }
	
	
}
