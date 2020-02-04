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
import constants.Operator as Operator
import constants.Urls as Urls
import data.ConsumerData as ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.MapUtil as MapUtil


Map<Fields, String> customerData =  ConsumerData.CUST_B
TestObject tableSearchResults = findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/table_SearchResults')

MapUtil.printMap(customerData)

'Customer data : ' + customerData

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)

'Verify usname is displayed on page header section'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/text_LoggedInUserName')), 
    GlobalVariable.UserProfileName, Operator.EQUALS_IGNORE_CASE)

'Search a Customer in SearchConstumer Page with lastName'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_LastName'), customerData.get(
        Fields.CUST_LAST_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify Last name value matches in result grid'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSTUMER_LASTNAME_INDEX, 
    customerData.get(Fields.CUST_LAST_NAME), Operator.EQUALS_IGNORE_CASE)

/*----------Search consumer with Firstname--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Search a Customer in SearchConstumer Page with firstName'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_FirstName'), customerData.get(
        Fields.CUST_FIRST_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Firstname is present in all rows of searchResults table'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSTUMER_FIRSTNAME_INDEX, 
    customerData.get(Fields.CUST_FIRST_NAME), Operator.EQUALS_IGNORE_CASE)

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

/*----------Search consumer with Emailid--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Search a Customer in SearchConstumer Page with EmailID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_Email'), customerData.get(Fields.CUST_MAILID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify Firstname is present in all rows of searchResults table'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSTUMER_EMAILID_INDEX, 
    customerData.get(Fields.CUST_MAILID), Operator.EQUALS_IGNORE_CASE)

/*----------Search consumer with DOB--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Type date of birth and search '
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_DateofBirth'), customerData.get(
        Fields.CUST_DOB))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'verify Birthdate colum'
CustomKeywords.'actions.WebActions.verifyMouseOverText'(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/icon_DOBEye'), findTestObject(
        'SearchConsumerResults/toolTipObject'), customerData.get(Fields.CUST_DOB), Operator.EQUALS)

/*----------Search consumer with PhoneNumber--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Type date of birth and search '
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_PhoneNumber'), customerData.get(
        Fields.CONTACT_PHONE_NUMBER))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify Phone Numbers for all results in the SearchResults Grid'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSTUMER_PHONENUMBER_INDEX, 
    customerData.get(Fields.CONTACT_PHONE_NUMBER), Operator.EQUALS_IGNORE_CASE)

/*----------Search consumer with TaxID--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Search a Customer in SearchConstumer Page with TAXID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_TaxID'), customerData.get(Fields.CUST_TAX_ID))

CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Click on the customer Row'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/table_SearchResult_FirstRow'))

'Goto Profile Tab of a Customer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Profile'))

'verify TaxID of the consumer'
CustomKeywords.'actions.WebActions.verifyMouseOverText'(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/icon_TaxIDEye'), findTestObject(
        'SearchConsumerResults/toolTipObject'), customerData.get(Fields.CUST_TAX_ID), Operator.EQUALS)

/*----------Search consumer with CustomerID--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Search a Customer in SearchConstumer Page with Customer ID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_CustomerID'), customerData.get(
        Fields.CUST_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Customer DashBoard details in Header Section'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyConsumerDataOnHeaderSection'(customerData)