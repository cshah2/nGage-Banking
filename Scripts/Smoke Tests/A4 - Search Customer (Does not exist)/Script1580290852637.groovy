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
import internal.GlobalVariable as GlobalVariable
import constants.Fields as Fields
import constants.Operator as Operator
import constants.Urls as Urls
import data.ConsumerData as ConsumerData
import utils.MapUtil as MapUtil

Map<Fields, String> customerData = ConsumerData.NA_CUSTOMERDATA_MAP

String expectedErrorMessage1 = "No results found"

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)


CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/SearchPage/options_SearchBar'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Consumer'))



'Search a Customer in SearchConstumer Page with lastName'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_LastName'), customerData.get(Fields.CUST_LAST_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*--------------Search with invalid First name-------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()


'Search a Customer in SearchConstumer Page with firstName'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_FirstName'), customerData.get(Fields.CUST_FIRST_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*--------------Search with Invalid EmailID name-------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Search a Customer in SearchConstumer Page with EmailID'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_Email'), customerData.get(Fields.CONTACT_EMAIL))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*----------Search consumer with invalid DOB--------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Type date of birth and search '
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_DateofBirth'), customerData.get(Fields.CUST_DOB))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*----------Search consumer with Invalid  PhoneNumber--------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Type date of birth and search '
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_PhoneNumber'), customerData.get(Fields.CONTACT_PHONE_NUMBER))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)


/*'Get error message'
String errorMessage3 = WebUI.getText(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoConsumerFound'))

CustomKeywords.'actions.WebActions.verifyMatch'(errorMessage3, expectedErrorMessage1, Operator.CONTAINS_IGNORE_CASE)*/

/*----------Search consumer with Invalid TaxID--------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Search a Customer in SearchConstumer Page with TAXID'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_TaxID'), customerData.get(Fields.CUST_TAX_ID))

CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)


/*'Get error message'
String errorMessage2 = WebUI.getText(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoConsumerFound'))

CustomKeywords.'actions.WebActions.verifyMatch'(errorMessage2, expectedErrorMessage1, Operator.CONTAINS_IGNORE_CASE)
*/

/*----------Search consumer with Invalid CustomerID--------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchConsumer'()

'Click Consumer Group'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/select_CustomerGroup'))

'Select Consumer Group'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/options_ConsumerGroups', [('group') : customerData.get(Fields.CUST_GROUP)]))

'Search a Customer in SearchConstumer Page with Customer ID'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_CustomerID'), customerData.get(Fields.CUST_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
//WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoConsumerFound'), FailureHandling.STOP_ON_FAILURE)

'Get error message'
String errorMessage = WebUI.getText(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoConsumerFound'))

String expectedErrorMessage2 = "No matching customer or account record found"

CustomKeywords.'actions.WebActions.verifyMatch'(errorMessage, expectedErrorMessage2, Operator.CONTAINS_IGNORE_CASE)

