package constants

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

import internal.GlobalVariable

public enum Fields {

	//Customer - Basic Information
	CUST_PREFIX,
	CUST_FIRST_NAME,
	CUST_MIDDLE_NAME,
	CUST_LAST_NAME,
	CUST_SUFFIX,
	CUST_NAME_VIEW,
	CUST_DOB,
	CUST_DOB_MASKED,
	CUST_TAX_ID,
	CUST_TAX_ID_MASKED,
	CUST_TAX_ID_TYPE,
	CUST_COUNTRY_OF_RESIDENCE,
	CUST_RESIDENCY_STATUS,
	//Customer - Customer Details
	CUST_FAMILIAR_NAME,
	CUST_MAIDEN_NAME,
	CUST_MARITAL_STATUS,
	CUST_TOTAL_HOUSEHOLD_MEMBERS,
	CUST_MOTHERS_MAIDEN_NAME,
	CUST_PREFERRED_LANGUAGE,
	CUST_ALTERNATE_LANGUAGE,
	CUST_AGE_BRACKET,
	//Customer - Location Information
	ADDR_LINE1,
	ADDR_LINE2,
	ADDR_LINE3,
	ADDR_LINE4,
	ADDR_STREET,
	ADDR_CITY,
	ADDR_COUNTY,
	ADDR_STATE,
	ADDR_ZIPCODE,
	ADDR_VERIFIED_DATE,
	ADDR_VALID_FROM,
	ADDR_VALID_UNTIL,
	ADDR_TYPE,
	ADDR_YEARS_AT_ADDRESS,
	ADDR_LABEL,
	ADDR_VIEW,
	ADDR_PREMISE,
	//Customer - Contact Information
	CONTACT_PHONE_NUMBER,
	CONTACT_PHONE_LABEL,
	CONTACT_PHONE_VERIFIED_DATE,
	CONTACT_PHONE_VALID_FROM,
	CONTACT_PHONE_VALID_UNTIL,
	CONTACT_PHONE_TYPE,
	CONTACT_EMAIL,
	CONTACT_EMAIL_LABEL,
	CONTACT_EMAIL_VERIFIED_DATE,
	CONTACT_EMAIL_VALID_FROM,
	CONTACT_EMAIL_VALID_UNTIL,
	CONTACT_EMAIL_TYPE,
	CONTACT_PREFERRED_CONTACT_METHOD,
	CONTACT_PREFERRED_LANGUAGE,
	//Customer - Customer Due diligence
	CUST_CHK_SENIOR_POLITICAL_FIGURE,
	CUST_SENIOR_POLITICAL_FIGURE_COUNTRY,
	CUST_ASSOCIATE_SR_POLITICAL_FIGURE,
	//Customer - Education and Occupation Details
	CUST_EMPLOYMENT_STATUS,
	CUST_OCCUPATION,
	CUST_MONTHLY_GROSS_INCOME,
	CUST_MILITARY_STATUS,
	CUST_EDUCATION,
	CUST_STUDENT_TYPE,
	CUST_WEB_ADDRESS,
	//Customer - Customer Information
	CUST_ID,
	CUST_GROUP,
	CUST_CHK_ACCOUNT,
	CUST_PARTY_ID,

	//Organization - Basic Information
	ORG_NAME,
	ORG_DBA_NAME,
	ORG_ESTABLISHED_DATE,
	ORG_TAX_ID,
	ORG_TAX_ID_MASKED,
	ORG_TAX_ID_TYPE,

	//Organization - Organization details
	ORG_DESCRIPTION,
	ORG_DUN_BRADSTEET_NO,
	ORG_CHK_PUBLICLY_HELD,
	ORG_TRADE_NAME,
	ORG_CHK_INTERNATIONAL_COMPANY,
	ORG_CHK_GOVERNMENT_OWNED,
	ORG_CHK_SMALL_BUSINESS,
	ORG_CHK_TAX_EXEMPT,
	ORG_TAX_EXEMPT_TYPE,
	ORG_REGISTRATION_COUNTRY,
	ORG_REGISTRATION_REGION,
	ORG_WEBSITE_URL,

