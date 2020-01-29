package services

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
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable

public class OneSecEmail {

	def messages
	def message

	def getMessages(String username) {
		RequestObject request = findTestObject('Object Repository/API/1SecMail/getMessages',
				[
					('username'):username,
				])
		ResponseObject response = WS.sendRequest(request)
		WS.verifyResponseStatusCode(response, 200)
		JsonSlurper jsonSlurper = new JsonSlurper()
		messages = jsonSlurper.parseText(response.getResponseBodyContent())
	}

	def getMessageCount() {

		return messages.size();
	}

	def getSubject(int messageNoFromTop) {

		return messages[0].subject;
	}

	def getMessageId(int messageNoFromTop) {

		return messages[0].id;
	}


	def readMessage(String username, int messageId) {
		RequestObject request = findTestObject('Object Repository/API/1SecMail/readMessage',
				[
					('username'):username,
					('messageId'):messageId,
				])
		ResponseObject response = WS.sendRequest(request)
		WS.verifyResponseStatusCode(response, 200)
		JsonSlurper jsonSlurper = new JsonSlurper()
		message = jsonSlurper.parseText(response.getResponseBodyContent())
	}

	def getMessageBody(){
		return message.textBody.toString()
	}

	def getValueFromMessageBody(String searchText, int textLength) {

		String body = getMessageBody()
		int startIndex = body.lastIndexOf(searchText)+searchText.length()
		int endIndex = startIndex+textLength
		String code = body[startIndex..endIndex]
		println "Verification code = "+code
		return code
	}
}
