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
import utils.MapUtil
import utils.WebUtil
import constants.Urls as Urls
import constants.ColumnPosition
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData as ConsumerData

Map<Fields, String> customerData = ConsumerData.CUST_B


TestObject casesTable = findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/PhoneNumberBlock/table_PhoneNumber')

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(customerData.get(Fields.URL))

'Click on Contact Details Tab'
WebUI.click(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/tab_ContactDetails'))

WebUI.delay(3)

'Click on Edit Phone Number Tab'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/PhoneNumberBlock/icon_EditPhoneNo'))

'Clear Phone Number'
WebUI.clearText(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/PhoneNumberBlock/input_PhoneNumber'))


'Type Phone Number'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/PhoneNumberBlock/input_PhoneNumber'), customerData.get(
		Fields.CONTACT_PHONE_NUMBER))


'Click on Phone Type Dropdown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/PhoneNumberBlock/select_PhoneType'))

'Select phone Type'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/PhoneNumberBlock/options_PhoneType', [('phoneType') : customerData.get(
				Fields.CONTACT_PHONE_TYPE)]))

'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/PhoneNumberBlock/button_Submit'))

'Wait for 20 seconds'
WebUI.delay(20)

'Verify the Phone number is updated in PhoneNumber Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(casesTable,ColumnPosition.OPEN_CASE_LATEST_ROW, ColumnPosition.PHONE_NUMBER, customerData.get(Fields.CONTACT_PHONE_NUMBER), Operator.EQUALS)



