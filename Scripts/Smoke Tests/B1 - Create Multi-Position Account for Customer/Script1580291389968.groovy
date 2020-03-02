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
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil


Map<Fields, String> custData = ConsumerData.CUST_B
Map<Fields, String> accData = ConsumerData.ACC_MULTIPOSO_1

WebUtil.shouldFailTest(custData)

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate to customer dashboard page'
WebUI.navigateToUrl(custData.get(Fields.URL))

'Click on Add account button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/OverviewTab/AccountsBlock/icon_AddAccount'))

'Create account'
CustomKeywords.'pages.account.CreateMultipositionAccountPage.createMutipositionAccount'(accData)


'Verify Banking account infomrtion'
CustomKeywords.'pages.consumer.tabs.ConsumerAccountsTab.verifyMPAccountInformation'(accData, 1)

'Multi=position account created'
accData.put(Fields.IS_CREATED, "true");
