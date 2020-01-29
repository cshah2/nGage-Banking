package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import actions.WebActions
import constants.Urls
import internal.GlobalVariable

public class LoginPage {

	@Keyword
	def loginIntoPortal(String username = GlobalVariable.UserName, String password = GlobalVariable.Password) {

		TestObject usernameField 	= findTestObject('Object Repository/LoginPage/input_UserName')
		TestObject passwordField	= findTestObject('Object Repository/LoginPage/input_Password')
		TestObject loginButton 		= findTestObject('Object Repository/LoginPage/btn_Login')
		TestObject loginPageHeader 	= findTestObject('Object Repository/LoginPage/text_PageHeading')

		int loginAttempt = 1
		boolean isLoginSuccess = false

		while (loginAttempt <= 3) {

			WebActions.openBrowser()
			WebUI.deleteAllCookies()
			WebUI.navigateToUrl(Urls.LOGIN_PAGE)
			String currentUrl = WebUI.getUrl()

			//Check if User is on Login page or not
			if(currentUrl.toLowerCase().contains('Login.aspx'.toLowerCase()) || currentUrl.toLowerCase().contains('NoPermission.aspx'.toLowerCase())) {

				WebUI.delay(2)
				WebUI.verifyElementVisible(loginPageHeader)
				WebUI.setText(usernameField, username)
				WebUI.setText(passwordField, password)
				WebUI.click(loginButton)
				WebUI.verifyMatch(WebUI.getUrl(), Urls.SEARCH_PAGE, false)
				isLoginSuccess = true
				break
			}
			else if(currentUrl.equalsIgnoreCase(Urls.SEARCH_PAGE)){
				isLoginSuccess = true
				break
			}
			else {
				println "Unable to perform login step. Current URL is "+currentUrl
				loginAttempt++
				WebUI.closeBrowser()
				continue
			}
		}
		if(!isLoginSuccess) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to login into portal exception occurred')
		}
	}
}
