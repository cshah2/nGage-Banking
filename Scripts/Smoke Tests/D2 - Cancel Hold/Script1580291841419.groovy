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
import constants.Icon
import constants.Operator as Operator
import data.ConsumerData as ConsumerData
import data.ConsumerTempData

int LATEST_ROW = 1
int WAIT_FOR_FIVE_SECONDS = 5

Map<Fields, String> accData = ConsumerData.ACC_B1
Map<Fields, String> custHoldData = ConsumerTempData.ACCOUNT_HOLD
TestObject holdsTable = findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/table_Holds')

String taskName = 'Add Hold'

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(accData.get(Fields.URL))

'Click on Holds Tab'
WebUI.click(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Holds'))

'Wait for Holds tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(holdsTable, GlobalVariable.Timeout)

'Verify Holds table has entry'
CustomKeywords.'actions.WebTable.verifyRowsCountMatches'(holdsTable, 1, Operator.EQUALS)

'Click on Edit Icon'
CustomKeywords.'actions.WebTable.clickIconInTable'(holdsTable, LATEST_ROW, 8, Icon.ELLIPSIS)

'Wait for Context menu to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Consumer/ConsumerDashboardPage/HoldsTab/link_CancelHold'), GlobalVariable.Timeout)


WebUI.delay(GlobalVariable.Timeout)

'Click on Cancel Hold Option'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/HoldsTab/link_CancelHold'))

'Type the hold Notes'
WebUI.setText(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/textarea_Notes'), 'Cancel Hold operation')

'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/btn_Submit'))

/*'Verify Hold Cancel Alert Message'
WebUI.verifyElementVisible(findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/ConsumerHolds/message_HoldCancel'))
*/
'Wait for Task drawer to close'
CustomKeywords.'pages.taskdrawer.TaskDrawer.waitForTaskDrawerToClose'()

WebUI.delay(WAIT_FOR_FIVE_SECONDS)

'Verify Holds table has no entry'
//CustomKeywords.'actions.WebTable.verifyRowsCountMatches'(holdsTable, 0, Operator.EQUALS)

'Click on Overview tab'
WebUI.click(findTestObject('Object Repository/Account/AccountDashboardPage/TabSection/tab_Overview'))

'Wait for Overview tab to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/text_AvailableBalance'), GlobalVariable.Timeout)

'Verify total holds amount'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Account/AccountDashboardPage/OverviewTab/text_TotalHoldsBalance')), '15.00', Operator.EQUALS)