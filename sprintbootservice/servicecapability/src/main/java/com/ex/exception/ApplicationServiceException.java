package com.ex.exception;

import org.springframework.http.HttpStatus;

import com.ex.exception.ErrorCodes;

/**
 * ApplicationServiceException
 * 
 */
public class ApplicationServiceException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 9624930330098092L;
    /**
     * errorCode
     */
    private String errorCode;

    /**
     * http status
     */
    private HttpStatus httpStatus;

    /**
     * @return HttpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @param httpStatus
     *            HttpStatus
     */
    public void setHttpStatus(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * @param message
     *            String
     */
    public ApplicationServiceException(final String message) {
        super(message);
    }

    /**
     * @param message
     *            String
     * @param errorCode
     *            String
     */
    public ApplicationServiceException(final String message, final String errorCode) {
        super(message);
        this.setErrorCode(errorCode);
    }

    /**
     * @param e
     *            Throwable
     * @param errorCode
     *            String
     * @param status
     *            Status
     */
    public ApplicationServiceException(final Throwable e, final String errorCode,
            final HttpStatus status) {
        super(e.getMessage());
        this.setErrorCode(errorCode);
        this.setHttpStatus(status);
    }

    /**
     * @param e
     *            Throwable
     *
     * @param errorCode
     *            ErrorCodes
     * @param status
     *            Status
     */
    public ApplicationServiceException(final Throwable e, final ErrorCodes errorCode,
            final HttpStatus status) {
        super(errorCode.getErrorMessage());
        this.setErrorCode(errorCode.getErrorCode());
        this.setHttpStatus(status);
    }

    /**
     * @param message
     *            String
     * @param status
     *            Status
     * @param errorCode
     *            String
     */
    public ApplicationServiceException(final String message, final String errorCode,
            final HttpStatus status) {
        super(message);
        this.setErrorCode(errorCode);
        this.setHttpStatus(status);

    }

    /**
     * @param e
     *            Throwable
     * @param status
     *            Status
     * @param errorCode
     *            String
     */
    public ApplicationServiceException(final Throwable e, final HttpStatus status,
            final ErrorCodes errorCode) {
        super(errorCode.getErrorMessage() + e.getMessage());
        this.setErrorCode(errorCode.getErrorCode());
        this.setHttpStatus(status);
    }

    /**
     * @return errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *            String
     */
    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

}
