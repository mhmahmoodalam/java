package com.nordstrom.siperian.operation;

import java.util.Properties;

import com.siperian.sif.client.EjbSiperianClient;
import com.siperian.sif.client.SiperianClient;

public class SiperianClientCreation {

	public SiperianClient createSiperianClient() throws Exception {

		EjbSiperianClient siperianClient = null;
		Properties properties = new Properties();
		// dev04
		/*
		 * properties.setProperty("java.naming.provider.url",
		 * "t3://y0319t86:8001/cmx/");
		 */
		properties.setProperty("java.naming.provider.url", "t3://y0319t86:8001");
		properties.setProperty("siperian-client.orsId",
				// "y0319t182-DD532-SCH_EZ_MDM");
				"y0319t87-DD664-SCH_EZ_MDM");

		properties.setProperty("siperian-client.protocol", "ejb");
		properties.setProperty("siperian-client.username", "admin");// uat-"xtxe/xtxe");
		// //
		// "dev04 -admin/admin");
		properties.setProperty("siperian-client.password", "admin");// "nord123");
		// "admin");
		properties.setProperty("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
		try {
			System.out.println("entered siperain client");
			siperianClient = new EjbSiperianClient(properties);
			System.out
					.println("createSiperianClient:DIT: Siperian client has been created using given properties dev02");
			// return siperianClient;
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
		return siperianClient;
	}

	/*
	 * Creates a siperian client with the details (like mdm hub link, user_id
	 * paswrd) present in the properties file
	 * 
	 * public static SiperianClient createSiperianClient() { SiperianClient
	 * siperianClient = null; File file = new File(
	 * "D:/CCMHYD/CCMWS War file/siperian-client.properties"); try { Properties
	 * siperianProperties = new Properties(); siperianProperties.load(new
	 * FileReader(file));
	 * siperianProperties.setProperty("siperian-client.orsId",
	 * "y0319t87-dd664-sch_ez_mdm"); siperianClient = SiperianClient
	 * .newSiperianClient(siperianProperties); } catch (Exception e) {
	 * e.printStackTrace(); } return siperianClient;
	 * 
	 * }
	 */
}
