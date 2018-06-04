package com.ex.sudoku.exception;

public class SudukoException extends Exception{
	
	 /**
     * errorCode
     */
    private String errorCode;

	/**
     * @param message
     *            String
     */
    public SudukoException(final String message) {
        super(message);
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

    /**
     * @param message
     *            String
     * @param errorCode
     *            String
     */
    public SudukoException(final String message, final String errorCode) {
        super(message);
        this.setErrorCode(errorCode);
    }
    
    public SudukoException(final Throwable e, final String message, final ErrorCode errorCode) {
        super(errorCode.getErrorMessage() + e.getMessage());
        this.setErrorCode(errorCode.getErrorCode());    }
}
