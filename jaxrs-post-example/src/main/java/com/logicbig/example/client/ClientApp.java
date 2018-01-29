package com.logicbig.example.client;


import com.logicbig.example.Customer;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.ArrayUtils;

public class ClientApp {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.
                  target("http://localhost:8080/jaxrs-post-example/api/customers");

       // postUsingRawJSON(target);
        postByObjectToJasonTransformation(target);
        //getAllCustomers(target);
    }

    private static void getAllCustomers(WebTarget target) {
        String s = target.request().get(String.class);
        System.out.println("All customers : "+s);
    }

    private static void postUsingRawJSON(WebTarget target) {
        String customer = ClientUtil.createCustomerInJSON("Alyssa William"
                  , "1021 Hweitt Street"
                  , "343-343-3433");
        String response = target.request()
                  .post(Entity.entity(customer, MediaType.APPLICATION_JSON)
                            , String.class);
        System.out.println("customer created with id: "+response);

      //get the new customer
        getCustomerById(target, response);

    }

    private static void getCustomerById(WebTarget target, String response) {

        //the complete resource URI would be
        //http://localhost:8080/jaxrs-post-example/api/customers/{newId}"
        String s = target.path(response)
                  .request()
                  .get(String.class);
        System.out.println("new customer :"+s);
    }

  private static void postByObjectToJasonTransformation(WebTarget target) {
        Customer newCustomer = ClientUtil.createNewCustomer("Jake Mae", "342, " +
                  "Snake Dr, GreenLake", "444-333-4564");

        long[] longs = new long[]{8788748L,767767L};
    	Long[] longObjects = ArrayUtils.toObject(longs);
    	List<Long> longList = java.util.Arrays.asList(longObjects);
    	 com.mkyong.rest.Customer customerA=new com.mkyong.rest.Customer(longList);
         
    	String response = target.request(MediaType.APPLICATION_JSON)
                  .accept(MediaType.TEXT_PLAIN_TYPE)
                  .post(Entity.json(customerA), String.class);

        System.out.println("customer created with id: "+response);

        //get the new customer
        //getCustomerById(target, response);

    }
}