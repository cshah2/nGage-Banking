
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Point
import org.openqa.selenium.WebElement

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import utils.MapUtil as MapUtil
import utils.WebUtil as WebUtil
import constants.Urls as Urls
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Icon
import constants.Operator as Operator
import data.ConsumerTempData as ConsumerData

int LATEST_ROW = 1

int WAIT_FOR_FIVE_SECONDS = 5

int SUBSTRING_DATE_START = 0

int SUBSTRING_DATE_END = 10

int ELLIPSIS_COLNUM = 11

String CASE_TYPE = 'Funds Transfer Internal'

String ORDER_STATUS = 'Entered'

String taskName = "Add Order"

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

println('The rows count: ' + recordCount)


'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

'Wait for Task to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountTaskDrawer/AddOrder/select_OrderType'), GlobalVariable.Timeout)

'Click on Account Task Drawer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/task_Drawer'))

'Click on Add Order Tasks'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/task_AddOrder'))

'Select OrderType'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Account/AccountTaskDrawer/AddOrder/select_OrderType'), custOrderData.get(Fields.ORDER_TYPE), true)

'Select Origin Source from OriginSource DropDown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Account/AccountTaskDrawer/AddOrder/select_OriginSource'), custOrderData.get(Fields.ORDER_ORIGIN_SOURCE), true)

'Select order Source from OriginSource DropDown'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/AddOrder/select_OrderSource'), custOrderData.get(Fields.ORDER_SOURCE), true)

'Select Operational area from OperationalArea DropDown'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/AddOrder/select_OperationalArea'), custOrderData.get(Fields.ORDER_OPERATIONL_AREA), true)


'Type Order Info'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderInfo'), custOrderData.get(Fields.ORDER_INFO))

'Type AccountTitle'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_AccountTitle'), custOrderData.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE))


'Click on Account Group DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/select_AccountGroup'))


'Select Account Group from Account Group DropDown'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/options_InSelect',[('value'):custOrderData.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP)]))

'Type Account Number'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_AccountNum'), custOrderData.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER))


'Set Start date'
CustomKeywords.'actions.WebActions.setText'(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderStartDate'),
	custOrderData, Fields.ORDER_DATE_FUTURE, true)


'Type transfer amount'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderAmt'), custOrderData.get(Fields.ORDER_TRANSFER_AMOUNT))


'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Submit'))


'Verify order details'
CustomKeywords.'pages.account.tabs.AccountOrderConfirmation.verifyOrderConfirmationDetails'(custOrderData)


'Click on Confirm Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Confirm'))

'Wait for 30 seconds'
WebUI.delay(20)

'Scroll to Tchedule transactions table'
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Account/AccountTaskDrawer/AddOrder/div_ScheduleTransactions'), 30)
Point p = element.getLocation()

WebUI.scrollToPosition(p.x-200, p.y-200)

'click on edit ellipsis of first row'
CustomKeywords.'actions.WebTable.clickIconInTable'(scheduledTransactionsTable, LATEST_ROW, ELLIPSIS_COLNUM, Icon.ELLIPSIS)

'click on Cancel Order Option of first row'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Account/AccountTaskDrawer/ScheduledTransactions/option_CancelOrder'))

'click on edit Order Option of first row'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Submit'))

'Maximize Window'
WebUI.maximizeWindow()


'Verify Money Movement Case Alert Displayed'
WebUI.verifyElementVisible(findTestObject('Account/AccountTaskDrawer/AddOrder/alert_CancelOrder'))


'Click on Orders Tab'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Account/AccountDashboardPage/TabSection/tab_Orders'))


TestObject ordersTable = findTestObject('Account/AccountDashboardPage/OrdersTab/table_Orders')

'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Status)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(ordersTable, LATEST_ROW, ColumnPosition.ORDER_STATUS,
	"Canceled", Operator.EQUALS_IGNORE_CASE)

'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Status)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(ordersTable, LATEST_ROW, ColumnPosition.ORDER_TYPE,
	custOrderData.get(Fields.ORDER_TYPE), Operator.EQUALS_IGNORE_CASE)

'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Status)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(ordersTable, LATEST_ROW, ColumnPosition.ORDER_DATE,
	custOrderData.get(Fields.ORDER_DATE_FUTURE).substring(SUBSTRING_DATE_START, SUBSTRING_DATE_END), Operator.EQUALS_IGNORE_CASE)

