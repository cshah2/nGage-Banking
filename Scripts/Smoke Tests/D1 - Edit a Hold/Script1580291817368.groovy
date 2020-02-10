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
import constants.Urls as Urls
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData as ConsumerData

int LATEST_ROW = 1

int WAIT_FOR_FIVE_SECONDS = 5

int SUBSTRING_DATE_START = 0

int SUBSTRING_DATE_END = 10

Map<Fields, String> customerData = ConsumerData.CUST_B

Map<Fields, String> custHoldData = ConsumerData.ACC_B1

TestObject holdsTable = findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/table_Holds')

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(custHoldData.get(Fields.URL))

'Click on Holds Tab'
WebUI.click(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Holds'))

//steps to goto accounts tab and click a account
'Click on Edit Icon'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/HoldsSection/icon_editAddedHold'))

'Click on Edit Hold Option'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/HoldsSection/link_EditHold'))

'Clear hold amount'
WebUI.clearText(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/input_HoldAmount'))

'Edit hold amount'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/input_HoldAmount'), 
    custHoldData.get(Fields.HOLD_AMOUNT))

'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/btn_Submit'))

'Verify Hold Created Alert Message'
WebUI.verifyElementVisible(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/message_HoldUpdated'))

WebUI.delay(WAIT_FOR_FIVE_SECONDS)

'Verify the consumer holds table (Hold Type)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(holdsTable, LATEST_ROW, ColumnPosition.HOLD_TYPE, custHoldData.get(
        Fields.HOLD_TYPE), Operator.EQUALS_IGNORE_CASE)

'Verify the consumer holds table (Hold Duration)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(holdsTable, LATEST_ROW, ColumnPosition.HOLD_DURATION, custHoldData.get(
        Fields.HOLD_DURATION), Operator.EQUALS_IGNORE_CASE)

'Verify the consumer holds table (Hold amount)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(holdsTable, LATEST_ROW, ColumnPosition.HOLD_AMOUNT, custHoldData.get(
        Fields.HOLD_AMOUNT), Operator.CONTAINS_IGNORE_CASE)

'Verify the consumer holds table (Start Date)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(holdsTable, LATEST_ROW, ColumnPosition.HOLD_START_DATE, custHoldData.get(
        Fields.HOLD_START_DATE).substring(SUBSTRING_DATE_START, SUBSTRING_DATE_END), Operator.EQUALS)

'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/OverviewTab/icon_ExpandHold'))

'Verify the Hold amount in Account Overview Page'
CustomKeywords.'pages.account.tabs.AccountOverviewTab.verifyHoldsUnderAccountOverview'(custHoldData.get(Fields.HOLD_TYPE), 
    custHoldData)