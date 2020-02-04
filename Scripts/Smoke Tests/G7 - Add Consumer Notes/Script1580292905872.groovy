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

import constants.Fields
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil
import constants.Urls as Urls
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData as ConsumerData


Map<Fields, String> customerData = ConsumerData.CUSTOMERDATA_MAP

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)

'Verify usname is displayed on page header section'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/text_LoggedInUserName')),
	GlobalVariable.UserProfileName, Operator.EQUALS_IGNORE_CASE)


'Search a Customer in SearchConstumer Page with Customer ID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_CustomerID'), customerData.get(
		Fields.CUST_ID))

'Click On Serach'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Click on Task Drawer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/task_Drawer'))

'Select Add Notes'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Notes/task_AddNotes'))

'Type Notes'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Notes/input_Notes'), customerData.get(
	Fields.CUST_NOTES))

'Click On Submit'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Notes/btn_Submit'))

'Verfiy the element popup is displayed as case created for address update'
WebUI.verifyElementPresent(findTestObject('Consumer/ConsumerTaskDrawer/Customer Notes/emailUpdateAlert'),GlobalVariable.Timeout, FailureHandling.STOP_ON_FAILURE)


'Logout of nGage Bank'
CustomKeywords.'actions.WebActions.logout'()

