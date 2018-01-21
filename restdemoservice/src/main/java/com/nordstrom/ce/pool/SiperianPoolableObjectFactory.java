/**
 * Copyright(c) Nordstrom, Inc. All Rights reserved. This software is the
 * confidential and proprietary information of Nordstrom, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with Nordstrom, Inc.
 */

package com.nordstrom.ce.pool;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.log4j.Logger;

import com.nordstrom.siperian.operation.SiperianProperties;
import com.siperian.sif.client.SiperianClient;

/**
 * Implementation of PoolableObjectFactory to create siperian client objects.
 * 
 * @author Akanksha_Sinha02
 */
public class SiperianPoolableObjectFactory implements PoolableObjectFactory {

	/**
	 * Initialize logger.
	 */
	private static Logger generalLog = Logger.getLogger(SiperianPoolableObjectFactory.class);

	private SiperianProperties siperianUtility;

	/**
	 * @return the siperianUtility
	 */
	/*
	 * public SiperianUtility getSiperianUtility() { return siperianUtility; }
	 */

	/**
	 * @param siperianUtility
	 *            the siperianUtility to set
	 */
	public void setSiperianUtility(final SiperianProperties siperianUtility) {
		this.siperianUtility = siperianUtility;
	}

	/**
	 * @param arg0
	 *            Object
	 * @throws CustomerServiceException
	 *             - if error occurs while processing the request
	 */
	@Override
	public void activateObject(final Object arg0) throws Exception {

	}

	/**
	 * @param arg0
	 *            Object
	 * @throws CustomerServiceException
	 *             - if error occurs while processing the request
	 */
	@Override
	public void destroyObject(final Object arg0) throws Exception {

	}

	/**
	 * @return Object
	 * @throws CustomerServiceException
	 *             - if error occurs while processing the request
	 */
	@Override
	public Object makeObject() throws Exception {
		SiperianClient siperianClient = null;
		try {
			siperianClient = siperianUtility.createSiperianClient();
		} catch (final Exception e) {

			e.printStackTrace();
		}
		return siperianClient;

	}

	/**
	 * @param arg0
	 *            Object
	 * @throws CustomerServiceException
	 *             - if error occurs while processing the request
	 */
	@Override
	public void passivateObject(final Object arg0) throws Exception {
	}

	/**
	 * @param arg0
	 *            Object
	 * @return boolean
	 */
	@Override
	public boolean validateObject(final Object arg0) {
		return true;
	}

}
