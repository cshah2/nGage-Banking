import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass as CustomKeywordDelegatingMetaClass
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Icon as Icon
import constants.Operator as Operator
import constants.Urls as Urls
import data.ConsumerData as ConsumerData


import data.ConsumerTempData as ConsumerTempData

import internal.GlobalVariable as GlobalVariable
import utils.MapUtil as MapUtil
import utils.TableUtil
import utils.WebUtil as WebUtil

Map<Fields, String> customerData = ConsumerData.CUST_B


WebUtil.shouldFailTest(customerData)

TestObject tableSearchResults = findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/table_SearchResults')



'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)

'Verify usname is displayed on page header section'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/text_LoggedInUserName')), 
    GlobalVariable.UserProfileName, Operator.EQUALS_IGNORE_CASE)

'Search a Customer in SearchConstumer Page with lastName'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_LastName'), customerData.get(Fields.CUST_LAST_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify Last name value matches in result grid'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSUMER_LASTNAME, customerData.get(
        Fields.CUST_LAST_NAME), Operator.EQUALS_IGNORE_CASE)

/*----------Search consumer with Firstname--------*/
'Login into portal'
//CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Search a Customer in SearchConstumer Page with firstName'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_FirstName'), customerData.get(Fields.CUST_FIRST_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Firstname is present in all rows of searchResults table'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSUMER_FIRSTNAME, 
    customerData.get(Fields.CUST_FIRST_NAME), Operator.EQUALS_IGNORE_CASE)

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

/*----------Search consumer with Emailid--------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Search a Customer in SearchConstumer Page with EmailID'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_Email'), customerData.get(Fields.CONTACT_EMAIL))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify Firstname is present in all rows of searchResults table'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSUMER_EMAILID, 
    customerData.get(Fields.CONTACT_EMAIL), Operator.EQUALS_IGNORE_CASE)

/*----------Search consumer with DOB--------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Type date of birth and search '
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_DateofBirth'), customerData.get(Fields.CUST_DOB))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Get Current transaction records count'
int recordCount = CustomKeywords.'actions.WebTable.getRowsCount'(tableSearchResults)


for(int i=0 ; i <=recordCount ; i++){
'Mouse over eye icon next to DOB field'
CustomKeywords.'actions.WebActions.verifyMouseOverText'(findTestObject('Object Repository/SearchPage/SearchConsumer/SearchConsumerResults/icon_DOBEye'), findTestObject('Object Repository/SearchPage/SearchConsumer/SearchConsumerResults/text_ToolTip'), customerData.get(Fields.CUST_DOB), Operator.EQUALS_IGNORE_CASE)
}

'Wait for tooltip to be visible'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/SearchPage/SearchConsumer/SearchConsumerResults/text_ToolTip'), 
    GlobalVariable.Timeout)

'Verify date of birth value'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/SearchPage/SearchConsumer/SearchConsumerResults/text_ToolTip')), 
    customerData.get(Fields.CUST_DOB), Operator.EQUALS)

/*----------Search consumer with PhoneNumber--------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Type date of birth and search '
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_PhoneNumber'), customerData.get(Fields.CONTACT_PHONE_NUMBER))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify Phone Numbers for all results in the SearchResults Grid'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSUMER_PHONENUMBER, customerData.get(
        Fields.CONTACT_PHONE_NUMBER), Operator.EQUALS_IGNORE_CASE)

/*----------Search consumer with TaxID--------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Search a Customer in SearchConstumer Page with TAXID'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_TaxID'), customerData.get(Fields.CUST_TAX_ID))

CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Click on the customer Row'
CustomKeywords.'actions.WebTable.clickCell'(tableSearchResults, 1, 5)
//CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/table_SearchResult_FirstRow'))

'Goto Profile Tab of a Customer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Profile'))

'verify TaxID of the consumer'
CustomKeywords.'actions.WebActions.verifyMouseOverText'(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/icon_TaxIDEye'), 
    findTestObject('Object Repository/SearchPage/SearchConsumer/SearchConsumerResults/text_ToolTip'), customerData.get(Fields.CUST_TAX_ID), 
    Operator.EQUALS)

/*----------Search consumer with CustomerID--------*/

WebUI.navigateToUrl(Urls.SEARCH_PAGE)

'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Select Customer Group'
WebUI.selectOptionByLabel(findTestObject('Object Repository/SearchPage/SearchConsumer/select_CustomerGroup'), customerData.get(
        Fields.CUST_GROUP), false)

'Search a Customer in SearchConstumer Page with Customer ID'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_CustomerID'), customerData.get(Fields.CUST_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Customer DashBoard details in Header Section'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyConsumerDataOnHeaderSection'(customerData)

