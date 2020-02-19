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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Fields
import constants.Operator
import constants.Urls
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.MapUtil

Map<Fields, String> customerData = ConsumerData.CUSTOMERDATA_MAP
MapUtil.printMap(customerData)

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Open Consumer dashboard page'
WebUI.navigateToUrl(customerData.get(Fields.URL))

'Verify the Customer-Overview page with User Email address'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Consumer/ConsumerDashboardPage/OverviewTab/Customer Information block/Email address')), customerData.get(Fields.CUST_MAILID),Operator.STARTS_WITH_IGNORE_CASE)

'Click on Accounts tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Accounts'))

'Wait for accounts tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/AccountsTab/Open Account_Heading'), GlobalVariable.Timeout)

'Click on Profile tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Profile'))

'Wait for profile tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Profile Tab/Heading_Consumer Information and Preference'), GlobalVariable.Timeout)

'Click on the Contact Details tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Contact Details'))

'Wait for contact details tab to load'

CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/ContactDetailsTab/AddressBlock/table_Address'), GlobalVariable.Timeout)	


'Click on Notes tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Notes'))
	
'Wait for Notes tab to load'

CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Notes Tab/Notes table'), GlobalVariable.Timeout)

'Click on Document tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Documents'))

'Wait for Document tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Documents Tab/Documents table'), GlobalVariable.Timeout)

'Click on Cases tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Cases'))

'Wait for Cases tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Cases tab/Cases table'), GlobalVariable.Timeout)

'Click on Notification tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Notification'))

'verify the Notification tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Notification Tab/Notification Table'), GlobalVariable.Timeout)


