package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.TimeUnit

import org.checkerframework.checker.regex.RegexUtil
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import actions.WebActions
import constants.Icon
import constants.Operator
import constants.TableType
import internal.GlobalVariable

public class TableUtil {

	private TableType type

	TableUtil(TableType type) {
		this.type = type
	}

	//Locators functions
	private By allRows() {

		By locator
		switch(type) {
			case TableType.DEFAULT:
				locator = By.xpath("./tbody/tr[not(contains(@class,'TableRowExpandable'))]")
				break
			case TableType.DOCUMENT:
				locator = By.xpath(".//div[@class='bodyRow']/span/div")
				break
			Default:
				locator = By.xpath(".//tbody/tr[not(contains(@class,'TableRowExpandable'))]")
				break
		}
		return locator
	}

	private By singleRow(int rowNo) {

		By locator
		switch(type) {
			case TableType.DEFAULT:
				locator = By.xpath(".//tbody/tr[not(contains(@class,'TableRowExpandable'))]["+rowNo+"]")
				break
			case TableType.DOCUMENT:
				locator = By.xpath(".//div[@class='bodyRow']/span/div["+rowNo+"]")
				break
			Default:
				locator = By.xpath(".//tbody/tr["+rowNo+"]")
				break
		}
		return locator
	}

	private By allCells() {

		By locator
		switch(type) {
			case TableType.DEFAULT:
				locator = By.xpath("./td")
				break
			case TableType.DOCUMENT:
				locator = By.xpath(".//div[contains(@class,'cell OSInline')]")
				break
			Default:
				locator = By.xpath("./td")
				break
		}
		return locator
	}

	private By singleCell(int colNo) {

		By locator
		switch(type) {
			case TableType.DEFAULT:
				locator = By.xpath("./td["+colNo+"]")
				break
			case TableType.DOCUMENT:
				locator = By.xpath(".//div[contains(@class,'cell OSInline')]["+colNo+"]")
				println "The locator : " + locator
				break
			Default:
				locator = By.xpath("./td["+colNo+"]")
				break
		}
		return locator
	}

	private By wholeColumn(int colNo) {

		By locator
		switch(type) {
			case TableType.DEFAULT:
				locator = By.xpath(".//tbody/tr[not(contains(@class,'TableRowExpandable'))]/td["+colNo+"]")
				break
			case TableType.DOCUMENT:
				locator = By.xpath(".//div[@class='bodyRow']/span/div//div[contains(@class,'cell OSInline')]["+colNo+"]")
				break
			Default:
				locator = By.xpath(".//tbody/tr[not(contains(@class,'TableRowExpandable'))]/td["+colNo+"]")
				break
		}
		return locator
	}

	private By cellIcon(Icon icon) {

		By locator
		switch(icon) {
			case Icon.DOUBLE_ARROW:
				locator = By.xpath(".//span[contains(@class,fa-angle-double-down)]")
				break
			case Icon.ELLIPSIS:
				locator = By.xpath(".//span[contains(@class,fa-ellipsis-v)]")
				break
			case Icon.EYE:
				locator = By.xpath("//span[contains(@class,fa-eye)")
				break
			Default:
				locator = By.xpath(".//a")
				break
		}
		return locator
	}

	private WebElement getTable(TestObject to) {
		return WebUiCommonHelper.findWebElement(to, GlobalVariable.Timeout)
	}

	private WebElement getRow(TestObject to, int rowNo) {
		WebElement table = getTable(to)
		return table.findElement(singleRow(rowNo))
	}

	private WebElement getCell(TestObject to, int rowNo, int colNo) {
		WebElement table = getTable(to)
		WebElement row = table.findElement(singleRow(rowNo))
		WebElement cell = row.findElement(singleCell(colNo))
		return cell
	}

	public String getCellText(TestObject to, int rowNo, int colNo) {
		WebElement cell = getCell(to, rowNo, colNo)
		return cell.getText().replaceAll('(^\\h*)|(\\h*$)', ' ').trim()
	}

	public int getRowsCount(TestObject to) {
		WebElement table = getTable(to)

		if(table.findElements(allRows()).size() == 1
		&& table.findElement(singleRow(1)).findElements(allCells()).size() == 1
		&& table.findElement(singleRow(1)).findElement(singleCell(1)).getAttribute("colspan") != null) {
			return 0;
		}

		return table.findElements(allRows()).size()
	}

	public List<String> getAllTextFromColumn(TestObject to, int colNo) {

		List<String> cellsText = new ArrayList<String>()
		List<WebElement> cells = new ArrayList<WebElement>()

		WebElement table = getTable(to)
		cells = table.findElements(wholeColumn(colNo))

		for(WebElement cell in cells) {
			cellsText.add(cell.getText())
		}

		return cellsText
	}

