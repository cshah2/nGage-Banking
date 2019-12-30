package data

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

import constants.Common
import constants.Fields
import internal.GlobalVariable
import utils.DateUtil
import utils.RandomUtil

public class ConsumerData {
	
	public static final Map<Fields, String> CUST_A;
	static {
		CUST_A = new HashMap<Fields, String>()
		Map parsedJson = RandomUtil.generateRandomCustomerData()

		//Basic Information
		CUST_A.put(Fields.CUST_PREFIX, parsedJson.get("results").get(0).get("name").get("title"))
		CUST_A.put(Fields.CUST_FIRST_NAME, parsedJson.get("results").get(0).get("name").get("first"))
		CUST_A.put(Fields.CUST_MIDDLE_NAME, RandomUtil.getRandomAlphabets(4))
		CUST_A.put(Fields.CUST_LAST_NAME, parsedJson.get("results").get(0).get("name").get("last"))
		CUST_A.put(Fields.CUST_NAME_VIEW, CUST_A.get(Fields.CUST_FIRST_NAME)+' '+CUST_A.get(Fields.CUST_LAST_NAME))
		CUST_A.put(Fields.CUST_SUFFIX, 'Jr.')
		CUST_A.put(Fields.CUST_DOB, DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', Common.dateFormat))
		CUST_A.put(Fields.CUST_DOB_MASKED, '**/**/'+CUST_A.get(Fields.CUST_DOB).substring(6))
		CUST_A.put(Fields.CUST_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
		CUST_A.put(Fields.CUST_TAX_ID_MASKED, '*****'+CUST_A.get(Fields.CUST_TAX_ID).substring(5))
		CUST_A.put(Fields.CUST_TAX_ID_TYPE, 'EIN')
		CUST_A.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
		CUST_A.put(Fields.CUST_RESIDENCY_STATUS, 'Resident')

		//Customer Details
		CUST_A.put(Fields.CUST_FAMILIAR_NAME, 'CHINOO')
		CUST_A.put(Fields.CUST_MAIDEN_NAME, 'SHAH')
		CUST_A.put(Fields.CUST_MARITAL_STATUS, 'Single')
		CUST_A.put(Fields.CUST_TOTAL_HOUSEHOLD_MEMBERS, '8')
		CUST_A.put(Fields.CUST_MOTHERS_MAIDEN_NAME, 'JOSHI')
		CUST_A.put(Fields.CUST_PREFERRED_LANGUAGE, 'English - United States')
		CUST_A.put(Fields.CUST_ALTERNATE_LANGUAGE, 'Hindi - India')
		CUST_A.put(Fields.CUST_AGE_BRACKET, '21 - 30')

		//Location Information
		CUST_A.put(Fields.ADDR_LINE1, DateUtil.getCurrentDateTime('dd MMMM', Common.timezone)+' Street')
		CUST_A.put(Fields.ADDR_LINE2, 'Broadway')
		CUST_A.put(Fields.ADDR_LINE3, 'Corona Ave')
		CUST_A.put(Fields.ADDR_LINE4, 'New Philadelphia')
		CUST_A.put(Fields.ADDR_CITY, 'Philadelphia')
		CUST_A.put(Fields.ADDR_COUNTY, 'United States of America')
		CUST_A.put(Fields.ADDR_STATE, 'Pennsylvania')
		CUST_A.put(Fields.ADDR_ZIPCODE, '1'+RandomUtil.getRandomNumeric(4))
		CUST_A.put(Fields.ADDR_TYPE, 'Residence')
		CUST_A.put(Fields.ADDR_LABEL, 'HOME')
		CUST_A.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(1, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.ADDR_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(10, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.ADDR_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-10, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.ADDR_VIEW, CUST_A.get(Fields.ADDR_LINE1)+', '+CUST_A.get(Fields.ADDR_LINE2)+', '+CUST_A.get(Fields.ADDR_CITY)+', PA '+CUST_A.get(Fields.ADDR_ZIPCODE))

		//Contact Information
		CUST_A.put(Fields.CONTACT_PHONE_NUMBER, '+1'+RandomUtil.getRandomNumeric(10))
		CUST_A.put(Fields.CONTACT_PHONE_TYPE, 'Mobile')
		CUST_A.put(Fields.CONTACT_PHONE_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(0, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.CONTACT_PHONE_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(8, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.CONTACT_PHONE_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-8, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.CONTACT_EMAIL, parsedJson.get("results").get(0).get("email"))
		CUST_A.put(Fields.CONTACT_EMAIL_TYPE, 'Personal')
		CUST_A.put(Fields.CONTACT_EMAIL_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.CONTACT_EMAIL_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(9, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.CONTACT_EMAIL_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-9, Common.dateFormat, Common.timezoneUTC))
		CUST_A.put(Fields.CONTACT_PREFERRED_CONTACT_METHOD, 'Email')

		//Customer Due diligence
		CUST_A.put(Fields.CUST_CHK_SENIOR_POLITICAL_FIGURE, 'true')
		CUST_A.put(Fields.CUST_SENIOR_POLITICAL_FIGURE_COUNTRY, 'India')
		CUST_A.put(Fields.CUST_ASSOCIATE_SR_POLITICAL_FIGURE, 'Family Member')

		//Education and Occupation details
		CUST_A.put(Fields.CUST_EMPLOYMENT_STATUS, 'Part-time')
		CUST_A.put(Fields.CUST_OCCUPATION, 'Computer and Mathmatical')
		CUST_A.put(Fields.CUST_MONTHLY_GROSS_INCOME, '30000')
		CUST_A.put(Fields.CUST_MILITARY_STATUS, 'Inactive')
		CUST_A.put(Fields.CUST_EDUCATION, 'High school or GED')
		CUST_A.put(Fields.CUST_STUDENT_TYPE, 'Full Time on campus')
		CUST_A.put(Fields.CUST_WEB_ADDRESS, 'http://www.savanainc.com')

		//Customer Information
		CUST_A.put(Fields.CUST_ID, 'ID'+RandomUtil.getRandomNumeric(7))
		CUST_A.put(Fields.CUST_GROUP, 'Banking Customer')

		//Script data
		CUST_A.put(Fields.IS_CREATED, '')
		CUST_A.put(Fields.URL, '')
	}
}
