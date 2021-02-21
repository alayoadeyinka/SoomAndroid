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
import utils.log;

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

public class Homepages extends utility {
	 private String reportDirectory = "reports";
	    	    
	  @BeforeMethod
	    public void setUp1() throws IOException {
		   log.info("-------------------------- ---START TEST - HOMEPAGE ELEMENTS ------ ---------------------------------------------------");
 
	    	initializes();
}

  @SuppressWarnings("rawtypes")
@Test  
  public void testHomepage() throws InterruptedException , IOException{
	  
	  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	  XSSFSheet sheets = workbook.getSheet("Platform");
		 
		 Row plaform = sheets.getRow(1);
		   Cell cell11 = plaform.getCell(1);
	   String Platform  = cell11.getStringCellValue();
	  
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	    
	    driver.findElement(By.xpath("//*[@id='greeting']"));	    	
   	 driver.findElement(By.xpath("//*[@id='toolbar_title']"));
	    

	   String Greetings= driver.findElement(By.xpath("//*[@id='greeting']")).getText()  ;   
	      log.info("Greeting is ");
	      log.info(Greetings);
	      Thread.sleep(1000);
	      
	      
	      
String Toolbartitle= driver.findElement(By.xpath("//*[@id='toolbar_title']")).getText()  ;  


{

	if (Toolbartitle.equals(CONFIG.getProperty("Toolbar_title"))) {
	    	  
	    		  log.info("Title Text  is Confirmed Okay ");
	    	  }
	else if   (!Toolbartitle.equals(CONFIG.getProperty("Toolbar_title"))) { 
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		  // Call method to capture screenshot
		  File src=screenshot.getScreenshotAs(OutputType.FILE);
		  // Copy files to specific location 
		  // result.getName() will return name of test case so that screenshot name will be same as test case name
		   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

		
		Assert.fail("Title Text  is Wrong"); 	  
	    		  }
	          	    
}

String Toolbarsubtitle= driver.findElement(By.xpath("//*[@id='toolbar_subtitle']")).getText()  ; 

{
	
	
	if (Toolbarsubtitle.equals(CONFIG.getProperty("Toolbar_subtitle"))) {
  	  
		  log.info("Sub Title Text  is Confirmed Okay ");
	  }
else if   (!Toolbarsubtitle.equals(CONFIG.getProperty("Toolbar_subtitle"))) { 
TakesScreenshot screenshot=(TakesScreenshot)driver;
// Call method to capture screenshot
File src=screenshot.getScreenshotAs(OutputType.FILE);
// Copy files to specific location 
// result.getName() will return name of test case so that screenshot name will be same as test case name
 FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));


Assert.fail("Sub Title Text  is Wrong"); 	  
		  }
	
	
	      
	      
	      
       
	      
	      JavascriptExecutor js1 = (JavascriptExecutor) driver;
	      HashMap<String, String> scrollObject2 = new HashMap<String, String>();
	      scrollObject2.put("direction", "down");
	      js1.executeScript("mobile: scroll", scrollObject2);
	      log.info("Scolled down ");
	      
	      
	      
      
	      
	  // FIX HEALTH PRECAUTION AND HOW VIDEO WOrks  
	      
	      driver.findElement(By.xpath("//*[@id='title_banner']"));	   
	      log.info("Banner is Available ");
	      driver.findElement(By.xpath("//*[@text='How do video consultations work?']")).click();
	      log.info("Banner Clicked ");
	      
