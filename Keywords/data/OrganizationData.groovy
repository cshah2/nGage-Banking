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

public class OrganizationData {
	
	public static final Map<Fields, String> ORG_A;
	static {
		ORG_A = new HashMap<Fields, String>()
		Map parsedJson = RandomUtil.generateRandomCustomerData()

		//Basic Information
		String orgName = "The "+parsedJson.get("results").get(0).get("name").get("first") +' '+ parsedJson.get("results").get(0).get("name").get("last") +" Inc"
		String dbaName = parsedJson.get("results").get(0).get("name").get("title") +' '+ parsedJson.get("results").get(0).get("name").get("last") +" and Sons "+RandomUtil.getRandomAlphabets(4)
		String establishedDate = DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', Common.dateFormat)

		ORG_A.put(Fields.ORG_NAME, orgName)
		ORG_A.put(Fields.ORG_DBA_NAME, dbaName)
		ORG_A.put(Fields.ORG_ESTABLISHED_DATE, establishedDate)
		ORG_A.put(Fields.ORG_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
		ORG_A.put(Fields.ORG_TAX_ID_MASKED, '******'+ORG_A.get(Fields.ORG_TAX_ID).substring(5))
		ORG_A.put(Fields.ORG_TAX_ID_TYPE, 'SSN')

		//Organization Details
		String tradeName = parsedJson.get("results").get(0).get("name").get("title") + parsedJson.get("results").get(0).get("name").get("first") +" PLC"
		ORG_A.put(Fields.ORG_DESCRIPTION, 'Organization 01 - Description')
		ORG_A.put(Fields.ORG_DUN_BRADSTEET_NO, RandomUtil.getRandomNumeric(9))
		ORG_A.put(Fields.ORG_CHK_PUBLICLY_HELD, 'true')
		ORG_A.put(Fields.ORG_TRADE_NAME, tradeName)
		ORG_A.put(Fields.ORG_CHK_INTERNATIONAL_COMPANY, 'true')
		ORG_A.put(Fields.ORG_CHK_GOVERNMENT_OWNED, 'true')
		ORG_A.put(Fields.ORG_CHK_SMALL_BUSINESS, 'true')
		ORG_A.put(Fields.ORG_CHK_TAX_EXEMPT, 'true')
		ORG_A.put(Fields.ORG_TAX_EXEMPT_TYPE, 'Title Holding Corporation for Exempt Organization')
		ORG_A.put(Fields.ORG_REGISTRATION_COUNTRY, 'United States of America')
		ORG_A.put(Fields.ORG_REGISTRATION_REGION, 'Pennsylvania')
		ORG_A.put(Fields.ORG_WEBSITE_URL, 'https://www.savanainc.com')

		//Location Information
		ORG_A.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMM', Common.timezone)+' Street')
		ORG_A.put(Fields.ADDR_CITY, 'Philadelphia')
		ORG_A.put(Fields.ADDR_COUNTY, 'United States of America')
		ORG_A.put(Fields.ADDR_STATE, 'Pennsylvania')
		ORG_A.put(Fields.ADDR_ZIPCODE, '1'+RandomUtil.getRandomNumeric(4))
		ORG_A.put(Fields.ADDR_TYPE, 'Residence')
		ORG_A.put(Fields.ADDR_LABEL, 'HOME')
		ORG_A.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(1, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.ADDR_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(10, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.ADDR_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-10, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.ADDR_VIEW, ORG_A.get(Fields.ADDR_STREET)+', '+ORG_A.get(Fields.ADDR_CITY)+', PA '+ORG_A.get(Fields.ADDR_ZIPCODE))

		//Contact Information
		ORG_A.put(Fields.CONTACT_PHONE_NUMBER, '+1'+RandomUtil.getRandomNumeric(10))
		ORG_A.put(Fields.CONTACT_PHONE_TYPE, 'Mobile')
		ORG_A.put(Fields.CONTACT_PHONE_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(0, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.CONTACT_PHONE_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(8, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.CONTACT_PHONE_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-8, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.CONTACT_EMAIL, parsedJson.get("results").get(0).get("email"))
		ORG_A.put(Fields.CONTACT_EMAIL_TYPE, 'Personal')
		ORG_A.put(Fields.CONTACT_EMAIL_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.CONTACT_EMAIL_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(9, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.CONTACT_EMAIL_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-9, Common.dateFormat, Common.timezoneUTC))
		ORG_A.put(Fields.CONTACT_PREFERRED_CONTACT_METHOD, 'Email')

		//Organization Due diligence
		ORG_A.put(Fields.ORG_BUSINESS_STRUCTURE, 'LLC')
		ORG_A.put(Fields.ORG_COUNTRY_OPERATIONS, 'United States of America')
		ORG_A.put(Fields.ORG_COUNTRY_HEADQUARTERS, 'India')
		ORG_A.put(Fields.ORG_INDUSTRY, 'Agriculature')
		ORG_A.put(Fields.ORG_YEARS_OWNED, '3 Years')
		ORG_A.put(Fields.ORG_EST_ANNUAL_REVENUE, 'Under 1 Million')
		ORG_A.put(Fields.ORG_NUMBER_LOCATIONS, '1 to 10 Locations')
		ORG_A.put(Fields.ORG_NUMBER_WIRE_TRANSACTIONS, '1 to 100 Wires')
		ORG_A.put(Fields.ORG_AMOUNT_WIRE_TRANSACTIONS, 'Up to $100')
		ORG_A.put(Fields.ORG_NUMBER_ACH_ORIGINATION, '1 to 100 ACH Originations')
		ORG_A.put(Fields.ORG_AMOUNT_ACH_ORIGINATION, 'Up to $100')
		ORG_A.put(Fields.ORG_NUMBER_MOBILE_DEPOSITS, '101 to 1000 Mobile Deposits')
		ORG_A.put(Fields.ORG_AMOUNT_MOBILE_DEPOSITS, 'Up to $100')
		ORG_A.put(Fields.ORG_NUMBER_REMOTE_DEPOSITS, 'More than 10000 Remote Deposits')
		ORG_A.put(Fields.ORG_AMOUNT_REMOTE_DEPOSITS, 'Up to $100')
		ORG_A.put(Fields.ORG_INTERMEDIATORY_SERVICES, 'Accounting')
		ORG_A.put(Fields.ORG_PERCENT_REVENUE_CASH, '26 to 50 Percent')
		ORG_A.put(Fields.ORG_CHK_NON_CASH_SERVICE, 'true')
		ORG_A.put(Fields.ORG_CHK_CHARITY, 'true')
		ORG_A.put(Fields.ORG_CHK_ATM_OPERATOR, 'true')
		ORG_A.put(Fields.ORG_CHK_MARIJUANA_BUSINESS, 'true')
		ORG_A.put(Fields.ORG_CHK_INTERNET_GAMBLING, 'true')
		ORG_A.put(Fields.ORG_CHK_THIRD_PARTY_BENEFIT, 'true')
		ORG_A.put(Fields.ORG_CHK_TRANSFER_CUSTOMERS, 'true')
		ORG_A.put(Fields.ORG_CHK_VIRTUAL_CURRENCY, 'true')

		//Customer Information
		ORG_A.put(Fields.ORG_ID, 'ID'+RandomUtil.getRandomNumeric(7))
		ORG_A.put(Fields.ORG_GROUP, 'Banking Customer')

		//Script data
		ORG_A.put(Fields.IS_CREATED, 'false')
		ORG_A.put(Fields.URL, '')
	}
}
