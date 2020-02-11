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
import constants.Icon
import constants.Operator
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

//WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A0 - Create Consumer'), null)
//WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A1 - Create Personal Savings Account'), null)

Map<Fields, String> custData = ConsumerData.CUST_B
Map<Fields, String> accData = ConsumerData.ACC_B1
Map<Fields, String> txnData = ConsumerData.ACC_B1_TXNC

WebUtil.shouldFailTest(custData)
WebUtil.shouldFailTest(accData)

TestObject txnTable = findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/table_Transactions')
String taskName = "Post a Transaction"
String transactionCode = txnData.get(Fields.TXN_CODE)
String amount = txnData.get(Fields.TXN_AMOUNT)
String amountView = String.format("%,.2f", Double.parseDouble(txnData.get(Fields.TXN_AMOUNT)))
String description = txnData.get(Fields.TXN_COMMENT)
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
txnData.put(Fields.ACC_LEDGER_BALANCE_BEFORE, ledgerBalanceBefore)

'Calculate ledger balance after'
ledgerBalanceAfter = String.format("%,.2f",Double.parseDouble(ledgerBalanceBefore.replaceAll(',', '')) + Double.parseDouble(amountView.replaceAll(',', '')))
txnData.put(Fields.ACC_LEDGER_BALANCE, ledgerBalanceAfter)

'Verify ledger balance after'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_LedgerBalanceAfter')), ledgerBalanceAfter, Operator.EQUALS)

'Get Current AvailableBalance'
availableBalanceBefore = WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_AvailableBalanceBefore'))
txnData.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, availableBalanceBefore)

'Calculate available balance after'
availableBalanceAfter = String.valueOf(String.format("%,.2f", Double.parseDouble(availableBalanceBefore.replaceAll(',', '')) + Double.parseDouble(amountView.replaceAll(',', ''))))
txnData.put(Fields.ACC_AVAILABLE_BALANCE, availableBalanceAfter)

'Verify available balance after'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/PostTransaction/ConfirmPage/text_AvailableBalanceAfter')), availableBalanceAfter, Operator.EQUALS)

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

'Click on Ellipsis icon next to transaction record in table'
CustomKeywords.'actions.WebTable.clickIconInTable'(txnTable, rowNo, 11, Icon.ELLIPSIS)

'Wait for Context Menu to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/block_ContextMenu'), GlobalVariable.Timeout)

'Click on Reverse Transaction'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/link_ContextMenu_ReverseTransaction'))

'Wait for Task drawert to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/text_TransactionCode'), GlobalVariable.Timeout)

Map<Fields, String> reverseTxn = new HashMap<Fields, String>()
reverseTxn.put(Fields.TXN_AMOUNT, "-"+txnData.get(Fields.TXN_AMOUNT))
reverseTxn.put(Fields.TXN_COMMENT, txnData.get(Fields.TXN_COMMENT))
reverseTxn.put(Fields.TXN_TYPE, 'Credit')
reverseTxn.put(Fields.TXN_CODE, 'Reversal')

'Verify Transaction code value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/text_TransactionCode')), transactionCode, Operator.CONTAINS)

'Verify amount value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/text_TransactionAmount')), amountView, Operator.EQUALS)

'Get Current ledgerBalance'
ledgerBalanceBeforeRev = WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/text_LedgerBalanceBefore'))
reverseTxn.put(Fields.ACC_LEDGER_BALANCE_BEFORE, ledgerBalanceBeforeRev)

'Calculate ledger balance after'
ledgerBalanceAfterRev = String.format("%,.2f",Double.parseDouble(ledgerBalanceBeforeRev.replaceAll(',', '')) - Double.parseDouble(amountView.replaceAll(',', '')))
reverseTxn.put(Fields.ACC_LEDGER_BALANCE, ledgerBalanceAfterRev)

'Verify ledger balance after'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/text_LedgerBalanceAfter')), ledgerBalanceAfterRev, Operator.EQUALS)

'Get Current AvailableBalance'
availableBalanceBeforeRev = WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/text_AvailableBalanceBefore'))
reverseTxn.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, availableBalanceBeforeRev)

'Calculate available balance after'
availableBalanceAfterRev = String.valueOf(String.format("%,.2f", Double.parseDouble(availableBalanceBeforeRev.replaceAll(',', '')) - Double.parseDouble(amountView.replaceAll(',', ''))))
reverseTxn.put(Fields.ACC_AVAILABLE_BALANCE, availableBalanceAfterRev)

'Verify available balance after'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/text_AvailableBalanceAfter')), availableBalanceAfterRev, Operator.EQUALS)

'Verify Comments value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/text_Comment')), description, Operator.CONTAINS)

'Set Note value'
WebUI.setText(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/input_Note'), 'Reverse a Transaction')

'Click on Submit button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountTaskDrawer/ReviewTransaction/btn_Submit'))

'Wait for taskdrawer to close'
CustomKeywords.'pages.taskdrawer.TaskDrawer.waitForTaskDrawerToClose'()

'Wait for record to get added in transactiont table'
CustomKeywords.'actions.WebTable.waitUntilRowsCountMatches'(txnTable, recordCount+2, Operator.EQUALS, GlobalVariable.Timeout)

'Verify Data in transaction table'
CustomKeywords.'pages.account.tabs.AccountTransactionTab.verifyTransactionDataInTable'(rowNo, reverseTxn)

