package com.ex.endpoints;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ex.model.Customer;

/**
 * author mh.mahmood.alam@gmail.com
 */
@Component
@Path("customerdatas/")
public class CustomerProgramDataResource {
	Logger logger = Logger.getLogger(CustomerProgramDataResource.class);
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIt(@HeaderParam("firstName") String firstName, 
			@HeaderParam("lastName") String lastName,
			@HeaderParam("phoneNumber") String phoneNumber,
			@HeaderParam("emailAddress") String emailAddress,
			@HeaderParam("dob") Date dob) throws Exception {
		
		Customer customer= new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPhoneNumber(phoneNumber);
		customer.setEmailAddress(emailAddress);
		customer.setDob(dob);
		customer.setCustomerId(UUID.randomUUID().toString());
		logger.info(" date recived:"+dob.toString());
		return Response.status(Status.OK).entity(customer).build();

	}
	@GET
	@Path("error")
	@Produces(MediaType.TEXT_HTML)
	public String getException() throws Exception {		
		logger.info("GET error called");
		String msg = "<h1 align=\"center\"> Welcome to new Server</h1></br><h4>hi there</h4>";	
		throw new NullPointerException("OOPS Another");
		

	}
	
	@GET
	@Path("welcome")
	@Produces(MediaType.TEXT_HTML)
	public String getItbypath() throws Exception {	
		logger.info("GET welcome called");
		String msg = "<h1 align=\"center\"> Welcome to new Server</h1></br><h4>hi there</h4>";	
		return msg;

	}

}
