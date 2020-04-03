import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

import com.github.javafaker.Faker
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

import constants.Operator
import constants.Urls
import internal.GlobalVariable as GlobalVariable

String username = 'sav_auto@savee.site'
String email = 'sav.auto@1secmail.com'
String name = 'Savana automation'
String expectedMailSubject = 'Enterprise Servicing Change Password Request'
String passwordUpdateMessage = 'Password Successfully Updated.'

Faker faker = new Faker(Locale.US)
String newPassword = faker.internet().password(12, 16, true, true)

WebUI.delay(10)

'Verify user mailbox has atleast one email'
CustomKeywords.'actions.Email.verifyMailCount'(email, 1, Operator.GREATER_THAN_OR_EQUALS)

'Verify last email is related to Reset password'
CustomKeywords.'actions.Email.verifyMailSubject'(email, 1, expectedMailSubject, Operator.EQUALS)

'Get Temporay password from email'
String password = CustomKeywords.'actions.Email.getTemporaryPassword'(email, 1)



println "The password : " + password

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

'Enter password'
WebUI.setText(findTestObject('Object Repository/LoginPage/input_Password'), password)

'Click on Login button'
WebUI.click(findTestObject('Object Repository/LoginPage/btn_Login'))

'Verify user is redirected user profile page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.USER_PROFILE_PAGE, Operator.EQUALS_IGNORE_CASE)

'Verify Name of the user matches'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/UserprofilePage/text_Name')), name, Operator.EQUALS)

'Verify email of the user matches'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/UserprofilePage/text_Email')), email, Operator.EQUALS)

'Enter Current password'
WebUI.setText(findTestObject('Object Repository/UserprofilePage/input_CurrentPassword'), password)

'Enter New password'
WebUI.setText(findTestObject('Object Repository/UserprofilePage/input_NewPassword'), newPassword)

'Enter Confirm New password'
WebUI.setText(findTestObject('Object Repository/UserprofilePage/input_ConfirmNewPassword'), newPassword)

'Press Tab key to change focuse'
WebUI.sendKeys(findTestObject('Object Repository/UserprofilePage/input_ConfirmNewPassword'), Keys.chord(Keys.TAB))

'Click on Save button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/UserprofilePage/btn_Save'))

'Wait for popup dialog to be visible'
WebUI.waitForElementVisible(findTestObject('Object Repository/UserprofilePage/block_PopupDialog'), GlobalVariable.Timeout)

'Verify message on popup dialog'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/UserprofilePage/text_PopupMessage')), passwordUpdateMessage, Operator.EQUALS)

'Click on OK button'
WebUI.click(findTestObject('Object Repository/UserprofilePage/btn_Popup_OK'))

/*'Wait for search page to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/SearchPage/SearchConsumer/input_FirstName'), GlobalVariable.Timeout)*/

/*'Verify user is redirected to the Search Page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS)*/

'Clear browser cache'
WebUI.deleteAllCookies()

'Navigate to login page'
WebUI.navigateToUrl(Urls.LOGIN_PAGE)

'Enter username'
WebUI.setText(findTestObject('Object Repository/LoginPage/input_UserName'), username)

'Enter new password'
WebUI.setText(findTestObject('Object Repository/LoginPage/input_Password'), newPassword)

'Click on Login button'
WebUI.click(findTestObject('Object Repository/LoginPage/btn_Login'))


'Verify user is redirected to the Search Page'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getUrl(), Urls.SEARCH_PAGE, Operator.EQUALS)