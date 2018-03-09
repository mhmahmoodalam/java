package com.ex.endpoints;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Provider
@Component
public class ErrorController
     implements ExceptionMapper<Exception> {

	Logger logger = Logger.getLogger(ErrorController.class);
   @Override
   public Response toResponse(Exception e) {
	   logger.info("ErrorController: reached here");
	   Status status=null;
	   String mesg=null;
	    if (e instanceof NullPointerException) {
		   status=Response.Status.INTERNAL_SERVER_ERROR;
		   mesg="OOPS! Our bad we messed it up.";
	   }else  {
		   status=Response.Status.BAD_REQUEST;
		   mesg="OOPS! you had a diversion";
	   }
      return Response.status(status).entity(mesg).build();
   }
}