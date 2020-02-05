package constants

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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Urls {

	final static String BASE_URL = GlobalVariable.URL
	final static String LOGIN_PAGE = BASE_URL + '/nGageBanking/login.aspx'
	final static String SEARCH_PAGE =  BASE_URL + '/nGageBanking_Customer/CustomerSearch.aspx'
	final static String CREATE_CUSTOMER_PAGE =  BASE_URL + '/nGageBanking_Customer/CustomerCreate.aspx?isOrg=False'
	final static String CREATE_ORGANIZATION_PAGE =  BASE_URL + '/nGageBanking_Customer/CustomerCreate.aspx?isOrg=True'
	final static String USER_PROFILE_PAGE =  BASE_URL + '/nGageBanking/MyInfo.aspx'
}
