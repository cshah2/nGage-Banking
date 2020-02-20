import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.poi.ss.formula.functions.DStarRunner.operator

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

import constants.Urls
import constants.Operator
import constants.Fields
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> accountData =  ConsumerData.ACC_B1

'Load browser'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE,Operator.EQUALS_IGNORE_CASE)

'Click on the Search type dropdown'
CustomKeywords.'actions.WebActions.click'(findTestObject("SearchPage/HeaderSection/icon_SearchTypeDropDown"))

'click on the Account link'
CustomKeywords.'actions.WebActions.click'(findTestObject("SearchPage/HeaderSection/link_Account"))

'Enter the Account Number'
CustomKeywords.'actions.WebActions.setText'(findTestObject("SearchPage/SearchAccount/input_AccountNumber"), accountData, Fields.ACC_NUMBER)

'Click On Search'
CustomKeywords.'actions.WebActions.click'(findTestObject("SearchPage/SearchAccount/btn_Search"))

'Save the Account Number in variable '
String text = WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/PositionSummary Block/text_AccountNumber'))

'Verify the Account Number'
CustomKeywords.'actions.WebActions.verifyMatch'(text, accountData.get(Fields.ACC_NUMBER), Operator.CONTAINS_IGNORE_CASE)




