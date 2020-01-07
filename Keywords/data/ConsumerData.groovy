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

public class ConsumerData {

	public static final Map<Fields, String> CUST_A;
	static {
		CUST_A = new HashMap<Fields, String>()
		//Map parsedJson = RandomUtil.generateRandomCustomerData()

		Faker faker = new Faker(Locale.US)
		String prefix = faker.name().prefix()
		String firstName = faker.name().firstName()
		String lastName = faker.name().lastName()
		String email = firstName+'.'+lastName+'@example.com'
		String addressLine1 = faker.address().buildingNumber() + faker.address().streetName()
		String addressLine2 = faker.address().streetAddress()
		String dob = DateUtil.convert(faker.dateAndTime.birthday(18, 65), Common.dateFormat)
		String city = faker.address().cityName()
		println faker.address().toString()

		//Basic Information
		//CUST_A.put(Fields.CUST_PREFIX, parsedJson.get("results").get(0).get("name").get("title"))
		//CUST_A.put(Fields.CUST_FIRST_NAME, parsedJson.get("results").get(0).get("name").get("first"))
		//CUST_A.put(Fields.CUST_MIDDLE_NAME, RandomUtil.getRandomAlphabets(4))
		//CUST_A.put(Fields.CUST_LAST_NAME, parsedJson.get("results").get(0).get("name").get("last"))
		CUST_A.put(Fields.CUST_PREFIX, prefix)
		CUST_A.put(Fields.CUST_FIRST_NAME, firstName)
		CUST_A.put(Fields.CUST_MIDDLE_NAME, RandomUtil.getRandomAlphabets(4))
		CUST_A.put(Fields.CUST_LAST_NAME, lastName)

		CUST_A.put(Fields.CUST_NAME_VIEW, CUST_A.get(Fields.CUST_FIRST_NAME)+' '+CUST_A.get(Fields.CUST_LAST_NAME))
		CUST_A.put(Fields.CUST_SUFFIX, 'Jr.')
		//CUST_A.put(Fields.CUST_DOB, DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', Common.dateFormat))
		CUST_A.put(Fields.CUST_DOB, dob)
		CUST_A.put(Fields.CUST_DOB_MASKED, '**/**/'+CUST_A.get(Fields.CUST_DOB).substring(6))
		CUST_A.put(Fields.CUST_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
		CUST_A.put(Fields.CUST_TAX_ID_MASKED, '******'+CUST_A.get(Fields.CUST_TAX_ID).substring(5))
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
		CUST_A.put(Fields.ADDR_LINE1, addressLine1)
		CUST_A.put(Fields.ADDR_LINE2, addressLine2)
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
		CUST_A.put(Fields.CONTACT_EMAIL, email)
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
	}

	//Personal Savings account for a consumer "Cust_A"
	public static final Map<Fields, String> ACC_A;
	static {

		//Basic Information
		ACC_A = new HashMap<Fields, String>()
		ACC_A.put(Fields.ACC_TITLE, CUST_A.get(Fields.CUST_FIRST_NAME)+' '+CUST_A.get(Fields.CUST_LAST_NAME))
		ACC_A.put(Fields.ACC_OWNERSHIP, 'Primary')
		ACC_A.put(Fields.ACC_DESCRIPTION, 'Savings Account')
		ACC_A.put(Fields.ACC_GROUP, 'Banking')
		ACC_A.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", Common.timezoneUTC)+RandomUtil.getRandomNumeric(4))
		ACC_A.put(Fields.ACC_BROKERED, 'false')
		ACC_A.put(Fields.ACC_TIMEZONE, 'UTC')
		ACC_A.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')

		//Product Information
		ACC_A.put(Fields.ACC_PRODUCT_TYPE, 'Personal Savings')
		ACC_A.put(Fields.ACC_POSITION_NAME, 'Personal Savings')
		ACC_A.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		ACC_A.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		ACC_A.put(Fields.ACC_VERTICAL, 'Vertical 01')
		ACC_A.put(Fields.ACC_DEPT_ID, 'Department 350')
		ACC_A.put(Fields.ACC_DEPT_ID_VIEW, '350')
		ACC_A.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(Common.dateFormat, Common.timezoneUTC))

		//T&C Document Information
		ACC_A.put(Fields.TC_DOC_TYPE1, 'Terms and conditions')
		ACC_A.put(Fields.TC_DOC_SIGNED_BY1, CUST_A.get(Fields.CUST_FIRST_NAME)+' '+CUST_A.get(Fields.CUST_LAST_NAME))
		ACC_A.put(Fields.TC_DOC_SIGNED_DATE1, DateUtil.getCurrentDateTime(Common.dateTimeFormat, Common.timezoneUTC))
		ACC_A.put(Fields.TC_DOC_VERSION1, '01')
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
}
