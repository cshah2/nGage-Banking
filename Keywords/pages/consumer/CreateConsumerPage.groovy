package pages.consumer

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

import actions.WebActions
import constants.Fields
import constants.Operator
import internal.GlobalVariable
import utils.MapUtil
import utils.WebUtil

public class CreateConsumerPage {

	private static void enterBasicInformation(Map<Fields, String> custData) {

		TestObject e_Prefix = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/input_Prefix')
		TestObject e_FirstName = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/input_First Name')
		TestObject e_MiddleName = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/input_Middle Name')
		TestObject e_LastName = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/input_Last Name')
		TestObject e_Suffix = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/input_Suffix')
		TestObject e_DateOfBirth = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/input_Date of Birth')
		TestObject e_TaxID = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/input_Tax ID')
		TestObject e_TaxIDType = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/select_SSN')
		TestObject e_CountryOfResidency = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/select_Country Of Residence')
		TestObject e_ResidencyStatus = findTestObject('Object Repository/Consumer/CreateConsumerPage/BasicInformation/select_Residency Status')

		//Wait for page elements to load
		WebActions.waitForElementVisible(e_Prefix, GlobalVariable.Timeout)

		WebActions.setText(e_Prefix, custData, Fields.CUST_PREFIX)
		WebActions.setText(e_FirstName, custData, Fields.CUST_FIRST_NAME)
		WebActions.setText(e_MiddleName, custData, Fields.CUST_MIDDLE_NAME)
		WebActions.setText(e_LastName, custData, Fields.CUST_LAST_NAME)
		WebActions.setText(e_Suffix, custData, Fields.CUST_SUFFIX)
		WebActions.setText(e_DateOfBirth, custData, Fields.CUST_DOB)
		WebActions.selectOptionByLabel(e_TaxIDType, custData, Fields.CUST_TAX_ID_TYPE)
		WebActions.setText(e_TaxID, custData, Fields.CUST_TAX_ID)
		WebActions.selectOptionByLabel(e_CountryOfResidency, custData, Fields.CUST_COUNTRY_OF_RESIDENCE)
		WebActions.selectOptionByLabel(e_ResidencyStatus, custData, Fields.CUST_RESIDENCY_STATUS)
	}

	private static void enterCustomerDetails(Map<Fields, String> custData) {

		TestObject e_FamiliarName = findTestObject('Object Repository/Consumer/CreateConsumerPage/Consumer Details/input_Familiar Name')
		TestObject e_MaidenName = findTestObject('Object Repository/Consumer/CreateConsumerPage/Consumer Details/input_Maiden Name')
		TestObject e_MaritalStatus = findTestObject('Object Repository/Consumer/CreateConsumerPage/Consumer Details/select_Marital Status')
		TestObject e_TotalHouseholdMembers = findTestObject('Object Repository/Consumer/CreateConsumerPage/Consumer Details/input_Total Household Members')
		TestObject e_MothersMaidenName = findTestObject('Object Repository/Consumer/CreateConsumerPage/Consumer Details/input_Mothers Maiden Name')
		TestObject e_PreferredLanguage = findTestObject('Object Repository/Consumer/CreateConsumerPage/Consumer Details/select_Preferred Language')
		TestObject e_AlternateLanguage = findTestObject('Object Repository/Consumer/CreateConsumerPage/Consumer Details/select_Alternate Language')
		TestObject e_AgeBracket = findTestObject('Object Repository/Consumer/CreateConsumerPage/Consumer Details/select_Age Bracket')

		//Wait for page elements to load
		WebActions.waitForElementVisible(e_FamiliarName, GlobalVariable.Timeout)

		WebActions.setText(e_FamiliarName, custData, Fields.CUST_FAMILIAR_NAME)
		WebActions.setText(e_MaidenName, custData, Fields.CUST_MAIDEN_NAME)
		WebActions.selectOptionByLabel(e_MaritalStatus, custData, Fields.CUST_MARITAL_STATUS)
		WebActions.setText(e_TotalHouseholdMembers, custData, Fields.CUST_TOTAL_HOUSEHOLD_MEMBERS)
		WebActions.setText(e_MothersMaidenName, custData, Fields.CUST_MOTHERS_MAIDEN_NAME)
		WebActions.selectOptionByLabel(e_PreferredLanguage, custData, Fields.CUST_PREFERRED_LANGUAGE)
		WebActions.selectOptionByLabel(e_AlternateLanguage, custData, Fields.CUST_ALTERNATE_LANGUAGE)
		WebActions.selectOptionByLabel(e_AgeBracket, custData, Fields.CUST_AGE_BRACKET)
	}

	private static void enterLocationInformation(Map<Fields, String> custData) {

		TestObject e_AddressLine1 = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_Address Line 1')
		TestObject e_AddressLine2 = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_Address Line 2')
		TestObject e_ShowMore = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/link_SHOW MORE')
		TestObject e_AddressLine3 = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_Address Line 3')
		TestObject e_AddressLine4 = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_Address Line 4')
		TestObject e_City = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_City')
		TestObject e_Country = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/select_Country')
		TestObject e_StateOrRegion = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/select_StateRegion')
		TestObject e_ZipOrPostalCode = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_ZipPostal Code')
		TestObject e_AddressType = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/select_Address Type')
		TestObject e_AddressLabel = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_Address Label')
		TestObject e_VerifiedDate = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_Verified Date (Address)')
		TestObject e_AddressValidLink = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/link_Set Address Valid tofrom dates')
		TestObject e_ValidFrom = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_Valid From (Address)')
		TestObject e_ValidUntil = findTestObject('Object Repository/Consumer/CreateConsumerPage/Location Information/input_Valid Until (Address)')

		//Wait for Location information fields to be visible
		WebActions.waitForElementVisible(e_AddressLine1, GlobalVariable.Timeout)

		WebActions.setText(e_AddressLine1, custData, Fields.ADDR_LINE1)
		WebActions.setText(e_AddressLine2, custData, Fields.ADDR_LINE2)

		if(MapUtil.isValidData(custData, Fields.ADDR_LINE3) || MapUtil.isValidData(custData, Fields.ADDR_LINE4)) {
			WebUI.click(e_ShowMore)
			WebActions.waitForElementVisible(e_AddressLine3, GlobalVariable.Timeout)
			WebActions.setText(e_AddressLine3, custData, Fields.ADDR_LINE3)
			WebActions.setText(e_AddressLine4, custData, Fields.ADDR_LINE4)
		}

		WebActions.setText(e_City, custData, Fields.ADDR_CITY)
		WebActions.selectOptionByLabel(e_Country, custData, Fields.ADDR_COUNTY)
		WebActions.selectOptionByLabel(e_StateOrRegion, custData, Fields.ADDR_STATE)
		WebActions.setText(e_ZipOrPostalCode, custData, Fields.ADDR_ZIPCODE)
		WebActions.selectOptionByLabel(e_AddressType, custData, Fields.ADDR_TYPE)
		WebActions.setText(e_AddressLabel, custData, Fields.ADDR_LABEL)
		WebActions.setText(e_VerifiedDate, custData, Fields.ADDR_VERIFIED_DATE, true)
		if(MapUtil.isValidData(custData, Fields.ADDR_VALID_FROM) || MapUtil.isValidData(custData, Fields.ADDR_VALID_UNTIL)) {
			WebActions.click(e_AddressValidLink)
			WebActions.waitForElementVisible(e_ValidFrom, GlobalVariable.Timeout)
		}
		WebActions.setText(e_ValidFrom, custData, Fields.ADDR_VALID_FROM, true)
		WebActions.setText(e_ValidUntil, custData, Fields.ADDR_VALID_UNTIL, true)
	}

