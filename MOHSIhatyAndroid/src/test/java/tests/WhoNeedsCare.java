package tests;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.utility;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.net.URL;
import java.text.SimpleDateFormat;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;
import utils.log;


public class WhoNeedsCare extends utility {
	 private String reportDirectory = "reports";
	    	    
	  @BeforeMethod
	    public void setUp1() throws IOException {
		  log.info("-----------------------------------------START TEST -Who Needs Cared Page--------------------------------------------------------------");

 	    	initializes();
}

  @SuppressWarnings("rawtypes")
@Test  
  public void testNeedsCare() throws InterruptedException , IOException{
	 
	  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 
XSSFSheet sheets = workbook.getSheet("Platform");
Row plaform = sheets.getRow(1);
Cell cell11 = plaform.getCell(1);
String Platform  = cell11.getStringCellValue();

	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 
	    
	      if (Platform.equals("SIHATY")){
	    	  
 
	   driver.findElement(By.xpath(objectrepo.getProperty("BookSpecialistAppointmentButton"))).click();
  
		    	    	       	  
		     	    	 
	 	}

	 	  else if(Platform.equals("EYADA")){

      driver.findElement(By.xpath(objectrepo.getProperty("BookConsultationButton"))).click();
 		    	 

	 	  }  
	   
	      
	      
	      String NeedsCare= driver.findElement(By.xpath(objectrepo.getProperty("NEEDSCARETITLE"))).getText()  ;        
	      Thread.sleep(1000); 
	      try {
	    	  if (CONFIG.getProperty("NeedsCareText").equals(NeedsCare)) {
	    		  log.info("Needs Care Confirmed Okay ");
	    		 
	    	  }
	        } catch (NoSuchElementException e) {
	        	  log.info("Needs Care is Not accurate  ");
	        }	  
	      
 	      driver.findElement(By.xpath(objectrepo.getProperty("MYCHILDREN")));
	      
 	      driver.findElement(By.xpath(objectrepo.getProperty("ADDCHILD")));
   
 	     
	      
	      
	      {
	      if (Platform.equals("SIHATY")){
	    	  
	    	  log.info("Confirmed Okay ------------------------ ");
 
	       		    	    	 
	    	    	 	}

	    	    	 	  else if(Platform.equals("EYADA")){
	    		 
	    	    	 		 boolean emergencyText1 = driver.getPageSource().contains(CONFIG.getProperty("EyadaEmergencyGuidelinesText"));
	    	   		      if (emergencyText1 == true)
	    	   		      {
	    	   		      	 log.info("Emergency Text1 Confirmed ");
	    	   		      }
	    	   		      else
	    	   		      {
	    	   		      	TakesScreenshot screenshot=(TakesScreenshot)driver;
	    	   		      	  // Call method to capture screenshot
	    	   		      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	    	   		      	  // Copy files to specific location 
	    	   		      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	    	   		      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	    	   		      	Assert.fail("Banner Text1 is not correct ");
	      
	    	    	 	  }
	    	    	 	 }
	      //End  Block
	      
	      }
	      
		  log.info("-----------------------------------------END TEST -Who Needs Cared Page--------------------------------------------------------------");

	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
    	      
  }

	  
private WaitOptions waitOptions(Duration ofMillis) {
	// TODO Auto-generated method stub
	return null;
}

@AfterMethod //AfterMethod annotation - This method executes after every test execution
public void screenShot(ITestResult result){
//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
if(ITestResult.FAILURE==result.getStatus()){
try{
// To create reference of TakesScreenshot
TakesScreenshot screenshot=(TakesScreenshot)driver;
// Call method to capture screenshot
File src=screenshot.getScreenshotAs(OutputType.FILE);
// Copy files to specific location 
// result.getName() will return name of test case so that screenshot name will be same as test case name
FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshots/"+result.getName()+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

System.out.println("Successfully captured a screenshot");
}catch (Exception e){
System.out.println("Exception while taking screenshot "+e.getMessage());
} 
}
driver.quit();
}

private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}