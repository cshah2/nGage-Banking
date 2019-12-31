package pages.organization

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

import constants.Fields
import constants.Operator
import internal.GlobalVariable
import utils.MapUtil
import utils.WebUtil

public class CreateOrganizationPage {

	private static void enterBasicInformation(Map<Fields, String> orgData) {

		TestObject e_OrgName = findTestObject('Object Repository/Organization/CreateOrganizationPage/BasicInformation/input_Organization Name')
		TestObject e_DbaName = findTestObject('Object Repository/Organization/CreateOrganizationPage/BasicInformation/input_DBA Name')
		TestObject e_EstablishedDate = findTestObject('Object Repository/Organization/CreateOrganizationPage/BasicInformation/input_Established Date')
		TestObject e_TaxID = findTestObject('Object Repository/Organization/CreateOrganizationPage/BasicInformation/input_Tax ID')
		TestObject e_TaxIDType = findTestObject('Object Repository/Organization/CreateOrganizationPage/BasicInformation/select_Tax ID Type')

		//Wait for page elements to load
		WebUI.waitForElementVisible(e_OrgName, GlobalVariable.Timeout)

		WebUtil.setText(e_OrgName, orgData, Fields.ORG_NAME)
		WebUtil.setText(e_DbaName, orgData, Fields.ORG_DBA_NAME)
		WebUtil.setText(e_EstablishedDate, orgData, Fields.ORG_ESTABLISHED_DATE)
		WebUtil.setText(e_TaxID, orgData, Fields.ORG_TAX_ID)
		WebUtil.selectOptionByLabel(e_TaxIDType, orgData, Fields.ORG_TAX_ID_TYPE)
	}

	private static void enterOrganizationDetails(Map<Fields, String> orgData) {

		TestObject e_Description = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/input_Description')
		TestObject e_DunAndBradSteetNo = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/input_Dun  Bradstreet Number')
		TestObject e_PubliclyHeld = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/check_Publicly Held')
		TestObject e_TradeName = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/input_Trade Name')
		TestObject e_InternationalCompany = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/check_International Company')
		TestObject e_GovernmentOwned = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/check_Government Owned')
		TestObject e_SmallBusiness = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/check_Small Business')
		TestObject e_TaxExempt = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/check_Tax Exempt')
		TestObject e_TaxExemptType = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/select_Tax Exempt Type')
		TestObject e_RegistrationCountry = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/select_Registration Country')
		TestObject e_RegistrationRegion = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/select_Registration Region')
		TestObject e_WebsiteURL = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDetails/input_Website URL')


		//Wait for page elements to load
		WebUI.waitForElementVisible(e_Description, GlobalVariable.Timeout)

		WebUtil.setText(e_Description, orgData, Fields.ORG_DESCRIPTION)
		WebUtil.setText(e_DunAndBradSteetNo, orgData, Fields.ORG_DUN_BRADSTEET_NO)
		if(MapUtil.isValidData(orgData, Fields.ORG_CHK_PUBLICLY_HELD)) {
			WebUI.check(e_PubliclyHeld)
			WebUI.waitForElementVisible(e_TradeName, GlobalVariable.Timeout)
			WebUtil.setText(e_TradeName, orgData, Fields.ORG_TRADE_NAME)
		}
		WebUtil.check(e_InternationalCompany, orgData, Fields.ORG_CHK_INTERNATIONAL_COMPANY)
		WebUtil.check(e_GovernmentOwned, orgData, Fields.ORG_CHK_GOVERNMENT_OWNED)
		WebUtil.check(e_SmallBusiness, orgData, Fields.ORG_CHK_SMALL_BUSINESS)
		if(MapUtil.isValidData(orgData, Fields.ORG_CHK_TAX_EXEMPT)) {
			WebUI.check(e_TaxExempt)
			WebUI.waitForElementVisible(e_TaxExemptType, GlobalVariable.Timeout)
			WebUtil.selectOptionByLabel(e_TaxExemptType, orgData, Fields.ORG_TAX_EXEMPT_TYPE)
		}
		WebUtil.selectOptionByLabel(e_RegistrationCountry, orgData, Fields.ORG_REGISTRATION_COUNTRY)
		WebUtil.selectOptionByLabel(e_RegistrationRegion, orgData, Fields.ORG_REGISTRATION_REGION)
		WebUtil.setText(e_WebsiteURL, orgData, Fields.ORG_WEBSITE_URL)
	}

