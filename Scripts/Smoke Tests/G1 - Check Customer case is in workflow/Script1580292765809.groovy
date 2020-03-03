import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.ColumnPosition
import constants.Fields
import constants.Operator
import constants.TableType
import internal.GlobalVariable as GlobalVariable
import data.ConsumerData as ConsumerData

int LATEST_ROW = 1
String taskName = "Add Customer Service Case"
String caseType = "Name Update"
String NEW_CASE_STATUS = "New"
Map<Fields, String> customerData = ConsumerData.CUST_B

//TestObject openCases = findTestObject('Account/AccountDashboardPage/CasesSection/table_OpenCases')

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(customerData.get(Fields.URL))


'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)



'Select Case Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerCase/AddCase/select_CaseType'), caseType, false)


'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerCase/AddCase/btn_Submit'))


'Switch to tab'
WebUI.switchToWindowIndex(1)

'Wait for workflow actions tab'
WebUI.waitForElementVisible(findTestObject('BasePage/WorkFlow/tab_WorkflowActions'),GlobalVariable.Timeout)

'Get Case number  from WMI UI'
String generalInfo = WebUI.getText(findTestObject('BasePage/WorkFlow/text_GeneralCaseInfo'))


'Get Case Tyep   from WMI UI'
String caseTypeInWMI = WebUI.getText(findTestObject('BasePage/WorkFlow/text_CaseType'))

String[]  spanText= generalInfo.split("\n")
println "Case number in WMI : "  + spanText[0]
String[] caseInfo = spanText[0].split(":")
String caseNumberGenerated = caseInfo[1]


caseNumberGenerated = caseNumberGenerated.replaceAll("\\s+", "")
println "The WMI case number we got : " + caseNumberGenerated
'Verify Routing Reason'
CustomKeywords.'actions.WebActions.verifyMatch'(caseTypeInWMI, caseType, Operator.EQUALS)

'Verify User profile name'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo, GlobalVariable.UserProfileName, Operator.CONTAINS_IGNORE_CASE)

'Verify Case status'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo,NEW_CASE_STATUS, Operator.CONTAINS_IGNORE_CASE)


'Switch to Default frame'
WebUI.switchToDefaultContent()

'click on First Close Window'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/btn_Closewindow'))

'Switch to default window'
WebUI.switchToWindowIndex(0)


'Click on Cases Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TabSection/tab_Cases'))

TestObject openCases = findTestObject('Account/AccountDashboardPage/CasesSection/table_OpenCases')


'Verify Case Type in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_TYPE,
	caseType, Operator.EQUALS_IGNORE_CASE)

'Verify case status in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_STATUS,
	"New", Operator.EQUALS_IGNORE_CASE)


'Go to Workflow'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/LeftMenus/link_Workflow'))

'Select Process'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/dropdown_SelectProcess'))

CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/option_AccountServicing'))

'Click on Approval activities'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/activities_Entry'))

'Click on filter'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/icon_Filters'))

'Type case number'
WebUI.setText(findTestObject('BasePage/WorkFlow/input_CaseNumber'), caseNumberGenerated)

'Wait for 2 seconds'
WebUI.delay(2)


'Click on Search Button'
WebUI.sendKeys(findTestObject('BasePage/WorkFlow/input_CaseNumber'), Keys.chord(Keys.ENTER))



//WebUI.waitForElementVisible(findTestObject('BasePage/Workflow/caseNumber', [('caseNumber') : caseNumberGenerated]), 30)

WebUI.delay(2)
String caseNum= WebUI.getText(findTestObject('BasePage/WorkFlow/text_CaseNumber'))
println " The Actual case Num : " + caseNum
println " The case Num expected : " + caseNumberGenerated.replaceAll("\\s+", "")

//TestObject tableCases = findTestObject('BasePage/WorkFlow/table_SearchCases')

'Verify Routing Reason'
CustomKeywords.'actions.WebActions.verifyMatch'(caseNum,caseNumberGenerated.replaceAll("\\s+", ""), Operator.EQUALS_IGNORE_CASE)


