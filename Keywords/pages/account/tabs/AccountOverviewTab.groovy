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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import actions.WebActions
import constants.Fields
import constants.Operator
import internal.GlobalVariable

public class AccountOverviewTab {

	@Keyword
	public static void verifyHoldsUnderAccountOverview(Map<Fields,String> holdsMap){

		String holdType = holdsMap.get(Fields.HOLD_TYPE)
		String holdAmount
		if(holdType.equalsIgnoreCase("Admin")){
			holdAmount = WebUI.getText(findTestObject("Account/AccountDashboardPage/OverviewTab/text_Hold_Admin"))
			WebActions.verifyMatch(holdAmount, holdsMap.get(Fields.HOLD_AMOUNT_VIEW), Operator.EQUALS)
		}
		else if(holdType.equalsIgnoreCase("PreAuth")){
			holdAmount = WebUI.getText(findTestObject("Account/AccountDashboardPage/OverviewTab/text_Hold_PreAuth"))
			WebActions.verifyMatch(holdAmount, holdsMap.get(Fields.HOLD_AMOUNT_VIEW), Operator.EQUALS)
		}
		else if(holdType.equalsIgnoreCase("Reg-CC")){
			holdAmount = WebUI.getText(findTestObject("Account/AccountDashboardPage/OverviewTab/text_Hold_RegCC"))
			WebActions.verifyMatch(holdAmount, holdsMap.get(Fields.HOLD_AMOUNT_VIEW), Operator.EQUALS)
		}
		else if(holdType.equalsIgnoreCase("Clearing")){
			holdAmount = WebUI.getText(findTestObject("Account/AccountDashboardPage/OverviewTab/text_Hold_Clearing"))
			WebActions.verifyMatch(holdAmount, holdsMap.get(Fields.HOLD_AMOUNT_VIEW), Operator.EQUALS)
		}
		else if(holdType.equalsIgnoreCase("Reserve")){
			holdAmount = WebUI.getText(findTestObject("Account/AccountDashboardPage/OverviewTab/text_Hold_Reserve"))
			WebActions.verifyMatch(holdAmount, holdsMap.get(Fields.HOLD_AMOUNT_VIEW), Operator.EQUALS)
		}
		else {
			KeywordUtil.markFailedAndStop('Incorrect hold type value provided in input'+holdType)
		}
	}
}
