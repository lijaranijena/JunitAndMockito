package com.amex.repositoryMapr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.amex.domain.LineItemDetail;
import com.amex.domain.LineItemDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LineItemDaoDtoImpl {
	
	public LineItemDetails getItemDeatils(String accountId, String statementId) {
		LineItemDetails lineItemDetails=new LineItemDetails();
		LineItemDetail lineItemDeatil=new LineItemDetail();
		
		lineItemDeatil.setItemDescription("cjhb");
		lineItemDeatil.setItemName("top");
		lineItemDeatil.setProductId("12345");
		
		List<LineItemDetail> itemList=new ArrayList<LineItemDetail>();
		itemList.add(lineItemDeatil);
		lineItemDetails.setCount(itemList.size());
		lineItemDetails.setItemdetails(itemList);
		return lineItemDetails;
	}
}
