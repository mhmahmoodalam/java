package com.nordstrom.siperian.operation;

import java.util.Properties;

import com.siperian.sif.client.EjbSiperianClient;
import com.siperian.sif.client.SiperianClient;

public class SiperianProperties {
	/**
	 * Properties
	 */
	private final Properties properties = new Properties();
	/**
	 * Url
	 */
	private String url;
	/**
	 * protocol
	 */
	private String protocol;
	/**
	 * orsId
	 */
	private String orsId;
	/**
	 * username
	 */
	private String username;
	/**
	 * password
	 */
	private String password;
	/**
	 * jndi name
	 */
	private String jndi;

	/**
	 * Constructor
	 */
	public SiperianProperties() {
	}

	/**
	 * @param jndi
	 *            String
	 */
	public void setJndi(final String jndi) {
		this.jndi = jndi;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * @param protocol
	 *            the protocol to set
	 */
	public void setProtocol(final String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @param orsId
	 *            the orsId to set
	 */
	public void setOrsId(final String orsId) {
		this.orsId = orsId;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * Initializes siperian client object.
	 * 
	 * @return SiperianClient siperianClient
	 * @throws AppException
	 *             If error occurred while processing the request.
	 */
	public SiperianClient createSiperianClient() {
		EjbSiperianClient siperianClient = null;

		properties.setProperty("java.naming.provider.url", url);
		properties.setProperty("siperian-client.protocol", protocol);
		properties.setProperty("siperian-client.orsId", orsId);
		properties.setProperty("siperian-client.username", username);
		properties.setProperty("siperian-client.password", password);
		properties.setProperty("java.naming.factory.initial", jndi);
		siperianClient = new EjbSiperianClient(properties);

		return siperianClient;
	}

}
