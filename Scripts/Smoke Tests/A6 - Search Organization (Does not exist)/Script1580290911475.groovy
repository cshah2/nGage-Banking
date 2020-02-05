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

'Verify usname is displayed on page header section'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/text_LoggedInUserName')), 
    GlobalVariable.UserProfileName, Operator.EQUALS_IGNORE_CASE)

'Click on Search Dropdown options'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/icon_SearchTypeDropDown'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Organization'))

'Search a Customer in SearchConstumer Page with lastName'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchOrganization/input_OrganizationName'), orgData.get(
        Fields.ORG_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/message_NoResults'), FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with Invalid Organization PhoneNumber--------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click on Search Dropdown options'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/icon_SearchTypeDropDown'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Organization'))

'Search a Customer in SearchConstumer Page with Phonenumber'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchOrganization/input_PhoneNumber'), orgData.get(
        Fields.ORG_PHONENUMBER))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with invalid Organization EmailID--------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click on Search Dropdown options'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/icon_SearchTypeDropDown'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Organization'))

'Search a Customer in SearchConstumer Page with Emailid'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchOrganization/input_Email'), orgData.get(Fields.ORG_EMAILID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with invalid Organization TaxID--------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click on Search Dropdown options'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/icon_SearchTypeDropDown'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Organization'))

'Search a Customer in SearchConstumer Page with DBA Name'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchOrganization/input_TaxID'), orgData.get(Fields.ORG_TAX_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with Invalid Organization DBA Name--------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click on Search Dropdown options'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/icon_SearchTypeDropDown'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Organization'))

'Search a Customer in SearchConstumer Page with DBA Name'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchOrganization/input_DBAName'), orgData.get(
        Fields.ORG_DBA_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with Invalid Organization Dun Badstreet ID Name--------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click on Search Dropdown options'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/icon_SearchTypeDropDown'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Organization'))

'Search a Customer in SearchConstumer Page with Dun and Badstreet Name'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchOrganization/input_DunBradstreetID'), orgData.get(
        Fields.ORG_DUN_BRADSTEET_NO))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoResults'), 
    FailureHandling.STOP_ON_FAILURE)

/*-----------Search Orrganization with Invalid Organization CustomerID--------------*/
'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click on Search Dropdown options'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/icon_SearchTypeDropDown'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Organization'))

'Click Consumer Group'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/select_CustomerGroup'))

'Select Consumer Group'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/options_ConsumerGroups', [('group') : orgData.get(
                Fields.ORG_GROUP)]))

'Search a Customer in SearchConstumer Page with Dun and Badstreet Name'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('SearchPage/SearchOrganization/input_CustomerID'), orgData.get(
        Fields.ORG_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Verify Error Message is Displayed'
WebUI.verifyElementVisible(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/message_NoOrgFound'), 
    FailureHandling.STOP_ON_FAILURE)