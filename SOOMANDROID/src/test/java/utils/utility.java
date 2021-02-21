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
import io.appium.java_client.remote.IOSMobileCapabilityType;
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
			 
			 Row plaform = sheet.getRow(3);
			   Cell cell11 = plaform.getCell(1);
		  String Platform  = cell11.getStringCellValue();
			 
			 
			 Row UD = sheet.getRow(1);
		   Cell cell = UD.getCell(1);
	     String UDID = cell.getStringCellValue();
	     
		 Row app = sheet.getRow(4);
		   Cell cell1 = app.getCell(1);
	     String APP = cell1.getStringCellValue();
	     
		 
		 Row devname = sheet.getRow(6);
		   Cell cell2 = devname.getCell(1);
	     String DeviceName = cell2.getStringCellValue();
	     
	     Row AutomationName = sheet.getRow(5);
		   Cell cell3 = AutomationName.getCell(1);
	     String automationName = cell3.getStringCellValue();
	     
	     
	     Row PlatformName = sheet.getRow(13);
		   Cell cell4 = PlatformName.getCell(1);
	     String platformName = cell4.getStringCellValue();
	     
	     
	     
 	      //  dc.setCapability(IOSMobileCapabilityType.PLATFORM_NAME, platformName);
  	    //     dc.setCapability("noReset", "true");
	      //  dc.setCapability("xcodeOrgId", XcodeOrgId);
	   //     dc.setCapability("xcodeSigningId", XcodeSigningId);
	    //    dc.setCapability("wdaStartupRetries", WdaStartupRetries);
	    //    dc.setCapability("iosInstallPause", IosInstallPause);
 
	     
		  
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
 
	if (Platform.equals("")){
		  dc.setCapability(MobileCapabilityType.APP, APP);
		   dc.setCapability(IOSMobileCapabilityType.PLATFORM_NAME, platformName);
		        dc.setCapability("automationName", automationName);
		        dc.setCapability("deviceName", DeviceName);
		     //   dc.setCapability("noReset", NoReset);
	 	         dc.setCapability("noReset", "true");

		//        dc.setCapability("xcodeOrgId", XcodeOrgId);
		  //      dc.setCapability("xcodeSigningId", XcodeSigningId);
		  //      dc.setCapability("wdaStartupRetries", WdaStartupRetries);
		  //      dc.setCapability("iosInstallPause", IosInstallPause);
	       dc.setCapability("udid", UDID);
			  
   log.info("Platform is Empty and No Capability");

		
	}

	  else if(Platform.equals("IOS")){
	 
		  dc.setCapability(MobileCapabilityType.APP, APP);
	   dc.setCapability(IOSMobileCapabilityType.PLATFORM_NAME, platformName);
	        dc.setCapability("automationName", automationName);
	        dc.setCapability("deviceName", DeviceName);
	     //   dc.setCapability("noReset", NoReset);
 	         dc.setCapability("noReset", "true");

	//        dc.setCapability("xcodeOrgId", XcodeOrgId);
	  //      dc.setCapability("xcodeSigningId", XcodeSigningId);
	  //      dc.setCapability("wdaStartupRetries", WdaStartupRetries);
	  //      dc.setCapability("iosInstallPause", IosInstallPause);
       dc.setCapability("udid", UDID);
		  

	  }
    
   
     URL url = new URL ("http://localhost:4723/wd/hub");

    driver = new AppiumDriver<MobileElement> (url, dc);
	
    driver.setLogLevel(Level.INFO);
    driver.setLogLevel(Level.INFO);
java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
 
	  }}
    
 
 
	 

 



@AfterMethod //AfterMethod annotation - This method executes after every test execution
public void screenShot(ITestResult result){

driver.quit();
}}