	public void clickCell(TestObject to, int rowNo, int colNo, Icon icon) {

		WebElement table = getTable(to)
		WebElement el;
		try {
			el = table.findElement(singleRow(rowNo)).findElement(singleCell(colNo)).findElement(cellIcon(icon))
			WebActions.scrollToElement(el, GlobalVariable.Timeout)
			el.click()
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to click on link inside table '+e.toString())
		}
	}

	public void clickCell(TestObject to, int rowNo, int colNo) {

		WebElement table = getTable(to)
		WebElement el;
		try {
			el = table.findElement(singleRow(rowNo)).findElement(singleCell(colNo))
			WebActions.scrollToElement(el, GlobalVariable.Timeout)
			el.click()
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to click on link inside table '+e.toString())
		}
	}


	/*	public void mouseOverCell(TestObject to, int rowNo, int colNo, Icon icon) {
	 WebElement table = getTable(to)
	 WebElement el;
	 Actions a = new Actions(DriverFactory.getWebDriver())
	 try {
	 WebActions.scrollToElement(el, GlobalVariable.Timeout)
	 }
	 catch(Exception e) {
	 WebUI.takeScreenshot()
	 KeywordUtil.markFailedAndStop('Unable to click on link inside table '+e.toString())
	 }
	 }
	 */

	public void mouseOverCell(TestObject to, int rowNo, int colNo, Icon icon) {

		String javaScript = "var evObj = document.createEvent('MouseEvents');" +
				"evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
				"arguments[0].dispatchEvent(evObj);";

		WebElement table = getTable(to)
		WebElement el;
		Actions a = new Actions(DriverFactory.getWebDriver())

		List<WebElement> arg = new ArrayList<WebElement>()
		//Actions asDriver
		try {
			el = table.findElement(singleRow(rowNo)).findElement(singleCell(colNo)).findElement(cellIcon(icon))
			WebActions.scrollToElement(el, GlobalVariable.Timeout)

			arg.add(el)
			WebUI.executeJavaScript(javaScript, arg)
			WebUI.delay(2)
			//asDriver = new Actions(DriverFactory.getWebDriver())
			//asDriver.moveToElement(el).build().perform()
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
		}
	}

	//Keywords

