package com.ex.utilities;

import java.io.IOException;
import java.util.*;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.http.MediaType;

import com.ex.model.ResponseModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@Provider
//@PreMatching
public class CustomUserFilter implements ContainerRequestFilter,ContainerResponseFilter{
	 private static final String FIRST_NAME = "FirstName";
	    private static final String LAST_NAME = "LastName";
	    private static final String PHONE_NUMBER = "PhoneNumber";
	    private static final String EMAIL_ADDRESS = "EmailAddress";
	    private static final String DATE_OF_BIRTH = "Dob";

	    private static final List<String> S_REQUIRED_HEADERS = Arrays.asList(
	    		FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL_ADDRESS, DATE_OF_BIRTH);
	final String errorMsg= " header field is missing in request.";
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

        //GENERALLOG.info("Validating headers");
       
        String loggerMsg = "Error for URI:" + requestContext.getUriInfo().getPath();
        final String requestURI = requestContext.getUriInfo().getPath();       
        
		for(String header: S_REQUIRED_HEADERS) {
			if(requestContext.getHeaderString(header)==null || "".equals(requestContext.getHeaderString(header).trim())) {
				
				requestContext.abortWith(Response
		                .status(Response.Status.BAD_REQUEST)
		                .entity(header+errorMsg)
		                .build());
			}
		}
		
		
	}
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		 final ObjectMapper mapper = new ObjectMapper();
	        ResponseModel responseModel= new ResponseModel();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        mapper.setPropertyNamingStrategy(
	                PropertyNamingStrategy.UPPER_CAMEL_CASE);
	        
	        if(responseContext.getStatus() >= 300) {
	        	responseModel.setCode("200");
	        	responseModel.setMessage("ERROR FOR REQUEST");
	        	responseContext.setEntity(responseModel);
	        }
		
	}

}
