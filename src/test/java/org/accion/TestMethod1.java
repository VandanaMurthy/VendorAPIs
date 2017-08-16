package org.accion;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;


import org.accion.entity.Vendor;
import org.accion.repository.VendorRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

//Integration Testing with @DataJpaTest
//Testing persistence Layer
@DataJpaTest
public class TestMethod1 extends  VendorManagementApplicationTests{

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	
	
	@Test
	public void whenFindByName_thenReturnVendor(){
		Vendor v1=new Vendor("Panasonic","Accessories","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		entityManager.persist(v1);
		entityManager.flush();
		
		Vendor expected=vendorRepository.findByName(v1.getName());
		assertThat(expected.getName()).isEqualTo(v1.getName());
	}
	
	@Test
	public void whenFindByCategory_thenReturnVendor(){
		Vendor v1=new Vendor("Panasonic","Accessories","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		entityManager.persist(v1);
		entityManager.flush();
		
		Vendor expected=vendorRepository.findByCategory(v1.getCategory());
		assertThat(expected.getCategory()).isEqualTo(v1.getCategory());
		
	}
	@Test
	public void whenFindAll_thenReturnAllVendors(){
		Vendor v1=new Vendor("Panasonic","Accessories","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		Vendor v2=new Vendor("sony","Headphones","18/09/2011","10/05/2013",25,1000.00,"Inactive","Bangalore");
		List<Vendor> vendors=new ArrayList<Vendor>();
		vendors.add(v1);
		vendors.add(v2);
		entityManager.persist(v1);
		entityManager.persist(v2);
		entityManager.flush();
		List<Vendor> vendorsList=vendorRepository.findAll();
		
		assertThat(vendorsList).isEqualTo(vendors);
		
	}
	
	
	
}