	//	@Keyword
	//	def waitUntilRecordsCountEquals(TestObject to, int expRowsCount, int timeout, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		def startTime = System.currentTimeMillis()
	//		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
	//		def currentTime = System.currentTimeMillis()
	//
	//		int actRowsCount = -1
	//		println "Actual records count = "+actRowsCount
	//		println "Expected records count = "+expRowsCount
	//
	//		boolean isRefreshed = false
	//
	//		while(currentTime < endTime) {
	//
	//			try {
	//				actRowsCount = getRowsCount(to)
	//			}
	//			catch(Exception e) {
	//				println "Exception occurred while fetching records count"+e.toString()
	//				WebUI.delay(2)
	//				currentTime = System.currentTimeMillis()
	//				continue
	//			}
	//
	//			println "Actual rows count = "+actRowsCount+" and Expected rows count = "+expRowsCount
	//
	//			if(actRowsCount == expRowsCount) {
	//				isRefreshed = true
	//				break
	//			}
	//			else {
	//				WebUI.delay(2)
	//				currentTime = System.currentTimeMillis()
	//				continue
	//			}
	//		}
	//
	//		if(isRefreshed) {
	//			KeywordUtil.markPassed("Table is refreshed")
	//			WebUI.delay(2)
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailedAndStop('Table is not refreshed withing given time')
	//		}
	//	}
	//
	//	@Keyword
	//	def waitUntilCellValueEquals(TestObject to, int rowNo, int colNo, String expText, int timeout, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		def startTime = System.currentTimeMillis()
	//		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
	//		def currentTime = System.currentTimeMillis()
	//		String actText
	//
	//		boolean isRefreshed = false
	//		while(currentTime < endTime) {
	//			try {
	//				actText = getCellText(to, rowNo, colNo)
	//			}
	//			catch(Exception e) {
	//				println "Exception occurred while fetching cell text"+e.toString()
	//				WebUI.delay(2)
	//				currentTime = System.currentTimeMillis()
	//				continue
	//			}
	//
	//			println "Actual cell text = "+actText+" and Expected cell text = "+expText
	//
	//			if(actText.equals(expText)) {
	//				isRefreshed = true
	//				break
	//			}
	//			else {
	//				WebUI.delay(2)
	//				currentTime = System.currentTimeMillis()
	//				continue
	//			}
	//		}
	//
	//		if(isRefreshed) {
	//			KeywordUtil.markPassed("Table is refreshed")
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailedAndStop('Table is not refreshed withing given time')
	//		}
	//	}
	//
	//	@Keyword
	//	def waitUntilCellValueStartsWith(TestObject to, int rowNo, int colNo, String expText, int timeout, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		def startTime = System.currentTimeMillis()
	//		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
	//		def currentTime = System.currentTimeMillis()
	//		String actText
	//
	//		boolean isRefreshed = false
	//		while(currentTime < endTime) {
	//			try {
	//				actText = getCellText(to, rowNo, colNo)
	//			}
	//			catch(Exception e) {
	//				println "Exception occurred while fetching cell text"+e.toString()
	//				WebUI.delay(2)
	//				currentTime = System.currentTimeMillis()
	//				continue
	//			}
	//
	//			println "Actual cell text = "+actText+" and Expected cell text = "+expText
	//
	//			if(actText.startsWith(expText)) {
	//
	//				isRefreshed = true
	//				break
	//			}
	//			else {
	//				WebUI.delay(2)
	//				currentTime = System.currentTimeMillis()
	//				continue
	//			}
	//		}
	//
	//		if(isRefreshed) {
	//			KeywordUtil.markPassed("Table is refreshed")
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailedAndStop('Table is not refreshed withing given time')
	//		}
	//	}
	//
	//
	//	@Keyword
	//	def moveToCell(TestObject to, int rowNo, int colNo, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		WebElement table = getTable(to)
	//		Actions asDriver = new Actions(DriverFactory.getWebDriver())
	//		//new actions.Common().moveToElement(getCell(to, rowNo, colNo))
	//	}
	//
	//
	//	@Keyword
	//	def getRecordsCount(TestObject to, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		int actRowsCount = getRowsCount(to)
	//		println "Actual records count = "+actRowsCount
	//
	//		return actRowsCount
	//	}
	//
	//	static def verifyRecordsCountMatches(TestObject to, int expRowsCount, Operator operator, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		int actRowsCount = getRowsCount(to)
	//		println "Actual records count = "+actRowsCount
	//
	//		switch(operator) {
	//			case Operator.EQUALS:
	//				WebUI.verifyEqual(actRowsCount, expRowsCount)
	//				println actRowsCount+" is equal to "+expRowsCount
	//				break;
	//			case Operator.GREATER_THAN:
	//				WebUI.verifyGreaterThan(actRowsCount, expRowsCount)
	//				println actRowsCount+" is greater than "+expRowsCount
	//				break;
	//			case Operator.GREATER_THAN_OR_EQUALS:
	//				WebUI.verifyGreaterThanOrEqual(actRowsCount, expRowsCount)
	//				println actRowsCount+" is greater than or equal to "+expRowsCount
	//				break;
	//			case Operator.LESS_THAN:
	//				WebUI.verifyLessThan(actRowsCount, expRowsCount)
	//				println actRowsCount+" is less than "+expRowsCount
	//				break;
	//			case Operator.LESS_THAN_OR_EQUALS:
	//				WebUI.verifyLessThanOrEqual(actRowsCount, expRowsCount)
	//				println actRowsCount+" is less than or equal to "+expRowsCount
	//				break;
	//			case Operator.NOT_EQUALS:
	//				WebUI.verifyNotEqual(actRowsCount, expRowsCount)
	//				println actRowsCount+" is not equal to "+expRowsCount
	//				break;
	//			default:
	//				WebUI.takeScreenshot()
	//				KeywordUtil.markFailedAndStop('Incorrect operator provided in keyword for integer comparison operation.')
	//				break;
	//		}
	//	}
	//
	//	//Cell value comparison
	//	@Keyword
	//	def verifyCellValueContains(TestObject to, int rowNo, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String actText = getCellText(to, rowNo, colNo)
	//		WebUI.verifyMatch(actText, RegexUtil.formRegexString(expText, RegexOperator.CONTAINS), true)
	//	}
	//
	//	@Keyword
	//	def verifyCellValueContainsIgnoreCase(TestObject to, int rowNo, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String actText = getCellText(to, rowNo, colNo)
	//		WebUI.verifyMatch(actText, RegexUtil.formRegexString(expText, RegexOperator.CONTAINS_IGNORE_CASE), true)
	//	}
	//
	//	@Keyword
	//	def verifyCellValueStartsWith(TestObject to, int rowNo, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		//TODO:
	//	}
	//
	//	@Keyword
	//	def verifyCellValueEndsWith(TestObject to, int rowNo, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		//TODO:
	//	}
	//
	//
	//	@Keyword
	//	def verifyCellValueEquals(TestObject to, int rowNo, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String actText = getCellText(to, rowNo, colNo)
	//		WebUI.verifyMatch(actText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS), true)
	//	}
	//
	//	@Keyword
	//	def verifyCellValueEqualsIgnoreCase(TestObject to, int rowNo, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String actText = getCellText(to, rowNo, colNo)
	//		WebUI.verifyMatch(actText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS_IGNORE_CASE), true)
	//	}
	//
	//	//Column values comparison
	//
	//	@Keyword
	//	def verifyAllValuesInColumnMatches(TestObject to, int colNo, String expText, RegexOperator operator, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//		for(String cellText in cellsText) {
	//			println "Cell Text = "+cellText
	//			new actions.Common().verifyMatch(cellText, expText, operator)
	//		}
	//	}
	//
	//
	//	@Keyword
	//	def verifyAllValuesInColumnEquals(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String regexString = RegexUtil.formRegexString(expText, RegexOperator.EQUALS)
	//		println "Regex String = "+regexString
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//		for(String cellText in cellsText) {
	//			println "Cell Text = "+cellText
	//			WebUI.verifyMatch(cellText, regexString, true)
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAllValuesInColumnEqualsIgnoreCase(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String regexString = RegexUtil.formRegexString(expText, RegexOperator.EQUALS_IGNORE_CASE)
	//		println "Regex String = "+regexString
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//		for(String cellText in cellsText) {
	//			println "Cell Text = "+cellText
	//			WebUI.verifyMatch(cellText, regexString, true)
	//		}
	//	}
	//
	//	@Keyword
	//	def VerifyAllValuesInColumnContains(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String regexString = RegexUtil.formRegexString(expText, RegexOperator.CONTAINS)
	//		println "Regex String = "+regexString
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//		for(String cellText in cellsText) {
	//			println "Cell Text = "+cellText
	//			WebUI.verifyMatch(cellText, regexString, true)
	//		}
	//	}
	//
	//	@Keyword
	//	def verifuAllValuesInColumnContainsIgnoreCase(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String regexString = RegexUtil.formRegexString(expText, RegexOperator.CONTAINS_IGNORE_CASE)
	//		println "Regex String = "+regexString
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//		for(String cellText in cellsText) {
	//			println "Cell Text = "+cellText
	//			WebUI.verifyMatch(cellText, regexString, true)
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAllValuesinColumnStartsWith(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String regexString = RegexUtil.formRegexString(expText, RegexOperator.STARTS_WITH)
	//		println "Regex String = "+regexString
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//		for(String cellText in cellsText) {
	//			println "Cell Text = "+cellText
	//			WebUI.verifyMatch(cellText, regexString, true)
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAllValuesInColumnEndsWith(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		String regexString = RegexUtil.formRegexString(expText, RegexOperator.ENDS_WITH)
	//		println "Regex String = "+regexString
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//		for(String cellText in cellsText) {
	//			println "Cell Text = "+cellText
	//			WebUI.verifyMatch(cellText, regexString, true)
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAnyValueInColumnEquals(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//
	//		boolean isMatchFound = false
	//		int rowNo = 1
	//		for(String cellText in cellsText) {
	//			try {
	//				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS), true)
	//				isMatchFound = true
	//				break
	//			}
	//			catch(Exception e) {
	//				rowNo++;
	//				println e.toString()
	//			}
	//		}
	//
	//		if(isMatchFound) {
	//			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailed("value "+expText+" not found in column")
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAnyValueInColumnEqualsIgnoreCase(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//
	//		boolean isMatchFound = false
	//		int rowNo = 1
	//		for(String cellText in cellsText) {
	//			try {
	//				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS_IGNORE_CASE), true)
	//				isMatchFound = true
	//				break
	//			}
	//			catch(Exception e) {
	//				rowNo++;
	//				println e.toString()
	//			}
	//		}
	//
	//		if(isMatchFound) {
	//			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailed("value "+expText+" not found in column")
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAnyValueInColumnContains(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//
	//		boolean isMatchFound = false
	//		int rowNo = 1
	//		for(String cellText in cellsText) {
	//			try {
	//				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.CONTAINS), true)
	//				isMatchFound = true
	//				break
	//			}
	//			catch(Exception e) {
	//				rowNo++;
	//				println e.toString()
	//			}
	//		}
	//
	//		if(isMatchFound) {
	//			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailed("value "+expText+" not found in column")
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAnyValueInColumnContainsIgnoreCase(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//
	//		boolean isMatchFound = false
	//		int rowNo = 1
	//		for(String cellText in cellsText) {
	//			try {
	//				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.CONTAINS_IGNORE_CASE), true)
	//				isMatchFound = true
	//				break
	//			}
	//			catch(Exception e) {
	//				rowNo++;
	//				println e.toString()
	//			}
	//		}
	//
	//		if(isMatchFound) {
	//			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailed("value "+expText+" not found in column")
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAnyValueInColumnStartsWith(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//
	//		boolean isMatchFound = false
	//		int rowNo = 1
	//		for(String cellText in cellsText) {
	//			try {
	//				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.STARTS_WITH), true)
	//				isMatchFound = true
	//				break
	//			}
	//			catch(Exception e) {
	//				rowNo++;
	//				println e.toString()
	//			}
	//		}
	//
	//		if(isMatchFound) {
	//			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailed("value "+expText+" not found in column")
	//		}
	//	}
	//
	//	@Keyword
	//	def verifyAnyValueInColumnEndsWith(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//
	//		boolean isMatchFound = false
	//		int rowNo = 1
	//		for(String cellText in cellsText) {
	//			try {
	//				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.ENDS_WITH), true)
	//				isMatchFound = true
	//				break
	//			}
	//			catch(Exception e) {
	//				rowNo++;
	//				println e.toString()
	//			}
	//		}
	//
	//		if(isMatchFound) {
	//			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailed("value "+expText+" not found in column")
	//		}
	//	}
	//
	//	@Keyword
	//	def getRowNumber(TestObject to, int colNo, String expText, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		List<String> cellsText = getAllTextFromColumn(to, colNo)
	//
	//		boolean isMatchFound = false
	//		int rowNo = 1
	//		for(String cellText in cellsText) {
	//			try {
	//				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS), true)
	//				isMatchFound = true
	//				break
	//			}
	//			catch(Exception e) {
	//				rowNo++;
	//				println e.toString()
	//			}
	//		}
	//
	//		if(isMatchFound) {
	//			return rowNo
	//		}
	//		else {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailed("value "+expText+" not found in column")
	//		}
	//	}
	//
	//	//Operation within cell
	//
	//	@Keyword
	//	def clickCell(TestObject to, int rowNo, int colNo, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		WebElement table = getTable(to)
	//		WebElement el;
	//		try {
	//			//moveToCell(to, rowNo, colNo, type)
	//			el = table.findElement(singleRow(rowNo)).findElement(singleCell(colNo)).findElement(clickElement())
	//			//			el.click()
	//			//			//new javaScript().click(el)
	//			new actions.Common().moveToElementAndClick(el)
	//		}
	//		catch(Exception e) {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailedAndStop('Unable to click on link inside table '+e.toString())
	//		}
	//	}
	//
	//	@Keyword
	//	def clickMoreButton(TestObject to, int rowNo, int colNo, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		WebElement table = getTable(to)
	//		try {
	//			WebElement e = getCell(to, rowNo, colNo).findElement(moreIcon())
	//			new actions.JavaScript().scrollToElement(e)
	//			WebUI.delay(1)
	//			//e.click()
	//			new actions.JavaScript().click(e)
	//
	//		}
	//		catch(Exception e) {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailedAndStop('Unable to click on link inside table '+e.toString())
	//		}
	//	}
	//
	//	@Keyword
	//	def clickMoreButtonAndSelectOption(TestObject to, int rowNo, int colNo, String option, WebTable type = WebTable.DEFAULT) {
	//
	//		//Set Webtable type
	//		this.type = type
	//
	//		WebElement table = getTable(to)
	//		try {
	//			moveToCell(to, rowNo, colNo, type)
	//			WebUI.delay(1)
	//			WebElement e = getCell(to, rowNo, colNo).findElement(moreIcon())
	//			//e.click()
	//			new actions.JavaScript().click(e)
	//			WebUI.delay(3) //Wait for 3 seconds to load the options menu
	//			WebElement optionElement = getCell(to, rowNo, colNo).findElement(By.xpath(".//div[contains(@id,'_wtMenu') and contains(@class,'DropdownMenu')]//a[text()='"+option+"']"))
	//			//optionElement.click()
	//			new actions.JavaScript().click(optionElement)
	//		}
	//		catch(Exception e) {
	//			WebUI.takeScreenshot()
	//			KeywordUtil.markFailedAndStop('Unable to click on link inside table '+e.toString())
	//		}
	//	}
	//}
}
