package com.amex.repositoryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amex.domain.LineItemDetails;
import com.amex.repository.LineItemRepository;

@Component
public class LineItemRepositoryClient {
	
	@Autowired
	private LineItemRepository lineItemRepository;
	 
	public LineItemDetails getLineItemDeatilsClient(String accountId, String statementId){
		return lineItemRepository.getLineitemDetails(accountId, statementId);
	}
	

}
