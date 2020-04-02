import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

import constants.Common
import constants.Fields
import data.ConsumerData
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil
import utils.WebUtil

Map<Fields, String> custData =  ConsumerData.CUST_B
String dobIso = DateUtil.convert(new Date(custData.get(Fields.CUST_DOB)), Common.dateFormatISO)



RequestObject request = findTestObject('API/createConsumer',
		[
			('customerId'):custData.get(Fields.CUST_ID), 
			('taxId'):custData.get(Fields.CUST_TAX_ID), 
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
			('familiarName'):custData.get(Fields.CUST_FAMILIAR_NAME),
			('lastName'):custData.get(Fields.CUST_LAST_NAME),
			('firstName'):custData.get(Fields.CUST_FIRST_NAME),
			('middleName'):custData.get(Fields.CUST_MIDDLE_NAME),
			('maidenName'):custData.get(Fields.CUST_MAIDEN_NAME),
			('motherMaidenName'):custData.get(Fields.CUST_MOTHERS_MAIDEN_NAME),
			('prefix'):custData.get(Fields.CUST_PREFIX),
			('suffix'):custData.get(Fields.CUST_SUFFIX),
			('website'):custData.get(Fields.CUST_WEB_ADDRESS),
			('phone'):custData.get(Fields.CONTACT_PHONE_NUMBER),
			('phoneValidFrom'):custData.get(Fields.CONTACT_PHONE_VALID_FROM),
			('phoneValidUntil'):custData.get(Fields.CONTACT_PHONE_VALID_UNTIL),
			('phoneVerifiedDate'):custData.get(Fields.CONTACT_PHONE_VERIFIED_DATE),
			('dob'):dobIso,
		]
	)

println "... Request JSON = "+request.getHttpBody()
ResponseObject response = WS.sendRequest(request)
println "... Response JSON = "+response.getResponseBodyContent()
WS.verifyResponseStatusCode(response, 200)

JsonSlurper slurper = new JsonSlurper()
String partyId = slurper.parseText(response.getResponseBodyContent()).party_person._Id
String customerId = custData.get(Fields.CUST_ID)
String url = WebUtil.generateCustomerUrl(partyId, "2", customerId, "false")

String profile = RunConfiguration.getExecutionProfile()
println "The profile is : " + profile

//String url = WebUtil.generateCustomerUrlApollo(partyId, "2", customerId, "NewCECustomerCreate")

custData.put(Fields.IS_CREATED, 'true')
custData.put(Fields.CUST_PARTY_ID, partyId)
custData.put(Fields.URL, url)