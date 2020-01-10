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

import constants.Fields
import internal.GlobalVariable
import utils.WebUtil

public class ConsumerTasks {

	@Keyword
	static def addAddress(Map<Fields, String> addressData) {

		TestObject e_AddressLine1 = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine1')
		TestObject e_AddressLine2 = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine2')
		TestObject e_AddressLine3 = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine3')
		TestObject e_AddressLine4 = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine4')
		TestObject e_City = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_City')
		TestObject e_State = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/select_State')
		TestObject e_ZipCode = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_Zipcode')
		TestObject e_Country = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/select_Country')
		TestObject e_AddressType = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/select_AddressType')
		TestObject e_YearsAtAddress = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/select_YearsAtAddress')
		TestObject e_AddressLabel = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLabel')
		TestObject e_Premise = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_Premise')
		TestObject e_VerifiedDate = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_VerifiedDate')
		TestObject e_LinkSetValidDates = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/link_SetValidToAndFromDates')
		TestObject e_ValidFromDate = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_ValidFromDate')
		TestObject e_ValidUntilDate = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/input_ValidUntilDate')
		TestObject e_Submit = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Address/btn_Submit')

		WebUtil.waitForElementVisible(e_AddressLine1, GlobalVariable.Timeout)

		WebUtil.setText(e_AddressLine1, addressData, Fields.ADDR_LINE1)
		WebUtil.setText(e_AddressLine2, addressData, Fields.ADDR_LINE2)
		WebUtil.setText(e_AddressLine3, addressData, Fields.ADDR_LINE3)
		WebUtil.setText(e_AddressLine4, addressData, Fields.ADDR_LINE4)
		WebUtil.setText(e_City, addressData, Fields.ADDR_CITY)
		WebUtil.selectOptionByLabel(e_State, addressData, Fields.ADDR_STATE)
		WebUtil.setText(e_ZipCode, addressData, Fields.ADDR_ZIPCODE)
		WebUtil.selectOptionByLabel(e_Country, addressData, Fields.ADDR_COUNTY)
		WebUtil.selectOptionByLabel(e_AddressType, addressData, Fields.ADDR_TYPE)
		WebUtil.selectOptionByLabel(e_YearsAtAddress, addressData, Fields.ADDR_YEARS_AT_ADDRESS)
		WebUtil.setText(e_AddressLabel, addressData, Fields.ADDR_LABEL)
		WebUtil.setText(e_Premise, addressData, Fields.ADDR_PREMISE)
		WebUtil.setText(e_VerifiedDate, addressData, Fields.ADDR_VERIFIED_DATE, true)
		WebUtil.click(e_LinkSetValidDates)
		WebUtil.waitForElementVisible(e_ValidFromDate, GlobalVariable.Timeout)
		WebUtil.setText(e_ValidFromDate, addressData, Fields.ADDR_VALID_FROM, true)
		WebUtil.setText(e_ValidUntilDate, addressData, Fields.ADDR_VALID_UNTIL, true)

		WebUtil.click(e_Submit)
	}
	
	@Keyword
	static def addNotes() {
		
	}
}
