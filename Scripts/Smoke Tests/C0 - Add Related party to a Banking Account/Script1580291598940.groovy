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
import constants.Operator
import data.ConsumerData
import data.OrganizationData
import internal.GlobalVariable as GlobalVariable
import utils.MapUtil
import utils.WebUtil

Map<Fields, String> custData = ConsumerData.CUST_B
Map<Fields, String> accData = ConsumerData.ACC_B1
Map<Fields, String> orgData = OrganizationData.ORG_B

WebUtil.shouldFailTest(custData)
WebUtil.shouldFailTest(orgData)
WebUtil.shouldFailTest(accData)

TestObject table = findTestObject('Object Repository/Account/AccountDashboardPage/DetailsTab/table_RelatedParty')
String taskName = 'Add Related Party'
String relationshipType = 'Power of attorney'
String orgName = orgData.get(Fields.ORG_NAME)
String description = 'Attach related party to an account'
String priority = '1'


'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate to account dashboard page'
WebUI.navigateToUrl(accData.get(Fields.URL))

'Click on details tab'
WebUI.click(findTestObject('Object Repository/Account/AccountDashboardPage/TabSection/tab_Details'))

'Wait for details tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountDashboardPage/DetailsTab/block_AccountDetails'), GlobalVariable.Timeout)

'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

'Click on Add Related party link'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountDashboardPage/DetailsTab/icon_AddRelatedParty'))

'Select Radio option organization'
WebUI.check(findTestObject('Object Repository/Account/AccountTaskDrawer/AddRelatedParty/radio_Organization'))

'Wait for Organization search field to be visible'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountTaskDrawer/AddRelatedParty/input_OrganizationName'), GlobalVariable.Timeout)

'Enter organization name as search criteria'
WebUI.setText(findTestObject('Object Repository/Account/AccountTaskDrawer/AddRelatedParty/input_OrganizationName'), orgName)

WebUI.delay(3)

'Select party in drop down'
WebUI.selectOptionByIndex(findTestObject('Object Repository/Account/AccountTaskDrawer/AddRelatedParty/select_Party'), 1)

/*'Enter description'
WebUI.setText(findTestObject('Object Repository/Account/AccountTaskDrawer/AddRelatedParty/input_Description'), description)

'Enter Priority'
WebUI.setText(findTestObject('Object Repository/Account/AccountTaskDrawer/AddRelatedParty/input_Priority'), priority)*/

'Click on Submit button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountTaskDrawer/AddRelatedParty/btn_Submit'))

'Wait for Task drawer to close'
CustomKeywords.'pages.taskdrawer.TaskDrawer.waitForTaskDrawerToClose'()

'Wait until record count is updated in Add relationship type table'
CustomKeywords.'actions.WebTable.waitUntilRowsCountMatches'(table, 2, Operator.EQUALS, GlobalVariable.Timeout)

int rowNo = 2
//Verify data in table

'Scroll to Table'
CustomKeywords.'actions.WebActions.scrollToElement'(table, GlobalVariable.Timeout)

'Verify party name in table'
CustomKeywords.'actions.WebTable.verifyCellValueContains'(table, 2, orgName, Operator.CONTAINS_IGNORE_CASE)


'Verify relaionsip type value in table'
CustomKeywords.'actions.WebTable.verifyCellValueContains'(table, 3, relationshipType, Operator.CONTAINS_IGNORE_CASE)
