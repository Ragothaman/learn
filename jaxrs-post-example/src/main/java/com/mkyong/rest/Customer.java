package com.mkyong.rest;

import java.util.List;


public class Customer {
	private List<Long> ids;

	 public Customer() {
		super();
	}
	public Customer(List<Long> ids) {
		  this.ids= ids;
		 }
	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	
}
