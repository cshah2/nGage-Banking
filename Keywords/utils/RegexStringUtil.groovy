package utils

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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Operator
import internal.GlobalVariable

public class RegexStringUtil {

	private static String addEscapeChars(String text) {

		//. \ + * ? [ ^ ] $ ( ) { } = ! < > | : -
		text = text.replaceAll('\\+', '\\\\+')
		text = text.replaceAll('\\*', '\\\\*')
		text = text.replaceAll('\\?', '\\\\?')
		text = text.replaceAll('\\.', '\\\\.')
		text = text.replaceAll('\\/', '\\\\/')

		return text
	}

	public static String formRegexString(String text, Operator operator) {


		switch(operator) {

			case Operator.EQUALS:
				text = addEscapeChars(text)
				break;
			case Operator.EQUALS_IGNORE_CASE:
				text = addEscapeChars(text)
				text = '(?i)'+text+'(?i)'
				break;
			case Operator.CONTAINS:
				text = addEscapeChars(text)
				text = '.*'+text+'.*'
				break;
			case Operator.CONTAINS_IGNORE_CASE:
				text = addEscapeChars(text)
				text = '.*(?i)'+text+'(?i).*'
				break;
			case Operator.STARTS_WITH:
				text = addEscapeChars(text)
				text = '^'+text+'.*'
				break;
			case Operator.STARTS_WITH_IGNORE_CASE:
				text = addEscapeChars(text)
				text = '^(?i)'+text+'(?i).*'
				break;
			case Operator.ENDS_WITH:
				text = addEscapeChars(text)
				text = '.*'+text+'$'
				break;
			case Operator.ENDS_WITH_IGNORE_CASE:
				text = addEscapeChars(text)
				text = '.*(?i)'+text+'(?i)$'
				break;
			case Operator.NONE:
				break;
			default:
				break;
		}
		return text;
	}
}
