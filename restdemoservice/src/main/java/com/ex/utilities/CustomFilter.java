package com.ex.utilities;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.ext.Provider;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.ex.model.ResponseModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

//@Provider
//@Component
public class CustomFilter implements ContainerRequestFilter{
	private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String PHONE_NUMBER = "PhoneNumber";
    private static final String EMAIL_ADDRESS = "EmailAddress";
    private static final String DATE_OF_BIRTH = "Dob";

    private static final List<String> S_REQUIRED_HEADERS = Arrays.asList(
    		FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL_ADDRESS, DATE_OF_BIRTH);
	Logger logger = Logger.getLogger(CustomFilter.class);
	@Override
	public ContainerRequest filter(ContainerRequest request) {
		logger.info("Validating headers");
        final ObjectMapper mapper = new ObjectMapper();
        ResponseModel responseModel= new ResponseModel();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.UPPER_CAMEL_CASE);
        String loggerMsg = "Error for URI:" + request.getPath();
        final String requestURI = request.getPath();       
            
            for (final String header : S_REQUIRED_HEADERS) {
                if (request.getHeaderValue(header) == null) {

                    final String msg = String
                            .format(" Required header %s is missing.", header);

                    // httpResponseMessage.setCorrelationId(correlationId);
                    responseModel.setMessage(msg);
                    //response.setStatus(HttpStatus.SC_BAD_REQUEST);
                    /*
                     * httpResponseMessage.setCode(
                     * Integer.toString(Status.BAD_REQUEST.getStatusCode()));
                     */

                    switch (header) {
                    case FIRST_NAME:
                    	responseModel
                                .setCode("errorcode");
                        break;
                    case LAST_NAME:
                    	responseModel
                        .setCode("errorcode");
                        break;
                    case PHONE_NUMBER:
                    	responseModel
                        .setCode("errorcode");
                        break;
                    case EMAIL_ADDRESS:
                    	responseModel
                        .setCode("errorcode");
                        break;
                    case DATE_OF_BIRTH:
                    	responseModel
                        .setCode("errorcode");
                        break;

                    }
                   // response.getOutputStream().println(mapper
                     //       .writeValueAsString(responseModel));
                    //response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    logger.error(String.format("%s - %s ", loggerMsg, msg));

                   
                }
            }
            return request;
	}

}
