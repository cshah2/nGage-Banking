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
import utils.MapUtil as MapUtil
import constants.Urls as Urls
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerTempData as ConsumerData

int LATEST_ROW = 1

int WAIT_FOR_FIVE_SECONDS = 5

int SUBSTRING_DATE_START = 0

int SUBSTRING_DATE_END = 10

String ADD_ORDER_TASK = 'Add Order'

String CASE_TYPE = 'Funds Transfer Internal'

String ORDER_STATUS = 'Entered'

Map<Fields, String> customerData = ConsumerData.CUSTOMERDATA_MAP

Map<Fields, String> custOrderData = ConsumerData.ACCOUNT_BOOKTRANSFER_ORDER


TestObject scheduledTransactionsTable = findTestObject('Account/AccountTaskDrawer/AddOrder/table_Orders')

TestObject openCases = findTestObject('Account/AccountDashboardPage/CasesSection/table_OpenCases')
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(custOrderData.get(Fields.URL))

'Get Current transaction records count'
int recordCount = CustomKeywords.'actions.WebTable.getRowsCount'(scheduledTransactionsTable)

'Click on Account Task Drawer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/task_Drawer'))

'Click on Add Order Tasks'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/task_AddOrder'))

'Click on Add Order Task '
//CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/taskList', [('taskName') : ADD_ORDER_TASK]))

'Click on Order Type DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/select_OrderType'))

'Select Order type from OrderType DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/options_InSelect', [('value') : custOrderData.get(
	Fields.ORDER_TYPE)]))

'Click on Origin Source DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/select_OriginSource'))

'Select Origin Source from OriginSource DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/options_InSelect', [('value') : custOrderData.get(
	Fields.ORDER_ORIGIN_SOURCE)]))

'Click on order Source DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/select_OrderSource'))

'Select order Source from OriginSource DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/options_InSelect', [('value') : custOrderData.get(
	Fields.ORDER_SOURCE)]))

'Click on Operational area  DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/select_OperationalArea'))

'Select Operational area from OperationalArea DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/options_InSelect', [('value') : custOrderData.get(
	Fields.ORDER_OPERATIONL_AREA)]))

'Type Order Info'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderInfo'), custOrderData.get(
		Fields.ORDER_INFO))

'Type AccountTitle'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Account/AccountTaskDrawer/AddOrder/input_AccountTitle'), custOrderData.get(
		Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE))

'Click on Account Group DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/select_AccountGroup'))

'Select Account Group from Account Group DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/options_InSelect', [('value') : custOrderData.get(
	Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP)]))

'Type Account Number'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Account/AccountTaskDrawer/AddOrder/input_AccountNum'), custOrderData.get(
		Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER))

'Click on Send now Checkbox'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/checkbox_SendNow'))

'Type transfer amount'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderAmt'), custOrderData.get(
		Fields.ORDER_TRANSFER_AMOUNT))

'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Submit'))

'Click on Confirm Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Confirm'))

'Verify Money Movement Case Alert Displayed'
WebUI.verifyElementVisible(findTestObject('Account/AccountTaskDrawer/AddOrder/alert_MoneyMovement'))


String alertMessage = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/alert_MoneyMovement'))
println "The message  :" + alertMessage
String [] splittedMessage = alertMessage.split(" ")
String caseNumber = splittedMessage[3]
println  "The case number generated  : " + caseNumber

WebUI.delay(WAIT_FOR_FIVE_SECONDS)

//println('record count : ' + recordCount)


'Logout'
CustomKeywords.'actions.WebActions.logout'()

'Login with Approver 1'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('LoginPage/input_UserName'), 'cctestuser@savee.sit')

CustomKeywords.'actions.WebActions.typeText'(findTestObject('LoginPage/input_Password'), 'Password1#')

CustomKeywords.'actions.WebActions.click'(findTestObject('LoginPage/btn_Login'))

'Go to Workflow'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/LeftMenus/link_Workflow'))

'Select Process'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/dropdown_SelectProcess'))

CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/option_AccountServicing'))

'Click on Approval activities'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/activities_Approval'))

'Click on filter'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/icon_Filters'))

'Type case number'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('BasePage/WorkFlow/input_CaseNumber'), caseNumber)


WebUI.sendKeys(findTestObject('BasePage/WorkFlow/btn_Search'), Keys.chord(Keys.ENTER))

'Click on Search Button'
//CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/btn_Search'))

WebUI.waitForElementVisible(findTestObject('BasePage/Workflow/caseNumber', [('caseNumber') : caseNumber]), 30)


String routingReason = WebUI.getText(findTestObject('BasePage/WorkFlow/text_RoutingReason'))

'Verify Routing Reason'
CustomKeywords.'actions.WebActions.verifyMatch'(routingReason, "Waiting for 1st Approval", Operator.EQUALS_IGNORE_CASE)

String caseNum = WebUI.getText(findTestObject('BasePage/WorkFlow/text_CaseNumber'))

'Verify Routing Reason'
CustomKeywords.'actions.WebActions.verifyMatch'(caseNum, caseNumber, Operator.EQUALS_IGNORE_CASE)


String accNum  = WebUI.getText(findTestObject('BasePage/WorkFlow/text_AccNumber'))

/*'Verify From counter party account number '
CustomKeywords.'actions.WebActions.verifyMatch'(accNum, custOrderData.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER), Operator.EQUALS_IGNORE_CASE)
*/


