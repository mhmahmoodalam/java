package com.ex.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;

/**
 * author mh.mahmood.alam@gmail.com
 */
@Component
@Path("customer/")
public class AnotherResource {
	
	@GET
	@Path("get")
	@Produces(MediaType.TEXT_HTML)
	public String getException() throws Exception {		
		String msg = "<h1 align=\"center\"> Welcome to new Server</h1></br><h4>hi there</h4>";	
		throw new NullPointerException("OOPS");
		

	}

}
