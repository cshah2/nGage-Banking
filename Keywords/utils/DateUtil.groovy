package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

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

public class DateUtil {

	public static String convert(String date, String currFormat, String expFormat) {

		def currFormatDate = new Date().parse(currFormat,date)
		return currFormatDate.format(expFormat)
	}

	public static String convert(Date d, String expFormat) {
		SimpleDateFormat s = new SimpleDateFormat(expFormat)
		return s.format(d)
	}

	public static String getCurrentDateTime(String format, String timezone) {

		String dateString = ZonedDateTime.now(ZoneId.of(timezone))format(DateTimeFormatter.ofPattern(format))
		println "Date is :"+dateString
		return dateString
	}

	public static String getCurrentDateTimeMinusDays(int days, String format, String timezone) {

		String dateString = ZonedDateTime.now(ZoneId.of(timezone)).minusDays(days).format(DateTimeFormatter.ofPattern(format))
		println "Date is :"+dateString
		return dateString
	}

	public static String getCurrentDateTimePlusDays(int days, String format, String timezone) {

		String dateString = ZonedDateTime.now(ZoneId.of(timezone)).plusDays(days).format(DateTimeFormatter.ofPattern(format))
		println "Date is :"+dateString
		return dateString
	}
	
	
	
	public static String  getDate(){
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date))
		return dateFormat.format(date)
	}
	
	
	public static String  getSystemDateTime(String currentSystemDateTime){		
		DateFormat dateFormat = new SimpleDateFormat(currentSystemDateTime);
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date))
		return dateFormat.format(date)
	}
	
	
	public static String getCurrentDateTimeWithTimeZone(String format,String timeZone){
			Date today = new Date();
		
		   //displaying this date on IST timezone
		   DateFormat df = new SimpleDateFormat(format);
		   df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		   String IST = df.format(today);
		   System.out.println("Date in Indian Timezone (IST) : " + IST);
		
		   //dispalying date on PST timezone
		   df.setTimeZone(TimeZone.getTimeZone(timeZone));
		   String dateTime = df.format(today);
		   System.out.println("Date in  " +timeZone + " Timezone : " + dateTime);
		   return dateTime
		
	}
	
	
	
	
	
}
