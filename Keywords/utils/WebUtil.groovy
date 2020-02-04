package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.Map

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

	static def shouldFailTest(Map<Fields, String> data) {
		if(!(data.containsKey(Fields.IS_CREATED) && data.get(Fields.IS_CREATED).equalsIgnoreCase("true"))) {
			KeywordUtil.markFailedAndStop('Pre-requisite test data is not created, Thus marking this test as failed')
		}
	}


	static def setText(TestObject uiObject,String text){
		try{
			if(uiObject == null){
				KeywordUtil.markFailed('Invalid Testobject'+uiObject+'provided.')
			}
			if(uiObject != null && text != null){
				WebUI.sendKeys(uiObject, text)
			}
		}catch(Exception e){
			e.printStackTrace()
		}
	}
}