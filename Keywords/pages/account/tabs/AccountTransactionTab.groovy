package pages.account.tabs

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import actions.WebActions
import actions.WebTable
import constants.ColumnPosition
import constants.Fields
import constants.Operator
import internal.GlobalVariable

public class AccountTransactionTab {

	@Keyword
	static def clickTransactionTab() {
		WebUI.click(findTestObject('Object Repository/Account/AccountDashboardPage/TabSection/tab_Transaction'))
		WebActions.waitForElementVisible(findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/table_Transactions'), GlobalVariable.Timeout)
	}
	
	@Keyword
	static def verifyTransactionDataInTable(int rowNo, Map<Fields, String> txnData) {
		
		TestObject txnTable = findTestObject('Object Repository/Account/AccountDashboardPage/TransactionTab/table_Transactions')
		String amountView = String.format('%,.2f',Double.parseDouble(txnData.get(Fields.TXN_AMOUNT)))
		
		'Verify data in transaction table - transaction type'
		WebTable.verifyCellValueMatches(txnTable, rowNo, ColumnPosition.TXN_CODE, txnData.get(Fields.TXN_CODE), Operator.EQUALS)
		
		if(txnData.get(Fields.TXN_TYPE).equalsIgnoreCase('Credit')) {
			'Verify data in transaction table - debit amount'
			WebTable.verifyCellValueMatches(txnTable, rowNo, ColumnPosition.TXN_DEBIT_AMOUNT, '', Operator.EQUALS)
			
			'Verify data in transaction table - credit amount'
			WebTable.verifyCellValueMatches(txnTable, rowNo, ColumnPosition.TXN_CREDIT_AMOUNT, amountView, Operator.EQUALS)
		}
		else {
			'Verify data in transaction table - debit amount'
			WebTable.verifyCellValueMatches(txnTable, rowNo, ColumnPosition.TXN_DEBIT_AMOUNT, amountView, Operator.EQUALS)
			
			'Verify data in transaction table - credit amount'
			WebTable.verifyCellValueMatches(txnTable, rowNo, ColumnPosition.TXN_CREDIT_AMOUNT, '', Operator.EQUALS)
		}
		
		'Verify data in transaction table - ending balance'
		WebTable.verifyCellValueMatches(txnTable, rowNo, ColumnPosition.TXN_BALANCE, txnData.get(Fields.ACC_AVAILABLE_BALANCE), Operator.EQUALS)
		
		'Verify data in transaction table - description'
		WebTable.verifyCellValueMatches(txnTable, rowNo, ColumnPosition.TXN_DESCRIPTION, txnData.get(Fields.TXN_COMMENT), Operator.EQUALS)
	}	
}
