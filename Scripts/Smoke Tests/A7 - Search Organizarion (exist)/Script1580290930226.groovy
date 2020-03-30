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

Map<Fields, String> orgData = OrganizationData.ORG_B

TestObject tableSearchResults = findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/table_OrgResults')

MapUtil.printMap(orgData)

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)

'Verify usname is displayed on page header section'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/text_LoggedInUserName')), 
    GlobalVariable.UserProfileName, Operator.EQUALS_IGNORE_CASE)

'Click on Search Dropdown options'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/SearchPage/options_SearchBar'))

'Click on Search Organizations Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/HeaderSection/link_Organization'))

/*-----------Search Orrganization with Organization Name--------------*/

WebUI.selectOptionByLabel(findTestObject('Object Repository/SearchPage/SearchConsumer/select_CustomerGroup'), 'Banking Customer',false)

'Search a Customer in SearchConstumer Page with lastName'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_OrganizationName'), orgData.get(
        Fields.ORG_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify organization name in the results grid'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.ORGANIZATION_NAME, orgData.get(
        Fields.ORG_NAME), Operator.EQUALS_IGNORE_CASE)

/*-----------Search Orrganization with Organization PhoneNumber--------------*/
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()


'Search a Customer in SearchConstumer Page with Phonenumber'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_PhoneNumber'), orgData.get(
        Fields.CONTACT_PHONE_NUMBER))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify organization name in the results grid'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.ORGANIZATION_PHONENO, 
    orgData.get(Fields.CONTACT_PHONE_NUMBER), Operator.EQUALS_IGNORE_CASE)

//------------------Search with Tax ID------------------
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()


'Search a Customer in SearchConstumer Page with DBA Name'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_TaxID'), orgData.get(Fields.ORG_TAX_ID))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Click on the Organization  Row'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/table_SearchOrgResult_FirstRow'))

'Goto Profile Tab of a Customer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Profile'))

'verify TaxID of the consumer'
CustomKeywords.'actions.WebActions.verifyMouseOverText'(findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/icon_TaxIDEye'), 
    findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/text_ToolTip'), orgData.get(Fields.ORG_TAX_ID), Operator.EQUALS)

/*-----------Search Orrganization with Organization EmailID--------------*/

WebUI.navigateToUrl(Urls.SEARCH_PAGE)

'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()

'Search a Customer in SearchConstumer Page with Emailid'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_Email'), orgData.get(Fields.CONTACT_EMAIL))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Click on the Organization  Row'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/table_SearchOrgResult_FirstRow'))

'Goto Profile Tab of a Customer'

//CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Profile'))
'Check the emailid in overview page'
String atualMailid = WebUI.getAttribute(findTestObject('Organization/OrganizationDashboardPage/info_OverviewPageEmailid'), 
    'href')

'Verify Emailid'
CustomKeywords.'actions.WebActions.verifyMatch'(atualMailid, orgData.get(Fields.CONTACT_EMAIL), Operator.CONTAINS_IGNORE_CASE)

/*-----------Search Orrganization with Organization DBA Name--------------*/

WebUI.navigateToUrl(Urls.SEARCH_PAGE)
'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()

'Search a Customer in SearchConstumer Page with DBA Name'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_DBAName'), orgData.get(
        Fields.ORG_DBA_NAME))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Click on the Organization  Row'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchOrganization/SearchOrganizationResults/table_SearchOrgResult_FirstRow'))

'Goto Profile Tab of a Customer'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Profile'))

'Scroll to DBA Details'
CustomKeywords.'actions.WebActions.click'(findTestObject('Organization/OrganizationDashboardPage/OrganizationProfile/div_OrgDetailsSection'))

'Check the DBA Name in overview page'
String actualDBAName = WebUI.getText(findTestObject('Organization/OrganizationDashboardPage/OrganizationProfile/readLabel_DBAName'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify DBA Name'
CustomKeywords.'actions.WebActions.verifyMatch'(actualDBAName, orgData.get(Fields.ORG_DBA_NAME), Operator.CONTAINS_IGNORE_CASE)

/*-----------Search Orrganization with Organization Dun Bradstreet ID Name--------------*/

WebUI.navigateToUrl(Urls.SEARCH_PAGE)

'Got to Search page and reset search page'
CustomKeywords.'actions.WebActions.goToSearchOrganization'()

'Search a Customer in SearchConstumer Page with Dun and Badstreet Name'
WebUI.setText(findTestObject('SearchPage/SearchOrganization/input_DunBradstreetID'), orgData.get(
        Fields.ORG_DUN_BRADSTEET_NO))

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify organization name in the results grid'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.ORGANIZATION_DUN_BADSTREETNO, 
    orgData.get(Fields.ORG_DUN_BRADSTEET_NO), Operator.EQUALS_IGNORE_CASE)

/*-----------Search Orrganization with Organization CustomerID--------------*/


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

'Verify Customer DashBoard details in Header Section'
CustomKeywords.'pages.organization.OrganizationDashboardPage.verifyOrganizationDataOnHeaderSection'(orgData)