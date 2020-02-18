package pages.account

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import actions.WebActions
import constants.Fields
import internal.GlobalVariable
import utils.MapUtil

public class CreateAccountPage {

	@Keyword
	static def createBankingAccount(Map<Fields, String> accData) {

		TestObject e_AccountTitle = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/input_Account Title')
		TestObject e_Ownership = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_Ownership')
		TestObject e_RelationShipType = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_RelationshipType')
		TestObject e_AccountDescription = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/input_Account Description')
		TestObject e_AccountGroup = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_Account Group')
		TestObject e_AccountNumber = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/input_Account Number')
		TestObject e_Brokered = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/checkbox_Brokered')
		TestObject e_TimeZone = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_Timezone')
		TestObject e_StatementFrequency = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_Statement Frequency')
		TestObject e_ReferenceId = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/input_ReferenceId')
		TestObject e_PaperStatement = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/checkbox_Paper Statement')

		TestObject e_ProductType = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/select_Product Type')
		TestObject e_PositionName = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/input_Position Name')
		TestObject e_ProductCode = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/input_Product Code')
		TestObject e_Currency = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/select_Currency')
		TestObject e_CreditLimit = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/input_Credit Limit')
		TestObject e_DepartmentId = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/select_Department Id')
		TestObject e_Vertical = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/select_Vertical')

		TestObject e_TC_DocumentType1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/select_Document Type 1')
		TestObject e_TC_AgreementCode1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_AgreementCode1')
		TestObject e_TC_DocumentSignedBy1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Signed By 1')
		TestObject e_TC_DocumentSignedDate1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Signed Date 1')
		TestObject e_TC_DocumentVersion1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Version 1')
		TestObject e_AddAdditionalDocument = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/link_Add Additional Document')
		TestObject e_TC_DocumentType2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/select_Document Type 2')
		TestObject e_TC_AgreementCode2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_AgreementCode2')
		TestObject e_TC_DocumentSignedBy2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Signed By 2')
		TestObject e_TC_DocumentSignedDate2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Signed Date 2')
		TestObject e_TC_DocumentVersion2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Version 2')

		TestObject e_Submit = findTestObject('Object Repository/Account/CreateAccountPage/btn_Submit')

		WebActions.waitForElementVisible(e_AccountTitle, GlobalVariable.Timeout)
		WebActions.setText(e_AccountTitle, accData, Fields.ACC_TITLE)
		WebActions.selectOptionByLabel(e_Ownership, accData, Fields.ACC_OWNERSHIP)
		WebActions.selectOptionByLabel(e_RelationShipType, accData, Fields.ACC_RELATIONSHIP_TYPE)
		WebActions.setText(e_AccountDescription, accData, Fields.ACC_DESCRIPTION)
		WebActions.selectOptionByLabel(e_AccountGroup, accData, Fields.ACC_GROUP)
		WebActions.waitForElementVisible(e_ProductType, GlobalVariable.Timeout)
		
		WebActions.check(e_Brokered, accData, Fields.ACC_BROKERED)
		WebActions.selectOptionByLabel(e_TimeZone, accData, Fields.ACC_TIMEZONE)
		WebActions.selectOptionByLabel(e_StatementFrequency, accData, Fields.ACC_STATEMENT_FREQUENCY)
		WebActions.setText(e_ReferenceId, accData, Fields.ACC_REFERENCE_ID)
		WebActions.check(e_PaperStatement, accData, Fields.ACC_PAPER_STATEMENT)

		WebActions.selectOptionByLabel(e_ProductType, accData, Fields.ACC_PRODUCT_TYPE)
		WebActions.setText(e_PositionName, accData, Fields.ACC_POSITION_NAME)
		WebActions.selectOptionByLabel(e_Currency, accData, Fields.ACC_CURRENCY_CODE)
		WebActions.setText(e_CreditLimit, accData, Fields.ACC_CREDIT_LIMIT)
		WebActions.selectOptionByLabel(e_DepartmentId, accData, Fields.ACC_DEPT_ID)
		WebActions.selectOptionByLabel(e_Vertical, accData, Fields.ACC_VERTICAL)
		
		if(WebActions.isReadonly(e_AccountNumber)) {
			String generatedAccNumber =  WebUI.getAttribute(e_AccountNumber, 'Value')
			accData.put(Fields.ACC_NUMBER, generatedAccNumber)
			println generatedAccNumber
		}
		else {
			WebActions.setText(e_AccountNumber, accData, Fields.ACC_NUMBER)
		}
		
		WebActions.selectOptionByLabel(e_TC_DocumentType1, accData, Fields.TC_DOC_TYPE1)
		WebActions.setText(e_TC_AgreementCode1, accData, Fields.TC_DOC_AGREEMENT_CODE1)
		WebActions.setText(e_TC_DocumentSignedBy1, accData, Fields.TC_DOC_SIGNED_BY1)
		WebActions.setText(e_TC_DocumentSignedDate1, accData, Fields.TC_DOC_SIGNED_DATE1, true)
		WebActions.setText(e_TC_DocumentVersion1, accData, Fields.TC_DOC_VERSION1)

		if(MapUtil.isValidData(accData, Fields.TC_DOC_TYPE2)) {

			WebActions.click(e_AddAdditionalDocument)
			WebActions.waitForElementVisible(e_TC_DocumentType2, GlobalVariable.Timeout)

			WebActions.selectOptionByLabel(e_TC_DocumentType2, accData, Fields.TC_DOC_TYPE2)
			WebActions.setText(e_TC_AgreementCode2, accData, Fields.TC_DOC_AGREEMENT_CODE2)
			WebActions.setText(e_TC_DocumentSignedBy2, accData, Fields.TC_DOC_SIGNED_BY2)
			WebActions.setText(e_TC_DocumentSignedDate2, accData, Fields.TC_DOC_SIGNED_DATE2, true)
			WebActions.setText(e_TC_DocumentVersion2, accData, Fields.TC_DOC_VERSION2)
		}

		WebActions.click(e_Submit)

		WebActions.waitForElementVisible(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Consumer Name'), GlobalVariable.Timeout)
	}
}