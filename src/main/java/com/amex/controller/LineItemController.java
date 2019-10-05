package com.amex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amex.domain.LineItemDetails;
import com.amex.repositoryClient.LineItemRepositoryClient;

@RestController
public class LineItemController {
	
	@Autowired
	private LineItemRepositoryClient lineItemClient;
	
	@GetMapping(value="/lineItem/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LineItemDetails> getItemDetails(
			@PathVariable("accountId") String accountId, 
			@RequestParam("statementId") String statementId, @RequestHeader String traceId, 
			@RequestHeader String spanid, @RequestHeader String authorization){

		 LineItemDetails lineItemDeatilsResponseBody = lineItemClient.getLineItemDeatilsClient(accountId, statementId);
		// return ResponseEntity.ok(lineItemDeatilsResponseBody);
		 return new ResponseEntity<LineItemDetails>(lineItemDeatilsResponseBody, HttpStatus.OK);
	}

}

