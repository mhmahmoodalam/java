/**
 * Copyright(c) Nordstrom, Inc. All Rights reserved. This software is the
 * confidential and proprietary information of Nordstrom, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Nordstrom, Inc.
 */
package com.nordstrom.siperian.utilities;

/**
 * server specific properties
 * 
 * @author x384
 * 
 */
public class ServerSpecificProperties {
	private static String driverClass = null;
	private static String javaNamingFactoryInitial = "weblogic.jndi.WLInitialContextFactory";
	// private static String javaNamingProviderUrl = "t3://y0319t183:8001";
	private static String javaNamingProviderUrl = "t3://y0319t86:8001";
	// private static String siperianClientOrsId = "y0319t184-DD529-SCH_EZ_MDM";
	private static String siperianClientOrsId = "y0319t87-DD664-SCH_EZ_MDM";
	private static String siperianClientProtocol = "ejb";

	public static String getDriverClass() {
		return driverClass;
	}

	public static String getJavaNamingFactoryInitial() {
		return javaNamingFactoryInitial;
	}

	public static String getJavaNamingProviderUrl() {
		return javaNamingProviderUrl;
	}

	public static String getSiperianClientOrsId() {
		return siperianClientOrsId;
	}

	public static String getSiperianClientProtocol() {
		return siperianClientProtocol;
	}

	public static void setDriverClass(final String driverClass) {
		ServerSpecificProperties.driverClass = driverClass;
	}

	public static void setJavaNamingFactoryInitial(final String javaNamingFactoryInitial) {
		ServerSpecificProperties.javaNamingFactoryInitial = javaNamingFactoryInitial;
	}

	public static void setJavaNamingProviderUrl(final String javaNamingProviderUrl) {
		ServerSpecificProperties.javaNamingProviderUrl = javaNamingProviderUrl;
	}

	public static void setSiperianClientOrsId(final String siperianClientOrsId) {
		ServerSpecificProperties.siperianClientOrsId = siperianClientOrsId;
	}

	public static void setSiperianClientProtocol(final String siperianClientProtocol) {
		ServerSpecificProperties.siperianClientProtocol = siperianClientProtocol;
	}

}
