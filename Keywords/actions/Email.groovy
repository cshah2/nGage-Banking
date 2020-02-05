package actions

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

import constants.Operator
import groovy.json.JsonSlurper
import internal.GlobalVariable
import services.OneSecEmail

public class Email {

	@Keyword
	static def verifyMailCount(String email, int expCount, Operator operator) {
		
		String username = email.split('@')[0]
		OneSecEmail mailbox = new OneSecEmail()
		mailbox.getMessages(username)
		
		int actCount = mailbox.getMessageCount()
		WebActions.verifyNumbericMatch(actCount, expCount, operator)
	}
	
	@Keyword
	static def verifyMailSubject(String email, int messageNo, String expSubject, Operator operator) {

		String username = email.split('@')[0]
		OneSecEmail mailbox = new OneSecEmail()
		mailbox.getMessages(username)
		
		String actSubject = mailbox.getSubject(messageNo)
		WebActions.verifyMatch(actSubject, expSubject, operator)
	}

	@Keyword
	static def getVerificationCode(String email, int messageNo) {

		String searchText = 'Pleaase use this one-time activation code '
		String username = email.split('@')[0]
		OneSecEmail mailbox = new OneSecEmail()
		mailbox.getMessages(username)
		
		int messageId = mailbox.getMessageId(messageNo)
		println "Message ID = "+messageId
		mailbox.readMessage(username, messageId)
		return mailbox.getValueFromMessageBody(searchText, 5)
	}
	
	@Keyword
	static def getTemporaryPassword(String email, int messageNo) {
		
		String searchText = 'Your new password is:\n'
		String username = email.split('@')[0]
		OneSecEmail mailbox = new OneSecEmail()
		mailbox.getMessages(username)
		
		int messageId = mailbox.getMessageId(messageNo)
		println "Message ID = "+messageId
		mailbox.readMessage(username, messageId)
		return mailbox.getValueFromMessageBody(searchText, 7)
	}
}
