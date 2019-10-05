package com.amex.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amex.domain.LineItemDetails;
import com.amex.trumphRepository.LineItemTurumph;

@Component
public class LineItemRepository {
	
	@Autowired
	private LineItemTurumph lineItemTrumph;
	
	public LineItemDetails getLineitemDetails(String accountId,String statementId){
		return lineItemTrumph.getItemDetailsTrumph(accountId, statementId);
	}
}
