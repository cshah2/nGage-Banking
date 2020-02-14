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

public class ColumnPosition {

	public static final int CONSTUMER_LASTNAME = 1
	public static final int CONSTUMER_FIRSTNAME = 2
	public static final int CONSTUMER_EMAILID = 5
	public static final int CONSTUMER_PHONENUMBER = 9


	//ORGANIZATION
	public static final int ORGANIZATION_NAME = 1
	public static final int ORGANIZATION_PHONENO  = 6
	public static final int ORGANIZATION_DUN_BADSTREETNO  = 5
	public static final int ORGANIZATION_CUSTID  = 2


	//Cases Table
	public static final int OPEN_CASE_LATEST_ROW = 1
	public static final int CASE_TYPE = 3
	public static final int CASE_NUMBER  = 2
	public static final int CASE_STATUS  = 7


	//Account  Open cases
	public static final int ACCOUNT_NUMBER = 4
	public static final int ORDER_CREATED_DATE = 5
	public static final int OPEN_CASES_ORDER_STATUS = 7


	//Address table
	public static final int ADDRESS_LINE1 = 4
	public static final int ADDRESS_CITY  =6
	public static final int ADDRESS_STATE  =7
	public static final int ADDRESS_ZIP  = 8
	public static final int ADDRESS_COUNTRY  = 9

	//Phone Table
	public static final int PHONE_NUMBER = 3

	//Email Table
	public static int EMAIL_ADDRESS = 3

	//Notes table
	public static final int NOTES = 1
	public static final int NOTES_CREATED_BY = 2

	//Holds Table
	public static int HOLD_TYPE = 2
	public static int HOLD_DURATION = 5
	public static int HOLD_AMOUNT = 6
	public static int HOLD_START_DATE = 3

	//Transaction Table
	public static int TXN_CODE = 5
	public static int TXN_CREATED_DATE = 2
	public static int TXN_DEBIT_AMOUNT = 6
	public static int TXN_CREDIT_AMOUNT = 7
	public static int TXN_BALANCE = 8
	public static int TXN_DESCRIPTION = 9

	//T-Account table
	public static int TACC_SEQ = 1
	public static int TACC_TXN_TYPE = 2
	public static int TACC_CLASS = 3
	public static int TACC_AMOUNT = 4
	public static int TACC_ACC_NUMBER = 5
	public static int TACC_GL_NUMBER = 6
	public static int TACC_GL_CATEGORY = 7
	public static int TACC_GL_NAME = 8



	//Scheduled Transactions Table
	public static int ORDER_TYPE = 2
	public static final int FROM_ACCOUNT = 5
	public static final ORDER_DATE = 4
	public static final int TO_ACCOUNT = 6
	public static final int ORDER_AMOUNT = 8
	public static final int ORDER_CREATED_DATE_IN_TRANSACTIONS = 3
	public static final int ORDER_STATUS = 10

}
