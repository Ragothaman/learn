package com.mkyong.rest;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


 
@Path("/hello")
public class HelloWorldService {
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	 
		@POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.TEXT_PLAIN)
		@Path("/createcustomer")
	    public Customer createCustomer(Customer newCustomer) {
	       System.out.println("customer"+newCustomer.getLoanIds());
	       return newCustomer;
	    }
 
}