	private static void enterContactInfomration(Map<Fields, String> custData) {

		TestObject e_PhoneNumber = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/input_Phone Number')
		TestObject e_PhoneType = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/select_PhoneType')
		TestObject e_PhoneVerifiedDate = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/input_Verified Date (Phone)')
		TestObject e_PhoneValidFrom = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/input_Valid From (Phone)')
		TestObject e_PhoneValidUntil = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/input_Valid Until (Phone)')
		TestObject e_PhoneValidLink = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/link_Set Phone Valid tofrom date')
		TestObject e_Email = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/input_Email')
		TestObject e_EmailType = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/select_EmailType')
		TestObject e_EmailVerifiedDate = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/input_Verified Date (Email)')
		TestObject e_EmailValidFrom = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/input_Valid From (Email)')
		TestObject e_EmailValidUntil = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/input_Valid Until (Email)')
		TestObject e_PreferredContact = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/select_Preferred Contact Method')
		TestObject e_EmailValidLink = findTestObject('Object Repository/Consumer/CreateConsumerPage/ContactInformation/link_Set Email Valid tofrom dates')

		//Wait for Contact information fields to be visible
		WebActions.waitForElementVisible(e_PhoneNumber, GlobalVariable.Timeout)

		WebActions.setText(e_PhoneNumber, custData, Fields.CONTACT_PHONE_NUMBER)
		WebActions.selectOptionByLabel(e_PhoneType, custData, Fields.CONTACT_PHONE_TYPE)
		WebActions.setText(e_PhoneVerifiedDate, custData, Fields.CONTACT_PHONE_VERIFIED_DATE, true)
		if(MapUtil.isValidData(custData, Fields.CONTACT_PHONE_VALID_FROM) || MapUtil.isValidData(custData, Fields.CONTACT_PHONE_VALID_UNTIL)) {
			WebActions.click(e_PhoneValidLink)
			WebActions.waitForElementVisible(e_PhoneValidFrom, GlobalVariable.Timeout)
			WebActions.setText(e_PhoneValidFrom, custData, Fields.CONTACT_PHONE_VALID_FROM, true)
			WebActions.setText(e_PhoneValidUntil, custData, Fields.CONTACT_PHONE_VALID_UNTIL, true)
		}

		WebActions.setText(e_Email, custData, Fields.CONTACT_EMAIL)
		WebActions.selectOptionByLabel(e_EmailType, custData, Fields.CONTACT_EMAIL_TYPE)
		WebActions.setText(e_EmailVerifiedDate, custData, Fields.CONTACT_EMAIL_VERIFIED_DATE, true)
		if(MapUtil.isValidData(custData, Fields.CONTACT_EMAIL_VALID_FROM) || MapUtil.isValidData(custData, Fields.CONTACT_EMAIL_VALID_UNTIL)) {
			WebActions.click(e_EmailValidLink)
			WebActions.waitForElementVisible(e_EmailValidFrom, GlobalVariable.Timeout)
			WebActions.setText(e_EmailValidFrom, custData, Fields.CONTACT_EMAIL_VALID_FROM, true)
			WebActions.setText(e_EmailValidUntil, custData, Fields.CONTACT_EMAIL_VALID_UNTIL, true)

		}
		WebActions.selectOptionByLabel(e_PreferredContact, custData, Fields.CONTACT_PREFERRED_CONTACT_METHOD)
	}

	private static void enterCustomerDueDiligence(Map<Fields, String> custData) {

		TestObject e_SeniorPoliticalFigure = findTestObject('Object Repository/Consumer/CreateConsumerPage/ConsumerDueDiligence/checkbox_Senior Political Figure')
		TestObject e_Country = findTestObject('Object Repository/Consumer/CreateConsumerPage/ConsumerDueDiligence/select_Country')
		TestObject e_AssociateSrPoliticalFigure = findTestObject('Object Repository/Consumer/CreateConsumerPage/ConsumerDueDiligence/select_Associated Sr Political Figure')

		//Wait for page elements to load
		WebActions.waitForElementVisible(e_SeniorPoliticalFigure, GlobalVariable.Timeout)

		if(MapUtil.isValidData(custData, Fields.CUST_CHK_SENIOR_POLITICAL_FIGURE)) {
			WebUI.check(e_SeniorPoliticalFigure)
			WebActions.waitForElementVisible(e_Country, GlobalVariable.Timeout)
		}
		WebActions.selectOptionByLabel(e_Country, custData, Fields.CUST_SENIOR_POLITICAL_FIGURE_COUNTRY)
		WebActions.selectOptionByLabel(e_AssociateSrPoliticalFigure, custData, Fields.CUST_ASSOCIATE_SR_POLITICAL_FIGURE)
	}

