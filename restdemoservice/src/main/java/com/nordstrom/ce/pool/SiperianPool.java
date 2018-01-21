/**
 * Copyright(c) Nordstrom, Inc. All Rights reserved. This software is the
 * confidential and proprietary information of Nordstrom, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with Nordstrom, Inc.
 */

package com.nordstrom.ce.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

/**
 * Siperian Pool provides method to create a pool of siperian client with
 * configurable pool properties and siperian properties.
 * 
 * @author Akanksha_Sinha02
 */
public class SiperianPool {

	private int wait;
	private int idle;
	private int active;

	/**
	 * Logger.
	 */
	private final Logger generalLog = Logger.getLogger(SiperianPool.class);

	/**
	 * @return the wait
	 */
	public int getWait() {
		return wait;
	}

	/**
	 * @param wait
	 *            the wait to set
	 */
	public void setWait(int wait) {
		this.wait = wait;
	}

	/**
	 * @return the idle
	 */
	public int getIdle() {
		return idle;
	}

	/**
	 * @param idle
	 *            the idle to set
	 */
	public void setIdle(int idle) {
		this.idle = idle;
	}

	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

	/**
	 * GenericObjectPool.
	 */
	private GenericObjectPool pool = null;

	private SiperianPoolableObjectFactory siperianPoolableObjectFactory;

	/**
	 * @param siperianPoolableObjectFactory
	 *            the siperianPoolableObjectFactory to set
	 */
	public void setSiperianPoolableObjectFactory(final SiperianPoolableObjectFactory siperianPoolableObjectFactory) {
		this.siperianPoolableObjectFactory = siperianPoolableObjectFactory;
	}

	/**
	 * @return the siperianPoolableObjectFactory
	 */
	/*
	 * public SiperianPoolableObjectFactory getSiperianPoolableObjectFactory() {
	 * return siperianPoolableObjectFactory; }
	 */

	/**
	 * @param siperianPoolableObjectFactory
	 *            SiperianPoolableObjectFactory
	 * @throws CustomerServiceException
	 *             If error occurred while processing request
	 */
	public SiperianPool(final SiperianPoolableObjectFactory siperianPoolableObjectFactory, int active, int idle,
			int wait) throws Exception {
		this.siperianPoolableObjectFactory = siperianPoolableObjectFactory;
		this.active = active;
		this.idle = idle;
		this.wait = wait;
		if (generalLog.isDebugEnabled()) {
			generalLog.debug("siperian pooleable object factory" + siperianPoolableObjectFactory);
		}
		createPool();
	}

	/**
	 * Creates a pool of siperian client objects using
	 * siperian-client.properties file and pool.properties file. Both properties
	 * file should be present in project classpath. Uses default pool properties
	 * incase pool.properties are not found.
	 * 
	 * @return GenericObjectPool
	 * @throws CustomerServiceException
	 *             If error occurred while processing request
	 */
	private GenericObjectPool createPool() throws Exception {
		if (generalLog.isDebugEnabled()) {
			generalLog.debug("createPool: Inside create pool");
		}
		final ClassPathResource classPathResource = new ClassPathResource("pool.properties");
		final Properties properties = new Properties();
		InputStream inputStream;
		try {
			inputStream = classPathResource.getInputStream();
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (generalLog.isDebugEnabled()) {
			generalLog.debug("createPool: Pool properties loaded" + active + "  " + idle + "  " + wait);
		}
		pool = new GenericObjectPool(siperianPoolableObjectFactory);
		pool.setMaxActive(active);
		pool.setMaxIdle(idle);
		pool.setMaxWait(wait);
		pool.setMinEvictableIdleTimeMillis(Integer.parseInt(properties.getProperty("MinEvictableIdleTimeMillis")));
		pool.setMinIdle(Integer.parseInt(properties.getProperty("MinIdle")));
		pool.setNumTestsPerEvictionRun(Integer.parseInt(properties.getProperty("NumTestsPerEvictionRun")));
		pool.setSoftMinEvictableIdleTimeMillis(
				Integer.valueOf(properties.getProperty("SoftMinEvictableIdleTimeMillis")));
		pool.setTestOnBorrow(Boolean.parseBoolean(properties.getProperty("TestOnBorrow")));
		pool.setTestOnReturn(Boolean.parseBoolean(properties.getProperty("TestOnReturn")));
		pool.setTestWhileIdle(Boolean.parseBoolean(properties.getProperty("TestWhileIdle")));
		pool.setTimeBetweenEvictionRunsMillis(Integer.valueOf(properties.getProperty("TimeBetweenEvictionRunsMillis")));
		pool.setWhenExhaustedAction(Byte.valueOf(properties.getProperty("WhenExhaustedAction")));

		return pool;
	}

	/**
	 * @return GenericObjectPool
	 */
	public GenericObjectPool getPool() {
		return pool;
	}

	/**
	 * @param pool
	 *            GenericObjectPool
	 */
	public void setPool(final GenericObjectPool pool) {
		this.pool = pool;
	}
}