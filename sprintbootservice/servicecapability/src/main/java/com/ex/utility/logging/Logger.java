
package com.ex.utility.logging;

import java.text.MessageFormat;

/**
 * Logger class that enables efficient logging at fine grain levels w/out
 * wrapping calls in "isEnabled" checks via the use of parametrized log messages
 * using the {@link MessageFormat} class when the log threshold has been met.
 * <p/>
 * This implementation acts as a thin wrapper around Log4J implementation.
 */
public final class Logger {

    /**
     * Internal logger which is delegated to.
     */
    private final org.apache.logging.log4j.Logger logger;

    /**
     * @param logger
     *            the logger to set
     */
    private Logger(final org.apache.logging.log4j.Logger logger) {
        this.logger = logger;
    }

    /**
     * @param aClass
     *            the Class object
     * @return Logger
     */
    @SuppressWarnings("rawtypes")
    public static Logger getLogger(final Class aClass) {

        return new Logger(
                org.apache.logging.log4j.LogManager.getLogger(aClass));
    }

    /**
     * Log the provided message at {@link Level#TRACE} level, substituting any
     * {@link MessageFormat} tokens in the message .
     * 
     * @param message
     *            Message to log
     * @param messageParams
     *            optional values to substitute for numbered tokens in the
     *            message.
     * @see LogMF#trace(org.apache.log4j.Logger, String, Object[])
     */
    public void trace(final String message, final Object... messageParams) {
        logger.trace(MessageFormat.format(message, messageParams));

    }

    /**
     * @return boolean
     */
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    /**
     * Log the provided message at {@link Level#DEBUG} level, substituting any
     * {@link MessageFormat} tokens in the message .
     * 
     * @param message
     *            Message to log
     * @param messageParams
     *            optional values to substitute for numbered tokens in the
     *            message.
     * @see LogMF#debug(org.apache.log4j.Logger, String, Object[])
     */
    public void debug(final String message, final Object... messageParams) {
        logger.debug(MessageFormat.format(message, messageParams));
    }

    /**
     * Log the provided message at {@link Level#INFO} level, substituting any
     * {@link MessageFormat} tokens in the message .
     * 
     * @param message
     *            Message to log
     * @param messageParams
     *            optional values to substitute for numbered tokens in the
     *            message.
     * @see LogMF#info(org.apache.log4j.Logger, String, Object[])
     */
    public void info(final String message, final Object... messageParams) {

        logger.info(MessageFormat.format(message, messageParams));
    }

    /**
     * Log the provided message at {@link Level#WARN} level, substituting any
     * {@link MessageFormat} tokens in the message .
     * 
     * @param message
     *            Message to log
     * @param messageParams
     *            optional values to substitute for numbered tokens in the
     *            message.
     * @see LogMF#warn(org.apache.log4j.Logger, String, Object[])
     */
    public void warn(final String message, final Object... messageParams) {
        logger.warn(MessageFormat.format(message, messageParams));
    }

    /**
     * Log the provided message at {@link Level#WARN} level, substituting any
     * {@link MessageFormat} tokens in the message .
     * 
     * @param message
     *            Message to log
     * @param exception
     *            Exception to log along with the message and optional msg
     *            params.
     * @param messageParams
     *            optional values to substitute for numbered tokens in the
     *            message.
     * @see LogMF#warn(org.apache.log4j.Logger, Throwable, String, Object[])
     */
    public void warn(final String message, final Throwable exception,
            final Object... messageParams) {
        logger.warn(MessageFormat.format(message, messageParams), exception);
    }

    /**
     * Log the provided message at {@link Level#ERROR} level, substituting any
     * {@link MessageFormat} tokens in the message .
     * 
     * @param message
     *            Message to log
     * @param messageParams
     *            optional values to substitute for numbered tokens in the
     *            message.
     * @see LogMF#error(org.apache.log4j.Logger, String, Object[])
     */
    public void error(final String message, final Object... messageParams) {
        logger.error(MessageFormat.format(message, messageParams));
    }

    /**
     * Log the provided message at {@link Level#ERROR} level, substituting any
     * {@link MessageFormat} tokens in the message .
     * 
     * @param message
     *            Message to log
     * @param exception
     *            Exception to log along with the message and optional msg
     *            params.
     * @param messageParams
     *            optional values to substitute for numbered tokens in the
     *            message.
     * @see LogMF#error(org.apache.log4j.Logger, Throwable, String, Object[])
     */
    public void error(final String message, final Throwable exception,
            final Object... messageParams) {
        logger.error(MessageFormat.format(message, messageParams), exception);
    }

    /**
     * Log the provided message at {@link Level#FATAL} level, substituting any
     * {@link MessageFormat} tokens in the message .
     * 
     * @param message
     *            Message to log
     * @param exception
     *            Exception to log along with the message and optional msg
     *            params.
     * @param messageParams
     *            optional values to substitute for numbered tokens in the
     *            message.
     * @see LogMF#fatal(org.apache.log4j.Logger, Throwable, String, Object[])
     */
    public void fatal(final String message, final Throwable exception,
            final Object... messageParams) {
        logger.fatal(MessageFormat.format(message, messageParams), exception);
    }
}
