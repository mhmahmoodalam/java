package com.ex.utilities;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ext.Provider;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ex.model.ResponseModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/*
 * created 
 */
/**
 * Exception class to encapsulate the Invalid Headers
 */
@Provider
@Component
public class HeadersValidationInterceptor extends HandlerInterceptorAdapter {
    private static final Logger GENERALLOG = Logger
            .getLogger(HeadersValidationInterceptor.class);

    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String PHONE_NUMBER = "PhoneNumber";
    private static final String EMAIL_ADDRESS = "EmailAddress";
    private static final String DATE_OF_BIRTH = "Dob";

    private static final List<String> S_REQUIRED_HEADERS = Arrays.asList(
    		FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL_ADDRESS, DATE_OF_BIRTH);
    static {
    	GENERALLOG.info("interceptor loaded");
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#
     * preHandle (javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(final HttpServletRequest request,
            final HttpServletResponse response, final Object handler)
                    throws JsonProcessingException, IOException {
        GENERALLOG.info("Validating headers");
        final ObjectMapper mapper = new ObjectMapper();
        ResponseModel responseModel= new ResponseModel();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.UPPER_CAMEL_CASE);
        String loggerMsg = "Error for URI:" + request.getRequestURI();
        final String requestURI = request.getRequestURI();       
            
            for (final String header : S_REQUIRED_HEADERS) {
                if (request.getHeader(header) == null) {

                    final String msg = String
                            .format(" Required header %s is missing.", header);

                    // httpResponseMessage.setCorrelationId(correlationId);
                    responseModel.setMessage(msg);
                    response.setStatus(HttpStatus.SC_BAD_REQUEST);
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
                    response.getOutputStream().println(mapper
                            .writeValueAsString(responseModel));
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    GENERALLOG.error(String.format("%s - %s ", loggerMsg, msg));

                    return false;
                }
            }

            
       
        return true;
    }
}