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
import data.ConsumerData
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

Map<Fields, String> custData =  ConsumerData.CUST_B
Map<Fields, String> accData = ConsumerData.ACC_B1

WebUtil.shouldFailTest(custData)

RequestObject request = findTestObject('Object Repository/API/createBankingAccount',
		[
			('consumerId'):custData.get(Fields.CUST_ID),
			('acctNbr'):accData.get(Fields.ACC_NUMBER),
			('acctTitle'):accData.get(Fields.ACC_TITLE),
			('acctOwnership'):accData.get(Fields.ACC_OWNERSHIP),
			('desc'):accData.get(Fields.ACC_DESCRIPTION),
			('posnName'):accData.get(Fields.ACC_POSITION_NAME),
			('prodCode'):accData.get(Fields.ACC_PRODUCT_CODE),
		]
	)

println "... Request JSON for account = "+request.getHttpBody()
ResponseObject response = WS.sendRequest(request)
println "... Response JSON = "+response.getResponseBodyContent()
WS.verifyResponseStatusCode(response, 200)



JsonSlurper slurper = new JsonSlurper()
String positionId = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_depDtl[0].posn_dep._Id
String customerId = custData.get(Fields.CUST_ID)
String partyId = custData.get(Fields.CUST_PARTY_ID)
String accNumber = accData.get(Fields.ACC_NUMBER)

String url = WebUtil.generateAccountUrl(partyId, "1", accNumber, positionId, "2", customerId, "false")
println "url = "+url

accData.put(Fields.IS_CREATED, 'true')
accData.put(Fields.URL, url)
accData.put(Fields.ACC_POSITION_ID, positionId)