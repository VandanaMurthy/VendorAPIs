package org.accion;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

//Integration Testing with @SpringBootTest(Testing with actual MYSQL database)
public class TestMethod4 {
	@Autowired
    private MockMvc mvc;

    @Test
    public void givenVendors_whenGetVendors_thenStatus200()
      throws Exception {
     
    	
        mvc.perform(get("/vendor/getAllVendors")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$[1].name", is("Market Basket")));
    }
    @Test
    public void givenVendor_whenGetVendorById_thenStatus200()
      throws Exception {
     
    	
        mvc.perform(get("/vendor/getById/1500")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$.name", is("Market Basket")));
    }
    @Test
    public void givenVendor_whenGetVendorByName_thenStatus200()
      throws Exception {
     
    	
        mvc.perform(get("/vendor/getByName/BSNL")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$.id", is(1000)));
    }
    @Test
    public void givenVendor_whenGetVendorByCategory_thenStatus200()
      throws Exception {
     
    	
        mvc.perform(get("/vendor/getByCategory/Internet Services")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$.name", is("BSNL")));
    }
   

}
