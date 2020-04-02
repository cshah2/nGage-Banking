package utils

import java.awt.Rectangle
import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.apache.commons.io.FileUtils
import org.openqa.selenium.Point
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.Fields
import internal.GlobalVariable
import net.sourceforge.tess4j.Tesseract

public class WebUtil {
	public static final String actualFileUploadedPath =  "C:/ActualDocument1.png"

	static def shouldFailTest(Map<Fields, String> data) {
		if(!(data.containsKey(Fields.IS_CREATED) && data.get(Fields.IS_CREATED).equalsIgnoreCase("true"))) {
			KeywordUtil.markFailedAndStop('Pre-requisite test data is not created, Thus marking this test as failed')
		}
	}


	//	static def setText(TestObject uiObject,String text){
	//		try{
	//			if(uiObject == null){
	//				KeywordUtil.markFailed('Invalid Testobject'+uiObject+'provided.')
	//			}
	//			if(uiObject != null && text != null){
	//				WebUI.sendKeys(uiObject, text)
	//			}
	//		}catch(Exception e){
	//			e.printStackTrace()
	//		}
	//	}

	static def generateCustomerUrl(String partyId, String customerGroup, String customerId, String isOrg) {

		StringBuilder url = new StringBuilder()
		url.append(GlobalVariable.URL)
		url.append("/nGageBanking_Customer/CustomerMainFlow.CustomerDetail.aspx?")
		url.append("partyId="+partyId)
		url.append("&customerGroup="+customerGroup)
		url.append("&customerId="+customerId)
		url.append("&isOrg="+isOrg)

		return url.toString()
	}
	
	
	static def generateCustomerUrlApollo(String partyId, String customerGroup, String customerId, String source) {
		
				StringBuilder url = new StringBuilder()
				url.append(GlobalVariable.URL)
				url.append("/nGageBanking_Customer/CustomerMainFlow.CustomerDetail.aspx?")
				url.append("partyId="+partyId)
				url.append("&customerGroup="+customerGroup)
				url.append("&customerId="+customerId)
				url.append("&source="+source)
		
				return url.toString()
			}
	

	static def generateAccountUrl(String partyId, String acctGroup, String accNumber, String positionId, String customerGroup, String customerId, String isOrg) {

		StringBuilder url = new StringBuilder()
		url.append(GlobalVariable.URL)
		url.append("/nGageBanking_Account/AccountMainFlow.AccountDetail.aspx?")
		url.append("partyId="+partyId)
		url.append("&acctGroup="+acctGroup)
		url.append("&acctNumber="+accNumber)
		url.append("&selectedPositionId="+positionId)
		url.append("&customerGroup="+customerGroup)
		url.append("&customerId="+customerId)
		url.append("&isOrg="+isOrg)

		return url.toString()
	}

	static def setZoomLevel() {
		WebUI.executeJavaScript("document.body.style.zoom='90%'", null)
	}


	public static void takeWebelementScreenshot(WebElement element,WebDriver driver){

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);


		Point p = element.getLocation();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		Rectangle rect = new Rectangle(width, height);

		BufferedImage img = null;
		img = ImageIO.read(screenShot);



		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width.intValue(), rect.height.intValue());

		ImageIO.write(dest, "png", screenShot);

		FileUtils.copyFile(screenShot,
				new File(actualFileUploadedPath));
	}



	public static String getTextFromImage(String filePath){
		String imageText
		//String filePath = "C:/NGage-Banking-Automation/nGage-Banking/Data Files/Upload File/Document1.png";
		File imageFile = new File(filePath)
		Tesseract instance = new Tesseract()
		try {

			String dataPath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\Tessdata\\'
			instance.setDatapath(dataPath)
			instance.setLanguage("eng")
			imageText  = instance.doOCR(imageFile)
			imageText.replaceAll("\n", "")
			println "The text from Actual image : "  + imageText
		} catch(Exception e){
			e.printStackTrace()
		}
		return imageText.trim();
	}


	public static void verifyDownloadedFile(String fileName){

		try{

			String dataPath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\DownloadedFile\\'

			File dir = new File(dataPath);
			File[] dir_contents = dir.listFiles();
			String temp = fileName + ".PNG";
			boolean check = new File(temp).exists();
			for(int i = 0; i<dir_contents.length;i++) {
				if(dir_contents[i].getName() == (fileName + ".PNG"))
					println "File has been downloaded and file exists in the Directory "
			}
		}catch(Exception e){
			e.printStackTrace()

		}


	}




}