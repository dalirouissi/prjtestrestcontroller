package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PrjtestRestControllerApplication.class)
@WebAppConfiguration
public class VehicleControllerTest {

	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("mappingJackson2HttpMessageConverter")
	private HttpMessageConverter httpMessageConverter;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MediaType contentType = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	//Test is Ok.
	@Test
	public void displayInfoTest_Bookmark() throws Exception{
		String vehicleJson = convertTojson(new Vehicle(23,"Sedan", "BMW"));
		this.mockMvc.perform(post("/vehicles/info")
                .contentType(contentType)
                .content(vehicleJson))
                .andExpect(status().isOk());
	}

	//Test should for with BadRequest.
	@Test
	public void displayInfoTest_Account() throws Exception{
        String tank = convertTojson(new Tank(12, "TANK-12-GASOLINE"));
		this.mockMvc.perform(post("/vehicles/info")
                .contentType(contentType)
                .content(tank))
                .andExpect(status().isOk());
	}
	
	@SuppressWarnings("unchecked")
	private String convertTojson(Object o)
			throws HttpMessageNotWritableException, IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.httpMessageConverter.write(o, MediaType.APPLICATION_JSON,
				mockHttpOutputMessage);
		System.out.println("The data Json Object "
				+ mockHttpOutputMessage.getBodyAsString());
		return mockHttpOutputMessage.getBodyAsString();
	}
	
}
