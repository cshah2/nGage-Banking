package data

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.javafaker.Faker
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Common
import constants.Fields
import internal.GlobalVariable
import utils.DateUtil
import utils.RandomUtil

public class ConsumerTempData {



	public static final Map<Fields, String> CUSTOMERDATA_MAP;
	static{
		CUSTOMERDATA_MAP = new HashMap<Fields, String>()
		CUSTOMERDATA_MAP.put(Fields.CUST_NAME_VIEW, "Ravi Bala")
		CUSTOMERDATA_MAP.put(Fields.CUST_FIRST_NAME, "Ravi")
		CUSTOMERDATA_MAP.put(Fields.CUST_LAST_NAME, "Bala")
		CUSTOMERDATA_MAP.put(Fields.CUST_MAILID, "ravii.balasundaram@aurionpro.com")
		CUSTOMERDATA_MAP.put(Fields.CONTACT_EMAIL, "ravi.balasundaram@aurionpro.com")
		CUSTOMERDATA_MAP.put(Fields.CUST_MAILIDTYPE, "Personal")
		CUSTOMERDATA_MAP.put(Fields.CUST_DOB, "09/05/1994")
		CUSTOMERDATA_MAP.put(Fields.CUST_DOB_MASKED, "**/**/1994")
		CUSTOMERDATA_MAP.put(Fields.CONTACT_PHONE_NUMBER, "+91 8976166795")

		CUSTOMERDATA_MAP.put(Fields.CONTACT_PHONE_TYPE, "Mobile")
		CUSTOMERDATA_MAP.put(Fields.CUST_ID, "1")
		CUSTOMERDATA_MAP.put(Fields.CUST_TAX_ID, "719892")
		CUSTOMERDATA_MAP.put(Fields.ADDR_VIEW, "8833 Stenton Ave, Washington Boro, PA 17582")
		CUSTOMERDATA_MAP.put(Fields.CUST_TAX_ID_MASKED, '*********2')
		CUSTOMERDATA_MAP.put(Fields.CUST_NOTES, "I have added this note through automation by Ravi")
		CUSTOMERDATA_MAP.put(Fields.CUST_GROUP, "Banking Customer")
		CUSTOMERDATA_MAP.put(Fields.URL, 'https://savossit.savanainc.com/nGageBanking_Customer/CustomerMainFlow.CustomerDetail.aspx?partyId=4TdHL8h5dIa9f----V5F-Bg-&customergroup=2&customerId=4&isOrg=False')
		CUSTOMERDATA_MAP.put(Fields.ACC_NUMBER, "200120202134")
	}

