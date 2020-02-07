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
import data.OrganizationData
import internal.GlobalVariable as GlobalVariable
import utils.MapUtil
import utils.WebUtil

//Map<Fields, String> custData = ConsumerData.CUST_B
//Map<Fields, String> accData = ConsumerData.ACC_B1
//Map<Fields, String> orgData = OrganizationData.ORG_B
//
//WebUtil.shouldFailTest(custData)
//WebUtil.shouldFailTest(orgData)
//WebUtil.shouldFailTest(accData)
//
//'Login into portal'
//CustomKeywords.'pages.LoginPage.loginIntoPortal'()
//
//'Navigate to account dashboard page'
//WebUI.navigateToUrl(accData.get(Fields.URL))
//
//'Click on details tab'
//WebUI.click(findTestObject('Object Repository/Account/AccountDashboardPage/TabSection/tab_Details'))
//
//'Wait for details tab to load'
//CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountDashboardPage/DetailsTab/block_AccountDetails'), GlobalVariable.Timeout)
//
//'Click on Add Related party link'
//CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Account/AccountDashboardPage/DetailsTab/icon_AddRelatedParty'))
//
//'Wait for task drawer to load'
//
//TODO: Waiting for dev team to add xpaths correctly