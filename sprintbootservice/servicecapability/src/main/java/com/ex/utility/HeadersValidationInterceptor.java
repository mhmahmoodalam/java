package com.ex.utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ex.utility.logging.Logger;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/*
 * created 8/5/2016 x75l
 */
/**
 * Exception class to encapsulate the Invalid Headers
 */
@Component
public class HeadersValidationInterceptor extends HandlerInterceptorAdapter {
    private static final Logger GENERALLOG = Logger
            .getLogger(HeadersValidationInterceptor.class);

    private static final String USER_ID = "UserId";
    private static final String Service_API_VERSION = "ServiceApiVersion";
    private static final String CORRELATION_ID = "CorrelationId";
    private static final String DATE_TIME = "DateTime";
    private static final String SOURCE = "Source";
    private static final String SUB_SOURCE = "SubSource";

    private static final List<String> S_REQUIRED_HEADERS = Arrays.asList(
            USER_ID, Service_API_VERSION, CORRELATION_ID, DATE_TIME, SOURCE,
            SUB_SOURCE);

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
        final ObjectMapper ServiceMapper = new ObjectMapper();
        ServiceMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        ServiceMapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.UPPER_CAMEL_CASE);
        final CustomResponseMessages httpResponseMessages = new CustomResponseMessages();
        final CustomResponseMessage httpResponseMessage = new CustomResponseMessage();
        String loggerMsg = "Error for URI:" + request.getRequestURI();
        final String requestURI = request.getRequestURI();
        if (!requestURI.contains("HealthCheck")) {
            final String correlationId = request
                    .getHeader("CORRELATION_ID");
            if (null != correlationId) {
                httpResponseMessage.setCorrelationId(correlationId);
                loggerMsg = String.format("%s - with Correlation Id : [%s]",
                        loggerMsg, correlationId);
            }
            for (final String header : S_REQUIRED_HEADERS) {
                if (request.getHeader(header) == null) {

                    final String msg = String
                            .format(" Required header %s is missing.", header);

                    // httpResponseMessage.setCorrelationId(correlationId);
                    httpResponseMessage.setMessage(msg);
                    response.setStatus(HttpStatus.SC_BAD_REQUEST);
                    /*
                     * httpResponseMessage.setCode(
                     * Integer.toString(Status.BAD_REQUEST.getStatusCode()));
                     */

                    switch (header) {
                    case USER_ID:
                        httpResponseMessage
                                .setCode("errorcode");
                        break;
                    case CORRELATION_ID:
                    	httpResponseMessage
                        .setCode("errorcode");
                        break;
                    case DATE_TIME:
                    	httpResponseMessage
                        .setCode("errorcode");
                        break;
                    case SOURCE:
                    	httpResponseMessage
                        .setCode("errorcode");
                        break;
                    case SUB_SOURCE:
                    	httpResponseMessage
                        .setCode("errorcode");
                        break;
                    case Service_API_VERSION:
                    	httpResponseMessage
                        .setCode("errorcode");
                        break;

                    }
                    httpResponseMessages.getHttpResponseMessages()
                            .add(httpResponseMessage);
                    response.getOutputStream().println(ServiceMapper
                            .writeValueAsString(httpResponseMessages));
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    GENERALLOG.error(String.format("%s - %s ", loggerMsg, msg));

                    return false;
                }
            }

            if (!"1.0".equalsIgnoreCase(request.getHeader(Service_API_VERSION))) {

                final String msg = "Incompatible Service_API_VERSION from client";
                httpResponseMessage.setMessage(msg);
                httpResponseMessage.setCode("400");
                httpResponseMessages.getHttpResponseMessages()
                        .add(httpResponseMessage);
                response.setStatus(HttpStatus.SC_BAD_REQUEST);
                response.getOutputStream().println(
                        ServiceMapper.writeValueAsString(httpResponseMessages));
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                GENERALLOG.error(String.format("%s - %s ", loggerMsg, msg));
                return false;
            }
        }
        return true;
    }
}