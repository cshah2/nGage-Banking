package pages.consumer.tabs

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
import constants.Fields
import constants.Operator
import internal.GlobalVariable
import utils.MapUtil

public class ConsumerAccountsTab {


	@Keyword
	def clickAccountsTab() {
		WebActions.click(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Accounts'))
		WebActions.waitForElementVisible(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/AccountsTab/table_BankingAccounts'), GlobalVariable.Timeout)
	}

	@Keyword
	def verifyBankingAccountInformation(Map<Fields, String> accData, int rowNo) {

		TestObject table = findTestObject('Object Repository/Consumer/ConsumerDashboardPage/AccountsTab/table_BankingAccounts')
		WebTable.verifyCellValueMatches(table, rowNo, 1, accData.get(Fields.ACC_NUMBER), Operator.EQUALS)
		WebTable.verifyCellValueMatches(table, rowNo, 4, accData.get(Fields.ACC_OWNERSHIP), Operator.EQUALS)
		WebTable.verifyCellValueMatches(table, rowNo, 5, accData.get(Fields.ACC_RELATIONSHIP_TYPE), Operator.EQUALS)
	}
	
	
	
	@Keyword
	def verifyMPAccountInformation(Map<Fields, String> accData, int rowNo) {
		MapUtil.printMap(accData)
		
		
		println "The account number : " + accData.get(Fields.ACC_NUMBER)
		WebActions.click(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Accounts'))
		WebActions.waitForElementVisible(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/AccountsTab/table_MPAccounts'), GlobalVariable.Timeout)
		TestObject table = findTestObject('Object Repository/Consumer/ConsumerDashboardPage/AccountsTab/table_MPAccounts')
		WebTable.verifyCellValueMatches(table, rowNo, 2, accData.get(Fields.ACC_NUMBER), Operator.EQUALS)
		WebTable.verifyCellValueMatches(table, rowNo, 3, accData.get(Fields.ACC_DESCRIPTION), Operator.EQUALS)
		WebTable.verifyCellValueMatches(table, rowNo, 6, accData.get(Fields.ACC_OWNERSHIP), Operator.EQUALS)
		WebTable.verifyCellValueMatches(table, rowNo, 7, accData.get(Fields.ACC_RELATIONSHIP_TYPE), Operator.EQUALS)
	}
	
	
}
