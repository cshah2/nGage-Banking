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
Map<Fields, String> accDataPos1 = ConsumerData.ACC_B2_POS1
Map<Fields, String> accDataPos2 = ConsumerData.ACC_B2_POS2
Map<Fields, String> accDataPos3 = ConsumerData.ACC_B2_POS3
Map<Fields, String> accDataPos4 = ConsumerData.ACC_B2_POS4
Map<Fields, String> accDataPos5 = ConsumerData.ACC_B2_POS5

Map<Fields, String> accDataPos6 = ConsumerData.ACC_B2_POS6

WebUtil.shouldFailTest(custData)

RequestObject request = findTestObject('Object Repository/API/createMultiPositionAccount',
		[
			('consumerId'):custData.get(Fields.CUST_ID),
			('acctNbr'):accDataPos1.get(Fields.ACC_NUMBER),
			('acctTitle'):accDataPos1.get(Fields.ACC_TITLE),
			('acctOwnership'):accDataPos1.get(Fields.ACC_OWNERSHIP),
			('desc'):accDataPos1.get(Fields.ACC_DESCRIPTION),
			('posnName'):accDataPos1.get(Fields.ACC_POSITION_NAME),
			('prodCode'):accDataPos1.get(Fields.ACC_PRODUCT_CODE),
			('posnName2'):accDataPos2.get(Fields.ACC_POSITION_NAME),
			('prodCode2'):accDataPos2.get(Fields.ACC_PRODUCT_CODE),
			('posnName3'):accDataPos3.get(Fields.ACC_POSITION_NAME),
			('prodCode3'):accDataPos3.get(Fields.ACC_PRODUCT_CODE),
			('posnName4'):accDataPos4.get(Fields.ACC_POSITION_NAME),
			('prodCode4'):accDataPos4.get(Fields.ACC_PRODUCT_CODE),
			('credLimit4'):accDataPos4.get(Fields.ACC_CREDIT_LIMIT),
			('posnName5'):accDataPos5.get(Fields.ACC_POSITION_NAME),
			('prodCode5'):accDataPos5.get(Fields.ACC_PRODUCT_CODE),
			('credLimit5'):accDataPos5.get(Fields.ACC_CREDIT_LIMIT),
			('posnName6'):accDataPos6.get(Fields.ACC_POSITION_NAME),
			('prodCode6'):accDataPos6.get(Fields.ACC_PRODUCT_CODE),
			('credLimit6'):accDataPos6.get(Fields.ACC_CREDIT_LIMIT)
		]
	)

println "... Request JSON = "+request.getHttpBody()
ResponseObject response = WS.sendRequest(request)
println "... Response JSON = "+response.getResponseBodyContent()
WS.verifyResponseStatusCode(response, 200)

JsonSlurper slurper = new JsonSlurper()
String positionId1 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_depDtl[0].posn_dep._Id
String positionId2 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_depDtl[1].posn_dep._Id
String positionId3 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_depDtl[2].posn_dep._Id
String positionId4 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_lnDtl[0].posn_ln._Id
String positionId5 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_lnDtl[1].posn_ln._Id
String positionId6 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_lnDtl[2].posn_ln._Id


String positionNo1 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_depDtl[0].posn_dep.posnAcctNbr
String positionNo2 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_depDtl[1].posn_dep.posnAcctNbr
String positionNo3 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_depDtl[2].posn_dep.posnAcctNbr
String positionNo4 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_lnDtl[0].posn_ln.posnAcctNbr
String positionNo5 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_lnDtl[1].posn_ln.posnAcctNbr
String positionNo6 = slurper.parseText(response.getResponseBodyContent()).createdAccounts[0].posn_lnDtl[2].posn_ln.posnAcctNbr


String customerId = custData.get(Fields.CUST_ID)
String partyId = custData.get(Fields.CUST_PARTY_ID)
String accNumber = accDataPos1.get(Fields.ACC_NUMBER)

String urlPosition1 = WebUtil.generateAccountUrl(partyId, "3", accNumber, positionId1, "2", customerId, "false")
String urlPosition2 = WebUtil.generateAccountUrl(partyId, "3", accNumber, positionId2, "2", customerId, "false")
String urlPosition3 = WebUtil.generateAccountUrl(partyId, "3", accNumber, positionId3, "2", customerId, "false")
String urlPosition4 = WebUtil.generateAccountUrl(partyId, "3", accNumber, positionId4, "2", customerId, "false")
String urlPosition5 = WebUtil.generateAccountUrl(partyId, "3", accNumber, positionId5, "2", customerId, "false")
String urlPosition6 = WebUtil.generateAccountUrl(partyId, "3", accNumber, positionId6, "2", customerId, "false")

accDataPos1.put(Fields.IS_CREATED, 'true')
accDataPos2.put(Fields.IS_CREATED, 'true')
accDataPos3.put(Fields.IS_CREATED, 'true')
accDataPos4.put(Fields.IS_CREATED, 'true')
accDataPos5.put(Fields.IS_CREATED, 'true')
accDataPos6.put(Fields.IS_CREATED, 'true')

accDataPos1.put(Fields.URL, urlPosition1)
accDataPos2.put(Fields.URL, urlPosition2)
accDataPos3.put(Fields.URL, urlPosition3)
accDataPos4.put(Fields.URL, urlPosition4)
accDataPos5.put(Fields.URL, urlPosition5)
accDataPos6.put(Fields.URL, urlPosition6)

accDataPos1.put(Fields.ACC_POSITION_ID, positionId1)
accDataPos2.put(Fields.ACC_POSITION_ID, positionId2)
accDataPos3.put(Fields.ACC_POSITION_ID, positionId3)
accDataPos4.put(Fields.ACC_POSITION_ID, positionId4)
accDataPos5.put(Fields.ACC_POSITION_ID, positionId5)
accDataPos6.put(Fields.ACC_POSITION_ID, positionId6)

accDataPos1.put(Fields.ACC_POSITION_NUMBER, positionNo1)
accDataPos2.put(Fields.ACC_POSITION_NUMBER, positionNo2)
accDataPos3.put(Fields.ACC_POSITION_NUMBER, positionNo3)
accDataPos4.put(Fields.ACC_POSITION_NUMBER, positionNo4)
accDataPos5.put(Fields.ACC_POSITION_NUMBER, positionNo5)
accDataPos6.put(Fields.ACC_POSITION_NUMBER, positionNo6)

