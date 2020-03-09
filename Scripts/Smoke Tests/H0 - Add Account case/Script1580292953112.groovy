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
import internal.GlobalVariable as GlobalVariable
import data.ConsumerData as ConsumerData

int LATEST_ROW = 1
String taskName = "Add Account Service Case"
String caseType = "Beneficial Owner"
Map<Fields, String> accData = ConsumerData.ACC_B1

Map<Fields, String> customerData = ConsumerData.CUST_B


'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(accData.get(Fields.URL))


'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)


'Select CaseType'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/CaseSection/select_CaseType'), caseType, true)


'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerCase/AddCase/btn_Submit'))


'Switch to tab'
WebUI.switchToWindowIndex(1)


/*WebUI.waitForElementPresent(findTestObject('BasePage/WorkFlow/text_GeneralInfoforCase'), GlobalVariable.Timeout)

'Extract General case information block from WMI UI'
String generalInfo = WebUI.getText(findTestObject('BasePage/WorkFlow/text_GeneralInfoforCase'))
println "Case info :" + generalInfo
*/

/*String[] genralInfoArray = generalInfo.split("\n")
String caseNumberFromGeneralInfo = genralInfoArray[0].split(":")[1]*/

/*'Verify Case type value in WMI'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('BasePage/WorkFlow/text_CaseType')), caseType, Operator.EQUALS)

'Verify User profile name in General case information block'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo, GlobalVariable.UserProfileName, Operator.CONTAINS_IGNORE_CASE)

'Verify Case status in General case information block'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo,"Case Status: New", Operator.CONTAINS_IGNORE_CASE)
*/


//verify customer info

'Extract Customer Info from WMI'
String customerInfo = WebUI.getText(findTestObject('BasePage/WorkFlow/text_ConsumerInfo'))

'Verify Consumer ID in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo,customerData.get(Fields.CUST_ID), Operator.CONTAINS_IGNORE_CASE)


'Verify Consumer first name  in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo,customerData.get(Fields.CUST_FIRST_NAME), Operator.CONTAINS_IGNORE_CASE)

'Verify Consumer Account Number  in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo,accData.get(Fields.ACC_NUMBER), Operator.CONTAINS_IGNORE_CASE)



'Switch to Default frame'
WebUI.switchToDefaultContent()

'click on First Close Window'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/btn_Closewindow'))

'Switch to default window'
WebUI.switchToWindowIndex(0)

'Close task drawer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/CaseSection/div_CloseAction'))

'Click on Cases Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TabSection/tab_Cases'))

'Table for open cases'
TestObject openCases = findTestObject('Account/AccountDashboardPage/CasesSection/table_OpenCases')

'Verify Case Type in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_TYPE,
	caseType, Operator.EQUALS_IGNORE_CASE)

'Verify case status in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_STATUS,
	"New", Operator.EQUALS_IGNORE_CASE)


/*'Verify case status in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_NUMBER,
	caseNumberFromGeneralInfo.trim(), Operator.EQUALS_IGNORE_CASE)
*/

