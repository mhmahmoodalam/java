package com.ex.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpHeaders;

import com.ex.utility.DateParam;

import com.ex.model.ServiceData;

/**
 * This class defines the RequestParams.
 * 
 */
public class RequestParams {

    /**
    *
    */
    private Date requestTimestamp;
    /**
     * 
     */
    private Date date;

    
    /**
     * dateTime
     */
    private DateParam dateTime;

    private static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * serviceData
     */
    private ServiceData serviceData;
    /**
     * isDefault
     */
    private String isDefault;
    /**
     * @return id
     */
    private String id;
    /**
     * @return idType
     */
    private String idType;

    /**
     * @return defaultFlag
     */
    private String defaultFlag;
    /**
     * userId
     */
    private String userId;

    /**
     * correlationId
     */
    private String correlationId;

    /**
     * bst
     */
    private String bst;

    /**
     * serviceApiVersion
     */
    private String serviceApiVersion;
    /**
     * subSource
     */
    private String subSource;

    /**
     * for header source
     */
    private String source;
    /**
     * customerId
     */
    private String customerId;
    /**
     * addressId
     */
    private String addressId;
    /**
     * isDefault
     */
    private String addressUsageType;

    /**
     * defualt constructor
     */
    public RequestParams() {

    }

    /**
     * set all header params.
     * 
     * @param headers
     *            HttpHeaders
     */
    public RequestParams(final HttpHeaders headers) {
        setUserId(headers.get("USER_ID").get(0))
                // .setRequestTimestamp(ThreadContext.get("RequestTimestamp"))
                .setCorrelationId(
                        headers.get("CORRELATION_ID").get(0))
                .setSource(headers.get("SOURCE").get(0))
                .setSubSource(headers.get("SUBSOURCE").get(0))
                .setserviceApiVersion(
                        headers.get("service_API_VERSION").get(0))
                .setDateTime(new DateParam(
                        headers.get("DATE_TIME").get(0)));
        this.setDate(this.dateTime.getDate());
    }

    /**
     * @param dateTime
     *            DateParam
     */
    public void setDateTime(final DateParam dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return dateTime
     */
    public DateParam getDateTime() {
        return dateTime;
    }

    /**
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setUserId(final String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * @return correlationId
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * @param correlationId
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setCorrelationId(final String correlationId) {
        this.correlationId = correlationId;
        return this;
    }

    /**
     * @return bst String
     */
    public String getBst() {
        return bst;
    }

    /**
     * @param bst
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setBst(final String bst) {
        this.bst = bst;
        return this;
    }

    /**
     * @return serviceApiVersion
     */
    public String getserviceApiVersion() {
        return serviceApiVersion;
    }

    /**
     * @param version
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setserviceApiVersion(final String version) {
        this.serviceApiVersion = version;
        return this;
    }

    /**
     * @return subSource
     */
    public String getSubSource() {
        return subSource;
    }

    /**
     * @param subSource
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setSubSource(final String subSource) {
        this.subSource = subSource;
        return this;

    }

    /**
     * @return source
     */
    public String getSource() {
        return source;
    }

    /**
     * setting header source
     * 
     * @param source
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setSource(final String source) {
        this.source = source;
        return this;

    }

    /**
     * Getter for serviceData
     * 
     * @return CustomerData serviceData
     */
    public ServiceData getServiceData() {
        return serviceData;
    }

    /**
     * Setter for serviceData
     * 
     * @param serviceData
     *            CustomerData
     * @return RequestParams RequestParams
     */
    public RequestParams setServiceData(final ServiceData serviceData) {
        this.serviceData = serviceData;
        return this;
    }

    /**
     * Getter for customerId
     * 
     * @return customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * seeter for customer id
     * 
     * @param customerId
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setCustomerId(final String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Setter for Date
     * 
     * @param date
     *            Date
     */
    public void setDate(final Date date) {
        this.date = date;
    }

    /**
     * 
     * @return Date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Getter for addressId
     * 
     * @return addressId
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * setter for addressId
     * 
     * @param addressId
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setAddressId(final String addressId) {
        this.addressId = addressId;
        return this;
    }

    /**
     * Getter for isDefault
     * 
     * @return isDefault
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * setter for isDefault
     * 
     * @param isDefault
     *            boolean
     * @return RequestParams RequestParams
     */
    public RequestParams setIsDefault(final String isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    /**
     * Getter for addressUsageType
     * 
     * @return addressUsageType
     */
    public String getAddressUsageType() {
        return addressUsageType;
    }

    /**
     * setter for addressUsageType
     * 
     * @param addressUsageType
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setAddressUsageType(final String addressUsageType) {
        this.addressUsageType = addressUsageType;
        return this;
    }

    /**
     * Get Id
     * 
     * @return String
     */
    public String getId() {

        return id;
    }

    /**
     * setter for id
     * 
     * @param id
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setId(final String id) {
        this.id = id;
        return this;
    }

    /**
     * Get IdType
     * 
     * @return String
     */
    public String getIdType() {

        return idType;
    }

    /**
     * setter for idType
     * 
     * @param idType
     *            String
     * @return RequestParams RequestParams
     */

    public RequestParams setIdType(final String idType) {
        this.idType = idType;
        return this;
    }

    /**
     * setter for defaultFlag
     * 
     * @param defaultFlag
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setDefaultFlag(final String defaultFlag) {
        this.defaultFlag = defaultFlag;
        return this;

    }

    /**
     * Get defaultFlag
     * 
     * @return defaultFlag String
     */

    public String getDefaultFlag() {

        return defaultFlag;
    }

    /**
     * getRequestTimestamp
     * 
     * @return requestTimestamp Date
     */
    public Date getRequestTimestamp() {
        return requestTimestamp;
    }

    /**
     * setter for dateTime which is in the request
     * 
     * @param _requestTimestamp
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setRequestTimestamp(final String _requestTimestamp) {
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    dateFormat);
            requestTimestamp = simpleDateFormat.parse(_requestTimestamp);
        } catch (final ParseException px) {
            requestTimestamp = null;
        }

        return this;
    }

    /**
     * This method sets the request parameters
     * 
     * @param dateTime
     *            DateParam
     * @param userId
     *            String
     * @param correlationId
     *            String
     * @param bst
     *            String
     * @param serviceApiVersion
     *            String
     * @param subSource
     *            String
     * @param source
     *            String
     * @return RequestParams RequestParams
     */
    public RequestParams setRequestParams(final DateParam dateTime,
            final String userId, final String correlationId, final String bst,
            final String serviceApiVersion, final String subSource,
            final String source) {
        setDateTime(dateTime);
        setUserId(userId);
        setCorrelationId(correlationId);
        setBst(bst);
        setserviceApiVersion(serviceApiVersion);
        setSubSource(subSource);
        setSource(source);

        return this;
    }

}