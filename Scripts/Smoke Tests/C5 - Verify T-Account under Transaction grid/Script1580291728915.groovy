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
//WebUI.callTestCase(findTestCase('Test Cases/Smoke Tests/C1 - Post a transaction for Banking Account (Credit)'), null)
//WebUI.callTestCase(findTestCase('Test Cases/Smoke Tests/C2 - Post a transaction for Banking Account (Debit)'), null)

Map<Fields, String> custData = ConsumerData.CUST_B
Map<Fields, String> accData = ConsumerData.ACC_B1
Map<Fields, String> txnData = ConsumerData.ACC_B1_TXNB


WebUtil.shouldFailTest(custData)
WebUtil.shouldFailTest(accData)
WebUtil.shouldFailTest(txnData)

TestObject txnTable = findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/table_Transactions')
TestObject tAccountTable = findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/DetailSection/T-Account/table_TAccountData')

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

'Expand Transaction Details section'
CustomKeywords.'actions.WebTable.clickIconInTable'(txnTable, 1, 1, Icon.DOUBLE_ARROW)
//CustomKeywords.'actions.WebTable.clickDetailsIcon'(txnTable, 1, 1)

'Wait for T-Account accordion to be visible'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/DetailSection/accordion_TAccount'), GlobalVariable.Timeout)

'Click on T-Account accordion'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/DetailSection/accordion_TAccount'))

'Wait for T-Account section to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tAccountTable, GlobalVariable.Timeout)

'Verify T-Account table has 2 rows'
CustomKeywords.'actions.WebTable.verifyRowsCountMatches'(tAccountTable, 2, Operator.EQUALS)

Map<Fields, String> glTxn1 = new HashMap<Fields, String>()
glTxn1.put(Fields.GL_SEQ, '1')
glTxn1.put(Fields.TXN_TYPE, 'Debit')
glTxn1.put(Fields.GL_CLASS, 'posn_dep')
glTxn1.put(Fields.TXN_AMOUNT, String.format("%,.2f",Double.parseDouble(txnData.get(Fields.TXN_AMOUNT))))
glTxn1.put(Fields.ACC_NUMBER, txnData.get(Fields.ACC_NUMBER))
glTxn1.put(Fields.GL_NUMBER, '20110')
glTxn1.put(Fields.GL_CATEGORY, 'L')
glTxn1.put(Fields.GL_NAME, 'Personal Savings <100K')

'Verify T-Account information for first row'
CustomKeywords.'pages.account.tabs.AccountTransactionTab.verifyTAccountIformation'(1, glTxn1)

Map<Fields, String> glTxn2 = new HashMap<Fields, String>()
glTxn2.put(Fields.GL_SEQ, '2')
glTxn2.put(Fields.TXN_TYPE, 'Credit')
glTxn2.put(Fields.GL_CLASS, 'posn_gl')
glTxn2.put(Fields.TXN_AMOUNT, String.format("%,.2f",Double.parseDouble(txnData.get(Fields.TXN_AMOUNT))))
glTxn2.put(Fields.ACC_NUMBER, '57670')
glTxn2.put(Fields.GL_NUMBER, '57670')
glTxn2.put(Fields.GL_CATEGORY, 'E')
glTxn2.put(Fields.GL_NAME, 'Misc Exp')

'Verify T-Account information for first row'
CustomKeywords.'pages.account.tabs.AccountTransactionTab.verifyTAccountIformation'(2, glTxn2)