import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

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
import internal.GlobalVariable as GlobalVariable
import sun.dc.pr.Rasterizer.ConsumerDisposer as ConsumerDisposer
import constants.Fields as Fields

import constants.ColumnPosition as ColumnPosition
import constants.Operator as Operator
import constants.TableType
import constants.Urls as Urls
import data.ConsumerData as ConsumerData
import utils.MapUtil as MapUtil
import services.OneSecEmail as OneSecEmail

String apiture_QA_URL = 'https://savana-qa.apiture.com/login'

Map<Fields, String> custData = ConsumerData.CUST_A

MapUtil.printMap(custData)

String expMailSubject = 'Welcome to Live Oak Bank'
String accBalance = "1000.00"

String amountView = String.format("%,.2f", Double.parseDouble(accBalance))
'Navigate To customer dashboard'
WebUI.openBrowser(apiture_QA_URL)

'Maximize Window'
WebUI.maximizeWindow()   


'Click on Open account Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/link_OpenAccount'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Onboarding/input_firstname'), GlobalVariable.Timeout)

'Type First Name'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_firstname'), custData.get(Fields.CUST_FIRST_NAME))

'Type Last Name'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_lastName'), custData.get(Fields.CUST_LAST_NAME))

'Type Username'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_UserName'), custData.get(Fields.CUST_FIRST_NAME).toLowerCase())

'Type Taxid  number'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_TaxNumber'), '1' + custData.get(Fields.CUST_TAX_ID))

'Type Mobile Number'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_PhoneNum'), custData.get(Fields.CONTACT_PHONE_NUMBER))

'Type Confirm Mobile Number'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_ConfirmPhoneNum'), custData.get(Fields.CONTACT_PHONE_NUMBER))

'Type Email adddresss'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_EmailAddress'), ((custData.get(Fields.CUST_FIRST_NAME).toLowerCase() + 
    '.') + custData.get(Fields.CUST_LAST_NAME).toLowerCase()) + '@1secmail.com')

'Type Password'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_Password'), custData.get(Fields.CUST_FIRST_NAME) + '@00001')

'Click on continue button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Continue'))

'Wait for 5 Seconds for email operation to complete'
WebUI.delay(20)

String emailId = custData.get(Fields.CUST_FIRST_NAME).toLowerCase()+  '.' + custData.get(Fields.CUST_LAST_NAME).toLowerCase() + '@1secmail.com'

println "The username : " + emailId.split('@')[0]
'Verify user receives email'
CustomKeywords.'actions.Email.verifyMailCount'(emailId, 1, Operator.GREATER_THAN_OR_EQUALS)

String OTP = CustomKeywords.'actions.Email.getVerificationCodeForOak'(custData.get(Fields.CUST_FIRST_NAME) +'.' + custData.get(Fields.CUST_LAST_NAME).toLowerCase() + '@1secmail.com', 1)

println('The OTP from Mail : ' + OTP)

'Type OTP'
CustomKeywords.'actions.Email.typeOTP'(OTP)

'Confirm Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_ConfirmRegistration'))

'Wait for the Account selection options'
WebUI.waitForElementVisible(findTestObject('Object Repository/Onboarding/div_Personal'), GlobalVariable.Timeout)

'Select Personal account'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/div_Personal'))

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))

'Select Account Type'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/div_SDA'))

'Select Premiere Savings'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/heading_PremiereSavings'))


'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))

'Set Date of Birth'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_DateOfBirth'), custData.get(Fields.CUST_DOB))


'Click Citzen true'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/checkbox_CitizenTrue'))


'Click Agreed checkbox'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/checkbox_Agreed'))

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))

'Set Address Line 1'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_Address1'), custData.get(Fields.ADDR_LINE1))

'Set Address Line 2'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_Address2'), custData.get(Fields.ADDR_LINE2))



'Set ACity'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_City'), custData.get(Fields.ADDR_CITY))

'Select state'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Onboarding/select_State'),"PA", false)

'Set Zip code'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_PostalCode'), custData.get(Fields.ADDR_ZIPCODE))

'Select Years At Address'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Onboarding/select_YearsAtAddress'),"3", false)

'Check no on another email address'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/radio_OtherMailFalse'))

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))

'Click No Radio Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/radio_TaxHoldingsFalse'))

'Select Employeement Status'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Onboarding/select_EmployeeStatus'), "Other", false)