'Click on case number row'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/Workflow/caseNumber', [('caseNumber') : caseNumber]))

'Switch to tab'
WebUI.switchToWindowIndex(1)

'Switch to Parent frame'
WebUI.switchToFrame(findTestObject('BasePage/WorkFlow/iframe_Container'), GlobalVariable.Timeout)

'Wait for workflow actions tab'
WebUI.waitForElementVisible(findTestObject('BasePage/WorkFlow/tab_WorkflowActions'),GlobalVariable.Timeout)

'Get Case number  from WMI UI'
String caseNumberWMI = WebUI.getText(findTestObject('BasePage/WorkFlow/text_CaseNumberWMI',[('caseNumber'):caseNumber])).split("<br />")[0]

String[]  spanText= caseNumberWMI.split("\n")
println "Case number in WMI : "  + spanText[0]
'Verify Routing Reason'
CustomKeywords.'actions.WebActions.verifyMatch'(spanText[0], caseNumber, Operator.CONTAINS_IGNORE_CASE)

'Mouser over workflow actions'
WebUI.mouseOver(findTestObject('BasePage/WorkFlow/tab_WorkflowActions'))

'click on First approver complete'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/option_FirstApproverComplete'))

'Switch to Default frame'
WebUI.switchToDefaultContent()

'click on First Close Window'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/btn_Closewindow'))

'Switch to default window'
WebUI.switchToWindowIndex(0)

'Logout'
CustomKeywords.'actions.WebActions.logout'()

'Login with Approver 2'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('LoginPage/input_UserName'), 'cclevel2@savee.sit')

'Enter aprrover 2 username'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('LoginPage/input_Password'), 'Password1#')

'Enter aprrover 2 password'
CustomKeywords.'actions.WebActions.click'(findTestObject('LoginPage/btn_Login'))

'Go to Workflow menu'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/LeftMenus/link_Workflow'))

'Select Process'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/dropdown_SelectProcess'))

'Select account servicing option'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/option_AccountServicing'))

'Click on Approval activities'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/activities_Approval'))

'Click on filter cases icon'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/icon_Filters'))

'Type case number'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('BasePage/WorkFlow/input_CaseNumber'), caseNumber)

'Press Enter after entering case number'
WebUI.sendKeys(findTestObject('BasePage/WorkFlow/btn_Search'), Keys.chord(Keys.ENTER))

'Click on Search Button'
//CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/btn_Search'))

'Wait until case number is loaded'
WebUI.waitForElementVisible(findTestObject('BasePage/Workflow/caseNumber', [('caseNumber') : caseNumber]), 30)

String routingReason2  = WebUI.getText(findTestObject('BasePage/WorkFlow/text_RoutingReason')) 

'Verify Routing Reason'
CustomKeywords.'actions.WebActions.verifyMatch'(routingReason2, "Waiting for 2nd Approval", Operator.EQUALS_IGNORE_CASE)

String caseNum2  = WebUI.getText(findTestObject('BasePage/WorkFlow/text_CaseNumber'))

'Verify Case number'
CustomKeywords.'actions.WebActions.verifyMatch'(caseNum2, caseNumber, Operator.EQUALS_IGNORE_CASE)


String accNum2  = WebUI.getText(findTestObject('BasePage/WorkFlow/text_AccNumber'))

/*'Verify From counter party account number '
CustomKeywords.'actions.WebActions.verifyMatch'(accNum2, custOrderData.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER), Operator.EQUALS_IGNORE_CASE)
*/

'Click on case number row'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/Workflow/caseNumber', [('caseNumber') : caseNumber]))

'Switch to tab'
WebUI.switchToWindowIndex(1)

'Switch to Parent Iframe in WMI'
WebUI.switchToFrame(findTestObject('BasePage/WorkFlow/iframe_Container'), GlobalVariable.Timeout)

'Wait for Workflow actions to be visible'
WebUI.waitForElementVisible(findTestObject('BasePage/WorkFlow/tab_WorkflowActions'),GlobalVariable.Timeout)


'Mouser over workflow actions'
WebUI.mouseOver(findTestObject('BasePage/WorkFlow/tab_WorkflowActions'))


'click on First approver complete'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/option_SecondApproverComplete'))

'Switch to default Content from IFrame'
WebUI.switchToDefaultContent()

'Click on Close Window tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/btn_Closewindow'))

'Login to nGage'

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Logout of the portal'
CustomKeywords.'actions.WebActions.logout'()

//CustomKeywords.'pages.LoginPage.loginIntoPortal'()
CustomKeywords.'actions.WebActions.typeText'(findTestObject('LoginPage/input_UserName'), 'cshah@savee.sit')

CustomKeywords.'actions.WebActions.typeText'(findTestObject('LoginPage/input_Password'), 'Savana1#')

CustomKeywords.'actions.WebActions.click'(findTestObject('LoginPage/btn_Login'))

'Navigaet to Account Overview'
WebUI.navigateToUrl(custOrderData.get(Fields.URL))

'Click on Orders tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TabSection/tab_Orders'))


'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Type)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_TYPE,
		custOrderData.get(Fields.ORDER_TYPE), Operator.EQUALS_IGNORE_CASE)

'Verify the order status is updated in Orders Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_STATUS,
		"Completed", Operator.EQUALS_IGNORE_CASE)












