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

import constants.Common
import constants.Operator
import constants.Urls
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil

'Load browser'
CustomKeywords.'actions.WebActions.openBrowser'()

'Maximize browsers window'
WebUI.maximizeWindow()

'Clear browser cache'
WebUI.deleteAllCookies()

'Navigate to login page'
WebUI.navigateToUrl(Urls.LOGIN_PAGE)

println "The current date and time  in java : " + DateUtil.getCurrentDateTimeWithTimeZone(Common.dateTimeFormat, Common.timezoneUTC)

'Enter username'
WebUI.setText(findTestObject('Object Repository/LoginPage/input_UserName'), GlobalVariable.UserName)

'Enter password'
WebUI.setText(findTestObject('Object Repository/LoginPage/input_Password'), GlobalVariable.Password)

'Click on Login button'
WebUI.click(findTestObject('Object Repository/LoginPage/btn_Login'))

'Verify user is redirected to consumer search page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS_IGNORE_CASE)

'Verify usname is displayed on page header section'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/text_LoggedInUserName')), GlobalVariable.UserProfileName, Operator.EQUALS_IGNORE_CASE)