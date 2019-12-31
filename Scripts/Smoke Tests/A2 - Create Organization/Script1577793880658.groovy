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

import constants.Fields
import constants.Operator
import constants.Urls
import data.OrganizationData
import internal.GlobalVariable as GlobalVariable
import utils.MapUtil

Map<Fields, String> orgData = OrganizationData.ORG_A
MapUtil.printMap(orgData)

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate to create customer page'
WebUI.navigateToUrl(Urls.CREATE_ORGANIZATION_PAGE)

'Create Organization'
CustomKeywords.'pages.organization.CreateOrganizationPage.createOrganization'(orgData)

'Store Current page url into a variable'
String pageUrl = WebUI.getUrl()

'Verify user is on Customer dashboard page'
CustomKeywords.'actions.WebActions.verifyMatch'(pageUrl, 'CustomerMainFlow.CustomerDetail.aspx', Operator.CONTAINS_IGNORE_CASE)

//'Verify Consumer data on header section'
//CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyConsumerDataOnHeaderSection'(custData)