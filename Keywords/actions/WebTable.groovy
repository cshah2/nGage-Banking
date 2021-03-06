package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.TimeUnit

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import constants.Icon
import constants.Operator
import constants.TableType
import internal.GlobalVariable
import utils.TableUtil

public class WebTable {

	@Keyword
	static def verifyRowsCountMatches(TestObject to, int expRowsCount, Operator operator, TableType type = TableType.DEFAULT) {
		TableUtil table = new TableUtil(type)
		int actRowsCount = table.getRowsCount(to)
		WebActions.verifyNumbericMatch(actRowsCount, expRowsCount, operator)
	}

	@Keyword
	static def waitUntilRowsCountMatches(TestObject to, int expRowsCount, Operator operator, int timeout, TableType type = TableType.DEFAULT) {

		//Set Webtable type
		TableUtil table = new TableUtil(type)

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		int actRowsCount = -1
		println "Actual records count = "+actRowsCount
		println "Expected records count = "+expRowsCount

		boolean isRefreshed = false

		while(currentTime < endTime) {

			try {
				actRowsCount = table.getRowsCount(to)
			}
			catch(Exception e) {
				println "Exception occurred while fetching records count"+e.toString()
				WebUI.delay(2)
				currentTime = System.currentTimeMillis()
				continue
			}

			println "Actual rows count = "+actRowsCount+" and Expected rows count = "+expRowsCount

			try {
				WebActions.verifyNumbericMatch(actRowsCount, expRowsCount, operator)
				isRefreshed = true
				break;
			}
			catch(Exception e1) {
				WebUI.delay(2)
				currentTime = System.currentTimeMillis()
				continue
			}
		}

		if(isRefreshed) {
			KeywordUtil.markPassed("Table is refreshed")
			WebUI.delay(2)
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Table is not refreshed withing given time')
		}
	}

	@Keyword
	static def verifyCellValueMatches(TestObject to, int rowNo, int colNo, String expText, Operator operator, TableType type = TableType.DEFAULT) {
		TableUtil table = new TableUtil(type)
		String actText = table.getCellText(to, rowNo, colNo)
		WebActions.verifyMatch(actText, expText, operator)
	}


	@Keyword
	public static void  verifyCellValueContains(TestObject to, int colNo, String expText, Operator operator, TableType type = TableType.DEFAULT) {
		List<String> columnData = new  ArrayList<String>()
		WebElement element  = WebUiCommonHelper.findWebElement(to, 30)

		List<WebElement> rows = element.findElements(By.tagName("tr"))
		println "The row size  " +  rows.size()
		for (int i = 1 ;i < rows.size() ; i ++) {
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"))
			println "The columns size  " +  columns.size()
			for (int j = 0 ; j < columns.size() ; j++){
				columnData.add(columns.get(j).getText())
			}

		}

		if(!columnData.contains(expText)){
			KeywordUtil.markFailedAndStop("Expected text " +expText + " is not present in the column")
		}

	}


	@Keyword
	static def getRowsCount(TestObject to, TableType type = TableType.DEFAULT) {
		TableUtil table = new TableUtil(type)
		int actRowsCount = table.getRowsCount(to)
		return actRowsCount
	}

	@Keyword
	static def verifyAllValuesInColumnMatches(TestObject to, int colNo, String expText, Operator o, TableType type = TableType.DEFAULT) {

		TableUtil table = new TableUtil(type)
		List<String> values = table.getAllTextFromColumn(to, colNo);

		if(values.size() == 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("No values found for comparison.")
		}

		values.each {actText -> WebActions.verifyMatch(actText, expText, o)}
		//values.stream().forEach{actText -> WebActions.verifyMatch(actText, expText, o)}
	}


	@Keyword
	static def clickCell(TestObject to,  int rowNo, int colNo, TableType type = TableType.DEFAULT) {

		TableUtil table = new TableUtil(type)
		table.clickCell(to, rowNo, colNo)
	}

	@Keyword
	static def clickIconInTable(TestObject to,  int rowNo, int colNo, Icon icon, TableType type = TableType.DEFAULT) {

		TableUtil table = new TableUtil(type)
		table.clickCell(to, rowNo, colNo, icon)
	}

	@Keyword
	static def mouseOverIconInTable(TestObject to,  int rowNo, int colNo, Icon icon, TableType type = TableType.DEFAULT) {
		TableUtil table = new TableUtil(type)
		table.mouseOverCell(findTestObject('Object Repository/SearchPage/SearchConsumer/SearchConsumerResults/icon_DOBEye'), rowNo, colNo, icon)
	}


	@Keyword
	public static void goToSearchConsumer(){
		WebUI.click(findTestObject('Object Repository/SearchPage/select_SearchConsumers'))
	}

	//	@Keyword
	//	static def clickDetailsIcon(TestObject to,  int rowNo, int colNo, TableType type = TableType.DEFAULT) {
	//
	//		TableUtil table = new TableUtil(type)
	//		table.clickCell(to, rowNo, colNo, Icon.DOUBLE_ARROW)
	//	}
	//
	//	@Keyword
	//	static def clickEllipsisIcon(TestObject to, int rowNo, int colNo, TableType type = TableType.DEFAULT) {
	//
	//		TableUtil table = new TableUtil(type)
	//		table.clickCell(to, rowNo, colNo, Icon.ELLIPSIS)
	//	}
}
