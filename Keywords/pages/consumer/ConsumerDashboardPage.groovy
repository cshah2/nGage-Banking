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

public class ConsumerDashboardPage {

	@Keyword
	def verifyConsumerDataOnHeaderSection(Map<Fields, String> custData) {

		String actConsumerName = WebUI.getText(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Consumer Name'))
		String actPhoneNumber = WebUI.getText(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Phone Number'))
		String actTaxId = WebUI.getText(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Tax ID'))
		String actDOB = WebUI.getText(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Date of Birth'))
		String actEmail = WebUI.getText(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Email'))
		String actAddress = WebUI.getText(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Address'))

		WebActions.verifyMatch(actConsumerName, custData.get(Fields.CUST_NAME_VIEW), Operator.EQUALS)
		WebActions.verifyMatch(actPhoneNumber, custData.get(Fields.CONTACT_PHONE_NUMBER), Operator.EQUALS)
		WebActions.verifyMatch(actTaxId, custData.get(Fields.CUST_TAX_ID_MASKED), Operator.EQUALS)
		WebActions.verifyMatch(actDOB, custData.get(Fields.CUST_DOB_MASKED), Operator.EQUALS)
		WebActions.verifyMatch(actEmail, custData.get(Fields.CONTACT_EMAIL), Operator.EQUALS)
		WebActions.verifyMatch(actAddress, custData.get(Fields.ADDR_VIEW), Operator.EQUALS)
	}
}
