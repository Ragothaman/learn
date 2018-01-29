/*package com.logicbig.example.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.mkyong.rest.Customer;

public class newClientForPost {

	public newClientForPost() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Customer newCustomer =new Customer();
		long[] loanIds={7877464773L,7847849393L};
newCustomer.setLoanIds(loanIds);
		 Client client = ClientBuilder.newClient();
	        WebTarget target = client.
	                  target("http://localhost:8080/RESTfulExample/rest/createcustomer");
	        String response = target.request(MediaType.APPLICATION_JSON)
	                  .accept(MediaType.TEXT_PLAIN_TYPE)
	                  .post(Entity.json(newCustomer), String.class);

	        System.out.println("customer created with id: "+response);

	}

}
*/