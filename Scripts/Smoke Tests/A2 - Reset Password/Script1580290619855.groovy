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
import constants.Operator as Operator
import constants.Urls as Urls
import internal.GlobalVariable as GlobalVariable

String username = 'sav_auto@savee.site'
String email = 'sav.auto@1secmail.com'
String forgotPasswordMessage = 'Click Submit below to send an automated password retrieval email message to the email address we have associated with your user account. Once you log on successfully, protect your account privacy by changing your password immediately.'
String successMessage = 'Your request has been received successfully.\nYou will receive an email shortly.'
String expectedMailSubject = 'Enterprise Servicing Change Password Request'

'Load browser'
CustomKeywords.'actions.WebActions.openBrowser'()

'Maximize browsers window'
WebUI.maximizeWindow()

'Clear browser cache'
WebUI.deleteAllCookies()

'Navigate to login page'
WebUI.navigateToUrl(Urls.LOGIN_PAGE)

'Enter username'
WebUI.setText(findTestObject('Object Repository/LoginPage/input_UserName'), username)

'Click on Forgot password link'
WebUI.click(findTestObject('Object Repository/LoginPage/link_ForgotPassword'))

'Verify the forgot password message is correct'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/ForgotPasswordPage/text_Information')), 
    forgotPasswordMessage, Operator.EQUALS)

'Click on Submit button'
WebUI.click(findTestObject('Object Repository/ForgotPasswordPage/btn_Submit'))

'Verify success message is displayed on the page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/ForgotPasswordPage/text_SuccessMessage')), 
    successMessage, Operator.EQUALS)

'Wait for 5 Seconds for email operation to complete'
WebUI.delay(5)

'Verify user receives email'
CustomKeywords.'actions.Email.verifyMailCount'(email, 1, Operator.GREATER_THAN_OR_EQUALS)

'Verify email subject'
CustomKeywords.'actions.Email.verifyMailSubject'(email, 1, expectedMailSubject, Operator.EQUALS)

