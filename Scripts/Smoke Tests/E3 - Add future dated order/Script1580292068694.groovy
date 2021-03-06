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
import utils.DateUtil
import utils.MapUtil as MapUtil
import constants.Urls as Urls
import constants.ColumnPosition as ColumnPosition
import constants.Common
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData
import data.ConsumerTempData
int LATEST_ROW = 1

int WAIT_FOR_FIVE_SECONDS = 5
int SUBSTRING_DATE_START = 0
int SUBSTRING_DATE_END = 10
String CASE_TYPE = "Funds Transfer Internal"
String ORDER_STATUS = "Entered"
String taskName = "Add Order"
Map<Fields, String> customerData = ConsumerData.CUST_B
Map<Fields, String> accountData = ConsumerData.ACC_B1
Map<Fields, String> custOrderData = ConsumerTempData.ACCOUNT_BOOKTRANSFER_ORDER
//added a futur date to the map
custOrderData.put(Fields.ORDER_DATE_FUTURE, DateUtil.getCurrentDateTimePlusDays(3, Common.dateTimeFormat, Common.timezoneUTC))
TestObject scheduledTransactionsTable = findTestObject('Account/AccountTaskDrawer/AddOrder/table_Orders')
TestObject openCases = findTestObject('Account/AccountDashboardPage/CasesSection/table_OpenCases')

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(accountData.get(Fields.URL))

'Open Task Drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Add Order Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

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


'Select Account Group from Account Group DropDown'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/AddOrder/select_AccountGroup'), custOrderData.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP), true)
WebUI.delay(2)

'Type Account Number'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_AccountNum'), custOrderData.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER))


'Type Position Account Number'
WebUI.setText(findTestObject('Object Repository/Account/AccountTaskDrawer/AddOrder/input_ToAccount_PositionNum'), custOrderData.get(Fields.ORDER_COUNTERPARTY_TO_POSITION_NUMBER))


'Set Start date'
CustomKeywords.'actions.WebActions.setText'(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderStartDate'),
	custOrderData, Fields.ORDER_DATE_FUTURE, false)



'Type transfer amount'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/AddOrder/input_OrderAmt'), custOrderData.get(Fields.ORDER_TRANSFER_AMOUNT))


'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Submit'))

'verify order details for confirmation'
CustomKeywords.'pages.account.tabs.AccountOrderConfirmation.verifyOrderConfirmationDetails'(custOrderData)



'Click on Confirm Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/AddOrder/btn_Confirm'))



String alertMessage = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/alert_MoneyMovement'))
println "The message  :" + alertMessage
String [] splittedMessage = alertMessage.split(" ")
String caseNumber = splittedMessage[3]
println  "The cae number : " + caseNumber

'Verify Money Movement Case Alert Displayed'
WebUI.verifyElementVisible(findTestObject('Account/AccountTaskDrawer/AddOrder/alert_MoneyMovement'))

WebUI.delay(WAIT_FOR_FIVE_SECONDS)

'Scroll to Schedule Transactions Table'
WebUI.scrollToElement(findTestObject('Account/AccountTaskDrawer/AddOrder/div_ScheduleTransactions'), GlobalVariable.Timeout)



'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Type)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_TYPE,
	custOrderData.get(Fields.ORDER_TYPE), Operator.EQUALS_IGNORE_CASE)


'Verify Order Created  Date in Schedule Transactions Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_CREATED_DATE_IN_TRANSACTIONS,
	custOrderData.get(Fields.ORDER_CREATED_DATE).substring(SUBSTRING_DATE_START, SUBSTRING_DATE_END), Operator.EQUALS_IGNORE_CASE)


'Verify  Order Date in Schedule Transactions Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_DATE,
	custOrderData.get(Fields.ORDER_DATE_FUTURE).substring(SUBSTRING_DATE_START, SUBSTRING_DATE_END), Operator.EQUALS_IGNORE_CASE)



'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(From Account)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.FROM_ACCOUNT,
	custOrderData.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER), Operator.EQUALS_IGNORE_CASE)


'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(To Account)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.TO_ACCOUNT,
	custOrderData.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER), Operator.EQUALS_IGNORE_CASE)


'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Amount)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_AMOUNT,
	custOrderData.get(Fields.ORDER_TRANSFER_AMOUNT), Operator.EQUALS_IGNORE_CASE)


'Verify Transactions(Scheduled) Table with the updated Order Book Transfer(Order Status)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(scheduledTransactionsTable, LATEST_ROW, ColumnPosition.ORDER_STATUS,
	ORDER_STATUS, Operator.EQUALS_IGNORE_CASE)


'Click on Cases Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TabSection/tab_Cases'))



'Verify Case number in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_NUMBER,
	caseNumber, Operator.EQUALS_IGNORE_CASE)

'Verify Case Type in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_TYPE,
	CASE_TYPE, Operator.EQUALS_IGNORE_CASE)

'Verify Account Number in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.ACCOUNT_NUMBER,
	custOrderData.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER), Operator.EQUALS_IGNORE_CASE)


'Verify Order Created Date in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.ORDER_CREATED_DATE,
	custOrderData.get(Fields.ORDER_CREATED_DATE).substring(SUBSTRING_DATE_START, SUBSTRING_DATE_END), Operator.EQUALS_IGNORE_CASE)


