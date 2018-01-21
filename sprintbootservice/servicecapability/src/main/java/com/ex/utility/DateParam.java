
package com.ex.utility;

import static java.text.MessageFormat.format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import com.ex.utility.logging.Logger;

import com.ex.exception.customResponseMessage;
import com.ex.exception.customResponseMessages;

/**
 * Date param
 * 
 * @author x6bt
 *
 */
public class DateParam {
    private final Date date;
    private String dateString;

    /**
     * @return dateString
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * GENERALLOG
     */
    private static final Logger GENERALLOG = Logger.getLogger(DateParam.class);

    /**
     * @param dateStr
     *            String
     * @throws WebApplicationException
     *             if error occurs
     */
    public DateParam(final String dateStr) throws WebApplicationException {
        final CustomResponseMessages CustomResponseMessages = new CustomResponseMessages();
        final CustomResponseMessage CustomResponseMessage = new CustomResponseMessage();

        if (StringUtils.isEmpty(dateStr)) {
            customResponseMessage.setCode("123");
            customResponseMessage.setMessage(format("[{0}]",
                    "exception"));
            customResponseMessages.getcustomResponseMessages()
                    .add(customResponseMessage);

            throw new WebApplicationException(Response
                    .status(Status.BAD_REQUEST).entity(customResponseMessages)
                    .type(MediaType.APPLICATION_JSON).build());

        }
        final DateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss");

        try {
            this.date = dateFormat.parse(dateStr);
            dateFormat.getCalendar().setTime(date);
            if (!dateStr.equals(dateFormat.format(date))) {
            	 customResponseMessage.setCode("123");
                 customResponseMessage.setMessage(format("[{0}]",
                         "exception"));
                customResponseMessages.getcustomResponseMessages()
                        .add(customResponseMessage);

                throw new WebApplicationException(Response
                        .status(Status.BAD_REQUEST).entity(customResponseMessages)
                        .type(MediaType.APPLICATION_JSON).build());
            }
            this.dateString = dateStr;

        } catch (final ParseException e) {
            GENERALLOG.error("Couldn't parse date string: " + e.getMessage());
            customResponseMessage.setCode(
                    Integer.toString(Status.BAD_REQUEST.getStatusCode()));
            customResponseMessage.setMessage(
                    "Couldn't parse date string: " + e.getMessage());
            customResponseMessages.getcustomResponseMessages()
                    .add(customResponseMessage);

            throw new WebApplicationException(Response
                    .status(Status.BAD_REQUEST).entity(customResponseMessages)
                    .type(MediaType.APPLICATION_JSON).build());

        }
    }

    /**
     * @return date
     */
    public Date getDate() {
        return new Date(date.getTime());
    }

    /**
     * @param date
     *            Date
     */
    public DateParam(final Date date) {
        this.date = new Date(date.getTime());
    }

    @Override
    public String toString() {
        String dateStr = "";
        if (null != this.date) {
            final DateFormat dateFormat = new SimpleDateFormat(
                    "YYYY-mm-DD");
            dateStr = dateFormat.format(this.date);
        }
        return dateStr;
    }
}