package com.amex.trumphRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amex.domain.LineItemDetails;
import com.amex.repositoryMapr.LineItemDaoDtoImpl;

@Component
public class LineItemTurumph {
	
	@Autowired
	private LineItemDaoDtoImpl lineItemDaoDtoImpl;
	
	public LineItemDetails getItemDetailsTrumph(String accountId, String statementId){
		return lineItemDaoDtoImpl.getItemDeatils(accountId, statementId);
	}

}
