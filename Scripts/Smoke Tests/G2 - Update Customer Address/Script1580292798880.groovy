import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import constants.Urls as Urls
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData as ConsumerData

Map<Fields, String> customerData = ConsumerData.CUSTOMERDATA_MAP

Map<Fields, String> customerAddress = ConsumerData.ADDR_A

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)

'Verify usname is displayed on page header section'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/text_LoggedInUserName')), 
    GlobalVariable.UserProfileName, Operator.EQUALS_IGNORE_CASE)


'Search a Customer in SearchConstumer Page with Customer ID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_CustomerID'), customerData.get(
        Fields.CUST_ID))

'Click on Search Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Click on Task Drawer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/task_Drawer'))

'Click on Add Address Task'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/add_Address'))

'Type Address Line1'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine1'), customerAddress.get(
        Fields.ADDR_LINE1))

'Type Address Line2'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine2'), customerAddress.get(
        Fields.ADDR_LINE2))

'Type Address Line3'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine3'), customerAddress.get(
        Fields.ADDR_LINE3))

'Type Address Line4'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine4'), customerAddress.get(
        Fields.ADDR_LINE4))

'Type Address City'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_City'), customerAddress.get(
        Fields.ADDR_CITY))

'Click on Dropdown region'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/addressRegionDropdown'))

'Select the region option'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/addressRegionOptions', [
            ('region') : customerAddress.get(Fields.ADDR_COUNTY)]))

'Type Zip code'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ZipCode'), 
    customerAddress.get(Fields.ADDR_ZIPCODE))


'Click on Valid From Date'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ValidFromDate'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ValidFromDate'), 
    30)

//WebUtil.setText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ValidFromDate'), customerAddressData, Fields.ADDR_VALID_FROM,true)
'Set text using javascript for Valid from date'
WebUI.executeJavaScript(('arguments[0].value="' + customerAddress.get(Fields.ADDR_VALID_FROM)) + '"', Arrays.asList(element))

'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/btn_Submit'))

'Verfiy the element popup is displayed as case created for address update'
WebUI.verifyElementPresent(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/addressUpdateAlert'), GlobalVariable.Timeout, FailureHandling.STOP_ON_FAILURE)

'Logout of nGage Bank'
CustomKeywords.'actions.WebActions.logout'()



