/**
 * Copyright(c) Nordstrom, Inc. All Rights reserved. This software is the
 * confidential and proprietary information of Nordstrom, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Nordstrom, Inc.
 */

package com.nordstrom.siperian.utilities;

/**
 * Constants class for best communication
 * 
 * @author x384
 * 
 */
public class ConstantsUtility {
	public static final String C_BO_CUST_TNDR_ACCT = "C_BO_CUST_TNDR_ACCT";
	public static final String BASE_OBJECT = "BASE_OBJECT.";
	public static final char ACTIVE = 'A';
	public static final String ACTIVE_EMP = "1";
	public static final char ALL_RECORDS = 'Z';
	public static final String ASGNMT_STS_TYP_CD = "ASGNMT_STS_TYP_CD";
	public static final String BO_ASGNMT = "BASE_OBJECT.C_BO_ASGNMT";
	public static final String BO_C_BO_LYLTY_CUST_RLN = "BASE_OBJECT.C_BO_LYLTY_CUST_RLN";
	public static final String BO_C_BO_RWDS_CUST_RLN = "BASE_OBJECT.C_BO_RWDS_CUST_RLN";
	public static final String BO_POSTAL_ADDR = "BASE_OBJECT.C_BO_POSTAL_ADDR";
	public static final String BO_PRTY = "BASE_OBJECT.C_BO_PRTY";
	public static final String BO_PSTL_CNTCT_USG = "BASE_OBJECT.C_BO_PSTL_CNTCT_USG";
	public static final String BO_TPHN = "BASE_OBJECT.C_BO_TPHN";
	public static final String BO_TPHN_CNTCT_USG = "BASE_OBJECT.C_BO_TPHN_CNTCT_USG";
	public static final String CCG = "CCG";
	public static final String CHLD_POST_MERGE = "CHLD_POST_MERGE";
	public static final String CKW = "CKW";
	public static final String CKW_LEGACY = "CKW_LEGACY";
	public static final String CLEANSE_FUNCTION = "CLEANSE_FUNCTION.CCM_WS|CCM_WS_MKG_BEST_PKSRC";
	public static final String CMH = "CMH";
	public static final String CNTCT_USG_TYP_ID = "CNTCT_USG_TYP_ID";
	public static final String COM = "COM";
	public static final String CONTINGENT = "76";
	public static final String CPP = "CPP";
	public static final String CPP_STEWARD = "CPP_STEWARD";
	public static final String CREATE_DATE = "CREATE_DATE";
	public static final String DATA_STEWARD = "DS_CM";
	public static final char DELETED = 'D';
	public static final int EIGHT = 8;
	public static final String END_OF_OPERATION = "--------------------------------";
	public static final String ENV_PROPERTIES = "ez.env.properties";
	public static final String FILTER_CNTCT_USG_TYP_CD = "CNTCT_USG_TYP_CD = ?";
	public static final String FILTER_GET_NEW_ROWID_OBJECT = "(TGT_ROWID_OBJECT = ? OR SRC_ROWID_OBJECT = ?) AND UNMERGE_DATE IS NOT NULL ORDER BY UNMERGE_DATE DESC";
	public static final String FILTER_HRMS_PRTY_ID = "PRTY_ID = ? ORDER BY ASGNMT_END_DT DESC";
	public static final String FILTER_LYLTY_PSTL_ID = "PSTL_ID = ? AND LYLTY_CUST_RLNSHP_END_DT IS NULL";
	public static final String FILTER_PRTY_ID = "PRTY_ID = ? ";
	public static final String FILTER_PRTY_ID_DNU = "PRTY_ID = ?  AND CUST_ADDR_DNU_RSN_ID IS NULL";
	public static final String FILTER_PRTY_ID_DNU_T = "PRTY_ID = ?  AND CUST_TPHN_DNU_RSN_ID IS NULL";
	public static final String FILTER_PRTY_ID_SYSTEM = "PRTY_ID = ? AND ROWID_SYSTEM = 'NCOA'";
	public static final String FILTER_PSTL_ID = "PSTL_ID = ? ";
	public static final String FILTER_ROWID_OBJECT = "ROWID_OBJECT = ? ";
	public static final String FILTER_RWDS_PRTY_ID = "PRTY_ID = ? AND RWDS_CUST_RLNSHP_END_DT IS NULL";
	public static final String FILTER_TGT_ROWID_OBJECT = "TGT_ROWID_OBJECT = ?  AND UNMERGE_DATE IS NULL";
	public static final String FILTER_TPHN_ID = "TPHN_ID = ? ";
	public static final int FIVE = 5;
	public static final int FOUR = 4;
	public static final String HRMS = "HRMS";
	public static final String INVALID_PRTY_ID = "Invalid Prty Id";
	public static final String JAVA_NAMING_FACTORY_INITIAL = "java.naming.factory.initial";
	public static final String JAVA_NAMING_PROVIDER_URL = "java.naming.provider.url";
	public static final String LEAVE = "95";
	public static final int LEVEL_DEFAULT = 0;
	public static final int LEVEL_ONE = 1;
	public static final int LEVEL_THREE = 3;
	public static final int LEVEL_TWO = 2;
	public static final String LOYALTY = "LOYALTY";
	public static final String LYLTY_CUST_RLNSHP_END_DT = "LYLTY_CUST_RLNSHP_END_DT";
	public static final String MARKETING_BEST = "Marketing_Best";
	public static final String MKTG_BEST = "MKTG_BEST";
	public static final String NCOA = "NCOA";
	public static final String NFSB = "NFSB";
	public static final String NULL_LRS = "NullLRS";
	public static final int ONE = 1;
	public static final String PARTY_ROWID_OBJECT = "PARTY_ROWID_OBJECT";
	public static final String PB = "PB";
	public static final String PKEY_SRC_OBJECT = "PKEY_SRC_OBJECT";
	public static final String PKG_CCM_BO_POSTAL_ADDR_XREF = "PACKAGE.CCM_BO_POSTAL_ADDR_XREF_PKG";
	public static final String PKG_CCM_BO_POSTAL_ADR_HMRG = "PACKAGE.CCM_BO_POSTAL_ADR_HMRG_PKG";
	public static final String PKG_CCM_BO_PRTY_HMRG = "PACKAGE.CCM_BO_PARTY_HMRG_PKG";
	public static final String PKG_CCM_BO_PSTL_CNTCT_USG_XREF = "PACKAGE.CCM_BO_PSTL_CNTCT_USG_XREF_PKG";
	public static final String PKG_CCM_BO_TPHN_CNTCT_USG_XREF = "PACKAGE.CCM_BO_TPHN_CNTCT_USG_XREF_PKG";
	public static final String PKG_CCM_BO_TPHN_HMRG = "PACKAGE.CCM_BO_TPHN_HMRG_PKG";
	public static final String PKSRC = "pksrc";
	public static final String POSTAL_ADDR = "POSTAL_ADDR";
	public static final String POSTAL_LEVEL_ONE_SOURCES = "DS_CM";
	public static final String POSTAL_LEVEL_THREE_SOURCES = "PB|ZIP|CCG|CKW_LEGACY|MICROSITE";
	public static final String POSTAL_LEVEL_TWO_SOURCES = "COM|NFSB|CPP_STEWARD|IEC";
	public static final String PRTY_HIDE_SRC_TXT = "PRTY_HIDE_SRC_TXT";
	public static final String PRTY_ID = "PRTY_ID";
	public static final String PRTY_POST_UNMERGE = "PRTY_POST_UNMERGE";
	public static final String PSTL_CNTCT_USG_CRE_BY_TYP = "PSTL_CNTCT_USG_CRE_BY_TYP";
	public static final String PSTL_CNTCT_USG_CRE_DT = "PSTL_CNTCT_USG_CRE_DT";
	public static final String PSTL_CNTCT_USG_UPDT_BY_TYP = "PSTL_CNTCT_USG_UPDT_BY_TYP";
	public static final String PSTL_CNTCT_USG_UPDT_DT = "PSTL_CNTCT_USG_UPDT_DT";
	public static final String PSTL_ID = "PSTL_ID";
	public static final String PSTL_LN1_TXT_LRS = "PSTL_LN1_TXT_LRS";
	public static final String PSTL_LN1_TXT_LUD = "PSTL_LN1_TXT_LUD";
	public static final String QUERY_POSTAL_INSERT_UE_TABLE = "INSERT INTO SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK VALUES(SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK_ID.NEXTVAL,?,"
			+ "'POSTAL_ADDR','NEW','JAVA',SYSDATE,SYSDATE)";
	public static final String QUERY_READ_FROM_PSTL_CTL = "SELECT PSTL_LN1_TXT_LRS, PSTL_LN1_TXT_LUD FROM SCH_EZ_MDM.C_BO_POSTAL_ADDR_CTL WHERE ROWID_OBJECT = ?";
	public static final String QUERY_READ_FROM_TPHN_CTL = "SELECT * FROM SCH_EZ_MDM.C_BO_TPHN_CTL WHERE ROWID_OBJECT = ?";
	public static final String QUERY_READ_FROM_USG_TYP = "SELECT * FROM SCH_EZ_MDM.C_BT_CNTCT_USG_TYP WHERE CNTCT_USG_TYP_CD = 'MKTG_BEST'";
	public static final String QUERY_TPHN_INSERT_UE_TABLE = "INSERT INTO SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK VALUES(SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK_ID.NEXTVAL,?,"
			+ "'TPHN','NEW','JAVA',SYSDATE,SYSDATE)";
	public final static String QUERY_UPDATE_FAIL_UETABLE = "Update SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK SET TASK_STS='NOT FOUND' WHERE MDM_USER_EXIT_TASK_ID = ?";
	public final static String QUERY_UPDATE_FAIL_UETABLE_DATE = "Update SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK SET MDM_USER_EXIT_TASK_UPDT_DT = sysdate WHERE"
			+ " MDM_USER_EXIT_TASK_ID = ?";
	public static final String QUERY_UPDATE_NULL_BEST = "Update SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK SET TASK_STS='NULL BEST' WHERE MDM_USER_EXIT_TASK_ID =?";
	public static final String QUERY_UPDATE_NULL_BEST_UPDATE_DATE = "Update SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK SET MDM_USER_EXIT_TASK_UPDT_DT = sysdate WHERE"
			+ " MDM_USER_EXIT_TASK_ID = ?";
	public final static String QUERY_UPDATE_PROGRESS_UETABLE = "Update SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK SET TASK_STS='IN PROGRESS' WHERE  MDM_USER_EXIT_TASK_ID = ?";
	public final static String QUERY_UPDATE_PROGRESS_UETABLE_DATE = "Update SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK SET MDM_USER_EXIT_TASK_UPDT_DT = sysdate WHERE"
			+ " MDM_USER_EXIT_TASK_ID = ?";
	public final static String QUERY_UPDATE_SUCCESS_UETABLE = "Update SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK SET TASK_STS='SUCCESS' WHERE MDM_USER_EXIT_TASK_ID = ?";
	public final static String QUERY_UPDATE_SUCCESS_UETABLE_DATE = "Update SCH_EZ_MDM_UTILS.MDM_USER_EXIT_TASK SET MDM_USER_EXIT_TASK_UPDT_DT = sysdate WHERE"
			+ " MDM_USER_EXIT_TASK_ID = ?";
	public static final String RETIREE = "98";
	public static final String REWARDS = "REWARDS";
	public static final String ROWID = "RowID";
	public static final int ROWID_LENGTH = 14;
	public static final String ROWID_OBJECT = "ROWID_OBJECT";
	public static final String ROWID_SYSTEM = "ROWID_SYSTEM";
	public static final String RWDS_CUST_RLNSHP_END_DT = "RWDS_CUST_RLNSHP_END_DT";
	public static final int SEVEN = 7;
	public static final String SIPERIAN_CLIENT_ORS_ID = "siperian-client.orsId";
	public static final String SIPERIAN_CLIENT_PROTOCOL = "siperian-client.protocol";
	public static final String SIPERIAN_PASSWORD = "siperian-client.password";
	public static final String SIPERIAN_USERNAME = "siperian-client.username";
	public static final int SIX = 6;
	public static final String SRC_ROWID_OBJECT = "SRC_ROWID_OBJECT";
	public static final String TASK_TYP = "TASK_TYP";
	public static final int TELEPHONE_NUMBER_LENGTH = 10;
	public static final String TERMINATE = "3";
	public static final String TGT_ROWID_OBJECT = "TGT_ROWID_OBJECT";
	public static final int THREE = 3;
	public static final long THREE_MONTHS_DIFFERENCE_IN_MILLI_SECONDS = 7776000000L;
	public static final String TPHN = "TPHN";
	public static final String TPHN_CNTCT_USG_CRE_BY_TYP = "TPHN_CNTCT_USG_CRE_BY_TYP";
	public static final String TPHN_CNTCT_USG_CRE_DT = "TPHN_CNTCT_USG_CRE_DT";
	public static final String TPHN_CNTCT_USG_UPDT_BY_TYP = "TPHN_CNTCT_USG_UPDT_BY_TYP";
	public static final String TPHN_CNTCT_USG_UPDT_DT = "TPHN_CNTCT_USG_UPDT_DT";
	public static final String TPHN_ID = "TPHN_ID";
	public static final String TPHN_LEVEL_ONE_SOURCES = "NFSB|COM|DS_CM|WEB|HRMS|IEC";
	public static final String TPHN_LEVEL_TWO_SOURCES = "PB|LOYALTY|REWARDS|CKW|CPP_STEWARD|MICROSITE";
	public static final String TPHN_NUM = "TPHN_NUM";
	public static final String TPHN_NUM_LRS = "TPHN_NUM_LRS";
	public static final String TPHN_NUM_LUD = "TPHN_NUM_LUD";
	public static final int TWO = 2;
	public static final String UPW_PROPERTIES = "/config/ez.upw.properties";
	public static final String USER_EXIT_TYP = "USER_EXIT_TYP";
	public static final String WEB = "WEB";
	public static final int ZERO = 0;
	public static final String ZIP = "ZIP";

	public static final String SELECTION_TYPE_FETCH = "fetch";
	public static final String SELECTION_TYPE_PUT = "put";

	public static final String PRTY_FST_NM = "PRTY_FST_NM";
	public static final String PRTY_LAST_NM = "PRTY_LAST_NM";
	public static final String PRTY_ORIG_FST_NM = "PRTY_ORIG_FST_NM";
	public static final String PRTY_ORIG_LST_NM = "PRTY_ORIG_LST_NM";
	public static final String PRTY_CUST_ROLE_FL = "PRTY_CUST_ROLE_FL";
	public static final String PRTY_PERS_ROLE_FL = "PRTY_PERS_ROLE_FL";
	// public static final String ="";

}
