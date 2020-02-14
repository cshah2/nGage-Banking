import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Fields
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A0 - Create Consumer'), null)

Map<Fields, String> custData = ConsumerData.CUST_B

WebUtil.shouldFailTest(custData)

String taskName = "Add Customer Document"

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate to account dashboard page'
WebUI.navigateToUrl(custData.get(Fields.URL))

'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

TestObject fileUploadObj = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/Customer Documents/input_FileUpload')
String filePath = RunConfiguration.getProjectDir()+"\\Data Files\\Upload File\\Image1.png"

'Wait for Task drawer to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(fileUploadObj, GlobalVariable.Timeout)

'Upload File'
CustomKeywords.'actions.WebActions.uploadFile'(fileUploadObj, filePath)
