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

import constants.Operator
import internal.GlobalVariable as GlobalVariable

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click on Information icon'
WebUI.click(findTestObject('Object Repository/BasePage/HeaderSection/icon_SystemInformation'))

'Wait for floating block to be visible'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/BasePage/HeaderSection/SystemInformation/block_TooltipBody'), GlobalVariable.Timeout)

'Verify connectedTo value is correctly populated'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/BasePage/HeaderSection/SystemInformation/text_ConnectedTo')), GlobalVariable.ConnectedTo, Operator.CONTAINS)

//TODO: We dont have any mechanism to verify version number as they keep on changin.