'Click false Figure Political Figure'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/radio_PolicticalFigFalse'))

'Click false Figure Political Figure'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/radio_SeniorPoliticalFigFalse'))


'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))


String filePath = RunConfiguration.getProjectDir()+"\\Data Files\\Upload File\\Document1.png"

TestObject document1 = findTestObject('Object Repository/Onboarding/upload_Doc1')
TestObject document2 = findTestObject('Object Repository/Onboarding/upload_Doc2')
TestObject document3 = findTestObject('Object Repository/Onboarding/upload_Doc3')

'Wait for Task drawer to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(document1, GlobalVariable.Timeout)

'Upload File'
CustomKeywords.'actions.WebActions.uploadFile'(document1, filePath)


'Wait for Task drawer to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(document2, GlobalVariable.Timeout)

'Upload File'
CustomKeywords.'actions.WebActions.uploadFile'(document2, filePath)

'Wait for Task drawer to load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(document3, GlobalVariable.Timeout)

'Upload File'
CustomKeywords.'actions.WebActions.uploadFile'(document3, filePath)


'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))

'Click Agree checkbox 0'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/checbox0_Agree'))

'Click Agree checkbox 0'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/checkboxOne_Agree'))

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))

'Set Bank Name'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_BankName'),"DAG #1")


'Click Lodi Bank'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/div_LodiBank'))

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))

'Set Bank Name'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_AccountUsername'),"apiture1.site16441.1")

'Set Bank Name'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_AccountPassword'),"site16441.1")

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))


'Click Platinum Checking Account'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/radio_PlatinumCheck'))


'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))


'Wait for next ppage'
WebUI.waitForElementVisible(findTestObject('Object Repository/Onboarding/message_SuccessAccountLinked'), GlobalVariable.Timeout)

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))

'Set Bank Name'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_FundingAmount'),amountView)

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))


'Navigate to Banking URL '
String loginURL = "https://savossit.savanainc.com/nGageBanking/Login.aspx"
WebUI.navigateToUrl(loginURL)

'Clear username and Password'
WebUI.clearText(findTestObject('LoginPage/input_UserName'))
WebUI.clearText(findTestObject('LoginPage/input_Password'))

'Set Username of Apiture'
WebUI.setText(findTestObject('LoginPage/input_UserName'), 'swaikar@apiture.sit')

'Set Password of Apiture'
WebUI.setText(findTestObject('LoginPage/input_Password'), 'Savana1#')

'Click on Login'
CustomKeywords.'actions.WebActions.click'(findTestObject('LoginPage/btn_Login'))

'Go to Workflow'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/LeftMenus/link_Workflow'))

'Select Process'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/dropdown_SelectProcess'))

'Click on Approval activities'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/option_OnboardingWMI'))

'Click on Onboarding Review Option'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/option_OnboardingReview'))


'Click on Filter Results'
CustomKeywords.'actions.WebActions.click'(findTestObject('BasePage/WorkFlow/icon_Filters'))

'Type last name'
WebUI.setText(findTestObject('Object Repository/Onboarding/input_FilterLastName'), custData.get(Fields.CUST_LAST_NAME))

'Press Enter Key'
WebUI.sendKeys(findTestObject('Object Repository/Onboarding/input_FilterLastName'), Keys.chord(Keys.ENTER))

'Click on First row results'
CustomKeywords.'actions.WebTable.clickCell'(findTestObject('Object Repository/Onboarding/table_SearchResultsInWorkflow'), 1, 10, TableType.DOCUMENT)


'Switch to Window Tab 1'
WebUI.switchToWindowIndex(1)

'Get Applicant Name'
String applicantName = WebUI.getText(findTestObject('Object Repository/Onboarding/OnboardingCases/text_ApplicantName'))

'Verify Applicants name'
CustomKeywords.'actions.WebActions.verifyMatch'(applicantName, custData.get(Fields.CUST_LAST_NAME), Operator.CONTAINS_IGNORE_CASE)

'Verify Applicants Email'
CustomKeywords.'actions.WebActions.verifyMatch'(WebUI.getText(findTestObject('Object Repository/Onboarding/OnboardingCases/text_EmailAddress')), emailId, Operator.CONTAINS_IGNORE_CASE)

'Click on Identity Verfication View'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/view_IdentityVerification'))


'Click on Approve Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_ApproveIdentity'))

