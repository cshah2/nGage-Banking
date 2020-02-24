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
import internal.GlobalVariable as GlobalVariable
import sun.dc.pr.Rasterizer.ConsumerDisposer as ConsumerDisposer
import constants.Fields as Fields
import constants.Operator as Operator
import constants.Urls as Urls
import data.ConsumerData as ConsumerData
import utils.MapUtil as MapUtil
import services.OneSecEmail as OneSecEmail

String apiture_QA_URL = 'https://savana-qa.apiture.com/login'

Map<Fields, String> custData = ConsumerData.CUST_A

MapUtil.printMap(custData)

String expMailSubject = 'Welcome to Live Oak Bank'

'Navigate To customer dashboard'
WebUI.openBrowser(apiture_QA_URL)

'Maximize Window'
WebUI.maximizeWindow()

'Click on Open account Link'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/link_OpenAccount'))

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
WebUI.setText(findTestObject('Object Repository/Onboarding/input_Password'), custData.get(Fields.CUST_FIRST_NAME) + '@0001')

'Click on continue button'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Continue'))

'Wait for 5 Seconds for email operation to complete'
WebUI.delay(10)

'Verify user receives email'
CustomKeywords.'actions.Email.verifyMailCount'(custData.get(Fields.CUST_FIRST_NAME)+  '.' + custData.get(Fields.CUST_LAST_NAME).toLowerCase() + '@1secmail.com', 1, Operator.GREATER_THAN_OR_EQUALS)

String OTP = CustomKeywords.'actions.Email.getVerificationCodeForOak'(custData.get(Fields.CUST_FIRST_NAME) +'.' + custData.get(Fields.CUST_LAST_NAME).toLowerCase() + '@1secmail.com', 
    1)

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
WebUI.setText(findTestObject('Object Repository/Onboarding/input_FundingAmount'),"100")

'Click Next'
CustomKeywords.'actions.WebActions.click'(findTestObject('Object Repository/Onboarding/btn_Next'))


'Navigate to Banking URL '

WebUI.navigateToUrl("https://savossit.savanainc.com/nGageBanking/Login.aspx")

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








