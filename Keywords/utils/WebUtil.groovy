package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.ElementClickInterceptedException
import org.openqa.selenium.ElementNotInteractableException
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Fields
import constants.Operator
import constants.Urls
import internal.GlobalVariable

public class WebUtil {

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

	static def void openBrowser() {

		try {
			DriverFactory.getWebDriver()
		}
		catch(Throwable t) {
			WebUI.openBrowser('')
			WebUI.maximizeWindow()
		}
	}

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
				WebUI.setText(to, text)
			}
		}
	}

	static def selectOptionByLabel(TestObject to, Map<Fields, String> map, Fields field) {
		if(MapUtil.isValidData(map, field)) {
			String text = map.get(field)
			WebUI.selectOptionByLabel(to, text, false)
		}
	}

	static def check(TestObject to, Map<Fields, String> map, Fields field) {
		if(MapUtil.isValidData(map, field)) {
			WebUI.check(to)
		}
	}

	static def scrollToElement(TestObject to, int timeout) {
		try {
			WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.Timeout)
			List<WebElement> list = new ArrayList<WebElement>()
			list.add(e)
			WebUI.executeJavaScript('arguments[0].scrollIntoViewIfNeeded()', list)
		}
		catch(Exception e1) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to scroll to element'+e1.toString())
		}
	}

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
}