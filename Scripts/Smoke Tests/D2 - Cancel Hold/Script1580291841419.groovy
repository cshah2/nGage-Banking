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
Map<Fields, String> customerData = ConsumerData.CUSTOMERDATA_MAP
Map<Fields, String> custHoldData = ConsumerData.ACCOUNT_HOLD
TestObject holdsTable = findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/table_Holds')

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(custHoldData.get(Fields.URL))


'Click on Accounts Tab'
WebUI.click(findTestObject('Consumer/ConsumerDashboardPage/TabsSection/tab_Holds'))
//steps to goto accounts tab and click a account
'Click on Edit Icon'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/HoldsSection/icon_editAddedHold'))

'Click on Cancel Hold Option'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerDashboardPage/HoldsSection/link_CancelHold'))


'Type the hold Notes'
CustomKeywords.'actions.WebActions.typeText'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/textarea_Notes'), custHoldData.get(Fields.HOLD_NOTE))


'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerHolds/btn_Submit'))