	private static void enterLocationInformation(Map<Fields, String> orgData) {

		TestObject e_AddressLine1 = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_Address Line 1')
		TestObject e_AddressLine2 = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_Address Line 2')
		TestObject e_ShowMore = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/link_SHOW MORE')
		TestObject e_AddressLine3 = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_Address Line 3')
		TestObject e_AddressLine4 = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_Address Line 4')
		TestObject e_City = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_City')
		TestObject e_Country = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/select_Country')
		TestObject e_StateOrRegion = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/select_State Or Region')
		TestObject e_ZipOrPostalCode = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_ZipPostal Code')
		TestObject e_AddressType = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/select_Address Type')
		TestObject e_AddressLabel = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_Address Label')
		TestObject e_VerifiedDate = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_Verified Date')
		TestObject e_AddressValidLink = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/link_Set Address Valid tofrom dates')
		TestObject e_ValidFrom = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_Valid From')
		TestObject e_ValidUntil = findTestObject('Object Repository/Organization/CreateOrganizationPage/LocationInformation/input_Valid Until')

		//Wait for Location information fields to be visible
		WebUI.waitForElementVisible(e_AddressLine1, GlobalVariable.Timeout)

		WebUtil.setText(e_AddressLine1, orgData, Fields.ADDR_LINE1)
		WebUtil.setText(e_AddressLine2, orgData, Fields.ADDR_LINE2)

		WebUI.click(e_ShowMore)
		WebUI.waitForElementVisible(e_AddressLine3, GlobalVariable.Timeout)

		WebUtil.setText(e_AddressLine3, orgData, Fields.ADDR_LINE3)
		WebUtil.setText(e_AddressLine4, orgData, Fields.ADDR_LINE4)
		WebUtil.setText(e_City, orgData, Fields.ADDR_CITY)
		WebUtil.selectOptionByLabel(e_Country, orgData, Fields.ADDR_COUNTY)
		WebUtil.selectOptionByLabel(e_StateOrRegion, orgData, Fields.ADDR_STATE)
		WebUtil.setText(e_ZipOrPostalCode, orgData, Fields.ADDR_ZIPCODE)
		WebUtil.selectOptionByLabel(e_AddressType, orgData, Fields.ADDR_TYPE)
		WebUtil.setText(e_AddressLabel, orgData, Fields.ADDR_LABEL)
		WebUtil.setText(e_VerifiedDate, orgData, Fields.ADDR_VERIFIED_DATE, true)
		if(MapUtil.isValidData(orgData, Fields.ADDR_VALID_FROM) || MapUtil.isValidData(orgData, Fields.ADDR_VALID_UNTIL)) {
			WebUtil.click(e_AddressValidLink)
			WebUI.waitForElementVisible(e_ValidFrom, GlobalVariable.Timeout)
		}
		WebUtil.setText(e_ValidFrom, orgData, Fields.ADDR_VALID_FROM, true)
		WebUtil.setText(e_ValidUntil, orgData, Fields.ADDR_VALID_UNTIL, true)
	}

	private static void enterContactInfomration(Map<Fields, String> orgData) {

		TestObject e_PhoneNumber = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/input_Phone Number')
		TestObject e_PhoneType = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/select_Phone Type')
		TestObject e_PhoneVerifiedDate = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/input_Verified Date (Phone)')
		TestObject e_PhoneValidFrom = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/input_Valid From (Phone)')
		TestObject e_PhoneValidUntil = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/input_Valid Until (Phone)')
		TestObject e_PhoneValidLink = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/link_Set Phone Valid tofrom date')
		TestObject e_Email = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/input_Email')
		TestObject e_EmailType = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/select_Email Type')
		TestObject e_EmailVerifiedDate = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/input_Verified Date (Email)')
		TestObject e_EmailValidFrom = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/input_Valid From (Email)')
		TestObject e_EmailValidUntil = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/input_Valid Until (Email)')
		TestObject e_PreferredContact = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/select_Preferred Contact Method')
		TestObject e_EmailValidLink = findTestObject('Object Repository/Organization/CreateOrganizationPage/ContactInformation/link_Set Email Valid tofrom dates')

		//Wait for Contact information fields to be visible
		WebUI.waitForElementVisible(e_PhoneNumber, GlobalVariable.Timeout)

		WebUtil.setText(e_PhoneNumber, orgData, Fields.CONTACT_PHONE_NUMBER)
		WebUtil.selectOptionByLabel(e_PhoneType, orgData, Fields.CONTACT_PHONE_TYPE)
		WebUtil.setText(e_PhoneVerifiedDate, orgData, Fields.CONTACT_PHONE_VERIFIED_DATE, true)
		if(MapUtil.isValidData(orgData, Fields.CONTACT_PHONE_VALID_FROM) || MapUtil.isValidData(orgData, Fields.CONTACT_PHONE_VALID_UNTIL)) {
			WebUtil.click(e_PhoneValidLink)
			WebUI.waitForElementVisible(e_PhoneValidFrom, GlobalVariable.Timeout)
			WebUtil.setText(e_PhoneValidFrom, orgData, Fields.CONTACT_PHONE_VALID_FROM, true)
			WebUtil.setText(e_PhoneValidUntil, orgData, Fields.CONTACT_PHONE_VALID_UNTIL, true)
		}

		WebUtil.setText(e_Email, orgData, Fields.CONTACT_EMAIL)
		WebUtil.selectOptionByLabel(e_EmailType, orgData, Fields.CONTACT_EMAIL_TYPE)
		WebUtil.setText(e_EmailVerifiedDate, orgData, Fields.CONTACT_EMAIL_VERIFIED_DATE, true)
		if(MapUtil.isValidData(orgData, Fields.CONTACT_EMAIL_VALID_FROM) || MapUtil.isValidData(orgData, Fields.CONTACT_EMAIL_VALID_UNTIL)) {
			WebUtil.click(e_EmailValidLink)
			WebUI.waitForElementVisible(e_EmailValidFrom, GlobalVariable.Timeout)
			WebUtil.setText(e_EmailValidFrom, orgData, Fields.CONTACT_EMAIL_VALID_FROM, true)
			WebUtil.setText(e_EmailValidUntil, orgData, Fields.CONTACT_EMAIL_VALID_UNTIL, true)

		}
		WebUtil.selectOptionByLabel(e_PreferredContact, orgData, Fields.CONTACT_PREFERRED_CONTACT_METHOD)
	}

