package com.logicbig.example;


import com.logicbig.example.api.CustomerRestService;
import com.logicbig.example.client.ClientUtil;
import com.mkyong.rest.Customer;

import org.apache.commons.lang.ArrayUtils;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

public class CustomerRestServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(CustomerRestService.class);
    }

    /*@Test
    public void customerRestServiceRawTest() {
        String joe = ClientUtil.createCustomerInJSON("Joe", "435 West Dr, Peejay", "555-456-9877");
        String response = target("customers").request()
                  .post(Entity.entity(joe, MediaType.APPLICATION_JSON),
                        String.class);
        System.out.println(response);
    }*/

    @Test
    public void customerRestServiceTest() {
    /*    com.logicbig.example.Customer newCustomer = new com.logicbig.example.Customer();
        newCustomer.setName("Jake Mae");
        newCustomer.setAddress("342, Snake Dr, GreenLake");
        newCustomer.setPhoneNumber("444-333-4564");
        */
    	long[] longs = new long[]{8788748L,767767L};
    	Long[] longObjects = ArrayUtils.toObject(longs);
    	List<Long> longList = java.util.Arrays.asList(longObjects);
    
    	System.out.println(longList.get(0)+" "+longList.get(1));
    	List<Long> list = new ArrayList<Long>();
    	list.add(8788748L);
    	list.add(767767L);
    	System.out.println(list.get(0)+" "+list.get(1));
    	
        com.mkyong.rest.Customer newCustomer=new Customer(longList);
        String response = target("customers")
                  .request(MediaType.APPLICATION_JSON)
                  .accept(MediaType.TEXT_PLAIN_TYPE)
                  //this time we are calling post to make a HTTP POST call
                  .post(Entity.json(newCustomer), String.class);


        System.out.println(response);
    }
}