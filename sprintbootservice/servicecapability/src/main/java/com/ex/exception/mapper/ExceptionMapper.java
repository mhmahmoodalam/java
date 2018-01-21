
package com.ex.exception.mapper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.codehaus.jackson.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ex.exception.ApplicationServiceException;
import com.ex.utility.logging.Logger;
import com.ex.exception.ErrorCodes;

import com.ex.exception.CustomResponseMessage;
import com.ex.exception.CustomResponseEntity;

/**
 * Exception Mapper
 *
 * @author x6bt
 *
 */
@ControllerAdvice
@RestController
public class ExceptionMapper {

    /**
     * logger
     */
    private static final Logger GENERALLOG = Logger
            .getLogger(ExceptionMapper.class);
    private static final String WITH_CORRELATION_ID = "- Correlation Id : ";

    @Context
    private HttpServletRequest request;

    /**
     * @param request
     *            HttpServletRequest
     */
    public void setRequest(final HttpServletRequest request) {
        this.request = request;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     *
     * implementing the exception mapper for handling exception to http response
     * properly. Exception Mappers are used to map all exception to http
     * response templates with proper exception code as status and body with
     * appropriate message and error code.
     */

    /**
     * Handles exception parsing of Json
     * 
     * @param e
     *            JsonParseException
     * @param request
     *            HttpServletRequest
     * @return ResponseEntity<CustomResponseEntity>
     * @throws IOException
     *             IOException
     */
    @ExceptionHandler(value = JsonParseException.class)
    public ResponseEntity<CustomResponseEntity> handleJsonParseException(
            final JsonParseException e, final HttpServletRequest request)
                    throws IOException {

        final String errorMsg = "Parse Exception Occured";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(getCustomResponseEntity(e, request, errorMsg, null,
                        HttpStatus.BAD_REQUEST));
    }

    /**
     * Handles exception occurred when input element for ServiceData is not
     * populated correctly
     * 
     * @param e
     *            ServiceBookException
     * @param request
     *            HttpServletRequest
     * @return ResponseEntity<CustomResponseEntity>
     * @throws IOException
     *             IOException
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ServiceBookException.class)
    public ResponseEntity<CustomResponseEntity> handleInvalidServiceDataException(
            final ServiceBookException e, final HttpServletRequest request)
                    throws IOException {
        String errorMsg="";
        if (e instanceof InvalidServiceDataException) {
            errorMsg = "Invalid Service Data Exception Occured ";
        } else if (e instanceof InvalidRequestHeaderParamsException) {
            errorMsg = "Invalid Request Header Params Exception Occured ";
        } else if (e instanceof InvalidRequestQueryParamsException) {
            errorMsg = "Invalid Query Params Exception Occured ";
        } else if (e instanceof InvalidTelephoneDataException) {
            errorMsg = "Invalid Telephone Data Exception Occured ";
        } else if (e instanceof InvalidEmailServiceException) {
            errorMsg = "Invalid Email Data Exception Occured ";
        } else if (e instanceof InternalServerException) {
            errorMsg = "Internal Server Exception Occured ";
        }
        return ResponseEntity.status(e.getHttpStatus())
                .body(getCustomResponseEntity(e, request, errorMsg,
                        e.getErrorCode(), e.getHttpStatus()));
    }

    /**
     * Handles exception occurred when we encounter an exception while reading
     * element from Cache
     * 
     * @param e
     *            CacheUtilityExceptionCU
     * @param request
     *            HttpServletRequest
     * @return ResponseEntity<CustomResponseEntity>
     * @throws IOException
     *             IOException
     */
    @ExceptionHandler(value = CacheUtilityExceptionCU.class)
    public ResponseEntity<CustomResponseEntity> handleCacheUtilityExceptionCU(
            final CacheUtilityExceptionCU e, final HttpServletRequest request)
                    throws IOException {

        final String errorMsg = "CacheUtilityExceptionCU Occured ";
        return ResponseEntity.status(e.getStatus())
                .body(getCustomResponseEntity(e, request, errorMsg,
                        e.getErrorCode(), e.getStatus()));
    }

    /**
     * Handles exception occurred when we encounter an exception while
     * interacting with SIP API
     * 
     * @param e
     *            SiperianUtilityException
     * @param request
     *            HttpServletRequest
     * @return ResponseEntity<CustomResponseEntity>
     * @throws IOException
     *             IOException
     */
    @ExceptionHandler(value = SiperianUtilityException.class)
    public ResponseEntity<CustomResponseEntity> handleSiperianUtilityException(
            final SiperianUtilityException e, final HttpServletRequest request)
                    throws IOException {

        final String errorMsg = "SiperianUtilityException Occured ";

        return ResponseEntity.status(e.getStatus())
                .body(getCustomResponseEntity(e, request, errorMsg,
                        e.getErrorCode(), e.getStatus()));
    }

    /**
     * Handles any un-handled exception occurred
     * 
     * @param e
     *            Exception
     * @param response
     *            HttpServletResponse
     * @return ResponseEntity<CustomResponseEntity>
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CustomResponseEntity> handleException(
            final Exception e, final HttpServletResponse response) {
        final String errorMsg = "Internal Server Exception Occured ";

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getCustomResponseEntity(e, request, errorMsg,
                        ErrorCodes.INTERNAL_SERVER_EXCEPTION.getErrorCode(),
                        HttpStatus.INTERNAL_SERVER_ERROR));
    }

    /**
     * Return CustomResponseMessage
     * 
     * @param e
     *            Exception
     * @param request
     *            HttpServletRequest
     * @param errorMsgHeading
     *            String
     * @param errorCode
     *            String
     * @param status
     *            HttpStatus
     * @return CustomResponseEntity CustomResponseEntity
     */
    public CustomResponseEntity getCustomResponseEntity(final Exception e,
            final HttpServletRequest request, final String errorMsgHeading,
            final String errorCode, final HttpStatus status) {
        final CustomResponseEntity CustomResponseEntity = new CustomResponseEntity();
        final CustomResponseMessage CustomResponseMessage = new CustomResponseMessage();
        final String correlationId = request
                .getHeader("CORRELATION_ID");
        CustomResponseMessage.setCorrelationId(correlationId);
        CustomResponseMessage.setMessage(errorMsgHeading + e.getMessage());
        if (null != errorCode) {
            CustomResponseMessage.setCode(errorCode);
        }

        if (null != errorCode) {
            GENERALLOG.error(
                    errorMsgHeading + WITH_CORRELATION_ID,
                            
                    e, correlationId, e.getMessage(), status.value());
        } else {
            GENERALLOG.error(
                    errorMsgHeading + WITH_CORRELATION_ID,
                    e, correlationId, e.getMessage());
        }
        CustomResponseEntity.getCustomResponseEntity().add(CustomResponseMessage);
        return CustomResponseEntity;
    }

}