	private static void enterOrganizationDueDiligence(Map<Fields, String> orgData) {

		TestObject e_BusinessStructure = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Business Structure')
		TestObject e_CountryOperations = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Countries of Operation')
		TestObject e_CountryHeadquarters = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Country of Headquarters')
		TestObject e_Industry = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Industry')
		TestObject e_YearsOwned = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Years Owned')
		TestObject e_EstAnnualRevenue = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Estimated Annual Revenue')
		TestObject e_NumberOfLocations = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Number of Locations')
		TestObject e_NumberWireTrxn = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Number of Wire Transactions per Month')
		TestObject e_AmountWireTrxn = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Amount of Wire Transactions per Month')
		TestObject e_NumberAchOrigination = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Number of ACH Originations per Month')
		TestObject e_AmountAchOrigination = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Amount of ACH Originations per Month')
		TestObject e_NumberMobileDeposit = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Number of Mobile Deposits per Month')
		TestObject e_AmountMobileDeposit = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Amount of Mobile Deposits per Month')
		TestObject e_NumberRemoteDeposit = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Number of Remote Deposits per Month')
		TestObject e_AmountRemoteDeposit = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Amount of Remote Deposits per Month')
		TestObject e_IntermediatoryService = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Intermediatory Services')
		TestObject e_PercentRevenueCash = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/select_Percent of Revenue from Cash Services')
		TestObject e_NonCashSevice = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/check_Non Cash Services Performed')
		TestObject e_Charity = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/check_Charity')
		TestObject e_AtmOperator = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/check_ATM Operator')
		TestObject e_MarijuanaBusiness = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/check_Marijuana Business')
		TestObject e_InternetGambling = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/check_Internet Gambling')
		TestObject e_ThirdPartyBenefit = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/check_Third Party Benefit Transactions')
		TestObject e_TransferCustomers = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/check_Transfers for Customers')
		TestObject e_VirtualCurrencyUsed = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationDueDiligence/check_Virtual Currency Used')

		//Wait for page elements to load
		WebUI.waitForElementVisible(e_BusinessStructure, GlobalVariable.Timeout)

		WebUtil.selectOptionByLabel(e_BusinessStructure, orgData, Fields.ORG_BUSINESS_STRUCTURE)
		WebUtil.selectOptionByLabel(e_CountryOperations, orgData, Fields.ORG_COUNTRY_OPERATIONS)
		WebUtil.selectOptionByLabel(e_CountryHeadquarters, orgData, Fields.ORG_COUNTRY_HEADQUARTERS)
		WebUtil.selectOptionByLabel(e_Industry, orgData, Fields.ORG_INDUSTRY)
		WebUtil.selectOptionByLabel(e_YearsOwned, orgData, Fields.ORG_YEARS_OWNED)
		WebUtil.selectOptionByLabel(e_EstAnnualRevenue, orgData, Fields.ORG_EST_ANNUAL_REVENUE)
		WebUtil.selectOptionByLabel(e_NumberOfLocations, orgData, Fields.ORG_NUMBER_LOCATIONS)
		WebUtil.selectOptionByLabel(e_NumberWireTrxn, orgData, Fields.ORG_NUMBER_WIRE_TRANSACTIONS)
		WebUtil.selectOptionByLabel(e_AmountWireTrxn, orgData, Fields.ORG_AMOUNT_WIRE_TRANSACTIONS)
		WebUtil.selectOptionByLabel(e_NumberAchOrigination, orgData, Fields.ORG_NUMBER_ACH_ORIGINATION)
		WebUtil.selectOptionByLabel(e_AmountAchOrigination, orgData, Fields.ORG_AMOUNT_ACH_ORIGINATION)
		WebUtil.selectOptionByLabel(e_NumberMobileDeposit, orgData, Fields.ORG_NUMBER_MOBILE_DEPOSITS)
		WebUtil.selectOptionByLabel(e_AmountMobileDeposit, orgData, Fields.ORG_AMOUNT_MOBILE_DEPOSITS)
		WebUtil.selectOptionByLabel(e_NumberRemoteDeposit, orgData, Fields.ORG_NUMBER_REMOTE_DEPOSITS)
		WebUtil.selectOptionByLabel(e_AmountRemoteDeposit, orgData, Fields.ORG_AMOUNT_REMOTE_DEPOSITS)
		WebUtil.selectOptionByLabel(e_IntermediatoryService, orgData, Fields.ORG_INTERMEDIATORY_SERVICES)
		WebUtil.selectOptionByLabel(e_PercentRevenueCash, orgData, Fields.ORG_PERCENT_REVENUE_CASH)
		WebUtil.check(e_NonCashSevice, orgData, Fields.ORG_CHK_NON_CASH_SERVICE)
		WebUtil.check(e_Charity, orgData, Fields.ORG_CHK_CHARITY)
		WebUtil.check(e_AtmOperator, orgData, Fields.ORG_CHK_ATM_OPERATOR)
		WebUtil.check(e_MarijuanaBusiness, orgData, Fields.ORG_CHK_MARIJUANA_BUSINESS)
		WebUtil.check(e_InternetGambling, orgData, Fields.ORG_CHK_INTERNET_GAMBLING)
		WebUtil.check(e_ThirdPartyBenefit, orgData, Fields.ORG_CHK_THIRD_PARTY_BENEFIT)
		WebUtil.check(e_TransferCustomers, orgData, Fields.ORG_CHK_TRANSFER_CUSTOMERS)
		WebUtil.check(e_VirtualCurrencyUsed, orgData, Fields.ORG_CHK_VIRTUAL_CURRENCY)
	}

