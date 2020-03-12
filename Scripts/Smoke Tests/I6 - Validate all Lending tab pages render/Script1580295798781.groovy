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
import internal.GlobalVariable as GlobalVariable
import pages.consumer.ConsumerDashboardPage
import constants.Fields as Fields
import constants.Operator as Operator
import constants.Urls as Urls
import data.ConsumerData as ConsumerData
import utils.MapUtil as MapUtil

Map<Fields, String> accData = ConsumerData.ACC_B2_POS5

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Open Consumer dashboard page'
WebUI.navigateToUrl(accData.get(Fields.URL))

'Verify the Account Overview tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/OverviewTab/AccountsBlock/Balance summary'), 
    GlobalVariable.Timeout)

'Click on Details tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Details'))

'verify the Details tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Details tab_Account/Table_Account Details'), 
    GlobalVariable.Timeout)

'Click on Transactions tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Transactions'))

'Verify the Transaction tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Transactions tab/table_transactions'), 
    GlobalVariable.Timeout)

'Click on Interest tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Interest'))

'Verify the Interest tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Interest Tab/Heading_Interest Details'), 
    GlobalVariable.Timeout)

'Click on Orders tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/Tab_Order'))

'Verify the Order tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Orders Tab/table_Order'), 
    GlobalVariable.Timeout)

'Click on Receivables tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Recievables'))


'Click on Notes tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Notes'))

'Verify the Notes tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Notes Tab/Notes table'), GlobalVariable.Timeout)

'Click on Documents tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Documents'))

'Verify the Documents tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Documents Tab/Documents table'), GlobalVariable.Timeout)

'Click on Cases tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Cases'))

'Verify the Cases tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Cases tab/Cases table'), GlobalVariable.Timeout)