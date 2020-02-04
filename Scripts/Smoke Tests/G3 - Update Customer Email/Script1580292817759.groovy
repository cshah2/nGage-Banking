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
import internal.GlobalVariable as GlobalVariable

import constants.ColumnPosition
import constants.Fields
import constants.Operator
import constants.Urls
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.MapUtil

Map<Fields, String> customerData = ConsumerData.CUSTOMERDATA_MAP

Map<Fields, String> customerAddress = ConsumerData.ADDR_A

'Load browser'
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)

'Verify usname is displayed on page header section'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/text_LoggedInUserName')),
	GlobalVariable.UserProfileName, Operator.EQUALS_IGNORE_CASE)

'Search a Customer'

'Search a Customer in SearchConstumer Page with Customer ID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_CustomerID'), customerData.get(
		Fields.CUST_ID))

'Click on Search Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Click on Tasks'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/task_Drawer'))

'Select Add Email Address'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/add_EmailTask'))

'Type EmailID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/input_Email'), customerData.get(
	Fields.CUST_MAILID))

'Click On Select EmailType'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/select_EmailType'))

'Select EmailType'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/option_EmailType',[('emailType'): customerData.get(Fields.CUST_MAILIDTYPE)]))

'Click on ValidFromDate'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/input_ValidFromDate'))

'Click On Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/btn_Submit'))

'Logout of nGage Bank'
CustomKeywords.'actions.WebActions.logout'()
