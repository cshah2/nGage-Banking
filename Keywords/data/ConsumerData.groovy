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


		//Basic Information
		CUST_A.put(Fields.CUST_PREFIX, prefix)
		CUST_A.put(Fields.CUST_FIRST_NAME, firstName)
		CUST_A.put(Fields.CUST_MIDDLE_NAME, RandomUtil.getRandomAlphabets(4))
		CUST_A.put(Fields.CUST_LAST_NAME, lastName)

		CUST_A.put(Fields.CUST_NAME_VIEW, CUST_A.get(Fields.CUST_FIRST_NAME)+' '+CUST_A.get(Fields.CUST_LAST_NAME))
		CUST_A.put(Fields.CUST_SUFFIX, 'Jr.')
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
		CUSTOMERDATA_MAP.put(Fields.CUST_NOTES, "I have added this note through automation")
		CUSTOMERDATA_MAP.put(Fields.CUST_GROUP, "Banking Customer")
		CUSTOMERDATA_MAP.put(Fields.URL, 'https://savossit.savanainc.com/nGageBanking_Customer/CustomerMainFlow.CustomerDetail.aspx?partyId=4Ti4SvGC9rLiAF---VDF-Bg-&customerId=3&customerGroup=2')
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











	//API Data
	public static final Map<Fields, String> CUST_B;
	static {
		CUST_B = new HashMap<Fields, String>()
		//Map parsedJson = RandomUtil.generateRandomCustomerData()

		Faker faker = new Faker(Locale.US)
		String prefix = faker.name().prefix()
		String firstName = faker.name().firstName()
		String lastName = faker.name().lastName()
		String email = firstName+'.'+lastName+'@example.com'
		String addressLine1 = faker.address().buildingNumber() + faker.address().streetName()
		String addressLine2 = faker.address().streetAddress()
		String dob = DateUtil.convert(faker.dateAndTime.birthday(18, 65), Common.dateFormatISO)
		String city = faker.address().cityName()

		//Basic Information
		CUST_B.put(Fields.CUST_PREFIX, prefix)
		CUST_B.put(Fields.CUST_FIRST_NAME, firstName)
		CUST_B.put(Fields.CUST_MIDDLE_NAME, RandomUtil.getRandomAlphabets(4))
		CUST_B.put(Fields.CUST_LAST_NAME, lastName)

		CUST_B.put(Fields.CUST_NAME_VIEW, CUST_B.get(Fields.CUST_FIRST_NAME)+' '+CUST_B.get(Fields.CUST_LAST_NAME))
		CUST_B.put(Fields.CUST_SUFFIX, 'Jr.')
		CUST_B.put(Fields.CUST_DOB, dob)
		CUST_B.put(Fields.CUST_DOB_MASKED, '**/**/'+CUST_B.get(Fields.CUST_DOB).substring(6))
		CUST_B.put(Fields.CUST_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
		CUST_B.put(Fields.CUST_TAX_ID_MASKED, '******'+CUST_B.get(Fields.CUST_TAX_ID).substring(5))
		CUST_B.put(Fields.CUST_TAX_ID_TYPE, 'EIN')
		CUST_B.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
		CUST_B.put(Fields.CUST_RESIDENCY_STATUS, 'Resident')

		//Customer Details
		CUST_B.put(Fields.CUST_FAMILIAR_NAME, 'CHINOO')
		CUST_B.put(Fields.CUST_MAIDEN_NAME, 'SHAH')
		CUST_B.put(Fields.CUST_MARITAL_STATUS, 'Single')
		CUST_B.put(Fields.CUST_TOTAL_HOUSEHOLD_MEMBERS, '8')
		CUST_B.put(Fields.CUST_MOTHERS_MAIDEN_NAME, 'JOSHI')
		CUST_B.put(Fields.CUST_PREFERRED_LANGUAGE, 'English - United States')
		CUST_B.put(Fields.CUST_ALTERNATE_LANGUAGE, 'Hindi - India')
		CUST_B.put(Fields.CUST_AGE_BRACKET, '21 - 30')

		//Location Information
		CUST_B.put(Fields.ADDR_LINE1, addressLine1)
		CUST_B.put(Fields.ADDR_LINE2, addressLine2)
		CUST_B.put(Fields.ADDR_LINE3, 'Corona Ave')
		CUST_B.put(Fields.ADDR_LINE4, 'New Philadelphia')
		CUST_B.put(Fields.ADDR_CITY, 'Philadelphia')
		CUST_B.put(Fields.ADDR_COUNTY, 'United States of America')
		CUST_B.put(Fields.ADDR_STATE, 'Pennsylvania')
		CUST_B.put(Fields.ADDR_ZIPCODE, '1'+RandomUtil.getRandomNumeric(4))
		CUST_B.put(Fields.ADDR_TYPE, 'Residence')
		CUST_B.put(Fields.ADDR_LABEL, 'HOME')
		CUST_B.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(1, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.ADDR_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(10, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.ADDR_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-10, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.ADDR_VIEW, CUST_B.get(Fields.ADDR_LINE1)+', '+CUST_B.get(Fields.ADDR_LINE2)+', '+CUST_B.get(Fields.ADDR_CITY)+', PA '+CUST_B.get(Fields.ADDR_ZIPCODE))

		//Contact Information
		CUST_B.put(Fields.CONTACT_PHONE_NUMBER, '+1'+RandomUtil.getRandomNumeric(10))
		CUST_B.put(Fields.CONTACT_PHONE_TYPE, 'Mobile')
		CUST_B.put(Fields.CONTACT_PHONE_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(0, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.CONTACT_PHONE_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(8, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.CONTACT_PHONE_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-8, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.CONTACT_EMAIL, email)
		CUST_B.put(Fields.CONTACT_EMAIL_TYPE, 'Personal')
		CUST_B.put(Fields.CONTACT_EMAIL_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.CONTACT_EMAIL_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(9, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.CONTACT_EMAIL_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-9, Common.dateFormatISO, Common.timezoneUTC)+'T00:00:00Z')
		CUST_B.put(Fields.CONTACT_PREFERRED_CONTACT_METHOD, 'Email')

		//Customer Due diligence
		CUST_B.put(Fields.CUST_CHK_SENIOR_POLITICAL_FIGURE, 'true')
		CUST_B.put(Fields.CUST_SENIOR_POLITICAL_FIGURE_COUNTRY, 'India')
		CUST_B.put(Fields.CUST_ASSOCIATE_SR_POLITICAL_FIGURE, 'Family Member')

		//Education and Occupation details
		CUST_B.put(Fields.CUST_EMPLOYMENT_STATUS, 'Part-time')
		CUST_B.put(Fields.CUST_OCCUPATION, 'Computer and Mathmatical')
		CUST_B.put(Fields.CUST_MONTHLY_GROSS_INCOME, '30000')
		CUST_B.put(Fields.CUST_MILITARY_STATUS, 'Inactive')
		CUST_B.put(Fields.CUST_EDUCATION, 'High school or GED')
		CUST_B.put(Fields.CUST_STUDENT_TYPE, 'Full Time on campus')
		CUST_B.put(Fields.CUST_WEB_ADDRESS, 'http://www.savanainc.com')

		//Customer Information
		CUST_B.put(Fields.CUST_ID, 'ID'+RandomUtil.getRandomNumeric(7))
		CUST_B.put(Fields.CUST_GROUP, 'Banking Customer')
	}


	//Personal Savings account for a consumer "Cust_A"
	public static final Map<Fields, String> ACC_B1;
	static {

		//Basic Information
		ACC_B1 = new HashMap<Fields, String>()
		ACC_B1.put(Fields.ACC_TITLE, CUST_B.get(Fields.CUST_FIRST_NAME)+' '+CUST_B.get(Fields.CUST_LAST_NAME))
		ACC_B1.put(Fields.ACC_OWNERSHIP, 'Single')
		ACC_B1.put(Fields.ACC_DESCRIPTION, 'Savings Account')
		ACC_B1.put(Fields.ACC_GROUP, 'Banking')
		ACC_B1.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", Common.timezone)+RandomUtil.getRandomNumeric(4))
		ACC_B1.put(Fields.ACC_BROKERED, 'false')
		ACC_B1.put(Fields.ACC_TIMEZONE, 'America/New_York')
		ACC_B1.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')

		//Product Information
		ACC_B1.put(Fields.ACC_PRODUCT_TYPE, 'Personal Savings')
		ACC_B1.put(Fields.ACC_PRODUCT_CODE, 'P2001')
		ACC_B1.put(Fields.ACC_POSITION_NAME, 'Personal Savings')
		ACC_B1.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		ACC_B1.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		ACC_B1.put(Fields.ACC_VERTICAL, 'Vertical 01')
		ACC_B1.put(Fields.ACC_DEPT_ID, 'Department 350')
		ACC_B1.put(Fields.ACC_DEPT_ID_VIEW, '350')
		ACC_B1.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(Common.dateFormat, Common.timezoneUTC))
	}
	
	//Personal Savings account for a consumer "Cust_A"
	public static final Map<Fields, String> ACC_B2_POS1;
	static {

		//Basic Information
		ACC_B2_POS1 = new HashMap<Fields, String>()
		ACC_B2_POS1.put(Fields.ACC_TITLE, CUST_B.get(Fields.CUST_FIRST_NAME)+' '+CUST_B.get(Fields.CUST_LAST_NAME))
		ACC_B2_POS1.put(Fields.ACC_OWNERSHIP, 'Single')
		ACC_B2_POS1.put(Fields.ACC_DESCRIPTION, 'Savings Account')
		ACC_B2_POS1.put(Fields.ACC_GROUP, 'Multi-Position')
		ACC_B2_POS1.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", Common.timezone)+RandomUtil.getRandomNumeric(4))
		ACC_B2_POS1.put(Fields.ACC_BROKERED, 'false')
		ACC_B2_POS1.put(Fields.ACC_TIMEZONE, 'America/New_York')
		ACC_B2_POS1.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')

		//Product Information
		ACC_B2_POS1.put(Fields.ACC_PRODUCT_TYPE, 'Business Savings')
		ACC_B2_POS1.put(Fields.ACC_PRODUCT_CODE, 'B2001')
		ACC_B2_POS1.put(Fields.ACC_POSITION_NAME, 'Business Savings')
		ACC_B2_POS1.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		ACC_B2_POS1.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		ACC_B2_POS1.put(Fields.ACC_VERTICAL, 'Vertical 01')
		ACC_B2_POS1.put(Fields.ACC_DEPT_ID, 'Department 350')
		ACC_B2_POS1.put(Fields.ACC_DEPT_ID_VIEW, '350')

		ACC_B2_POS1.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(Common.dateFormat, Common.timezoneUTC))
	}

	public static final Map<Fields, String> ACC_B2_POS2;
	static {

		//Basic Information
		ACC_B2_POS2 = new HashMap<Fields, String>()
		ACC_B2_POS2.put(Fields.ACC_PRODUCT_TYPE, '18 Month Compounding-Business')
		ACC_B2_POS2.put(Fields.ACC_PRODUCT_CODE, 'B3018')
		ACC_B2_POS2.put(Fields.ACC_POSITION_NAME, '18 Month Compounding-Business')
	}

	public static final Map<Fields, String> ACC_B2_POS3;
	static {

		//Basic Information
		ACC_B2_POS3 = new HashMap<Fields, String>()
		ACC_B2_POS3.put(Fields.ACC_PRODUCT_TYPE, 'Interest Checking')
		ACC_B2_POS3.put(Fields.ACC_PRODUCT_CODE, 'C2001')
		ACC_B2_POS3.put(Fields.ACC_POSITION_NAME, 'Interest Checking')
	}

	public static final Map<Fields, String> ACC_B2_POS4;
	static {

		//Basic Information
		ACC_B2_POS4 = new HashMap<Fields, String>()
		ACC_B2_POS4.put(Fields.ACC_PRODUCT_TYPE, 'Revolving Personal Loan')
		ACC_B2_POS4.put(Fields.ACC_PRODUCT_CODE, 'LOC')
		ACC_B2_POS4.put(Fields.ACC_POSITION_NAME, 'Revolving Personal Loan')
		ACC_B2_POS4.put(Fields.ACC_CREDIT_LIMIT, '200000')
	}

	public static final Map<Fields, String> ACC_B2_POS5;
	static {

		//Basic Information
		ACC_B2_POS5 = new HashMap<Fields, String>()
		ACC_B2_POS5.put(Fields.ACC_PRODUCT_TYPE, 'Installment Personal Loan')
		ACC_B2_POS5.put(Fields.ACC_PRODUCT_CODE, 'LN')
		ACC_B2_POS5.put(Fields.ACC_POSITION_NAME, 'Installment Personal Loan')
		ACC_B2_POS5.put(Fields.ACC_CREDIT_LIMIT, '100000')
	}


}



