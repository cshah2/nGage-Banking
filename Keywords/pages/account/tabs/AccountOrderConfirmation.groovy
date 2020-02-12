package pages.account.tabs

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import actions.WebActions
import constants.Fields
import constants.Operator
import internal.GlobalVariable

public class AccountOrderConfirmation {
	
	@Keyword
	public static void verifyOrderConfirmationDetails(Map<Fields,String> orderDetails){
	
		
		String orderType = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_OrderType'))
		WebActions.verifyMatch(orderType,orderDetails.get(Fields.ORDER_TYPE), Operator.EQUALS_IGNORE_CASE)
		
		String orderAmt = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_OrderAmount'))
		WebActions.verifyMatch(orderAmt,orderDetails.get(Fields.ORDER_TRANSFER_AMOUNT), Operator.EQUALS_IGNORE_CASE)
		
		String orderSource = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_OrderSource'))
		WebActions.verifyMatch(orderSource,orderDetails.get(Fields.ORDER_SOURCE), Operator.EQUALS_IGNORE_CASE)
		
		String orderOriginSource = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_OriginSource'))
		WebActions.verifyMatch(orderOriginSource,orderDetails.get(Fields.ORDER_ORIGIN_SOURCE), Operator.EQUALS_IGNORE_CASE)
		
		String transferDate = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_TransferDate'))
		WebActions.verifyMatch(transferDate,"Immediate", Operator.EQUALS_IGNORE_CASE)

		
		String recurringOrder = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_Recurring'))
		WebActions.verifyMatch(recurringOrder,"No", Operator.EQUALS_IGNORE_CASE)


		
		if(!orderDetails.get(Fields.ORDER_TYPE).equalsIgnoreCase("Collection order")){
		
			String orderCounterPartyAccNum = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_ToCounterPartyAccNo'))
			WebActions.verifyMatch(orderCounterPartyAccNum,orderDetails.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER), Operator.EQUALS_IGNORE_CASE)
		
	
				
		if(orderDetails.get(Fields.ORDER_TYPE).equalsIgnoreCase("Payment order") || orderDetails.get(Fields.ORDER_TYPE).equalsIgnoreCase("Collection order")){
			String routingNumber = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_RoutingNum'))
			WebActions.verifyMatch(routingNumber,orderDetails.get(Fields.ORDER_ROUTING_NUMBER), Operator.EQUALS_IGNORE_CASE)
	
		}
				
		String counterPartAccTitle = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_CounterPartyAccTitle'))
		WebActions.verifyMatch(counterPartAccTitle,orderDetails.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE), Operator.EQUALS_IGNORE_CASE)
		
		
		String counterPartAccGroup = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_CounterAccGroup'))
		WebActions.verifyMatch(counterPartAccGroup,orderDetails.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP), Operator.EQUALS_IGNORE_CASE)
		
		
		String counterPartToAcc = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_ToCounterPartyAccNo'))
		WebActions.verifyMatch(counterPartToAcc,orderDetails.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_NUMBER), Operator.EQUALS_IGNORE_CASE)

		
		String accType = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_AccType'))
		WebActions.verifyMatch(accType,orderDetails.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE), Operator.EQUALS_IGNORE_CASE)

		

		} else if(orderDetails.get(Fields.ORDER_TYPE).equalsIgnoreCase("Collection order")){
			verifyCollectionOrderConfirmationDetails(orderDetails)
		
		}
		else {
			KeywordUtil.markFailedAndStop('Incorrect hold type value provided in input'+orderDetails.get(Fields.ORDER_TYPE))
		}
	
	}
	public static void verifyCollectionOrderConfirmationDetails(Map<Fields,String> orderDetails){
			
		String counterPartFromAccGroup = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_FromCounterAccGroup'))
		WebActions.verifyMatch(counterPartFromAccGroup,orderDetails.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_NUMBER), Operator.EQUALS_IGNORE_CASE)
		
		String routingNumber = WebUI.getText(findTestObject('Account/AccountTaskDrawer/AddOrder/text_RoutingNum'))
		WebActions.verifyMatch(routingNumber,orderDetails.get(Fields.ORDER_ROUTING_NUMBER), Operator.EQUALS_IGNORE_CASE)

		
		}
	
	
	
}