	      Thread.sleep(2000); 
	      driver.findElement(By.xpath("//*[@text and @class='android.view.View']")).click();
	    
	      
boolean BannerText1 = driver.getPageSource().contains(CONFIG.getProperty("BannerText1"));
if (BannerText1 == true)
{
	 log.info("Banner Text1 Confirmed ");
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
	  
boolean BannerText2 = driver.getPageSource().contains(CONFIG.getProperty("BannerText2"));
if (BannerText2 == true)
{
	 log.info("Banner Text2 Confirmed ");
}
else
{
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	  // Call method to capture screenshot
	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	  // Copy files to specific location 
	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	Assert.fail("Banner Text2 is not correct ");
	
}

boolean BannerText3 = driver.getPageSource().contains(CONFIG.getProperty("BannerText3"));
if (BannerText3 == true)
{
	 log.info("Banner Text3 Confirmed ");
}
else
{
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	  // Call method to capture screenshot
	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	  // Copy files to specific location 
	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	Assert.fail("Banner Text3 is not correct ");
	
}


driver.findElement(By.xpath("//*[@id='close']")).click();      
	      
log.info("Banner Page closed ");
Thread.sleep(1000);


JavascriptExecutor js3 = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject3 = new HashMap<String, String>();
scrollObject3.put("direction", "down");
js3.executeScript("mobile: scroll", scrollObject3);
log.info("Scolled down ");
	      
	      //VALIDATE THAT PRECAUTION IS NOT AVAIABLE 
	      
	      if(!driver.findElements(By.xpath("//*[@id='title_precaution']")).isEmpty()){
	    	  
	    	  
	    	  TakesScreenshot screenshot=(TakesScreenshot)driver;
			  // Call method to capture screenshot
			  File src=screenshot.getScreenshotAs(OutputType.FILE);
			  // Copy files to specific location 
			  // result.getName() will return name of test case so that screenshot name will be same as test case name
			   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

			Assert.fail("Precautions is available and should be disabled ");
	    	  
	    	 
	      }else{
	    	  
	    	  log.info("Precautions is not available  "); 
    
	      }
	      
	      
	          

	
	
	
	
	
}
    	      
	    	      if (Platform.equals("SIHATY")){
	    	    	  

JavascriptExecutor js4 = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject4 = new HashMap<String, String>();
scrollObject4.put("direction", "up");
js4.executeScript("mobile: scroll", scrollObject4);
log.info("Scolled up ");
	    	    	  
	    	    	  driver.findElement(By.xpath(objectrepo.getProperty("BookAppointmentButtonImage"))); 	  
	    	    	  log.info("Book Appointment Image Available");
String ConsultButton= driver.findElement(By.xpath(objectrepo.getProperty("BookSpecialistAppointmentButton"))).getText()  ;        
	    		      Thread.sleep(1000); 
	    		      try {
	    		    	  if (CONFIG.getProperty("SihatyButton").equals(ConsultButton)) {
	    		    		  log.info("Consultation Button Confirmed Okay ");
	    		    	  }
	    		        } catch (NoSuchElementException e) {
	    		        	  log.info("Consultation Button is Not accurate  ");
	    		        }	      	  
	    			  String ConsultSubButton=  driver.findElement(By.xpath(objectrepo.getProperty("BookSpecialistAppointmentSubTitle"))).getText()  ;        
	    			  Thread.sleep(1000); 
	    		      try {
	    		    	  if (CONFIG.getProperty("SihatySubButton").equals(ConsultSubButton)) {
	    		    		  log.info("Consultation Sub Title Confirmed Okay ");
	    		    	  }
	    		        } catch (NoSuchElementException e) {
	    		        	  log.info("Consultation Sub Title is Not accurate  ");
	    		        }	    
	    		      
	    		      
	    		      
	    		    	    	 
	    	 	}

	    	 	  else if(Platform.equals("EYADA")){
	    	 		 JavascriptExecutor js5 = (JavascriptExecutor) driver;
	    	 		HashMap<String, String> scrollObject5 = new HashMap<String, String>();
	    	 		scrollObject5.put("direction", "up");
	    	 		js5.executeScript("mobile: scroll", scrollObject5);
	    	 		log.info("Scolled up ");
		 
	    	 		 String ConsultButton= driver.findElement(By.xpath("//*[@id='btn_book_consultation']")).getText()  ;        
	    		      Thread.sleep(1000); 
	    		      try {
	    		    	  if (CONFIG.getProperty("EyadaButton").equals(ConsultButton)) {
	    		    		  log.info("Consultation Button Confirmed Okay ");
 	    		    	  }
	    		        } catch (NoSuchElementException e) {
	    		        	  log.info("Consultation Button is Not accurate  ");
	    		        }	      	     		    	 
    	 
	    	 	  }  
    	         
	   		   log.info("-------------------------- ---END TEST - APP Version ------ ---------------------------------------------------");
	      
      	    

  
	    	      
	    	      
	    	      
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