'Wait for the Popup to Load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Onboarding/OnboardingCases/popup_Confirm'), GlobalVariable.Timeout)


'Click on Yes Button'
WebUI.click(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_Yes'))


'Click on Driver License View'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/view_DriverLicense'))

'Click on Approve Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_ApproveLicense'))

'Wait for the Popup to Load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Onboarding/OnboardingCases/popup_Confirm'), GlobalVariable.Timeout)


'Click on Yes Button'
WebUI.click(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_Yes'))

'Click on Tax Identification  View'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/view_TaxIdentity'))

'Click on Approve Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_ApproveTaxIdentity'))

'Wait for the Popup to Load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Onboarding/OnboardingCases/popup_Confirm'), GlobalVariable.Timeout)


'Click on Yes Button'
WebUI.click(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_Yes'))

'Click on Utility Bill  View'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/view_UtilityBill'))

'Click on Approve Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_ApproveUtilityBill'))

'Wait for the Popup to Load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Onboarding/OnboardingCases/popup_Confirm'), GlobalVariable.Timeout)


'Click on Yes Button'
WebUI.click(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_Yes'))


'Click on Account Verification   View'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/view_AccountVerification'))

'Click on Approve Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_ApproveAccountVerification'))

'Wait for the Popup to Load'
CustomKeywords.'actions.WebActions.waitForElementVisible'(findTestObject('Object Repository/Onboarding/OnboardingCases/popup_Confirm'), GlobalVariable.Timeout)


'Click on Yes Button'
WebUI.click(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_Yes'))


'Click on Task Drawer'
CustomKeywords.'pages.taskdrawer.TaskDrawer.openTaskDrawer'()

'Click on Closure Actions'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/link_ClosureActions'))


'Select Actions'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Onboarding/OnboardingCases/select_Actions'), "Approve - Onboarding", false)

'Click on Submit'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_Submit'))


'Click on Submit'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/OnboardingCases/btn_Submit'))

'Switch to default window'
WebUI.switchToWindowIndex(0)

'Search results for consumer search'
TestObject tableSearchResults = findTestObject('SearchPage/SearchConsumer/SearchConsumerResults/table_SearchResults')

'Logout of the portal'
CustomKeywords.'actions.WebActions.logout'()

'Enter apiture username'
WebUI.setText(findTestObject('LoginPage/input_UserName'), 'swaikar@apiture.sit')

'Enter Password (Apiture)'
WebUI.setText(findTestObject('LoginPage/input_Password'), 'Savana1#')

'Click on Login Button'
CustomKeywords.'actions.WebActions.click'(findTestObject('LoginPage/btn_Login'))


'Type Email ID and Search a consumer'
WebUI.setText(findTestObject('SearchPage/SearchConsumer/input_Email'), emailId)

'Click on Search button'
CustomKeywords.'actions.WebActions.click'(findTestObject('SearchPage/SearchConsumer/btn_Search'))

'Wait for search result grid to be displayed'
CustomKeywords.'actions.WebActions.waitForElementVisible'(tableSearchResults, GlobalVariable.Timeout)

'Verify Firstname is present in all rows of searchResults table'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSUMER_FIRSTNAME,
	custData.get(Fields.CUST_FIRST_NAME), Operator.EQUALS_IGNORE_CASE)

'Verify Lastname is present in all rows of searchResults table'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(tableSearchResults, ColumnPosition.CONSUMER_LASTNAME,
	custData.get(Fields.CUST_LAST_NAME), Operator.EQUALS_IGNORE_CASE)

'Click on First Row'
CustomKeywords.'actions.WebTable.clickCell'(tableSearchResults, 1, 1)

'Click on Account Tab'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Consumer/ConsumerDashboardPage/TabsSection/tab_Accounts'))


TestObject accountsTable = findTestObject('Object Repository/Consumer/ConsumerDashboardPage/AccountsTab/table_ActiveAccounts')

'Verify Account Type in Accounts Table table'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(accountsTable, ColumnPosition.PRODUCT_TYPE, "Premier Savings", Operator.CONTAINS_IGNORE_CASE)


'Verify Account Legdger Balance in Accounts Table table'
CustomKeywords.'actions.WebTable.verifyAllValuesInColumnMatches'(accountsTable, ColumnPosition.ACCOUNT_LEDGER_BALANCE,amountView, Operator.CONTAINS_IGNORE_CASE)


