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

import constants.Fields
import constants.Operator
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A0 - Create Consumer'), null)
WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A1 - Create Personal Savings Account'), null)
WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A2 - Create Multi-Position account'), null)

Map<Fields, String> custData = ConsumerData.CUST_B
Map<Fields, String> sourceAccData = ConsumerData.ACC_B2_POS5
Map<Fields, String> destAccData = ConsumerData.ACC_B1
Map<Fields, String> txnData = ConsumerData.ACC_B2_POS5_TXNA

WebUtil.shouldFailTest(custData)
WebUtil.shouldFailTest(sourceAccData)
WebUtil.shouldFailTest(destAccData)

TestObject txnTable = findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/table_Transactions')
String taskName = "Post a Transaction"
String transactionCode = txnData.get(Fields.TXN_CODE)
String amount = txnData.get(Fields.TXN_AMOUNT)
String amountView = String.format("%,.2f", Double.parseDouble(txnData.get(Fields.TXN_AMOUNT)))
String description = txnData.get(Fields.TXN_COMMENT)
String source_ledgerBalanceBefore
String source_ledgerBalanceAfter
String source_availableBalanceBefore
String source_availableBalanceAfter
String dest_ledgerBalanceBefore
String dest_ledgerBalanceAfter
String dest_availableBalanceBefore
String dest_availableBalanceAfter

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate to account dashboard page of destination account'
WebUI.navigateToUrl(destAccData.get(Fields.URL))

'Store Ledger balance of Destination account'
dest_LedgerBalanceBefore = WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/text_LedgerBalance'))

'Store Available balance of Destination account'
dest_AvailableBalanceBefore = WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/text_AvailableBalance'))

'Navigate to account dashboard page of source account'
WebUI.navigateToUrl(sourceAccData.get(Fields.URL))

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

'Enter Amount'
WebUI.setText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/InputPage/input_TransactionAmount'), txnData.get(Fields.TXN_AMOUNT))

'Enter To Account Number'
WebUI.setText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/InputPage/input_ToAccount'), destAccData.get(Fields.ACC_NUMBER))

'Selct To Account Group'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/InputPage/select_ToAccountGroup'), destAccData.get(Fields.ACC_GROUP), false)

'Enter Transaction description'
WebUI.setText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/InputPage/input_Description'), txnData.get(Fields.TXN_COMMENT))

'Click on Submit button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/InputPage/btn_Submit'))

'Wait for review page to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_TransactionCode'), GlobalVariable.Timeout)

'Verify Transaction code value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_TransactionCode')), transactionCode, Operator.EQUALS)

'Verify amount value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_TransactionAmount')), amountView, Operator.EQUALS)

'Get Current ledgerBalance'
source_ledgerBalanceBefore = WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_LedgerBalanceBefore'))
txnData.put(Fields.ACC_LEDGER_BALANCE_BEFORE, source_ledgerBalanceBefore)

'Calculate ledger balance after'
source_ledgerBalanceAfter = String.format("%,.2f",Double.parseDouble(source_ledgerBalanceBefore.replaceAll(',', '')) + Double.parseDouble(amountView.replaceAll(',', '')))
txnData.put(Fields.ACC_LEDGER_BALANCE, source_ledgerBalanceAfter)

'Verify ledger balance after'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_LedgerBalanceAfter')), source_ledgerBalanceAfter, Operator.EQUALS)

'Get Current AvailableBalance'
source_availableBalanceBefore = WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_AvailableBalanceBefore'))
txnData.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, source_availableBalanceBefore)

'Calculate available balance after'
source_availableBalanceAfter = String.valueOf(String.format("%,.2f", Double.parseDouble(source_availableBalanceBefore.replaceAll(',', '')) - Double.parseDouble(amountView.replaceAll(',', ''))))
txnData.put(Fields.ACC_AVAILABLE_BALANCE, source_availableBalanceAfter)

'Verify available balance after'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_AvailableBalanceAfter')), source_availableBalanceAfter, Operator.EQUALS)

'Click on Confirm button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/btn_Confirm'))

'Wait for taskdrawer to close'
CustomKeywords.'pages.taskdrawer.TaskDrawer.waitForTaskDrawerToClose'()

'Wait for record to get added in transactiont table'
CustomKeywords.'actions.WebTable.waitUntilRowsCountMatches'(txnTable, recordCount+1, Operator.EQUALS, GlobalVariable.Timeout)

int rowNo =  1

'Verify Data in transaction table'
CustomKeywords.'pages.account.tabs.AccountTransactionTab.verifyTransactionDataInTable'(rowNo, txnData)

txnData.put(Fields.IS_CREATED, "true")

'Click on Overview tab'
WebUI.click(findTestObject('Object Repository/Account/AccountDashboardPage/TabSection/tab_Overview'))

'Wait for page to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/Loan/text_LedgerBalance'), GlobalVariable.Timeout)

'Verify Ledger balance value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/Loan/text_LedgerBalance')), source_ledgerBalanceAfter, Operator.EQUALS)

'Verify Available balance value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/Loan/text_AvailableBalance')), source_availableBalanceAfter, Operator.EQUALS)

'Navigate to account dashboard page of destination account'
WebUI.navigateToUrl(destAccData.get(Fields.URL))

'Calculate Ledger balance of Destination account after transction'
dest_ledgerBalanceAfter = String.valueOf(String.format("%,.2f", Double.parseDouble(dest_LedgerBalanceBefore.replaceAll(',', '')) + Double.parseDouble(amountView.replaceAll(',', ''))))

'Calculate Available balance of Destination account after transction'
dest_availableBalanceAfter = String.valueOf(String.format("%,.2f", Double.parseDouble(dest_AvailableBalanceBefore.replaceAll(',', '')) + Double.parseDouble(amountView.replaceAll(',', ''))))

'Verify Ledger balance after transaction in destination account'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/text_LedgerBalance')), dest_ledgerBalanceAfter, Operator.EQUALS)

'Verify Available balance after transaction in destination account'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/text_AvailableBalance')), dest_availableBalanceAfter, Operator.EQUALS)
