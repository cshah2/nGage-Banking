import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.Rectangle
import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.apache.commons.io.FileUtils
import org.openqa.selenium.Point
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.seleniumhq.jetty9.server.Response.OutputType

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.model.KatalonPackage
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KatalonHarEntry
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.ScreenUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Fields
import constants.Operator
import constants.TableType
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

//WebUI.callTestCase(findTestCase('Test Cases/Base API Calls/A0 - Create Consumer'), null)

Map<Fields, String> custData = ConsumerData.CUST_B

'Task Name'
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
String filePath = RunConfiguration.getProjectDir()+"\\Data Files\\Upload File\\Document1.png"

'Wait for Task drawer to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(fileUploadObj, GlobalVariable.Timeout)

'Upload File'
CustomKeywords.'actions.WebActions.uploadFile'(fileUploadObj, filePath)


'Select Document class'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/Customer Documents/select_DocClass'), "Identification", false)


'Select Document Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/Customer Documents/select_DocType'), "Identity Card", false)

'click on First Document'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/Customer Documents/btn_Submit'))


'click on First Close Window'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Documents'))


TestObject  docTable = findTestObject('Consumer/ConsumerDashboardPage/DocumentSection/Documents table')

'Wait for table to load'
WebUI.waitForElementVisible(docTable, GlobalVariable.Timeout)

'Click on first row'
CustomKeywords.'actions.WebTable.clickCell'(findTestObject('Consumer/ConsumerDashboardPage/DocumentSection/Documents table'), 1, 3,TableType.DOCUMENT)

'Switch to Child window tab :1'
WebUI.switchToWindowIndex(1)



'Wait for Image to load'
WebUI.waitForElementVisible(findTestObject('Consumer/ConsumerDashboardPage/DocumentSection/img_UploadedDoc'), GlobalVariable.Timeout)

'Take webelemnet screenshot'
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Consumer/ConsumerDashboardPage/DocumentSection/img_UploadedDoc'), 30)

'Initialize the WebDriver'
WebDriver driver = DriverFactory.getWebDriver()

"Take screenshot the uploaded image"
WebUtil.takeWebelementScreenshot(element, driver)
   
println "Screenshot sucess"

String expectedTextFromImage = "This is Image comparison"
String actualFilePath = WebUtil.actualFileUploadedPath
String atualTextFromImage = WebUtil.getTextFromImage(actualFilePath)
println "Actual text : " + atualTextFromImage
println "Expected text : " + expectedTextFromImage

'Verify text from actual and expected image'
CustomKeywords.'actions.WebActions.verifyMatch'(atualTextFromImage, expectedTextFromImage, Operator.EQUALS_IGNORE_CASE)


'Click on Download Icon'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/DocumentSection/icon_Download'))

'Get document title from the document page'
String docTitle = WebUI.getText(findTestObject('Consumer/ConsumerDashboardPage/DocumentSection/text_DocTitle'))
println "DocTitle :" + docTitle.replaceAll("/","")

'Path for the downloaded document'
//String path = "C:\\NGage-Banking-Automation\\nGage-Banking\\Data Files\\DownloadedFile\\"+docTitle.replaceAll("/","")+".PNG"

String path = "C:\\Users\\rbalasundaram\\Downloads\\"+docTitle.replaceAll("/","")+".PNG"

'Switch to Child Window(1)'
WebUI.switchToWindowIndex(1)

'Open downloaded image in the browser'
WebUI.navigateToUrl(path)

'Take webelemnet screenshot'
WebElement downloadedImgelement = WebUiCommonHelper.findWebElement(findTestObject('Consumer/ConsumerDashboardPage/DocumentSection/downloaded_Image',[('url') : WebUI.getUrl()]), 30)


"Take screenshot the uploaded image"
WebUtil.takeWebelementScreenshot(downloadedImgelement, driver)

println "Screenshot sucess"
String atualTextFromDownloadedImage = WebUtil.getTextFromImage(path)
println "Actual text : " + atualTextFromDownloadedImage
println "Expected text : " + expectedTextFromImage

'Verify text from actual and expected image'
CustomKeywords.'actions.WebActions.verifyMatch'(atualTextFromDownloadedImage, expectedTextFromImage, Operator.EQUALS_IGNORE_CASE)

'verify Downloaded Document'
WebUtil.verifyDownloadedFile(docTitle.replaceAll("/",""))

'Initiliazxe the Directory path to be cleaned'
String dataCleanPath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\DownloadedFile\\'
//String dataCleanPath = 'C:\\Users\\apatil\\Downloads\\'
'Clean Directory'
FileUtils.cleanDirectory(new File(dataCleanPath))

'Close current window'
WebUI.closeWindowIndex(1)

'Switch to Child Window(0)'
WebUI.switchToWindowIndex(0)





