import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Fields
import data.OrganizationData
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

Map<Fields, String> custData =  OrganizationData.ORG_B

RequestObject request = findTestObject('API/createOrganization',
		[
			('customerId'):custData.get(Fields.ORG_ID),
			('taxId'):custData.get(Fields.ORG_TAX_ID),
			('addressLine1'):custData.get(Fields.ADDR_LINE1),
			('addressLine2'):custData.get(Fields.ADDR_LINE2),
			('addressLine3'):custData.get(Fields.ADDR_LINE3),
			('addressLine4'):custData.get(Fields.ADDR_LINE4),
			('city'):custData.get(Fields.ADDR_CITY),
			('zipcode'):custData.get(Fields.ADDR_ZIPCODE),
			('addressValidFrom'):custData.get(Fields.ADDR_VALID_FROM),
			('addressValidUntil'):custData.get(Fields.ADDR_VALID_UNTIL),
			('addressVerifiedDate'):custData.get(Fields.ADDR_VERIFIED_DATE),
			('email'):custData.get(Fields.CONTACT_EMAIL),
			('emailValidFrom'):custData.get(Fields.CONTACT_EMAIL_VALID_FROM),
			('emailValidUntil'):custData.get(Fields.CONTACT_EMAIL_VALID_UNTIL),
			('emailVerifiedDate'):custData.get(Fields.CONTACT_EMAIL_VERIFIED_DATE),
			('website'):custData.get(Fields.ORG_WEBSITE_URL),
			('phone'):custData.get(Fields.CONTACT_PHONE_NUMBER),
			('phoneValidFrom'):custData.get(Fields.CONTACT_PHONE_VALID_FROM),
			('phoneValidUntil'):custData.get(Fields.CONTACT_PHONE_VALID_UNTIL),
			('phoneVerifiedDate'):custData.get(Fields.CONTACT_PHONE_VERIFIED_DATE),
			('tradeName'):custData.get(Fields.ORG_TRADE_NAME),
			('orgName'):custData.get(Fields.ORG_NAME),
			('dbaName'):custData.get(Fields.ORG_DBA_NAME),
			('description'):custData.get(Fields.ORG_DESCRIPTION),
			('dbnumber'):custData.get(Fields.ORG_DUN_BRADSTEET_NO)
		]
	)

println "... Request JSON = "+request.getHttpBody()
ResponseObject response = WS.sendRequest(request)
println "... Response JSON = "+response.getResponseBodyContent()
WS.verifyResponseStatusCode(response, 200)

JsonSlurper slurper = new JsonSlurper()
String partyId = slurper.parseText(response.getResponseBodyContent()).party_org._Id
String customerId = custData.get(Fields.ORG_ID)
String url = WebUtil.generateCustomerUrl(partyId, "2", customerId, "true")

custData.put(Fields.IS_CREATED, 'true')
custData.put(Fields.ORG_PARTY_ID, partyId)
custData.put(Fields.URL, url)