	public static final Map<Fields, String> NA_CUSTOMERDATA_MAP;
	static{
		NA_CUSTOMERDATA_MAP = new HashMap<Fields, String>()
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_NAME_VIEW, "Ravi Bala")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_FIRST_NAME, "Abc")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_LAST_NAME, "xyz")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_MAILID, "abc@haio.com")
		NA_CUSTOMERDATA_MAP.put(Fields.CONTACT_EMAIL, "ravi.balasundaram@aurionpro.com")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_MAILIDTYPE, "Personal")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_DOB, "01/01/1091")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_GROUP, "Banking Customer")

		NA_CUSTOMERDATA_MAP.put(Fields.CONTACT_PHONE_NUMBER, "+91 0000000000")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_ID, "100")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_TAX_ID, "00000")
		NA_CUSTOMERDATA_MAP.put(Fields.ADDR_VIEW, "Danis Street Room no 222, Los Angels, AL 989898")
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_TAX_ID_MASKED, '*********2')
		NA_CUSTOMERDATA_MAP.put(Fields.CUST_NOTES, "I have added this note through automation")
	}




	public static final Map<Fields, String> ACCOUNT_HOLD;

	static{
		ACCOUNT_HOLD = new HashMap<Fields, String>()
		ACCOUNT_HOLD.put(Fields.ACC_NUMBER, "160120202304")
		ACCOUNT_HOLD.put(Fields.HOLD_TYPE, "Reserve")
		ACCOUNT_HOLD.put(Fields.HOLD_START_DATE, DateUtil.getCurrentDateTime(Common.dateTimeFormat, Common.timezoneUTC))
		//ACCOUNT_HOLD.put(Fields.HOLD_START_DATE, DateUtil.getCurrentDateTimePlusDays(2,Common.dateTimeFormat, Common.timezoneUTC))
		ACCOUNT_HOLD.put(Fields.HOLD_END_DATE, DateUtil.getCurrentDateTimeMinusDays(-2,Common.dateTimeFormat, Common.timezoneUTC))
		ACCOUNT_HOLD.put(Fields.HOLD_DURATION, "Twelve Months")
		ACCOUNT_HOLD.put(Fields.HOLD_AMOUNT, "15.00")
		ACCOUNT_HOLD.put(Fields.HOLD_REASON, "First hold for the Customer Clearance")
		ACCOUNT_HOLD.put(Fields.HOLD_NOTE, "First hold cancelled  the Customer Clearance")
		ACCOUNT_HOLD.put(Fields.URL,"https://savossit.savanainc.com/nGageBanking_Account/AccountMainFlow.AccountDetail.aspx?partyId=4TeSCPmgC7M__V---V9F-Bg-&acctGroup=1&acctNumber=000000002550&selectedPositionId=4TeSG8FHC2N2Q----V9F-Co-&customerGroup=2&customerId=7&isOrg=False")


	}

	public static final Map<Fields, String> ADDR_A;
	static {
		ADDR_A = new HashMap<Fields, String>()
		ADDR_A.put(Fields.ADDR_LINE1, DateUtil.getCurrentDateTime('dd MMMM', Common.timezone)+' Street')
		ADDR_A.put(Fields.ADDR_LINE2, 'Wagon Lane')
		ADDR_A.put(Fields.ADDR_LINE3, 'Pheasant Road')
		ADDR_A.put(Fields.ADDR_LINE4, 'Pineknoll Drive')
		ADDR_A.put(Fields.ADDR_CITY, 'Romeoville')
		ADDR_A.put(Fields.ADDR_COUNTY, 'United States of America')
		ADDR_A.put(Fields.ADDR_STATE, 'Illinois')
		ADDR_A.put(Fields.ADDR_ZIPCODE, '2'+RandomUtil.getRandomNumeric(4))
		ADDR_A.put(Fields.ADDR_TYPE, 'Work/Office')
		ADDR_A.put(Fields.ADDR_YEARS_AT_ADDRESS, '3 Years')
		ADDR_A.put(Fields.ADDR_LABEL, 'OFFICE')
		ADDR_A.put(Fields.ADDR_PREMISE, 'Broadway Park Building')
		ADDR_A.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, Common.dateFormat, Common.timezoneUTC))
		ADDR_A.put(Fields.ADDR_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(15, Common.dateFormat, Common.timezoneUTC))
		ADDR_A.put(Fields.ADDR_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-15, Common.dateFormat, Common.timezoneUTC))
		ADDR_A.put(Fields.ADDR_VIEW, ADDR_A.get(Fields.ADDR_LINE1)+', '+ADDR_A.get(Fields.ADDR_LINE2)+', '+ADDR_A.get(Fields.ADDR_CITY)+', PA '+ADDR_A.get(Fields.ADDR_ZIPCODE))
		ADDR_A.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> ADDRESS_A;
	static {
		ADDRESS_A = new HashMap<Fields, String>()
		ADDRESS_A.put(Fields.ADDR_LINE1,'882 Letort Rd')
		ADDRESS_A.put(Fields.ADDR_LINE2, '')
		ADDRESS_A.put(Fields.ADDR_LINE3, '')
		ADDRESS_A.put(Fields.ADDR_LINE4, '')
		ADDRESS_A.put(Fields.ADDR_CITY, 'Washington Boro')
		ADDRESS_A.put(Fields.ADDR_COUNTY, 'United States of America')
		ADDRESS_A.put(Fields.ADDR_STATE, 'Pennsylvania')
		//ADDRESS_A.put(Fields.ADDR_ZIPCODE, '2'+RandomUtil.getRandomNumeric(4))
		ADDRESS_A.put(Fields.ADDR_ZIPCODE, '17582')
		ADDRESS_A.put(Fields.ADDR_TYPE, 'Work/Office')
		ADDRESS_A.put(Fields.ADDR_YEARS_AT_ADDRESS, '3 Years')
		ADDRESS_A.put(Fields.ADDR_LABEL, 'OFFICE')
		ADDRESS_A.put(Fields.ADDR_PREMISE, 'Broadway Park Building')
		ADDRESS_A.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, Common.dateFormat, Common.timezoneUTC))
		ADDRESS_A.put(Fields.ADDR_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(15, Common.dateFormat, Common.timezoneUTC))
		ADDRESS_A.put(Fields.ADDR_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-15, Common.dateFormat, Common.timezoneUTC))
		ADDRESS_A.put(Fields.ADDR_VIEW, ADDR_A.get(Fields.ADDR_LINE1)+', '+ADDR_A.get(Fields.ADDR_LINE2)+', '+ADDR_A.get(Fields.ADDR_CITY)+', PA '+ADDR_A.get(Fields.ADDR_ZIPCODE))
		ADDRESS_A.put(Fields.IS_CREATED, 'false')
	}


	//account order map
	public static final Map<Fields, String> ACCOUNT_BOOKTRANSFER_ORDER;
	static {
		ACCOUNT_BOOKTRANSFER_ORDER = new HashMap<Fields, String>()
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_TYPE,"Book transfer")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_ORIGIN_SOURCE,"Prearranged")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_SOURCE,"Bank operations")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_OPERATIONL_AREA,"Back Office")

		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER,"200120201234")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER,"000000002550")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE,"Savings Account")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_ROUTING_NUMBER,"043000096")

		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP,"Banking")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE,"Demand deposit account")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_TRANSFER_AMOUNT,"16.00")
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_CREATED_DATE, DateUtil.getCurrentDateTime(Common.dateTimeFormat, Common.timezoneUTC))
		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.ORDER_DATE, DateUtil.getCurrentDateTime(Common.dateTimeFormat, Common.timezoneUTC))

		ACCOUNT_BOOKTRANSFER_ORDER.put(Fields.URL,"https://savossit.savanainc.com/nGageBanking_Account/AccountMainFlow.AccountDetail.aspx?partyId=4TeSCPmgC7M__V---V9F-Bg-&acctGroup=1&acctNumber=000000002550&selectedPositionId=4TeSG8FHC2N2Q----V9F-Co-&customerGroup=2&customerId=7&isOrg=False")
	}

	public static final Map<Fields, String> ACCOUNT_PAYEMENT_ORDER;
	static {
		ACCOUNT_PAYEMENT_ORDER = new HashMap<Fields, String>()
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_TYPE,"Payment order")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_ORIGIN_SOURCE,"Prearranged")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_SOURCE,"Bank operations")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_OPERATIONL_AREA,"Back Office")
		ACCOUNT_PAYEMENT_ORDER
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER,"160120202304")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER,"000000002550")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE,"Savings Account")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_ROUTING_NUMBER,"043000096")
		ACCOUNT_PAYEMENT_ORDER
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP,"Banking")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE,"Demand deposit account")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_TRANSFER_AMOUNT,"16.00")
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_CREATED_DATE, DateUtil.getCurrentDateTime(Common.dateTimeFormat, Common.timezoneUTC))
		ACCOUNT_PAYEMENT_ORDER.put(Fields.ORDER_DATE, DateUtil.getCurrentDateTime(Common.dateTimeFormat, Common.timezoneUTC))
		ACCOUNT_PAYEMENT_ORDER
		ACCOUNT_PAYEMENT_ORDER.put(Fields.URL,"https://savossit.savanainc.com/nGageBanking_Account/AccountMainFlow.AccountDetail.aspx?partyId=4TeSCPmgC7M__V---V9F-Bg-&acctGroup=1&acctNumber=000000002550&selectedPositionId=4TeSG8FHC2N2Q----V9F-Co-&customerGroup=2&customerId=7&isOrg=False")
	}

	public static final Map<Fields, String> ACCOUNT_COLLECTION_ORDER;
	static {
		ACCOUNT_COLLECTION_ORDER = new HashMap<Fields, String>()
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_TYPE,"Collection order")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_ORIGIN_SOURCE,"Telephone")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_SOURCE,"Bank operations")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_OPERATIONL_AREA,"Back Office")
		ACCOUNT_COLLECTION_ORDER
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER,"000000002550")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER,"200120201234")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE,"Savings Account")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_ROUTING_NUMBER,"043000096")
		ACCOUNT_COLLECTION_ORDER
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP,"Banking")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE,"Demand deposit account")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_TRANSFER_AMOUNT,"15.00")
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_CREATED_DATE, DateUtil.getCurrentDateTime(Common.dateTimeFormat, Common.timezoneUTC))
		ACCOUNT_COLLECTION_ORDER.put(Fields.ORDER_DATE, DateUtil.getCurrentDateTime(Common.dateTimeFormat, Common.timezoneUTC))
		ACCOUNT_COLLECTION_ORDER
		ACCOUNT_COLLECTION_ORDER.put(Fields.URL,"https://savossit.savanainc.com/nGageBanking_Account/AccountMainFlow.AccountDetail.aspx?partyId=4TeSCPmgC7M__V---V9F-Bg-&acctGroup=1&acctNumber=000000002550&selectedPositionId=4TeSG8FHC2N2Q----V9F-Co-&customerGroup=2&customerId=7&isOrg=False")
	}
}




