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
import constants.Fields
import constants.Operator
import constants.Urls
import data.ConsumerData
import internal.GlobalVariable as GlobalVariable
import utils.MapUtil

Map<Fields, String> accData = ConsumerData.ACC_B2_POS1

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Open Consumer dashboard page'
WebUI.navigateToUrl(accData.get(Fields.URL))

'Verify the Account Overview tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Consumer/ConsumerDashboardPage/OverviewTab/AccountsBlock/Heading Holds'), GlobalVariable.Timeout)

'Verify the Transactions tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/OverviewTab/AccountsBlock/Transactions table'), GlobalVariable.Timeout)

'Click on Details tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Details'))

'Verify the Account Details tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Details tab_Account/Table_Account Details'), GlobalVariable.Timeout)

'Click on Transactions tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Transactions'))

'Verify the Transactions tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Transactions tab/table_transactions'), GlobalVariable.Timeout)

'Click on Interest tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Interest'))

'Verify the Interest tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Interest Tab/Heading_Interest Accural Information'), GlobalVariable.Timeout)

'Click on Holds tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Holds'))
'Verify the Holds tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Consumer/ConsumerDashboardPage/HoldsTab/Table_Holds'), GlobalVariable.Timeout)

'Click on Orders tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/Tab_Order'))
'Verify the Order tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/Orders Tab/table_Order'), GlobalVariable.Timeout)

'Click on Notes tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Notes'))

'Verify the Notes tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Consumer/ConsumerDashboardPage/NotesTab/Notes table'), GlobalVariable.Timeout)
'Click on Documents tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Documents'))

'Verify the Documents tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/DocumentSection/Documents table'), GlobalVariable.Timeout)

'Click on Cases tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Cases'))

'Verify the Cases tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Consumer/ConsumerDashboardPage/CasesTab/table_Cases'), GlobalVariable.Timeout)