package com.amex.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemDetails {
	private int count;
	private List<LineItemDetail> itemdetails;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<LineItemDetail> getItemdetails() {
		return itemdetails;
	}
	public void setItemdetails(List<LineItemDetail> itemdetails) {
		this.itemdetails = itemdetails;
	}
	
	

}
