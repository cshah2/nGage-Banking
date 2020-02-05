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

public class ColumnPosition {
	
	public static final int CONSTUMER_LASTNAME_INDEX = 1
	public static final int CONSTUMER_FIRSTNAME_INDEX = 2
	public static final int CONSTUMER_EMAILID_INDEX = 5
	public static final int CONSTUMER_PHONENUMBER_INDEX = 9
	
	
	//ORGANIZATION 
	public static final int ORGANIZATION_NAME = 1
	public static final int ORGANIZATION_PHONENO  = 6
	public static final int ORGANIZATION_DUN_BADSTREETNO  = 5
	public static final int ORGANIZATION_CUSTID  = 2
	
	
}