	//Organization - Organization Due Diligence
	ORG_BUSINESS_STRUCTURE,
	ORG_COUNTRY_OPERATIONS1,
	ORG_COUNTRY_OPERATIONS2,
	ORG_COUNTRY_HEADQUARTERS,
	ORG_INDUSTRY,
	ORG_YEARS_OWNED,
	ORG_EST_ANNUAL_REVENUE,
	ORG_NUMBER_LOCATIONS,
	ORG_NUMBER_WIRE_TRANSACTIONS,
	ORG_AMOUNT_WIRE_TRANSACTIONS,
	ORG_NUMBER_ACH_ORIGINATION,
	ORG_AMOUNT_ACH_ORIGINATION,
	ORG_NUMBER_MOBILE_DEPOSITS,
	ORG_AMOUNT_MOBILE_DEPOSITS,
	ORG_NUMBER_REMOTE_DEPOSITS,
	ORG_AMOUNT_REMOTE_DEPOSITS,
	ORG_INTERMEDIATORY_SERVICES,
	ORG_PERCENT_REVENUE_CASH,
	ORG_CHK_NON_CASH_SERVICE,
	ORG_CHK_CHARITY,
	ORG_CHK_ATM_OPERATOR,
	ORG_CHK_MARIJUANA_BUSINESS,
	ORG_CHK_INTERNET_GAMBLING,
	ORG_CHK_THIRD_PARTY_BENEFIT,
	ORG_CHK_TRANSFER_CUSTOMERS,
	ORG_CHK_VIRTUAL_CURRENCY,

	//Organization - Customer Information
	ORG_ID,
	ORG_GROUP,
	ORG_CHK_ACCOUNT,


	//Account Info
	ACC_TITLE,
	ACC_DESCRIPTION,
	ACC_GROUP,
	ACC_NUMBER,
	ACC_BROKERED,
	ACC_TIMEZONE,
	ACC_STATEMENT_FREQUENCY,
	ACC_PAPER_STATEMENT,
	ACC_PRODUCT_TYPE,
	ACC_POSITION_NAME,
	ACC_CURRENCY_CODE,
	ACC_CURRENCY_CODE_VIEW,
	ACC_VERTICAL,
	ACC_DEPT_ID,
	ACC_DEPT_ID_VIEW,
	ACC_CREDIT_LIMIT,
	ACC_INTEREST_RATE,
	ACC_OPEN_DATE,
	ACC_OWNERSHIP,
	ACC_PRODUCT_NAME,
	ACC_PRODUCT_CODE,
	ACC_LEDGER_BALANCE_BEFORE,
	ACC_LEDGER_BALANCE,
	ACC_AVAILABLE_BALANCE_BEFORE,
	ACC_AVAILABLE_BALANCE,
	ACC_HOLD_BALANCE,

	TC_DOC_TYPE1,
	TC_DOC_SIGNED_BY1,
	TC_DOC_SIGNED_DATE1,
	TC_DOC_SIGNED_DATE_VIEW1,
	TC_DOC_VERSION1,
	TC_DOC_TYPE2,
	TC_DOC_SIGNED_BY2,
	TC_DOC_SIGNED_DATE2,
	TC_DOC_SIGNED_DATE2_VIEW,
	TC_DOC_VERSION2,


	DOCUMENT_FILEPATH,
	DOCUMENT_CLASS,
	DOCUMENT_TYPE,
	DOCUMENT_START_DATE,
	DOCUMENT_END_DATE,
	DOCUMENT_RECEIVED_DATE,
	DOCUMENT_STATUS,
	DOCUMENT_DESCRIPTION,
	DOCUMENT_LAUNCH,
	DOCUMENT_TITLE,

	//This is Transaction type field
	TXN_CODE,
	TXN_AMOUNT,
	TXN_AMOUNT_VIEW,
	TXN_COMMENT,
	TXN_ID,
	TXN_TYPE,
	HOLD_TYPE,
	HOLD_START_DATE,
	HOLD_START_DATE_VIEW,
	HOLD_END_DATE,
	HOLD_END_DATE_VIEW,
	HOLD_CANCEL_DATE,
	HOLD_CANCEL_DATE_VIEW,
	HOLD_DURATION,
	HOLD_DURATION_VIEW,
	HOLD_AMOUNT,
	HOLD_AMOUNT_VIEW,
	HOLD_NOTE,
	HOLD_CANCEL_NOTE,
	HOLD_REASON,
	HOLD_PRE_AUTH,
	HOLD_REG_CC,
	HOLD_CLEARING,
	HOLD_RESERVE,
	HOLD_ADMIN,
	ORDER_TYPE,
	ORDER_SOURCE,
	ORDER_INFO,
	ORDER_ORIGIN_SOURCE,
	ORDER_NETWORK,
	ORDER_COUNTERPARTY_ACCOUNT_TITLE,
	ORDER_COUNTERPARTY_ACCOUNT_GROUP,
	ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER,
	ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE,
	ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER,
	ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE,
	ORDER_ROUTING_NUMBER,
	ORDER_TRANSFER_DATE,
	ORDER_TRANSFER_DATE_VIEW,
	ORDER_ISRECURRING,
	ORDER_TRANSFER_AMOUNT,
	ORDER_TRANSFER_AMOUNT_VIEW,
	ORDER_STATUS,

	IS_CREATED,
	URL
}
