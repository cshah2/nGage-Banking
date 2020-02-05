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

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*--------------Search with invalid First name-------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Search a Customer in SearchConstumer Page with firstName'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_FirstName'), customerData.get(
        Fields.CUST_FIRST_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*--------------Search with Invalid EmailID name-------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Search a Customer in SearchConstumer Page with EmailID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_Email'), customerData.get(Fields.CUST_MAILID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*----------Search consumer with invalid DOB--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Type date of birth and search '
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_DateofBirth'), customerData.get(
        Fields.CUST_DOB))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*----------Search consumer with Invalid  PhoneNumber--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Type date of birth and search '
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_PhoneNumber'), customerData.get(
        Fields.CONTACT_PHONE_NUMBER))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*----------Search consumer with Invalid TaxID--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Search a Customer in SearchConstumer Page with TAXID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_TaxID'), customerData.get(Fields.CUST_TAX_ID))

CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*----------Search consumer with Invalid CustomerID--------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click Consumer Group'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/select_CustomerGroup'))

'Select Consumer Group'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/options_ConsumerGroups', [('group') : customerData.get(
                Fields.CUST_GROUP)]))

'Search a Customer in SearchConstumer Page with Customer ID'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchConsumer/input_CustomerID'), customerData.get(
        Fields.CUST_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoConsumerFound'), FailureHandling.STOP_ON_FAILURE)