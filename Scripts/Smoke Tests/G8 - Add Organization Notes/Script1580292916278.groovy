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
import data.OrganizationData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil
import constants.ColumnPosition
import constants.Urls as Urls
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData as ConsumerData

int CLOSED_CASES_LATEST_ROW = 1
int WAIT_FOR_TEN_SECONDS =10
String notes  = "Ravi has viewed Organization  Info"
Map<Fields, String> orgData = OrganizationData.ORG_B

TestObject notesTable = findTestObject('Consumer/ConsumerDashBoardPage/NotesSection/table_Notes')

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(orgData.get(Fields.URL))


'Click on Task Drawer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/task_Drawer'))

'Select Add Notes'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Notes/task_AddNotes'))

'Type Notes'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Notes/input_Notes'),notes)

'Click On Submit'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Notes/btn_Submit'))

'Verfiy the element popup is displayed as case created for address update'
WebUI.verifyElementPresent(findTestObject('Consumer/ConsumerDashBoardPage/NotesSection/message_EmailUpdateAlert'),GlobalVariable.Timeout, FailureHandling.STOP_ON_FAILURE)

'Wait for notes to get updated'
WebUI.delay(WAIT_FOR_TEN_SECONDS)

'Click on Contact Details Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Notes'))

'Verify the notes is added to the notes table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(notesTable,CLOSED_CASES_LATEST_ROW, ColumnPosition.NOTES,notes, Operator.EQUALS)

'Verify the notes created by username'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(notesTable,CLOSED_CASES_LATEST_ROW, ColumnPosition.NOTES_CREATED_BY, GlobalVariable.UserProfileName, Operator.EQUALS)


