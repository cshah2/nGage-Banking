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

Map<Fields, String> custData = ConsumerData.CUST_A
Map<Fields, String> addressData = ConsumerData.ADDR_A

TestObject addressTable = findTestObject('Object Repository/Consumer/ConsumerDashboardPage/ContactDetailsTab/AddressBlock/table_Address')

WebUtil.shouldFailTest(custData)

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate to customer dashboard page'
WebUI.navigateToUrl(custData.get(Fields.URL))

'Click on Contact Details tab'
CustomKeywords.'pages.consumer.tabs.ConsumerContactDetailsTab.clickContactDetailsTab'()

'Get rows count for existing address'
int actRowsCount = CustomKeywords.'actions.WebTable.getRowsCount'(addressTable)

'Click on Add Address icon'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/ContactDetailsTab/AddressBlock/icon_AddAddress'))

'Fill up address form'
CustomKeywords.'pages.consumer.ConsumerTasks.addAddress'(addressData)

'Wait for Address to get added to the table'
CustomKeywords.'actions.WebTable.waitUntilRowsCountMatches'(addressTable, actRowsCount+1 , Operator.EQUALS, GlobalVariable.Timeout)

'Verify rows count is increased'
CustomKeywords.'actions.WebTable.verifyRowsCountMatches'(addressTable, actRowsCount+1 , Operator.EQUALS)