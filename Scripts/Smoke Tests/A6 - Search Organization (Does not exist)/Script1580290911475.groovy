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
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Operator as Operator
import constants.Urls as Urls
import data.OrganizationData as OrganizationData
import utils.MapUtil as MapUtil

Map<Fields, String> orgData = OrganizationData.NA_ORGANIZATIONMAP

MapUtil.printMap(orgData)

/*-----------Search Orrganization with Invalid Organization Name--------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)


CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/SearchPage/options_SearchBar'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/SearchPage/link_Org'))

'Search a Customer in SearchConstumer Page with lastName'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_OrganizationName'), orgData.get(
        Fields.ORG_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with Invalid Organization PhoneNumber--------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()

'Search a Customer in SearchConstumer Page with Phonenumber'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_PhoneNumber'), orgData.get(
        Fields.CONTACT_PHONE_NUMBER))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with invalid Organization EmailID--------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()


'Search a Customer in SearchConstumer Page with Emailid'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_Email'), orgData.get(Fields.CONTACT_EMAIL))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with invalid Organization TaxID--------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()


'Search a Customer in SearchConstumer Page with DBA Name'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_TaxID'), orgData.get(Fields.ORG_TAX_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with Invalid Organization DBA Name--------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()


'Search a Customer in SearchConstumer Page with DBA Name'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_DBAName'), orgData.get(
        Fields.ORG_DBA_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with Invalid Organization Dun Badstreet ID Name--------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()


'Search a Customer in SearchConstumer Page with Dun and Badstreet Name'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_DunBradstreetID'), orgData.get(
        Fields.ORG_DUN_BRADSTEET_NO))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with Invalid Organization CustomerID--------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()


'Click Consumer Group'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/select_CustomerGroup'))

'Select Consumer Group'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/options_ConsumerGroups', [('group') : orgData.get(
                Fields.ORG_GROUP)]))

'Search a Customer in SearchConstumer Page with Dun and Badstreet Name'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_CustomerID'), orgData.get(
        Fields.ORG_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoOrgFound'), 
    FailureHandling.STOP_ON_FAILURE)