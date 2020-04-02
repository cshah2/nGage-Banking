import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.WebElement as WebElement
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
import utils.MapUtil as MapUtil
import constants.Urls as Urls
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData as ConsumerData

String addressUpdateCase = 'Address Update'
 int CLOSED_CASE_LATEST_ROW = 1
Map<Fields, String> customerData = ConsumerData.CUST_B

Map<Fields, String> customerAddress = ConsumerData.ADDRESS_A

MapUtil.printMap(customerAddress)

TestObject casesTable = findTestObject('Consumer/ConsumerDashBoardPage/CasesSection/table_ClosedCases')
TestObject addressTable = findTestObject('Consumer/ConsumerDashBoardPage/ContactDetailsTab/AddressBlock/table_Address')

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(customerData.get(Fields.URL))

'Click on Contact Details Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/tab_ContactDetails'))

'Click on Icon edit on address  Details Section'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/AddressBlock/icon_AddAddress'))

'Click on Edit Address Option'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/AddressBlock/option_EditAddress'))

'Clear Address Line 1'
WebUI.clearText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine1'))

'Type Address Line1'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine1'), 
    customerAddress.get(Fields.ADDR_LINE1))

'Clear Address Line 2'
WebUI.clearText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine2'))

'Type Address Line2'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine2'), 
    customerAddress.get(Fields.ADDR_LINE2))

'Clear Address Line 3'
WebUI.clearText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine3'))

'Type Address Line3'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine3'), 
    customerAddress.get(Fields.ADDR_LINE3))

'Clear Address Line 4'
WebUI.clearText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine4'))

'Type Address Line4'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_AddressLine4'), 
    customerAddress.get(Fields.ADDR_LINE4))

'Clear Address City'
WebUI.clearText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_City'))

'Type Address City'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_City'), 
    customerAddress.get(Fields.ADDR_CITY))

'Click on Dropdown region'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/addressRegionDropdown'))

'Select the region option'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/addressRegionOptions', 
        [('region') : customerAddress.get(Fields.ADDR_COUNTY)]))

'Clear Address Zipcode'
WebUI.clearText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ZipCode'))

'Type Zip code'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ZipCode'), 
    customerAddress.get(Fields.ADDR_ZIPCODE))

'Click on Link Valid From Date'
//CustomKeywords.'actions.WebActions.clickEvent'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/link_SetValidToAndFromDates'))

'Set Valid From Text'
CustomKeywords.'actions.WebActions.setText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ValidFromDate'), 
    customerData, Fields.ADDR_VALID_FROM, false)

'Set Valid Till Text'
CustomKeywords.'actions.WebActions.setText'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/input_ValidUntilDate'), 
    customerData, Fields.ADDR_VALID_UNTIL, false)

'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/btn_Submit'))

'Verfiy the element popup is displayed as case created for address update'
WebUI.verifyElementPresent(findTestObject('Consumer/ConsumerTaskDrawer/Customer Address/addressUpdateAlert'), GlobalVariable.Timeout, 
    FailureHandling.STOP_ON_FAILURE)

'Wait for the Case to refelect in Closed Cases table'
WebUI.delay(GlobalVariable.Timeout)

'Click on Cases Tab '
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Cases'))

'Click on Cases Tab '
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/CasesTab/tab_ClosedCases'))

'Click on Cases Tab '
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/CasesTab/tab_ClosedCases'))


/*'Verify Case type in Closed cases Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(casesTable, CLOSED_CASE_LATEST_ROW, ColumnPosition.CASE_TYPE,
	addressUpdateCase, Operator.EQUALS_IGNORE_CASE)*/


WebUI.delay(10)

'Click on Contact Details Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/ContactDetailsTab/tab_ContactDetails'))

'Verify Address Table with the updated Address Data(Address Line1'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(addressTable, CLOSED_CASE_LATEST_ROW, ColumnPosition.ADDRESS_LINE1, 
    customerAddress.get(Fields.ADDR_LINE1), Operator.EQUALS_IGNORE_CASE)

'Verify Address Table with the updated Address Data(Addresss_state)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(addressTable, CLOSED_CASE_LATEST_ROW, ColumnPosition.ADDRESS_CITY, 
    customerAddress.get(Fields.ADDR_CITY), Operator.EQUALS_IGNORE_CASE)

'Verify Address Table with the updated Address Data (Addresss_city)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(addressTable, CLOSED_CASE_LATEST_ROW, ColumnPosition.ADDRESS_STATE, 
    customerAddress.get(Fields.ADDR_STATE), Operator.EQUALS_IGNORE_CASE)

'Verify Address Table with the updated Address Data (Address_Zipcode)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(addressTable, CLOSED_CASE_LATEST_ROW, ColumnPosition.ADDRESS_ZIP, 
    customerAddress.get(Fields.ADDR_ZIPCODE), Operator.CONTAINS_IGNORE_CASE)

'Verify Address Table with the updated Address Data (Address Country)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(addressTable,CLOSED_CASE_LATEST_ROW, ColumnPosition.ADDRESS_COUNTRY, 
    customerAddress.get(Fields.ADDR_COUNTY), Operator.CONTAINS_IGNORE_CASE)