	private static void enterCustomerInformation(Map<Fields, String> custData) {

		TestObject e_OrganizationId = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationInformation/input_Customer ID')
		TestObject e_OrganizationGroup = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationInformation/select_CustomerGroup')

		//Wait for Customer ID and Group field to load
		WebUI.waitForElementVisible(e_OrganizationId, GlobalVariable.Timeout)

		WebUtil.setText(e_OrganizationId, custData, Fields.ORG_ID)
		WebUtil.selectOptionByLabel(e_OrganizationGroup, custData, Fields.ORG_GROUP)
	}

	@Keyword
	static def createOrganization(Map<Fields, String> orgData) {

		TestObject e_next = findTestObject('Object Repository/Organization/CreateOrganizationPage/btn_Next')
		TestObject e_Create = findTestObject('Object Repository/Organization/CreateOrganizationPage/OrganizationInformation/btn_Create')

		TestObject e_Dialog_Msg = findTestObject('Object Repository/Organization/CreateOrganizationPage/PopupDialog/text_SuccessMessage')
		TestObject e_Dialog_Yes = findTestObject('Object Repository/Organization/CreateOrganizationPage/PopupDialog/btn_Yes')
		TestObject e_Dialog_No = findTestObject('Object Repository/Organization/CreateOrganizationPage/PopupDialog/link_No')

		enterBasicInformation(orgData)
		WebUtil.click(e_next)

		enterOrganizationDetails(orgData)
		WebUtil.click(e_next)

		enterLocationInformation(orgData)
		WebUtil.click(e_next)

		enterContactInfomration(orgData)
		WebUtil.click(e_next)

		enterOrganizationDueDiligence(orgData)
		WebUtil.click(e_next)

		enterCustomerInformation(orgData)
		WebUtil.click(e_Create)

		//handle popup dialog
		WebUI.waitForElementVisible(e_Dialog_Msg, GlobalVariable.Timeout)
		WebUtil.verifyMatch(e_Dialog_Msg, 'Customer has been created', Operator.CONTAINS)

		if(MapUtil.isValidData(orgData, Fields.ORG_CHK_ACCOUNT)) {
			WebUI.click(e_Dialog_Yes)
		}
		else {
			WebUI.click(e_Dialog_No)
		}
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Consumer Name'), GlobalVariable.Timeout)
	}
}
