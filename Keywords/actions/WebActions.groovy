package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.Map

import org.openqa.selenium.ElementClickInterceptedException
import org.openqa.selenium.ElementNotInteractableException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Fields
import constants.Operator
import internal.GlobalVariable
import utils.ExceptionUtil
import utils.MapUtil
import utils.RegexStringUtil
import utils.WebUtil

public class WebActions {

	static KeywordLogger log = new KeywordLogger()

	@Keyword
	static def verifyMatch(String actText, String expText, Operator o) {

		String expTextRegex = RegexStringUtil.formRegexString(expText, o)

		try {
			WebUI.verifyMatch(actText, expTextRegex, true)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			throw e
		}
	}

	@Keyword
	static def verifyNumbericMatch(Object actValue, Object expValue, Operator o) {
		switch(o) {
			case Operator.EQUALS:
				WebUI.verifyEqual(actValue, expValue)
				break;

			case Operator.GREATER_THAN:
				WebUI.verifyGreaterThan(actValue, expValue)
				break;

			case Operator.GREATER_THAN_OR_EQUALS:
				WebUI.verifyGreaterThanOrEqual(actValue, expValue)
				break;

			case Operator.LESS_THAN:
				WebUI.verifyLessThan(actValue, expValue)
				break;

			case Operator.LESS_THAN_OR_EQUALS:
				WebUI.verifyLessThanOrEqual(actValue, expValue)
				break;

			case Operator.NOT_EQUALS:
				WebUI.verifyNotEqual(actValue, expValue)
				break;

			default:
				KeywordUtil.markFailedAndStop('Invalid operator provided')
				break;
		}
	}

	@Keyword
	static def openBrowser() {
		try {
			DriverFactory.getWebDriver()
		}
		catch(Throwable t) {
			WebUI.openBrowser('')
			WebUI.maximizeWindow()
		}
	}

	@Keyword
	static def click(TestObject to) {
		//Move to Element
		try {
			scrollToElement(to, GlobalVariable.Timeout)
		}
		catch(Exception e) {
			//DO nothing if move operation fails.
		}

		//Click on Element
		try {
			WebUI.click(to)
		}
		catch(StepFailedException e) {
			boolean isException = (ExceptionUtil.isCause(ElementClickInterceptedException.class, e) || ExceptionUtil.isCause(ElementNotInteractableException.class, e))
			if(isException) {
				WebElement el = WebUiCommonHelper.findWebElement(to, GlobalVariable.Timeout)
				List<WebElement> list = new ArrayList<WebElement>()
				list.add(el)
				WebUI.executeJavaScript('arguments[0].click()', list)

			}
			else {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("Unable to move to element and click on it."+e.toString())
			}
		}

	}

