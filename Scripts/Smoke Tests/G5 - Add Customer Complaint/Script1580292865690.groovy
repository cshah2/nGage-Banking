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
import data.ConsumerTempData as ConsumerData

int LATEST_ROW = 1

String taskName = 'Add Customer Complaint'

String caseType = 'CMS Complaint'

Map<Fields, String> customerData = ConsumerData.CUSTOMERDATA_MAP

Map<Fields, String> custComplaintData = ConsumerData.CUST_COMPLAINT

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(customerData.get(Fields.URL))

'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

'Select Complaint Source'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_ComplaintSource'), custComplaintData.get(
        Fields.CUST_COMPLAINT_SOURCE), true)

'Select Complaint Origin'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_Origin'), custComplaintData.get(
        Fields.CUST_COMPLAINT_ORIGIN), true)

'Select Product Line'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_ProductLine'), custComplaintData.get(
        Fields.CUST_PROD_LINE), true)


'Select Product Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_ProductType'), custComplaintData.get(
		Fields.CUST_PROD_TYPE), true)


'Select Issue Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_IssueType'), custComplaintData.get(
		Fields.CUST_ISSUE_TYPE), true)


'Select Company '
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/select_Company'), custComplaintData.get(
		Fields.CUST_COMPANY), true)


'Type Complaint Summary'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/input_ComplaintSource'), "This is a demo complaint")

'Click on Launch case'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/checkbox_LaunchCase'))


'Click on Submit'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/btn_Submit'))


'Switch to tab'
WebUI.switchToWindowIndex(1)

'Get Case number  from WMI UI'
String generalInfo = WebUI.getText(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/text_GeneralCaseInfo'))
String[] genralInfoArray = generalInfo.split("\n")
String caseNumberFromGeneralInfo = genralInfoArray[0].split(":")[1]


String[]  spanText= generalInfo.split("\n")
println "Case number in WMI : "  + spanText[0]

'Verify Product Line in WMI'
TestObject selectProductLine = findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/selected_ProductLineWMI')
WebUI.verifyOptionSelectedByLabel(selectProductLine, custComplaintData.get(Fields.CUST_PROD_LINE), false, GlobalVariable.Timeout)


'Verify Product Type in WMI'
TestObject selectedProductedType = findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/selected_ProdType')
WebUI.verifyOptionSelectedByLabel(selectedProductedType, custComplaintData.get(Fields.CUST_PROD_TYPE), false, GlobalVariable.Timeout)


'Verify Issue Type in WMI'
TestObject selectedIssueType = findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/selected_IssueType')
WebUI.verifyOptionSelectedByLabel(selectedIssueType, custComplaintData.get(Fields.CUST_ISSUE_TYPE), false, GlobalVariable.Timeout)


'Verify Origin Type in WMI'
TestObject selectedOrigin = findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/selected_Origin')
WebUI.verifyOptionSelectedByLabel(selectedOrigin, custComplaintData.get(Fields.CUST_COMPLAINT_ORIGIN), false, GlobalVariable.Timeout)


'Verify User profile name'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo, GlobalVariable.UserProfileName, Operator.CONTAINS_IGNORE_CASE)

'Verify Case status'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo,"Case Status: New", Operator.CONTAINS_IGNORE_CASE)



//verify customer_Info
'Extract Customer Info from WMI'
String customerInfo = WebUI.getText(findTestObject('Consumer/ConsumerTaskDrawer/CustomerComplaint/text_CaseInfo'))

'Verify Consumer ID in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo,customerData.get(Fields.CUST_ID), Operator.CONTAINS_IGNORE_CASE)


'Verify Consumer mailid  in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo,customerData.get(Fields.CUST_MAILID), Operator.CONTAINS_IGNORE_CASE)


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

'Verify case number in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_NUMBER,
	caseNumberFromGeneralInfo.trim(), Operator.EQUALS_IGNORE_CASE)
















