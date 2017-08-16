package org.accion;


import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.accion.entity.Vendor;
import org.accion.repository.VendorRepository;
import org.accion.service.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

//Unit Testing with @MockBean
public class TestMethod2 extends  VendorManagementApplicationTests{
	
	@TestConfiguration
    static class VendorServiceImplTestContextConfiguration {
  
        @Bean
        public VendorService vendorService() {
            return new VendorService();
        }
    }
	@Autowired
	private VendorService vendorService;
	
	@MockBean
	private VendorRepository vendorRepository;
	//SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
	@Before
	public void setUp() {
	    Vendor vendor = new Vendor("MSA","Data Sources","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
	 
	    Mockito.when(vendorRepository.findByName(vendor.getName()))
	      .thenReturn(vendor);
	}
	@Test
	public void whenValidName_thenVendor() {
	    String expected = "MSA";
	    Vendor ven = vendorService.findVendorByName(expected);
	  
	     assertThat(ven.getName())
	      .isEqualTo(expected);
	 }
	@Before
	public void setUpCategory() {
	    Vendor vendor = new Vendor("ABC","Data","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
	 
	    Mockito.when(vendorRepository.findByCategory(vendor.getCategory()))
	      .thenReturn(vendor);
	}
	@Test
	public void whenValidCategory_thenVendor() {
	    String category = "Data";
	    Vendor ven = vendorService.findByCategory(category);
	  
	     assertThat(ven.getCategory())
	      .isEqualTo(category);
	 }
	
	@Before
	public void setUpVendors(){
		List<Vendor> vendors=new ArrayList<Vendor>();
		Vendor v1=new Vendor("ABC","XYZ","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		Vendor v2=new Vendor("DEF","UVW","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		vendors.add(v1);
		vendors.add(v2);
		 Mockito.when(vendorRepository.findAll())
	      .thenReturn((ArrayList<Vendor>) vendors);
		}
	@Test
	public void whenFindAll_thenVendors() {
	    List<Vendor> ven=new ArrayList<Vendor>();
	    Vendor v3=new Vendor("ABC","XYZ","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		Vendor v4=new Vendor("DEF","UVW","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		ven.add(v3);
		ven.add(v4);
	     List<Vendor> ven1 = vendorService.findAll();
	     
	  
	     assertThat(ven1)
	      .isEqualTo(ven1);
	 }
	
	
}