	@Keyword
	static def setText(TestObject to, Map<Fields, String> map, Fields field, boolean isJavaScript = false) {
		if(MapUtil.isValidData(map, field)) {
			String text = map.get(field)
			if(isJavaScript) {
				WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.Timeout)
				List<WebElement> list = new ArrayList<WebElement>()
				list.add(e)
				WebUI.executeJavaScript('arguments[0].value = "'+text+'"', list)
			}
			else {
				WebUI.setText(to, text, FailureHandling.STOP_ON_FAILURE)
			}
		}
	}

	@Keyword
	static def selectOptionByLabel(TestObject to, Map<Fields, String> map, Fields field) {
		if(MapUtil.isValidData(map, field)) {
			String text = map.get(field)
			WebUI.selectOptionByLabel(to, text, false)
		}
	}

	@Keyword
	static def check(TestObject to, Map<Fields, String> map, Fields field, String isScrollType = "nearest") {
		if(MapUtil.isValidData(map, field)) {
			scrollToElement(to, GlobalVariable.Timeout, isScrollType)
			WebUI.check(to)
		}
	}

	@Keyword
	static def uncheck(TestObject to, Map<Fields, String> map, Fields field, String isScrollType = "nearest") {
		if(MapUtil.isValidData(map, field)) {
			scrollToElement(to, GlobalVariable.Timeout, isScrollType)
			WebUI.uncheck(to)
		}
	}

	static def scrollToElement(TestObject to, int timeout, String isScrollType = "nearest") {

		//arguments[0].scrollIntoView({ behavior: 'smooth', block: 'nearest', inline: 'start' }); window.scrollBy(0,-100);     -> Working for customer pages
		try {
			WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.Timeout)
			List<WebElement> list = new ArrayList<WebElement>()
			list.add(e)
			if(isScrollType.equalsIgnoreCase("nearest"))
				WebUI.executeJavaScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'nearest', inline: 'start' }); window.scrollBy(0,-100);", list)
			else if(isScrollType.equalsIgnoreCase("top"))
				WebUI.executeJavaScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-100);", list)
			else if(isScrollType.equalsIgnoreCase("bottom"))
				WebUI.executeJavaScript("arguments[0].scrollIntoView(false); window.scrollBy(0,100);", list)
		}
		catch(Exception e1) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to scroll to element'+e1.toString())
		}
	}

	static def scrollBy(int x, int y) {
		WebUI.executeJavaScript("window.scrollBy("+x+","+y+");", null)
	}

	@Keyword
	static def waitForElementVisible(TestObject to, int timeout) {
		WebUI.waitForElementVisible(to, timeout)
		WebUI.verifyElementVisible(to)
	}

	static def isEnabled(TestObject to) {
		return WebUiCommonHelper.findWebElement(to, GlobalVariable.Timeout).isEnabled()
	}

	static def isReadonly(TestObject to) {

		Boolean result = false;
		try {
			String value = WebUiCommonHelper.findWebElement(to, GlobalVariable.Timeout).getAttribute("readOnly")
			if (value != null){
				result = true;
			}
		} catch (Exception e) {}

		return result;
	}

	@Keyword
	public static  void typeText(TestObject uiObject,String text){
		if(uiObject == null ){
			KeywordUtil.markFailed('Invalid Testobject'+uiObject+'provided.')
		}
		if(text != null){
			try{
				WebUtil.setText(uiObject,text)
			}
			catch(Exception e){
				WebUI.takeScreenshot()
				e.printStackTrace()
			}
		}
	}

	@Keyword
	public static verifyMouseOverText(TestObject objectForMouseOver,TestObject toolTip,String expected,Operator o){
		WebUI.mouseOver(objectForMouseOver)
		WebUI.waitForElementPresent(toolTip, GlobalVariable.Timeout)
		//WebUI.delay(2)
		String actualText = WebUI.getText(toolTip)
		WebActions.verifyMatch(actualText, expected, Operator.EQUALS_IGNORE_CASE)
		println "Title is : "+ actualText
	}


	@Keyword
	public static void clickObject(TestObject uiObject){
		if(uiObject != null){
			try{
				WebUI.click(uiObject)
			}
			catch(Exception e){
				WebUI.takeScreenshot()
				e.printStackTrace()
			}
		}
	}

	@Keyword
	def static logout(){
		TestObject userInfo = findTestObject('Logout/userInfo')
		clickObject(userInfo)
		TestObject logoutOption = findTestObject('Logout/logoutOption')
		clickObject(logoutOption)
		WebUI.delay(3)
	}

	@Keyword
	public boolean verifyElementPresent(TestObject uiObject,int timeout){
		if(uiObject == null ){
			KeywordUtil.markFailed('Invalid Testobject'+uiObject+'provided.')
		}
		if(WebUI.verifyElementPresent(uiObject, 3,FailureHandling.CONTINUE_ON_FAILURE) == true){
			log.logInfo("Element  present  successfully in " + uiObject )
			return true
		}else{
			KeywordUtil.markFailed("Element not present  successfully in " + uiObject)
			log.logError("Element not present  successfully in " + uiObject )
			return false
		}
		return true;
	}





}
