import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.swing.Icon

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
import constants.Operator as Operator
import data.ConsumerTempData as ConsumerData
import constants.Icon

int LATEST_ROW = 1

int WAIT_FOR_FIVE_SECONDS = 5

int SUBSTRING_DATE_START = 0

int SUBSTRING_DATE_END = 10

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


'Select OrderType'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Account/AccountTaskDrawer/AddOrder/select_OrderType'), custOrderData.get(Fields.ORDER_TYPE), true)

'Select Origin Source from OriginSource DropDown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Account/AccountTaskDrawer/AddOrder/select_OriginSource'), custOrderData.get(Fields.ORDER_ORIGIN_SOURCE), true)

'Select order Source from OriginSource DropDown'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/AddOrder/select_OrderSource'), custOrderData.get(Fields.ORDER_SOURCE), true)

'Select Operational area from OperationalArea DropDown'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/AddOrder/select_OperationalArea'), custOrderData.get(Fields.ORDER_OPERATIONL_AREA), true)

'Type Order Info'
//WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderInfo'), custOrderData.get(Fields.ORDER_INFO))

'Type AccountTitle'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_AccountTitle'), custOrderData.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE))


'Select Account Group from Account Group DropDown'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/AddOrder/select_AccountGroup'), custOrderData.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP), true)
WebUI.delay(2)

'Type Account Number'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_AccountNum'), custOrderData.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER))

'Click on Send now Checkbox'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/checkbox_SendNow'))

'Type transfer amount'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderAmt'), custOrderData.get(Fields.ORDER_TRANSFER_AMOUNT))


'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Submit'))

//Verify Order details
CustomKeywords.'pages.account.tabs.AccountOrderConfirmation.verifyOrderConfirmationDetails'(custOrderData)


'Click on Confirm Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Confirm'))

'Scroll to Transactions Table'
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Account/AccountTaskDrawer/AddOrder/div_ScheduleTransactions'), 30)
Point p = element.getLocation()

WebUI.scrollToPosition(p.x-200, p.y-200)


//CustomKeywords.'actions.WebTable.clickIconInTable'(scheduledTransactionsTable, LATEST_ROW, WAIT_FOR_FIVE_SECONDS, Icon.ELLIPSIS)


'click on edit ellipsis of first row'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Account/AccountTaskDrawer/ScheduledTransactions/icon_OrderOptions'))

'click on edit Order Option of first row'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Account/AccountTaskDrawer/ScheduledTransactions/option_EditOrder'))

WebUI.maximizeWindow()

'Click on Send now Checkbox'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Account/AccountTaskDrawer/AddOrder/checkbox_SendNow'))

'Clear transfer amount'
WebUI.clearText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderAmt'))

'Type transfer amount'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderAmt'), custOrderData.get(
        Fields.ORDER_TRANSFER_AMOUNT))

'Click on Submit Button'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Submit'))

'Click on Confirm Button'
CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Confirm'))

'Verify Money Movement Case Alert Displayed'
WebUI.verifyElementVisible(findTestObject('Account/AccountTaskDrawer/AddOrder/alert_EditOrder'))

'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Amount)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_AMOUNT, 
    custOrderData.get(Fields.ORDER_TRANSFER_AMOUNT), Operator.EQUALS_IGNORE_CASE)

'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Status)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_STATUS, 
    ORDER_STATUS, Operator.EQUALS_IGNORE_CASE)