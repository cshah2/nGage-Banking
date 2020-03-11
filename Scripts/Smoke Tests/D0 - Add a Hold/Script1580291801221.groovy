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
import utils.MapUtil as MapUtil
import constants.Urls as Urls
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Operator as Operator
import data.ConsumerData as ConsumerData
import data.ConsumerTempData

int LATEST_ROW = 1

int WAIT_FOR_FIVE_SECONDS = 5
int SUBSTRING_DATE_START = 0
int SUBSTRING_DATE_END = 10
Map<Fields, String> accData = ConsumerData.ACC_B1
Map<Fields, String> custHoldData = ConsumerTempData.ACCOUNT_HOLD
TestObject holdsTable = findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/table_Holds')

String taskName = 'Add Hold'

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(accData.get(Fields.URL))

'Click on Task Drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Click on Add Hold Tasks'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

'Wait for task to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/select_HoldType'), GlobalVariable.Timeout)

'Select Account Hold Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/select_HoldType'), custHoldData.get(Fields.HOLD_TYPE), true)

//'Set value on start date'
//CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/input_StartDate'))

'Set Start date'
CustomKeywords.'actions.WebActions.setText'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/input_StartDate'), custHoldData, Fields.HOLD_START_DATE, true)

'Select Account Hold Type'
WebUI.selectOptionByLabel(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/select_Duration'), custHoldData.get(Fields.HOLD_DURATION), true)

'Type Hold Amount'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/input_HoldAmount'), custHoldData.get(Fields.HOLD_AMOUNT))

'Type the hold reason'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/input_Reason'), custHoldData.get(Fields.HOLD_REASON))

'Click on Submit Button'
WebUI.click(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/btn_Submit'))

'Verify Hold Created Alert Message'
//WebUI.verifyElementVisible(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/message_HoldCreated'))

'Wait for Task drawer to close'
CustomKeywords.'pages.taskdrawer.TaskDrawer.waitForTaskDrawerToClose'()

'Wait for Holds table to load transaction'
CustomKeywords.'actions.WebTable.waitUntilRowsCountMatches'(holdsTable, 1, Operator.EQUALS, GlobalVariable.Timeout)

'Verify Holds table has entry'
CustomKeywords.'actions.WebTable.verifyRowsCountMatches'(holdsTable, 1, Operator.EQUALS)

'Verify the consumer holds table (Hold Type)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(holdsTable, LATEST_ROW, ColumnPosition.HOLD_TYPE, custHoldData.get(Fields.HOLD_TYPE), Operator.EQUALS_IGNORE_CASE)

'Verify the consumer holds table (Hold Duration)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(holdsTable, LATEST_ROW, ColumnPosition.HOLD_DURATION, custHoldData.get(Fields.HOLD_DURATION), Operator.EQUALS_IGNORE_CASE)

'Verify the consumer holds table (Hold amount)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(holdsTable, LATEST_ROW, ColumnPosition.HOLD_AMOUNT, custHoldData.get(Fields.HOLD_AMOUNT_VIEW), Operator.CONTAINS_IGNORE_CASE)

'Verify the consumer holds table (Start Date)'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(holdsTable, LATEST_ROW, ColumnPosition.HOLD_START_DATE, custHoldData.get(Fields.HOLD_START_DATE).substring(SUBSTRING_DATE_START, SUBSTRING_DATE_END), Operator.EQUALS)

'Click on Overview tab'
WebUI.click(findTestObject('Object Repository/Account/AccountDashboardPage/TabSection/tab_Overview'))

'Wait for Overview tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/text_AvailableBalance'), GlobalVariable.Timeout)

'Verify total holds amount'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/text_TotalHoldsBalance')), custHoldData.get(Fields.HOLD_AMOUNT_VIEW), Operator.EQUALS)

'Expand Holds section in balance summary block'
CustomKeywords.'actions.WebActions.click'(findTestObject('Account/AccountDashboardPage/OverviewTab/icon_ExpandHold'))

'Verify the Hold amount in Account Overview Page'
CustomKeywords.'pages.account.tabs.AccountOverviewTab.verifyHoldsUnderAccountOverview'(custHoldData)