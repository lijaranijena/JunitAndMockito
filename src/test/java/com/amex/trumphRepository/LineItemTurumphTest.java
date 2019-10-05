package com.amex.trumphRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.amex.domain.LineItemDetail;
import com.amex.domain.LineItemDetails;
import com.amex.repositoryMapr.LineItemDaoDtoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LineItemTurumphTest {
	
	@Mock
	private LineItemDaoDtoImpl lineItemDaoDtoImpl;
	
	@InjectMocks
	private LineItemTurumph lineItemTurumph;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getItemDetailsTrumph() throws Exception{
		
	/*	String respBody="{\"count\":1,\"itemdetails\":[{\"productId\":\"12345\""
				+ ",\"itemName\":\"top\",\"itemDescription\":\"cjhb\"}]}";
		LineItemDetails lineItemResponse = new ObjectMapper().readValue(respBody, LineItemDetails.class);*/
		
		
		LineItemDetails lineItemDetails=new LineItemDetails();
		LineItemDetail lineItemDeatil=new LineItemDetail();
		
		lineItemDeatil.setItemDescription("cjhb");
		lineItemDeatil.setItemName("top");
		lineItemDeatil.setProductId("12345");
		
		List<LineItemDetail> itemList=new ArrayList<LineItemDetail>();
		itemList.add(lineItemDeatil);
		lineItemDetails.setCount(itemList.size());
		lineItemDetails.setItemdetails(itemList);
		
		
		
		Mockito.when(lineItemDaoDtoImpl.getItemDeatils(Mockito.any(), Mockito.any()))
		.thenReturn(lineItemDetails);
		
		LineItemDetails itemDetailsTrumphResponse = lineItemTurumph.getItemDetailsTrumph(Mockito.any(), Mockito.any());
		Assert.assertEquals(lineItemDetails.getCount(), itemDetailsTrumphResponse.getCount());
		Assert.assertEquals(lineItemDetails.getItemdetails(), itemDetailsTrumphResponse.getItemdetails());
		
	}

}
