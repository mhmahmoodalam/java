/**
 * Copyright(c) Nordstrom, Inc. All Rights reserved. This software is the
 * confidential and proprietary information of Nordstrom, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Nordstrom, Inc.
 */

package com.nordstrom.siperian.utilities;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.siperian.sif.client.EjbSiperianClient;
import com.siperian.sif.client.SiperianClient;

/**
 * to create a siperian connection between the program and mdm
 * 
 * 
 */
public class SiperianClientCreation {
	/**
	 * Initialize logger
	 */
	private static final Logger GENERALLOG = Logger.getLogger(SiperianClientCreation.class);

	private class ReadSiperianProperties {
		private String password;
		private String userName;

		private void assignProperties(final String appHome) {

			/*
			 * this.userName = "cet04a"; this.password = "utr37gh0";
			 */
			this.userName = "admin";
			this.password = "admin";
			/**
			 * setting username and password
			 */
			setUsername(this.userName);
			setPassword(this.password);

		}
	}

	/**
	 * jndi name
	 */
	private final String jndi;
	/**
	 * orsId
	 */
	private final String orsId;
	/**
	 * password
	 */
	private String password;
	private final Properties properties = new Properties();
	/**
	 * protocol
	 */
	private final String protocol;
	/**
	 * Properties
	 */
	private EjbSiperianClient siperianClient;
	/**
	 * Url
	 */
	private final String url;

	/**
	 * username
	 */
	private String username;

	/**
	 * Constructor
	 */
	public SiperianClientCreation() {
		this.protocol = ServerSpecificProperties.getSiperianClientProtocol();
		this.jndi = ServerSpecificProperties.getJavaNamingFactoryInitial();
		this.url = ServerSpecificProperties.getJavaNamingProviderUrl();
		this.orsId = ServerSpecificProperties.getSiperianClientOrsId();
		final ReadSiperianProperties readSiperianProperties = new ReadSiperianProperties();
		readSiperianProperties.assignProperties("");
	}

	public void closeSiperianClient() {
		setSiperianClient(null);
	}

	/**
	 * Initializes siperian client object.
	 * 
	 * @return SiperianClient siperianClient
	 * @throws AppException
	 *             If error occurred while processing the request.
	 */
	public void createSiperianClient() {

		this.properties.setProperty(ConstantsUtility.JAVA_NAMING_PROVIDER_URL, this.url);
		this.properties.setProperty(ConstantsUtility.SIPERIAN_CLIENT_PROTOCOL, this.protocol);
		this.properties.setProperty(ConstantsUtility.SIPERIAN_CLIENT_ORS_ID, this.orsId);
		this.properties.setProperty(ConstantsUtility.SIPERIAN_USERNAME, this.username);
		this.properties.setProperty(ConstantsUtility.SIPERIAN_PASSWORD, this.password);
		this.properties.setProperty(ConstantsUtility.JAVA_NAMING_FACTORY_INITIAL, this.jndi);
		this.siperianClient = new EjbSiperianClient(this.properties);
		System.out.println(this.siperianClient);
		System.out.println("createSiperianClient: Siperian client has been created using given properties");
	}

	public SiperianClient getSiperianClient() {
		return this.siperianClient;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	private void setPassword(final String password) {
		this.password = password;
	}

	public void setSiperianClient(final EjbSiperianClient siperianClient) {
		this.siperianClient = siperianClient;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	private void setUsername(final String username) {
		this.username = username;
	}
}
