package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import static org.hamcrest.CoreMatchers.*;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
//import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileNotFoundException;
import org.openqa.selenium.remote.CapabilityType;  
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility {
	private String reportDirectory = "reports";
	  private String reportFormat = "xml";
	  private String testName = "MOHRegistration";
		public static Properties CONFIG=null; 
	//  protected AndroidDriver<AndroidElement> driver = null;
	  
	  protected AppiumDriver<MobileElement> driver;
	  
	  
	  private static Workbook wb;
	  private static Sheet sh;
	  private static FileInputStream fis; 
	  private static FileOutputStream fos; 
	  private static Row row;
	  private static Cell cell;
	  
	  protected Properties objectrepo;
 
	  private static Logger log = Logger.getLogger(log.class.getName());//
	 
	 
	  public void initializes() throws IOException{ {
		  String filePath = System.getProperty("user.dir");
  			FileInputStream fis = new FileInputStream(filePath+"/config/Testdata.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 
			 XSSFSheet sheet = workbook.getSheet("Utility");
			 XSSFSheet sheets = workbook.getSheet("Platform");
			 
			 Row plaform = sheets.getRow(1);
			   Cell cell11 = plaform.getCell(1);
		  String Platform  = cell11.getStringCellValue();
			 
			 
			 Row UD = sheet.getRow(1);
		   Cell cell = UD.getCell(1);
	     String UDID = cell.getStringCellValue();
	     
		 
	     Row UD1 = sheet.getRow(2);
		   Cell cell1 = UD1.getCell(1);
	     String EYADA_APP_PACKAGE = cell1.getStringCellValue();
		    
		    
	     Row UD2 = sheet.getRow(3);
		   Cell cell2 = UD2.getCell(1);
	     String EYADA_APP_ACTIVITY = cell2.getStringCellValue();
		    
	     Row UD3 = sheet.getRow(4);
		   Cell cell3 = UD3.getCell(1);
	     String SIHATY_APP_PACKAGE = cell3.getStringCellValue();
		    
	     Row UD4 = sheet.getRow(5);
		   Cell cell4 = UD4.getCell(1);
	     String SIHATY_APP_ACTIVITY = cell4.getStringCellValue();	    
		 
		  
    DesiredCapabilities dc = new DesiredCapabilities();
 
	   
	   
	   
 

    dc.setCapability("reportDirectory", reportDirectory);
    dc.setCapability("reportFormat", reportFormat);
    dc.setCapability("testName", testName);
    log.info("Pleaase enter Pin ");
    
    CONFIG= new Properties();
	FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"//src//test/java//utils/config.properties");
	CONFIG.load(fn);
	
	 
	
	
	
	
	  objectrepo   = new Properties();
		File objfile = new File(System.getProperty("user.dir")+"//src//test/java//utils/objectrepo.properties");
		FileReader objrepo = new FileReader(objfile);
		objectrepo.load(objrepo);

	//	/Users/user/eclipse-workspace/SihatyWeb/src/test/java/utils/objectrepo.properties
 
	if (Platform.equals("EYADA")){
		
		  
	    
		
		 dc.setCapability(MobileCapabilityType.UDID, UDID);
		    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, EYADA_APP_PACKAGE);
		    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, EYADA_APP_ACTIVITY);
	 //	    dc.setCapability(MobileCapabilityType.NO_RESET, true);
		    
		 
		
	}

	  else if(Platform.equals("SIHATY")){
		  dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, SIHATY_APP_PACKAGE);
		    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, SIHATY_APP_ACTIVITY);
		    dc.setCapability("noResetValue","true");
	//	     dc.setCapability(MobileCapabilityType.NO_RESET, true);

	  }
    
   
  // driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    URL url = new URL ("http://localhost:4723/wd/hub");

    driver = new AppiumDriver<MobileElement> (url, dc);
	
    driver.setLogLevel(Level.INFO);
    driver.setLogLevel(Level.INFO);
java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
 

    
 
    
    // this will install the app on the device
//    dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\Adeyinka.Alayo\\AppData\\Roaming\\appiumstudio\\original-apks\\Sihaty-MOH.ipa");
     
// HERE IS TO LOGIN TO THE APP (PIN HERE IS 111111). It can be changed 
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

   
	
	 }


Logger log = Logger.getLogger("devpinoyLogger"); 


FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config//Testdata.xlsx");


//FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

XSSFWorkbook workbook = new XSSFWorkbook(fis);
 
XSSFSheet sheets = workbook.getSheet("Platform");


Row plaform = sheets.getRow(1);
Cell cell11 = plaform.getCell(1);
String Platform  = cell11.getStringCellValue();




		
		if (Platform.equals("EYADA")){
		 
			
			{
  String Pintitle=  driver.findElement(By.xpath(objectrepo.getProperty("PINTILE"))).getText()  ; 
				 
				{		 
 
	if (Pintitle.equals(CONFIG.getProperty("EyadaPinText"))) {
		log.info("Eyada Pin Text verified  "); 
	    	  }
	else if      (!Pintitle.equals(CONFIG.getProperty("EyadaPinText"))) { 
		 
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		  // Call method to capture screenshot
		  File src=screenshot.getScreenshotAs(OutputType.FILE);
		  // Copy files to specific location 
		  // result.getName() will return name of test case so that screenshot name will be same as test case name
		   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

		
		Assert.fail("Eyada Pin Text is not correct  "); 
		
		 
		 	
	} 
			}
			}
			
			
			
			
			
			
			
		}

		  else if(Platform.equals("SIHATY")){
			  
			
			
	 			{
  String Pintitle=  driver.findElement(By.xpath(objectrepo.getProperty("PINTILE"))).getText()  ; 
 
	 				{		 
	 
	 	if (Pintitle.equals(CONFIG.getProperty("SihatyPinText"))) {
	 		log.info("Sihaty Pin Text verified  "); 
	 	    	  }
	 	else if      (!Pintitle.equals(CONFIG.getProperty("SihatyPinText"))) { 
		 
	 		TakesScreenshot screenshot=(TakesScreenshot)driver;
	 		  // Call method to capture screenshot
	 		  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 		  // Copy files to specific location 
			  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 		   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

			
	 		Assert.fail("Sihaty Pin Text is not correct  "); 
			
	 	} 
	 	} 
			  
		 			} 
			  
			  
			  
		  }
			  
			  
		

	//	Row firstval = sheets.getRow(9);
	  //   Cell cell5 = firstval.getCell(1);
	  //   String firstvals  = cell5.getStringCellValue();
	     
	     
//  driver.findElement(By.xpath("//*[@text='" + firstvals + "']"))   ;  	 


driver.findElement(By.xpath("//*[@text='1']")).click();
driver.findElement(By.xpath("//*[@text='1']")).click();
driver.findElement(By.xpath("//*[@text='1']")).click();
driver.findElement(By.xpath("//*[@text='1']")).click();
driver.findElement(By.xpath("//*[@text='1']")).click();

driver.findElement(By.xpath("//*[@text='1']")).click(); 
log.info("Pin entered  ");





		 


 
}
 



@AfterMethod //AfterMethod annotation - This method executes after every test execution
public void screenShot(ITestResult result){

driver.quit();
}}