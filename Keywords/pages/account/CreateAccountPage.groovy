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

import constants.Fields
import internal.GlobalVariable
import utils.MapUtil
import utils.WebUtil

public class CreateAccountPage {

	@Keyword
	static def createBankingAccount(Map<Fields, String> accData) {

		TestObject e_AccountTitle = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/input_Account Title')
		TestObject e_Ownership = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_Ownership')
		TestObject e_AccountDescription = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/input_Account Description')
		TestObject e_AccountGroup = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_Account Group')
		TestObject e_AccountNumber = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/input_Account Number')
		TestObject e_Brokered = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/checkbox_Brokered')
		TestObject e_TimeZone = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_Timezone')
		TestObject e_StatementFrequency = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/select_Statement Frequency')
		TestObject e_PaperStatement = findTestObject('Object Repository/Account/CreateAccountPage/BasicInformation/checkbox_Paper Statement')

		TestObject e_ProductType = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/select_Product Type')
		TestObject e_PositionName = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/input_Position Name')
		TestObject e_ProductCode = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/input_Product Code')
		TestObject e_Currency = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/select_Currency')
		TestObject e_CreditLimit = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/input_Credit Limit')
		TestObject e_DepartmentId = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/select_Department Id')
		TestObject e_Vertical = findTestObject('Object Repository/Account/CreateAccountPage/ProductInformation/Banking/select_Vertical')

		TestObject e_TC_DocumentType1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/select_Document Type 1')
		TestObject e_TC_DocumentSignedBy1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Signed By 1')
		TestObject e_TC_DocumentSignedDate1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Signed Date 1')
		TestObject e_TC_DocumentVersion1 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Version 1')
		TestObject e_AddAdditionalDocument = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/link_Add Additional Document')
		TestObject e_TC_DocumentType2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/select_Document Type 2')
		TestObject e_TC_DocumentSignedBy2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Signed By 2')
		TestObject e_TC_DocumentSignedDate2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Signed Date 2')
		TestObject e_TC_DocumentVersion2 = findTestObject('Object Repository/Account/CreateAccountPage/DocumentInformation/input_Version 2')

		TestObject e_Submit = findTestObject('Object Repository/Account/CreateAccountPage/btn_Submit')

		WebUtil.waitForElementVisible(e_AccountTitle, GlobalVariable.Timeout)
		WebUtil.setText(e_AccountTitle, accData, Fields.ACC_TITLE)
		WebUtil.selectOptionByLabel(e_Ownership, accData, Fields.ACC_OWNERSHIP)
		WebUtil.setText(e_AccountDescription, accData, Fields.ACC_DESCRIPTION)
		WebUtil.selectOptionByLabel(e_AccountGroup, accData, Fields.ACC_GROUP)
		WebUtil.waitForElementVisible(e_ProductType, GlobalVariable.Timeout)
		
		WebUtil.check(e_Brokered, accData, Fields.ACC_BROKERED)
		WebUtil.selectOptionByLabel(e_TimeZone, accData, Fields.ACC_TIMEZONE)
		WebUtil.selectOptionByLabel(e_StatementFrequency, accData, Fields.ACC_STATEMENT_FREQUENCY)
		WebUtil.check(e_PaperStatement, accData, Fields.ACC_PAPER_STATEMENT)

		WebUtil.selectOptionByLabel(e_ProductType, accData, Fields.ACC_PRODUCT_TYPE)
		WebUtil.setText(e_PositionName, accData, Fields.ACC_POSITION_NAME)
		WebUtil.selectOptionByLabel(e_Currency, accData, Fields.ACC_CURRENCY_CODE)
		WebUtil.setText(e_CreditLimit, accData, Fields.ACC_CREDIT_LIMIT)
		WebUtil.selectOptionByLabel(e_DepartmentId, accData, Fields.ACC_DEPT_ID)
		WebUtil.selectOptionByLabel(e_Vertical, accData, Fields.ACC_VERTICAL)
		
		if(WebUtil.isReadonly(e_AccountNumber)) {
			String generatedAccNumber =  WebUI.getAttribute(e_AccountNumber, 'Value')
			accData.put(Fields.ACC_NUMBER, generatedAccNumber)
			println generatedAccNumber
		}
		else {
			WebUtil.setText(e_AccountNumber, accData, Fields.ACC_NUMBER)
		}
		
		WebUtil.selectOptionByLabel(e_TC_DocumentType1, accData, Fields.TC_DOC_TYPE1)
		WebUtil.setText(e_TC_DocumentSignedBy1, accData, Fields.TC_DOC_SIGNED_BY1)
		WebUtil.setText(e_TC_DocumentSignedDate1, accData, Fields.TC_DOC_SIGNED_DATE1, true)
		WebUtil.setText(e_TC_DocumentVersion1, accData, Fields.TC_DOC_VERSION1)

		if(MapUtil.isValidData(accData, Fields.TC_DOC_TYPE2)) {

			WebUtil.click(e_AddAdditionalDocument)
			WebUtil.waitForElementVisible(e_TC_DocumentType2, GlobalVariable.Timeout)

			WebUtil.selectOptionByLabel(e_TC_DocumentType2, accData, Fields.TC_DOC_TYPE2)
			WebUtil.setText(e_TC_DocumentSignedBy2, accData, Fields.TC_DOC_SIGNED_BY2)
			WebUtil.setText(e_TC_DocumentSignedDate2, accData, Fields.TC_DOC_SIGNED_DATE2, true)
			WebUtil.setText(e_TC_DocumentVersion2, accData, Fields.TC_DOC_VERSION2)
		}

		WebUtil.click(e_Submit)

		WebUtil.waitForElementVisible(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/HeaderSection/text_Consumer Name'), GlobalVariable.Timeout)
	}
}