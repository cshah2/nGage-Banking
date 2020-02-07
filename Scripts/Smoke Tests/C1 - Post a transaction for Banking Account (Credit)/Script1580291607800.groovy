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

import constants.ColumnPosition
import constants.Fields
import constants.Operator
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

//WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A0 - Create Consumer'), null)
//WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A1 - Create Personal Savings Account'), null)

Map<Fields, String> custData = ConsumerData.CUST_B
Map<Fields, String> accData = ConsumerData.ACC_B1

WebUtil.shouldFailTest(custData)
WebUtil.shouldFailTest(accData)

TestObject txnTable = findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/table_Transactions')
String taskName = "Post a Transaction"
String transactionCode = 'Savings Deposit Cash'
String amount = '50000'
String amountView = '50,000.00'
String description = 'Credit transaction for savings account'
String ledgerBalanceBefore
String ledgerBalanceAfter
String availableBalanceBefore 
String availableBalanceAfter  

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate to account dashboard page'
WebUI.navigateToUrl(accData.get(Fields.URL))

'Click on Transaction tab'
CustomKeywords.'pages.account.tabs.AccountTransactionTab.clickTransactionTab'()

'Get Current transaction records count'
int recordCount = CustomKeywords.'actions.WebTable.getRowsCount'(txnTable)

'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

'Wait for page to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/select_TransactionCode'), GlobalVariable.Timeout)

'Select Transaction code'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/select_TransactionCode'), transactionCode, false)

'Wait for amount field to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/input_TransactionAmount'), GlobalVariable.Timeout)

'Enter amount value'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/input_TransactionAmount'), amount)

'Enter description'
WebUI.setText(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/input_Description'), description)

'Click on Submit button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountTaskDrawer/PostTransaction/InputPage/btn_Submit'))

'Wait for review page to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_TransactionCode'), GlobalVariable.Timeout)

'Verify Transaction code value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_TransactionCode')), transactionCode, Operator.EQUALS)

'Verify amount value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_TransactionAmount')), amountView, Operator.EQUALS)

'Get Current ledgerBalance'
ledgerBalanceBefore = WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_LedgerBalanceBefore'))

'Calculate ledger balance after'
ledgerBalanceAfter = String.valueOf(String.format("%,.2f",Double.parseDouble(ledgerBalanceBefore.replaceAll(',', '')) + Double.parseDouble(amountView.replaceAll(',', ''))))

'Verify ledger balance after'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_LedgerBalanceAfter')), ledgerBalanceAfter, Operator.EQUALS)

'Get Current AvailableBalance'
availableBalanceBefore = WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_AvailableBalanceBefore'))

'Calculate available balance after'
availableBalanceAfter = String.valueOf(String.format("%,.2f", Double.parseDouble(availableBalanceBefore.replaceAll(',', '')) + Double.parseDouble(amountView.replaceAll(',', ''))))

'Verify available balance after'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_AvailableBalanceAfter')), availableBalanceAfter, Operator.EQUALS)

'Click on Confirm button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/btn_Confirm'))

'Wait for taskdrawer to close'
CustomKeywords.'pages.taskdrawer.TaskDrawer.waitForTaskDrawerToClose'()

'Wait for record to get added in transactiont table'
CustomKeywords.'actions.WebTable.waitUntilRowsCountMatches'(txnTable, recordCount+1, Operator.EQUALS, GlobalVariable.Timeout)

int rowNo =  1

'Verify data in transaction table - transaction type'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(txnTable, rowNo, ColumnPosition.TXN_CODE, transactionCode, Operator.EQUALS)

'Verify data in transaction table - debit amount'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(txnTable, rowNo, ColumnPosition.TXN_DEBIT_AMOUNT, '', Operator.EQUALS)

'Verify data in transaction table - credit amount'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(txnTable, rowNo, ColumnPosition.TXN_CREDIT_AMOUNT, amountView, Operator.EQUALS)

'Verify data in transaction table - ending balance'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(txnTable, rowNo, ColumnPosition.TXN_BALANCE, availableBalanceAfter, Operator.EQUALS)

'Verify data in transaction table - description'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(txnTable, rowNo, ColumnPosition.TXN_DESCRIPTION, description, Operator.EQUALS)