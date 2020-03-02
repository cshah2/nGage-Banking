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

 int CLOSED_CASES_LATEST_ROW = 1
Map<Fields, String> customerData = ConsumerData.CUST_B

TestObject emailTable = findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/EmailAddress/table_EmailAddress')

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(customerData.get(Fields.URL))

'Click on Contact Details Tab'
WebUI.click(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/tab_ContactDetails'))

'Click on Edit Email address Icon'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/EmailAddress/icon_EditEmail'))

'Clear email address'
WebUI.clearText(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/EmailAddress/input_Email'))

'Type the emailaddress to update'
WebUI.setText(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/EmailAddress/input_Email'),customerData.get(Fields.CONTACT_EMAIL))


'Select Email Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/select_EmailType'), customerData.get(Fields.CONTACT_EMAIL_TYPE), false)



'Click on Link Valid From Date'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/link_SetValidToAndFromDates'))
 
'Set Valid From Text'
CustomKeywords.'actions.WebActions.setText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ValidFromDate'), customerData, Fields.ADDR_VALID_FROM, false)

'Set Valid Till Text'
CustomKeywords.'actions.WebActions.setText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ValidUntilDate'), customerData, Fields.ADDR_VALID_UNTIL, false)

/*'Scroll to Submit'
WebUI.scrollToElement(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/btn_Submit'), GlobalVariable.Timeout)
*/
'Click On Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Email/btn_Submit'))


'Verify Updated Alert Message'
WebUI.verifyElementVisible(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/EmailAddress/message_EmailUpdated'))

'Verify the EmailAddress updated in Emailaddress Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(emailTable,CLOSED_CASES_LATEST_ROW, ColumnPosition.EMAIL_ADDRESS, customerData.get(Fields.CONTACT_EMAIL), Operator.EQUALS)