	private static void enterEducationAndOccupationDetails(Map<Fields, String> custData) {

		TestObject e_EmploymentStatus = findTestObject('Object Repository/Consumer/CreateConsumerPage/EductionAndOccupationDetails/select_Employment Status')
		TestObject e_Occupation = findTestObject('Object Repository/Consumer/CreateConsumerPage/EductionAndOccupationDetails/select_Occupation')
		TestObject e_MonthlyGrossIncome = findTestObject('Object Repository/Consumer/CreateConsumerPage/EductionAndOccupationDetails/input_Monthly Gross Income')
		TestObject e_MilitaryStatus = findTestObject('Object Repository/Consumer/CreateConsumerPage/EductionAndOccupationDetails/select_Military Status')
		TestObject e_Education = findTestObject('Object Repository/Consumer/CreateConsumerPage/EductionAndOccupationDetails/select_Education')
		TestObject e_StudentType = findTestObject('Object Repository/Consumer/CreateConsumerPage/EductionAndOccupationDetails/select_Student Type')
		TestObject e_WebAddress = findTestObject('Object Repository/Consumer/CreateConsumerPage/EductionAndOccupationDetails/input_Web Address')

		//Wait for page elements to load
		WebActions.waitForElementVisible(e_EmploymentStatus, GlobalVariable.Timeout)

		WebActions.selectOptionByLabel(e_EmploymentStatus, custData, Fields.CUST_EMPLOYMENT_STATUS)
		WebActions.selectOptionByLabel(e_Occupation, custData, Fields.CUST_OCCUPATION)
		WebActions.setText(e_MonthlyGrossIncome, custData, Fields.CUST_MONTHLY_GROSS_INCOME)
		WebActions.selectOptionByLabel(e_MilitaryStatus, custData, Fields.CUST_MILITARY_STATUS)
		WebActions.selectOptionByLabel(e_Education, custData, Fields.CUST_EDUCATION)
		WebActions.selectOptionByLabel(e_StudentType, custData, Fields.CUST_STUDENT_TYPE)
		WebActions.setText(e_WebAddress, custData, Fields.CUST_WEB_ADDRESS)
	}

	private static void enterCustomerInformation(Map<Fields, String> custData) {

		TestObject e_ConsumerId = findTestObject('Object Repository/Consumer/CreateConsumerPage/ConsumerInformation/input_Customer ID')
		TestObject e_ConsumerGroup = findTestObject('Object Repository/Consumer/CreateConsumerPage/ConsumerInformation/select_CustomerGroup')

		//Wait for Customer ID and Group field to load
		WebActions.waitForElementVisible(e_ConsumerId, GlobalVariable.Timeout)

		if(!WebActions.isReadonly(e_ConsumerId)) {
			WebActions.setText(e_ConsumerId, custData, Fields.CUST_ID)
		}

		WebActions.selectOptionByLabel(e_ConsumerGroup, custData, Fields.CUST_GROUP)
	}

	@Keyword
	def createConsumer(Map<Fields, String> custData) {

		TestObject e_Next = findTestObject('Object Repository/Consumer/CreateConsumerPage/btn_Next')
		TestObject e_Create = findTestObject('Object Repository/Consumer/CreateConsumerPage/ConsumerInformation/btn_Create')

		TestObject e_Dialog_Msg = findTestObject('Object Repository/Consumer/CreateConsumerPage/PopupDialog/text_SuccessMessage')
		TestObject e_Dialog_Yes = findTestObject('Object Repository/Consumer/CreateConsumerPage/PopupDialog/btn_Yes')
		TestObject e_Dialog_No = findTestObject('Object Repository/Consumer/CreateConsumerPage/PopupDialog/link_No')

		enterBasicInformation(custData)
		WebActions.click(e_Next)

		enterCustomerDetails(custData)
		WebActions.click(e_Next)

		enterLocationInformation(custData)
		WebActions.click(e_Next)

		enterContactInfomration(custData)
		WebActions.click(e_Next)

		enterCustomerDueDiligence(custData)
		WebActions.click(e_Next)

		enterEducationAndOccupationDetails(custData)
		WebActions.click(e_Next)

		enterCustomerInformation(custData)
		WebActions.click(e_Create)

		//handle popup dialog
		WebActions.waitForElementVisible(e_Dialog_No, GlobalVariable.Timeout)

		WebActions.verifyMatch(WebUI.getText(e_Dialog_Msg), 'Customer has been created', Operator.CONTAINS)

		if(MapUtil.isValidData(custData, Fields.CUST_CHK_ACCOUNT)) {
			WebActions.click(e_Dialog_Yes)
		}
		else {
			WebActions.click(e_Dialog_No)
		}

		WebActions.waitForElementVisible(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Consumer Name'), GlobalVariable.Timeout)
	}
}