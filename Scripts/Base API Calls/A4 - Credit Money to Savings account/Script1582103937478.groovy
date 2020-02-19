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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject

import constants.Fields
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

Map<Fields, String> custData =  ConsumerData.CUST_B
Map<Fields, String> accData = ConsumerData.ACC_B1

WebUtil.shouldFailTest(custData)
WebUtil.shouldFailTest(accData)


RequestObject request = findTestObject('Object Repository/API/postTransaction',
	[
		('acctGroup'):1,
		('acctNbr'):accData.get(Fields.ACC_NUMBER),
		('comment'):'Credit 50k to account',
		('isDr0'):false,
		('isDr1'):true,
		('posnAcctNbr'):accData.get(Fields.ACC_NUMBER),
		('posnId'):accData.get(Fields.ACC_POSITION_ID),
		('trnAmt'):50000,
		('trnCode'):138,
	]
)

println "... Request JSON = "+request.getHttpBody()
ResponseObject response = WS.sendRequest(request)
println "... Response JSON = "+response.getResponseBodyContent()
WS.verifyResponseStatusCode(response, 200)


