package com.nordstrom.siperian.operation;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import javax.ejb.EJB;

import org.apache.commons.pool.impl.GenericObjectPool;

import com.nordstrom.ce.pool.SiperianPool;
import com.nordstrom.siperian.utilities.ConstantsUtility;
import com.nordstrom.siperian.utilities.RestWebAppException;
import com.siperian.common.util.StringUtil;
import com.siperian.sif.client.EjbSiperianClient;
import com.siperian.sif.client.SiperianClient;
import com.siperian.sif.message.Field;
import com.siperian.sif.message.Parameter;
import com.siperian.sif.message.Record;
import com.siperian.sif.message.RecordKey;
import com.siperian.sif.message.mrm.PutRequest;
import com.siperian.sif.message.mrm.SearchQueryRequest;
import com.siperian.sif.message.mrm.SearchQueryResponse;
//import com.siperian.sif.client.EjbSiperianClient;

//import siperian.operation.SiperianClientCreation;

public class ProcessCustomerQuery {
	/*
	  private EjbSiperianClient siperianClientSQ;
	 * 
	 * @EJB EjbSiperianClient siperianClientSQ;
	 * 
	 * public EjbSiperianClient getSiperianClientSQ() { return siperianClientSQ;
	 * }
	 * 
	 * 
	 * public void setSiperianClientSQ(EjbSiperianClient siperianClientSQ) {
	 * this.siperianClientSQ = siperianClientSQ; }
	 * 
	 * 
	 * com.nordstrom.siperian.utilities.SiperianClientCreation sipClient;
	 */

	@EJB
	private SiperianPool siperianPool;
	private GenericObjectPool genericObjectPool;

	public GenericObjectPool getGenericObjectPool() {
		return genericObjectPool;
	}

	public void setGenericObjectPool(GenericObjectPool genericObjectPool) {
		this.genericObjectPool = genericObjectPool;
	}

	private SiperianProperties siperianUtility;

	public SiperianProperties getSiperianUtility() {
		return siperianUtility;
	}

	public void setSiperianUtility(SiperianProperties siperianUtility) {
		this.siperianUtility = siperianUtility;
	}

	private SiperianClient createSiperianClient() throws Exception {
		SiperianClient siperianClient = null;
		Object object = null;
		try {
			if (null == genericObjectPool) {
				setGenericObjectPool(siperianPool.getPool());
			}
			object = genericObjectPool.borrowObject();

			if (object instanceof SiperianClient) {
				siperianClient = (SiperianClient) object;
			} else {
				throw new Exception();
			}
		} catch (final Exception ae) {
			ae.printStackTrace();
		}
		return siperianClient;
	}

	/*
	 * Retrieving the details of the customer by passing the customer first_name
	 * and last_name SearchQueryResponse does not retrieve the customer details
	 * if that customer was soft deleted
	 */
	public String getDetails(String fname, String lname, String dataSource) throws Exception {
		String msg = "";
		if (null == fname || null == lname || dataSource == null) {

			throw new RestWebAppException("FETCH PARAMERTRES HAVE NUL VALUE");
		}

		SearchQueryRequest srchQryReq = new SearchQueryRequest();

		srchQryReq.setSiperianObjectUid("PACKAGE.CCM_BO_PRTY_XREF_PKG");
		srchQryReq.setDisablePaging(true);
		String filterCtriteria = "ROWID_SYSTEM = ? AND PRTY_FST_NM = ? AND PRTY_LAST_NM = ? ";
		srchQryReq.setFilterCriteria(filterCtriteria);

		ArrayList<Parameter> parameters = new ArrayList<Parameter>();

		parameters.add(new Parameter(StringUtil.padRowid(dataSource.toUpperCase())));
		parameters.add(new Parameter(fname.toUpperCase().trim()));
		parameters.add(new Parameter(lname.toUpperCase().trim()));
		srchQryReq.setFilterParameters(parameters);

		SearchQueryResponse srchQryRes;

		try {

			// sipClient.createSiperianClient();
			// siperianClientSQ= (EjbSiperianClient)
			// sipClient.getSiperianClient();

			SiperianClient sipClient = createSiperianClient();
			if (sipClient == null) {

				msg = "Siperian client null";
			} else {

				srchQryRes = (SearchQueryResponse) sipClient.process(srchQryReq);

				if (srchQryRes.getRecords().size() > 0) {
					msg = "Name details found";
				} else {
					// LOGGER.log(Level.INFO,"No records found with the given
					// search criteria");
					msg = "No records found with the given search criteria";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			// LOGGER.log(Level.INFO,e.getMessage());
		}

		return msg;

	}

	
	  public String putCustomerDetails(String firstName,String lastName,String
	  dataSource) throws RestWebAppException{ 
	     String msg="Hi";
	    // commented code for update in sif
	     /*
	  if(null==firstName||null==lastName){
	  
	  throw new RestWebAppException("FETCH PARAMERTRES HAVE NUL VALUE"); }
	  Random randomGenerator = new Random();
	  PutRequest putRequest=new	  PutRequest(); 
	  RecordKey recordKey = new RecordKey();
	  recordKey.setSourceKey(UUID.randomUUID().toString());
	  recordKey.setSystemName(dataSource.toUpperCase().trim());
	  Record record= new Record(); 
	  record.setSiperianObjectUid("BASE_OBJECT.C_BO_PRTY");
	  record.setField(new
	  Field(ConstantsUtility.PRTY_FST_NM,firstName.toUpperCase()));
	  record.setField(new
	  Field(ConstantsUtility.PRTY_ORIG_FST_NM,firstName.toUpperCase()));
	  record.setField(new
	  Field(ConstantsUtility.PRTY_LAST_NM,lastName.toUpperCase()));
	  record.setField(new
	  Field(ConstantsUtility.PRTY_ORIG_LST_NM,lastName.toUpperCase()));
	  record.setField(new Field(ConstantsUtility.PRTY_CUST_ROLE_FL,"Y"));
	  record.setField(new Field(ConstantsUtility.PRTY_PERS_ROLE_FL,"N")); //
	  record.setField(new Field(ConstantsUtility.PRTY_FST_NM,firstName));
	  putRequest.setRecord(record); putRequest.setRecordKey(recordKey);
	  SiperianClientCreation sipClient = new SiperianClientCreation();
	  
	 sipClient.createSiperianClient(); 
	 siperianClientSQ= (EjbSiperianClient) sipClient.getSiperianClient();
	  
	  if(siperianClientSQ==null){
	  
	  msg="Siperian client null"; 
	  } 
	  else{ PutResponse response =
	  (PutResponse)siperianClientSQ.process(putRequest); msg=
	  "New CLoumn Added Successfully\n"+"Rowid is: "
	  +response.getRecordKey().getRowid(); 
	  } */
	     
	     return msg; 
	  }
	 

}
