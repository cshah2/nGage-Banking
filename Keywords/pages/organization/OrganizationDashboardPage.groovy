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

import actions.WebActions
import constants.Fields
import constants.Operator
import internal.GlobalVariable

public class OrganizationDashboardPage {

	@Keyword
	def verifyOrganizationDataOnHeaderSection(Map<Fields, String> orgData) {

		String actOrganizationName = WebUI.getText(findTestObject('Object Repository/Organization/OrganizationDashboardPage/HeaderSection/text_Organization Name'))
		String actDbaName = WebUI.getText(findTestObject('Object Repository/Organization/OrganizationDashboardPage/HeaderSection/text_DBA Name'))
		String actTaxId = WebUI.getText(findTestObject('Object Repository/Organization/OrganizationDashboardPage/HeaderSection/text_Tax ID'))
		String actEstablishedDate = WebUI.getText(findTestObject('Object Repository/Organization/OrganizationDashboardPage/HeaderSection/text_Established Date'))
		String actAddress = WebUI.getText(findTestObject('Object Repository/Organization/OrganizationDashboardPage/HeaderSection/text_Address'))

		WebActions.verifyMatch(actOrganizationName, orgData.get(Fields.ORG_NAME), Operator.EQUALS)
		WebActions.verifyMatch(actDbaName, orgData.get(Fields.ORG_DBA_NAME), Operator.EQUALS)
		WebActions.verifyMatch(actTaxId, orgData.get(Fields.ORG_TAX_ID_MASKED), Operator.EQUALS)
		WebActions.verifyMatch(actEstablishedDate, orgData.get(Fields.ORG_ESTABLISHED_DATE), Operator.EQUALS)
		//WebActions.verifyMatch(actAddress, orgData.get(Fields.ADDR_VIEW), Operator.EQUALS)
	}
}
