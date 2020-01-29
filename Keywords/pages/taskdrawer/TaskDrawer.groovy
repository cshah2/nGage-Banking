package pages.taskdrawer

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

import actions.WebActions
import internal.GlobalVariable

public class TaskDrawer {

	@Keyword
	static def openTaskDrawer() {
		WebActions.click(findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/btn_Tasks'))
		WebActions.waitForElementVisible(findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/block_DrawerOpen'), GlobalVariable.Timeout)
	}

	@Keyword
	static def selectTaskInDrawer(String taskName) {
		TestObject task = findTestObject('Object Repository/Consumer/ConsumerTaskDrawer/taskList',[('taskName'):taskName])
		WebActions.click(task)
	}
}
