package com.ex.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.ex.capability.Capability;
import com.ex.dto.RequestParams;
//custom exception if any. else comment thisimport
import com.ex.exception.ApplicationServiceException;
import com.ex.utility.logging.Logger;


/**
 * This is the resource class for ServiceModel book service.
 * 
 */
@RestController
@RequestMapping("/Customers")
public class ServiceResource {

  /**
   * GENERALLOG
   */
  private static final Logger GENERAL_LOG = Logger
  .getLogger(ServiceResource.class);

  /**
   * Constant used for the conversion of time into seconds
   */
  private static final int MILLI_SECOND = 1000;

  

  /**
   * serviceCapability
   */
  private Capability serviceCapability;

  /**
   * Setter for serviceCapability
   * 
   * @param serviceCapabilityImpl
   *          serviceCapabilityImpl
   */
  public void setserviceCapability(
  final Capability CapabilityImpl) {
    this.serviceCapability = CapabilityImpl;
  }

  /**
   * Get RequestParams
   * 
   * @param headers
   *          HttpHeaders
   * @return RequestParams
   */
  public RequestParams getRequestParams(final HttpHeaders headers) {
    return new RequestParams(headers);
  }

  /**
   * API to add an ServiceModel record in personal contact table
   * 
   * @param customerId
   *          String
   * @param serviceData
   *          ServiceData
   * @param requestHeaders
   *          HttpHeaders
   * @param servletResponse
   *          HttpServletResponse
   * @return ResponseEntity<ServiceModel>
   * @throws ApplicationServiceException
   *           ApplicationServiceException
   * @throws JsonGenerationException
   *           JsonGenerationException
   * @throws JsonMappingException
   *           JsonMappingException
   * @throws IOException
   *           IOException
   * @throws CacheUtilityExceptionCU
   *           CacheUtilityExceptionCU
   * @throws TransactionUtilityException
   *           TransactionUtilityException
   */
  @RequestMapping(value = "/{CustomerId}/ApplicationService", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
  @Timed(absolute = true, name = "api.add")
  public ResponseEntity<ServiceModel> add(
  @PathVariable("customer_id") final String customerId,
  @RequestBody final ServiceData serviceData,
  @RequestHeader final HttpHeaders requestHeaders,
  @Context final HttpServletResponse servletResponse)
  throws ApplicationServiceException, JsonGenerationException, JsonMappingException,
  IOException, CacheUtilityExceptionCU,
  TransactionUtilityException {

   
    final RequestParams requestParams = this.getRequestParams(requestHeaders)
    .setServiceData(serviceData).setCustomerId(customerId);

    ServiceModel serviceModel;

    try {
     
      /*
       * setting response to jersey response to return 201 status. servlet
       * response is unable to detect 201 status.So Jersey response is being
       * used instead of servlet response.
       */
    	 servletResponse.setHeader("CORRELATION_ID", "12345");
      return ResponseEntity.status(HttpStatus.CREATED).body(new ServiceModel());

    } finally {

     
    }

  }

  
  /**
   * Performs a test of the service provider to indicate health of the service.
   */

  @RequestMapping(path = "/HealthCheck", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  @Timed(absolute = true, name = "api.healthCheck")
  public void healthCheck() {
    GENERAL_LOG.info("ApplicationService server is up");
  }

}