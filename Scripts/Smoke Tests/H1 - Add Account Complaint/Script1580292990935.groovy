import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData as ConsumerData

int LATEST_ROW = 1

String taskName = 'Add Account Complaint'

String caseType = 'CMS Complaint'


String CUST_COMPLAINT_SOURCE =  "DOJ"
String CUST_COMPLAINT_ORIGIN = "Back Office"
String CUST_PROD_TYPE =  "Auto debt"
String CUST_ISSUE_TYPE =  "Account opening, closing or management"
String CUST_PROD_LINE =  "Bank account or service"
String CUST_COMPANY =  "Demo Company"

Map<Fields, String> customerData = ConsumerData.CUST_B

Map<Fields, String> accData = ConsumerData.ACC_B1


'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To Account dashboard'
WebUI.navigateToUrl(accData.get(Fields.URL))

'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

'Select Complaint Source'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_ComplaintSource'), CUST_COMPLAINT_SOURCE, true)

'Select Complaint Origin'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_Origin'),CUST_COMPLAINT_ORIGIN, true)

'Select Product Line'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_ProductLine'), CUST_PROD_LINE, true)


'Select Product Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_ProductType'), CUST_PROD_TYPE, true)


'Select Issue Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_IssueType'), CUST_ISSUE_TYPE, true)


'Select Company '
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_Company'), CUST_COMPANY, true)


'Type Complaint Summary'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/input_ComplaintSource'), "This is a demo complaint")

'Click on Launch case'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/checkbox_LaunchCase'))


'Click on Submit'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/btn_Submit'))


'Switch to tab'
WebUI.switchToWindowIndex(1)

/*'Wait for 2 seconds'
WebUI.waitForElementVisible(findTestObject('BasePage/WorkFlow/text_GeneralCaseInfo'),GlobalVariable.Timeout)

'Get Case number  from WMI UI'
String generalInfo = WebUI.getText(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/text_GeneralCaseInfo'))
String[] genralInfoArray = generalInfo.split("\n")
String caseNumberFromGeneralInfo = genralInfoArray[0].split(":")[1]


String[]  spanText= generalInfo.split("\n")
println "Case number in WMI : "  + spanText[0]*/

'Verify Product Line in WMI'
TestObject selectProductLine = findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/selected_ProductLineWMI')
WebUI.verifyOptionSelectedByLabel(selectProductLine, CUST_PROD_LINE, false, GlobalVariable.Timeout)


'Verify Product Type in WMI'
TestObject selectedProductedType = findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/selected_ProdType')
WebUI.verifyOptionSelectedByLabel(selectedProductedType,CUST_PROD_TYPE, false, GlobalVariable.Timeout)


'Verify Issue Type in WMI'
TestObject selectedIssueType = findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/selected_IssueType')
WebUI.verifyOptionSelectedByLabel(selectedIssueType, CUST_ISSUE_TYPE, false, GlobalVariable.Timeout)


'Verify Origin Type in WMI'
TestObject selectedOrigin = findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/selected_Origin')
WebUI.verifyOptionSelectedByLabel(selectedOrigin, CUST_COMPLAINT_ORIGIN, false, GlobalVariable.Timeout)

/*
'Verify User profile name'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo, GlobalVariable.UserProfileName, Operator.CONTAINS_IGNORE_CASE)

'Verify Case status'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo,"Case Status: New", Operator.CONTAINS_IGNORE_CASE)
*/

//verify customer_Info
'Extract Customer Info from WMI'
String customerInfo = WebUI.getText(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/text_CaseInfo'))

'Verify Consumer ID in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo,customerData.get(Fields.CUST_ID), Operator.CONTAINS_IGNORE_CASE)


'Verify Consumer first name  in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo,customerData.get(Fields.CUST_FIRST_NAME), Operator.CONTAINS_IGNORE_CASE)



'Switch to Default frame'
WebUI.switchToDefaultContent()

'click on First Close Window'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/btn_Closewindow'))

'Switch to default window'
WebUI.switchToWindowIndex(0)


'Click on Cases Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TabSection/tab_Cases'))

'Open cases table'
TestObject openCases = findTestObject('Account/AccountDashboardPage/CasesSection/table_OpenCases')

'Verify Case Type in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_TYPE,
	caseType, Operator.EQUALS_IGNORE_CASE)

'Verify case status in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_STATUS,
	"New", Operator.EQUALS_IGNORE_CASE)

/*'Verify case number in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_NUMBER,
	caseNumberFromGeneralInfo.trim(), Operator.EQUALS_IGNORE_CASE)
*/

'Verify Account number in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.ACCOUNT_NUMBER,
	accData.get(Fields.ACC_NUMBER), Operator.EQUALS_IGNORE_CASE)
