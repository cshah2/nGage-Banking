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
String CASE_TYPE = "Disputed Transaction"
String ORDER_STATUS = "Entered"


String disputeTransactionType = "ACH"
String disputeReason = "Not Processed"
Map<Fields, String> customerData = ConsumerData.CUSTOMERDATA_MAP
Map<Fields, String> accData = ConsumerData.ACCOUNT_INTEREST_CHK
String taskName = "Post a Transaction"
TestObject transactionsTable = findTestObject('Account/AccountDashboardPage/TransactionTab/table_Transactions')





'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(accData.get(Fields.URL))





'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

'Wait for page to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/select_TransactionCode'), GlobalVariable.Timeout)

'Select Transaction code'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/select_TransactionCode'), accData.get(Fields.TXN_CODE), false)

'Wait for amount field to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/input_TransactionAmount'), GlobalVariable.Timeout)

'Enter amount value'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/input_TransactionAmount'), accData.get(Fields.TXN_AMOUNT))

'Enter description'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/input_Description'), "This is disputed transaction in future")

'Click on Submit button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/btn_Submit'))


'Click on Confirm button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/btn_Confirm'))



WebUI.delay(WAIT_FOR_FIVE_SECONDS)


'Switch to Transactions tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TabSection/tab_Transaction'))

'Click on Ellipsis on transactions'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TransactionTab/icon_OptionsTransactions'))


'Click on Ellipsis on transactions'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TransactionTab/option_DisputeTransaction'))


'Select Dispute Type'
WebUI.selectOptionByLabel(findTestObject('Account/AccountDashboardPage/TransactionTab/DisputeTransaction/select_DisputeType'), disputeTransactionType, false)

'Select Dispute Reason'
WebUI.selectOptionByLabel(findTestObject('Account/AccountDashboardPage/TransactionTab/DisputeTransaction/select_DisputeReason'), disputeReason, false)

'Get disputed amount'
String amount = WebUI.getAttribute(findTestObject('Account/AccountDashboardPage/TransactionTab/DisputeTransaction/text_DisputedAmount'),"value")

println "Disputed amount : " +amount 

'Click on Ellipsis on transactions'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TransactionTab/DisputeTransaction/btn_Submit'))


'Get text from the disputed alert message'
String disputeAlertMessage = WebUI.getText(findTestObject('Account/AccountDashboardPage/TransactionTab/DisputeTransaction/alert_DisputeMessage'))

println "The meesge : " + disputeAlertMessage

'Get case number'
String[] disputeMessage = disputeAlertMessage.split(":")
String caseNum =  disputeMessage[1]

'Click on Cases Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/TabSection/tab_Cases'))

TestObject openCases = findTestObject('Account/AccountDashboardPage/CasesSection/table_OpenCases')

'Verify Case number in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_NUMBER,
	caseNum.trim(), Operator.EQUALS_IGNORE_CASE)


'Verify Case Type in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_TYPE,
	CASE_TYPE, Operator.EQUALS_IGNORE_CASE)

'Verify Account Number in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.ACCOUNT_NUMBER,
	accData.get(Fields.ACC_NUMBER), Operator.EQUALS_IGNORE_CASE)


'Verify Order Status Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.CASE_STATUS,
	"New", Operator.EQUALS_IGNORE_CASE)

'Verify Order Created Date in Open cases Tab'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(openCases, LATEST_ROW, ColumnPosition.ORDER_CREATED_DATE,
	accData.get(Fields.ORDER_CREATED_DATE).substring(SUBSTRING_DATE_START, SUBSTRING_DATE_END), Operator.EQUALS_IGNORE_CASE)






























