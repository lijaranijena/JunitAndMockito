package com.amex.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.amex.domain.LineItemDetails;
import com.amex.repositoryClient.LineItemRepositoryClient;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(controllers={LineItemController.class}, secure=false)
public class LineItemControllerTest {
 
	private MockMvc mockMvc;
	@Mock
	private LineItemRepositoryClient lineItemClient;
	
	@InjectMocks
	private LineItemController lineItemController;
	
	private static String accountNumaber="57846298u88ui98y";
	
	@Before
	public void setUp() {
		//MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(lineItemController).build();
	}
	
	@Test
	@Ignore
	public void getItemDetailsTest() throws Exception {
		String respBody="{\"count\":1,\"itemdetails\":[{\"productId\":\"12345\""
				+ ",\"itemName\":\"top\",\"itemDescription\":\"cjhb\"}]}";
		
		Mockito.when(lineItemClient.getLineItemDeatilsClient( Mockito.any(), Mockito.any() ))
		.thenReturn(new ObjectMapper().readValue(respBody, LineItemDetails.class));
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/lineItem/"+accountNumaber)
				.param("statementId", "test")
				.header("traceId", "test_traeId")
				.header("spanid", "test_spanId")
				.header("authorization", "test_authorization")
				.accept(MediaType.APPLICATION_JSON_VALUE)
			).andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(MockMvcResultMatchers.content().json(respBody));
			//.andExpect(MockMvcResultMatchers.content().string(respBody));
	}
}