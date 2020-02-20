import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.swing.Icon as Icon
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass as CustomKeywordDelegatingMetaClass
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import constants.ColumnPosition as ColumnPosition
import constants.Fields as Fields
import constants.Operator as Operator
import constants.TableType as TableType
import data.ConsumerData as ConsumerData

int WAIT_FOR_THREE_SECONDS = 3

Map<Fields, String> customerData = ConsumerData.CUST_B

int LATEST_ROW = 1

String taskName = 'Add Customer Service Case'

String caseType = 'Name Update'

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Navigate To customer dashboard'
WebUI.navigateToUrl(customerData.get(Fields.URL))

'Open task drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Select Task'
CustomKeywords.'pages.taskdrawer.TaskDrawer.selectTaskInDrawer'(taskName)

'Select CaseType'
WebUI.selectOptionByLabel(findTestObject('Account/AccountTaskDrawer/CaseSection/select_CaseType'), caseType, true)

'Click on Submit Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Consumer/ConsumerTaskDrawer/ConsumerCase/AddCase/btn_Submit'))

'Switch to tab'
WebUI.switchToWindowIndex(1)

'Get Case number  from WMI UI'
String generalInfo = WebUI.getText(findTestObject('BasePage/WorkFlow/text_GeneralCaseInfo'))

String[] genralInfoArray = generalInfo.split('\n')

String caseNumberFromGeneralInfo = (genralInfoArray[0]).split(':')[1]

'Get Case Tyep   from WMI UI'
String caseTypeInWMI = WebUI.getText(findTestObject('BasePage/WorkFlow/text_CaseType'))

String[] spanText = generalInfo.split('\n')

println('Case number in WMI : ' + (spanText[0]))

'Verify Routing Reason'
CustomKeywords.'actions.WebActions.verifyMatch'(caseTypeInWMI, caseType, Operator.EQUALS)

'Verify User profile name'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo, GlobalVariable.UserProfileName, Operator.CONTAINS_IGNORE_CASE)

'Verify Case status'
CustomKeywords.'actions.WebActions.verifyMatch'(generalInfo, 'Case Status: New', Operator.CONTAINS_IGNORE_CASE)

//verify customer_Info
'Extract Customer Info from WMI'
String customerInfo = WebUI.getText(findTestObject('BasePage/WorkFlow/text_ConsumerInfo'))

'Verify Consumer ID in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo, customerData.get(Fields.CUST_ID), Operator.CONTAINS_IGNORE_CASE)

'Verify Consumer mailid  in Customer Info'
CustomKeywords.'actions.WebActions.verifyMatch'(customerInfo, customerData.get(Fields.CONTACT_EMAIL), Operator.CONTAINS_IGNORE_CASE)

'Switch to Default frame'
WebUI.switchToDefaultContent()

'click on First Close Window'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/btn_Closewindow'))

'Switch to default window'
WebUI.switchToWindowIndex(0)

'Login into portal'
CustomKeywords.'pages.LoginPage.loginIntoPortal'()

'Click on Vault'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/LeftMenus/link_TheVault'))

'Select Process'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/Vault/select_searchRepo'))

'Select All account services'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/Vault/option_AllAccountServices'))

'Select Search Repository'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/Vault/select_SearchClass'))

'Click on All Documents Services'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/Vault/option_AllAccountCases'))

'Type customer ID'
WebUI.setText(findTestObject('BasePage/Vault/input_CaseNumber'), caseNumberFromGeneralInfo)

WebUI.delay(WAIT_FOR_THREE_SECONDS)

'Click on Search Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/Vault/btn_Search'))

TestObject tableCaseResults = findTestObject('BasePage/Vault/table_DivDocuments')

'Wait forSearch results table'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableCaseResults, GlobalVariable.Timeout)

'Verify Case Type in in Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(tableCaseResults, LATEST_ROW, ColumnPosition.VAULT_CASE_TYPE, caseType, Operator.EQUALS_IGNORE_CASE, 
    TableType.DOCUMENT)

'Verify Customer ID in Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(tableCaseResults, LATEST_ROW, ColumnPosition.VAULT_CUST_ID, customerData.get(Fields.CUST_ID), 
    Operator.EQUALS_IGNORE_CASE, TableType.DOCUMENT)

'Verify Case status in Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(tableCaseResults, LATEST_ROW, ColumnPosition.VAULT_CASE_STATUS, "New",
	Operator.EQUALS_IGNORE_CASE, TableType.DOCUMENT)

'Verify Case Current queue in Table'
CustomKeywords.'actions.WebTable.verifyCellValueMatches'(tableCaseResults, LATEST_ROW, ColumnPosition.VAULT_CURRENT_QUEUE, "Entry",
	Operator.EQUALS_IGNORE_CASE, TableType.DOCUMENT)
