package com.ex.utility.logging;

import java.text.MessageFormat;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogMF;
import org.apache.log4j.PatternLayout;

public class Logger {
	
	/**
     * Internal logger which is delegated to.
     */
    private final org.apache.log4j.Logger logger;;
    
    /**
     * @param logger
     *            the logger to set
     */
    private Logger(final org.apache.log4j.Logger logger) {
        this.logger = logger;
    }
	
	/**
     * @param aClass
     *            the Class object
     * @return Logger
     */
    @SuppressWarnings("rawtypes")
    public static Logger getLogger(final Class aClass) {
    	PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
        //layout.
        layout.setConversionPattern(conversionPattern);

        // creates console appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();

        // creates file appender
        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile("applog3.txt");
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();

        // configures the root logger
        org.apache.log4j.Logger logger=org.apache.log4j.LogManager.getLogger(aClass);
        logger.setLevel(Level.DEBUG);
        logger.addAppender(consoleAppender);
        logger.addAppender(fileAppender);

        return new Logger(logger );
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
