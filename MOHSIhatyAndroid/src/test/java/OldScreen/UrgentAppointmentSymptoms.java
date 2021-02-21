package OldScreen;

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

public class UrgentAppointmentSymptoms extends utility {
	 private String reportDirectory = "reports";
	    	    
	  @BeforeMethod
	    public void setUp1() throws IOException {
		  log.info("-----------------------------------------START TEST -Validate Urgent Appointments Symptoms--------------------------------------------------------------");

		  log.info("START TEST -Validate Urgent Appointments Symptoms ");
	    	initializes();
	    	   
}

  @SuppressWarnings("rawtypes")
@Test  
// THIS TEST VALIDATES THAT THE SYMPTOMS CATEGORIES ARE CORRECT 

  public void testUrgentAppointmentSymptoms() throws InterruptedException , IOException{
	  
	  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	  XSSFSheet sheets = workbook.getSheet("Platform");
		 
		 Row plaform = sheets.getRow(1);
		   Cell cell11 = plaform.getCell(1);
	   String Platform  = cell11.getStringCellValue();
	 

	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    
	    
	      if (Platform.equals("SIHATY")){
	    	  
String ConsultButton= driver.findElement(By.xpath("//*[@id='btn_book_consultation']")).getText()  ;        
		      Thread.sleep(1000); 
		      try {
		    	  if (CONFIG.getProperty("SihatyButton").equals(ConsultButton)) {
		    		  log.info("Consultation Button Confirmed Okay ");
		    		  driver.findElement(By.xpath("//*[@id='btn_book_consultation']")).click();
  		  
		    		     
		    	  }
		        } catch (NoSuchElementException e) {
		        	  log.info("Consultation Button is Not accurate  ");
		        }	      	  
	    	  

		    	    	 
	 	}

	 	  else if(Platform.equals("EYADA")){

	 		 String ConsultButton= driver.findElement(By.xpath("//*[@id='btn_book_consultation']")).getText()  ;        
		      Thread.sleep(1000); 
		      try {
		    	  if (CONFIG.getProperty("EyadaButton").equals(ConsultButton)) {
		    		  log.info("Consultation Button Confirmed Okay ");
		    		  driver.findElement(By.xpath("//*[@id='btn_book_consultation']")).click();
		    		  
		    		  
		    		  
		    		  

		    	  }
		        } catch (NoSuchElementException e) {
		        	  log.info("Consultation Button is Not accurate  ");
		        }	      	     		    	 

	 	  }  
	   
	      
	      
	      String NeedsCare= driver.findElement(By.xpath("//*[@id='title_who_needs_care']")).getText()  ;        
	      Thread.sleep(1000); 
	      try {
	    	  if (CONFIG.getProperty("NeedsCareText").equals(NeedsCare)) {
	    		  log.info("Needs Care Confirmed Okay ");
	    		 
	    	  }
	        } catch (NoSuchElementException e) {
	        	  log.info("Needs Care is Not accurate  ");
	        }	      	  

	      driver.findElement(By.xpath("//*[@id='tv_name']")).click();
	      Thread.sleep(3000);
	      
	      // this is actually for sihaty flow so change after 

	   
	      
	      
	      
	      if (Platform.equals("EYADA")){
	    	  driver.findElement(By.xpath("//*[@id='logo']"));	
	    	
 
	    	  
  {
	  boolean TellUsTitle = driver.getPageSource().contains(CONFIG.getProperty("TellUsTitle"));
	  if (TellUsTitle == true)
      {
      	 log.info("Title Text Confirmed ");
      }
      else
      {
      	TakesScreenshot screenshot=(TakesScreenshot)driver;
      	  // Call method to capture screenshot
      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
      	  // Copy files to specific location 
      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

      	Assert.fail("Title  is not correct ");  	
      }
	  
	  
	  {
		  
		  boolean TellUsSubTitle = driver.getPageSource().contains(CONFIG.getProperty("TellUsSubTitle"));
		  if (TellUsSubTitle == true)
	      {
	      	 log.info("SubTitle Text Confirmed ");
	      	 
	      }
	      else
	      {
	      	TakesScreenshot screenshot=(TakesScreenshot)driver;
	      	  // Call method to capture screenshot
	      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	      	  // Copy files to specific location 
	      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	      	Assert.fail("SubTitle  is not correct ");  	    
	      }
	
		  
		  
		  
		  {
			  
			  boolean EYADAURGENT1 = driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT1"));
			  if (EYADAURGENT1 == true)
		      {
		      	 log.info("EYADAURGENT1 Confirmed ");
		      	 
		      }
		      else
		      {
		      	TakesScreenshot screenshot=(TakesScreenshot)driver;
		      	  // Call method to capture screenshot
		      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
		      	  // Copy files to specific location 
		      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
		      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

		      	Assert.fail("EYADAURGENT1  is not correct ");  		    
			  
		      	
		  }
		  
		 	  
			  
			  {
				  
				  boolean EYADAURGENT2 = driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT2"));
				  if (EYADAURGENT2 == true)
			      {
			      	 log.info("EYADAURGENT2 Confirmed ");
			      	 
			      }
			      else
			      {
			      	TakesScreenshot screenshot=(TakesScreenshot)driver;
			      	  // Call method to capture screenshot
			      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
			      	  // Copy files to specific location 
			      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
			      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

			      	Assert.fail("EYADAURGENT2  is not correct ");  		    
				  
			      }}}
		  

		  
			  
		  {
			  
			  boolean EYADAURGENT3 = driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT3"));
			  if (EYADAURGENT3 == true)
		      {
		      	 log.info("EYADAURGENT3 Confirmed ");
		      	 
		      }
		      else
		      {
		      	TakesScreenshot screenshot=(TakesScreenshot)driver;
		      	  // Call method to capture screenshot
		      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
		      	  // Copy files to specific location 
		      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
		      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

		      	Assert.fail("EYADAURGENT3  is not correct ");  		    
			  
		      }}	  
		  
		  
		  JavascriptExecutor js1 = (JavascriptExecutor) driver;
	      HashMap<String, String> scrollObject = new HashMap<String, String>();
	      scrollObject.put("direction", "down");
	      js1.executeScript("mobile: scroll", scrollObject);
	      log.info("Scolled Up ");
		  
			  
{
			  
			  boolean EYADAURGENT4 = driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT4"));
			
			  if (EYADAURGENT4 == true)
		      {
		      	 log.info("EYADAURGENT4 Confirmed ");
		      	 
		      }
		      else
		      {
		      	TakesScreenshot screenshot=(TakesScreenshot)driver;
		      	  // Call method to capture screenshot
		      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
		      	  // Copy files to specific location 
		      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
		      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

		      	Assert.fail("EYADAURGENT4  is not correct ");  		    
			  
		      }}	   
			  
			  
{
	  
	  boolean EYADAURGENT5 = driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT5"));
	  if (EYADAURGENT5 == true)
    {
    	 log.info("EYADAURGENT5 Confirmed ");
    	 
    }
    else
    {
    	TakesScreenshot screenshot=(TakesScreenshot)driver;
    	  // Call method to capture screenshot
    	  File src=screenshot.getScreenshotAs(OutputType.FILE);
    	  // Copy files to specific location 
    	  // result.getName() will return name of test case so that screenshot name will be same as test case name
    	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

    	Assert.fail("EYADAURGENT5  is not correct ");  		    
	  
    }}			  
		  


{
	  
	  boolean ProblemsText = driver.getPageSource().contains(CONFIG.getProperty("ProblemsText"));
	  if (ProblemsText == true)
  {
  	 log.info("ProblemsText Confirmed ");
  	 
  }
  else
  {
  	TakesScreenshot screenshot=(TakesScreenshot)driver;
  	  // Call method to capture screenshot
  	  File src=screenshot.getScreenshotAs(OutputType.FILE);
  	  // Copy files to specific location 
  	  // result.getName() will return name of test case so that screenshot name will be same as test case name
  	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

  	Assert.fail("ProblemsText  is not correct ");  		    
	  
  }}			
		  
{
	  
	  boolean ProblemsSubText = driver.getPageSource().contains(CONFIG.getProperty("ProblemsSubText"));
	  if (ProblemsSubText == true)
{
	 log.info("ProblemsSubText Confirmed ");
	 
}
else
{
	TakesScreenshot screenshot=(TakesScreenshot)driver;
	  // Call method to capture screenshot
	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	  // Copy files to specific location 
	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	Assert.fail("ProblemsSubText  is not correct ");  		    
	  
}}				  
	
JavascriptExecutor js5 = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject5 = new HashMap<String, String>();
scrollObject5.put("direction", "up");
js5.executeScript("mobile: scroll", scrollObject5);
log.info("Scolled Up ");

 // COUGH Symptoms
driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click();
 
	 
driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT1"));
driver.findElement(By.xpath("//*[@text='Allergies']"));	
//driver.findElement(By.xpath("//*[@text='Coronavirus symptoms']"));	
driver.findElement(By.xpath("//*[@text='Cough']"));	
driver.findElement(By.xpath("//*[@text='Fever']"));	
driver.findElement(By.xpath("//*[@text='Flu-like symptoms']"));	
driver.findElement(By.xpath("//*[@text='Sore throat']")); 
log.info("All Cough Symptoms Verified");
driver.navigate().back();
//General Symptoms Symptoms



driver.findElement(By.xpath("//*[@text='General symptoms']")).click();
driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT2"));
driver.findElement(By.xpath("//*[@text='Anxiety and stress']"));	
driver.findElement(By.xpath("//*[@text='Dizziness']"));	
driver.findElement(By.xpath("//*[@text='Eye or eyelid problems']"));	
driver.findElement(By.xpath("//*[@text='Fatigue (tiredness)']"));
driver.findElement(By.xpath("//*[@text='Headache']"));
driver.findElement(By.xpath("//*[@text='Joint or limb pain']"));
driver.findElement(By.xpath("//*[@text='Low back pain']"));
driver.findElement(By.xpath("//*[@text='Minor injuries']"));
driver.findElement(By.xpath("//*[@text='Sleep difficulties']"));
log.info("All General Symptoms Verified");
driver.navigate().back();



JavascriptExecutor js6 = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject8 = new HashMap<String, String>();
scrollObject8.put("direction", "up");
js6.executeScript("mobile: scroll", scrollObject8);
log.info("Scolled up ");






//Genital and urinary symptoms Symptoms Symptoms
driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click();
driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT3"));
driver.findElement(By.xpath("//*[@text='Contraception counseling']"));
driver.findElement(By.xpath("//*[@text='Erectile dysfunction']"));
driver.findElement(By.xpath("//*[@text='Period problems']"));
driver.findElement(By.xpath("//*[@text='Sexually transmitted infections']"));
driver.findElement(By.xpath("//*[@text='Urinary tract infections']"));
driver.findElement(By.xpath("//*[@text='Vaginal discharge or itching']"));
log.info("All Genital and urinary Symptoms Verified");
driver.navigate().back();





//Skin Problems symptoms Symptoms Symptoms
driver.findElement(By.xpath("//*[@text='Skin problems']")).click();
driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT4"));
driver.findElement(By.xpath("//*[@text='Acne']"));
driver.findElement(By.xpath("//*[@text='Hair problems']"));
driver.findElement(By.xpath("//*[@text='Head lice']"));
driver.findElement(By.xpath("//*[@text='Insect bites and stings']"));
driver.findElement(By.xpath("//*[@text='Nail problems']"));
driver.findElement(By.xpath("//*[@text='Rash']"));
log.info("Skin Problems Symptoms Verified");
driver.navigate().back();



JavascriptExecutor js7 = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject7 = new HashMap<String, String>();
scrollObject7.put("direction", "down");
js7.executeScript("mobile: scroll", scrollObject7);
log.info("Scolled down ");

//Stomach an Bowel symptoms Symptoms Symptoms
driver.findElement(By.xpath("//*[@text='Stomach and bowel symptoms']")).click();
driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT5"));
driver.findElement(By.xpath("//*[@text='Constipation']"));
driver.findElement(By.xpath("//*[@text='Heartburn (indigestion)']"));
driver.findElement(By.xpath("//*[@text='Pain (abdominal)']"));
driver.findElement(By.xpath("//*[@text='Vomiting and diarrhea']"));

log.info("Stomach an Bowel symptoms Verified");
driver.navigate().back();


JavascriptExecutor js3 = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject3 = new HashMap<String, String>();
scrollObject3.put("direction", "down");
js3.executeScript("mobile: scroll", scrollObject3);
log.info("Scolled down ");

//Tests and medications symptoms Symptoms

driver.findElement(By.xpath("//*[@text='Tests and medications']")).click();
driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT6"));
driver.findElement(By.xpath("//*[@text='Laboratory tests']"));
driver.findElement(By.xpath("//*[@text='Prescription medications']"));

log.info("Tests and medications symptoms Verified");
driver.navigate().back();
log.info("-----------------------------------------END TEST -Validate Urgent Appointments Symptoms--------------------------------------------------------------");

	  }
  }}
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	 	  else if(Platform.equals("SIHATY")){

	 		 driver.findElement(By.xpath("//*[@id='logo']"));	
		    	
	 		 
	    	  
	 		  {
	 			  boolean TellUsTitle = driver.getPageSource().contains(CONFIG.getProperty("TellUsTitle"));
	 			  if (TellUsTitle == true)
	 		      {
	 		      	 log.info("Title Text Confirmed ");
	 		      }
	 		      else
	 		      {
	 		      	TakesScreenshot screenshot=(TakesScreenshot)driver;
	 		      	  // Call method to capture screenshot
	 		      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 		      	  // Copy files to specific location 
	 		      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 		      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 		      	Assert.fail("Title  is not correct ");  	
	 		      }
	 			  
	 			  
	 			  {
	 				  
	 				  boolean TellUsSubTitle = driver.getPageSource().contains(CONFIG.getProperty("TellUsSubTitle"));
	 				  if (TellUsSubTitle == true)
	 			      {
	 			      	 log.info("SubTitle Text Confirmed ");
	 			      	 
	 			      }
	 			      else
	 			      {
	 			      	TakesScreenshot screenshot=(TakesScreenshot)driver;
	 			      	  // Call method to capture screenshot
	 			      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 			      	  // Copy files to specific location 
	 			      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 			      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 			      	Assert.fail("SubTitle  is not correct ");  	    
	 			      }
	 			
	 				  
	 				  
	 				  
	 				  {
	 					  
	 					  boolean SIYATYURGENT1 = driver.getPageSource().contains(CONFIG.getProperty("SIYATYURGENT1"));
	 					  if (SIYATYURGENT1 == true)
	 				      {
	 				      	 log.info("SIYATYURGENT1 Confirmed ");
	 				      	 
	 				      }
	 				      else
	 				      {
	 				      	TakesScreenshot screenshot=(TakesScreenshot)driver;
	 				      	  // Call method to capture screenshot
	 				      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 				      	  // Copy files to specific location 
	 				      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 				      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 				      	Assert.fail("SIYATYURGENT1  is not correct ");  		    
	 					  
	 				      	
	 				  }
	 				  
	 					  
	 					  {
	 						  
	 						  boolean SIYATYURGENT2 = driver.getPageSource().contains(CONFIG.getProperty("SIYATYURGENT2"));
	 						  if (SIYATYURGENT2 == true)
	 					      {
	 					      	 log.info("SIYATYURGENT2 Confirmed ");
	 					      	 
	 					      }
	 					      else
	 					      {
	 					      	TakesScreenshot screenshot=(TakesScreenshot)driver;
	 					      	  // Call method to capture screenshot
	 					      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 					      	  // Copy files to specific location 
	 					      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 					      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 					      	Assert.fail("SIYATYURGENT2  is not correct ");  		    
	 						  
	 					      }}}
	 					  
	 				  {
	 					  
	 					  boolean SIYATYURGENT3 = driver.getPageSource().contains(CONFIG.getProperty("SIYATYURGENT3"));
	 					  if (SIYATYURGENT3 == true)
	 				      {
	 				      	 log.info("SIYATYURGENT3 Confirmed ");
	 				      	 
	 				      }
	 				      else
	 				      {
	 				      	TakesScreenshot screenshot=(TakesScreenshot)driver;
	 				      	  // Call method to capture screenshot
	 				      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 				      	  // Copy files to specific location 
	 				      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 				      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 				      	Assert.fail("SIYATYURGENT3  is not correct ");  		    
	 					  
	 				      }}	  
	 				  
	 				  
	 				  JavascriptExecutor js1 = (JavascriptExecutor) driver;
	 			      HashMap<String, String> scrollObject = new HashMap<String, String>();
	 			      scrollObject.put("direction", "down");
	 			      js1.executeScript("mobile: scroll", scrollObject);
	 			      log.info("Scolled down ");
	 				  
	 					  
	 		{
	 					  
	 					  boolean SIYATYURGENT4 = driver.getPageSource().contains(CONFIG.getProperty("SIYATYURGENT4"));
	 					
	 					  if (SIYATYURGENT4 == true)
	 				      {
	 				      	 log.info("SIYATYURGENT4 Confirmed ");
	 				      	 
	 				      }
	 				      else
	 				      {
	 				      	TakesScreenshot screenshot=(TakesScreenshot)driver;
	 				      	  // Call method to capture screenshot
	 				      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 				      	  // Copy files to specific location 
	 				      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 				      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 				      	Assert.fail("SIYATYURGENT4  is not correct ");  		    
	 					  
	 				      }}	   
	 					  
	 					  
	 		{
	 			  
	 			  boolean SIYATYURGENT5 = driver.getPageSource().contains(CONFIG.getProperty("SIYATYURGENT5"));
	 			  if (SIYATYURGENT5 == true)
	 		    {
	 		    	 log.info("SIYATYURGENT5 Confirmed ");
	 		    	 
	 		    }
	 		    else
	 		    {
	 		    	TakesScreenshot screenshot=(TakesScreenshot)driver;
	 		    	  // Call method to capture screenshot
	 		    	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 		    	  // Copy files to specific location 
	 		    	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 		    	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 		    	Assert.fail("SIYATYURGENT5  is not correct ");  		    
	 			  
	 		    }}			  
	 				  
	 				  
	 		{
	 			  
	 			  boolean ProblemsText = driver.getPageSource().contains(CONFIG.getProperty("ProblemsText"));
	 			  if (ProblemsText == true)
	 		  {
	 		  	 log.info("ProblemsText Confirmed ");
	 		  	 
	 		  }
	 		  else
	 		  {
	 		  	TakesScreenshot screenshot=(TakesScreenshot)driver;
	 		  	  // Call method to capture screenshot
	 		  	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 		  	  // Copy files to specific location 
	 		  	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 		  	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 		  	Assert.fail("ProblemsText  is not correct ");  		    
	 			  
	 		  }}			
	 				  
	 		{
	 			  
	 			  boolean ProblemsSubText = driver.getPageSource().contains(CONFIG.getProperty("ProblemsSubText"));
	 			  if (ProblemsSubText == true)
	 		{
	 			 log.info("ProblemsSubText Confirmed ");
	 			 
	 		}
	 		else
	 		{
	 			TakesScreenshot screenshot=(TakesScreenshot)driver;
	 			  // Call method to capture screenshot
	 			  File src=screenshot.getScreenshotAs(OutputType.FILE);
	 			  // Copy files to specific location 
	 			  // result.getName() will return name of test case so that screenshot name will be same as test case name
	 			   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	 			Assert.fail("ProblemsSubText  is not correct ");  		    
	 			  
	 		}}				  
	 			
	 		JavascriptExecutor js2 = (JavascriptExecutor) driver;
	 		HashMap<String, String> scrollObject2 = new HashMap<String, String>();
	 		scrollObject2.put("direction", "up");
	 		js2.executeScript("mobile: scroll", scrollObject2);
	 		log.info("Scolled Up ");

	 		 // COUGH Symptoms
	 		driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click();
	 		 
	 			 
	 		driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT1"));
	 		driver.findElement(By.xpath("//*[@text='Allergies']"));	
	 		//driver.findElement(By.xpath("//*[@text='Coronavirus symptoms']"));	
	 		driver.findElement(By.xpath("//*[@text='Cough']"));	
	 		driver.findElement(By.xpath("//*[@text='Fever']"));	
	 		driver.findElement(By.xpath("//*[@text='Flu-like symptoms']"));	
	 		driver.findElement(By.xpath("//*[@text='Sore throat']")); 
	 		log.info("All Cough Symptoms Verified");
	 		driver.navigate().back();
	 		//General Symptoms Symptoms
	 		
	 		  JavascriptExecutor js8 = (JavascriptExecutor) driver;
			  HashMap<String, String> scrollObject8 = new HashMap<String, String>();
			  scrollObject8.put("direction", "up");
			  js8.executeScript("mobile: scroll", scrollObject8);
			  log.info("Scolled Up ");

	 		driver.findElement(By.xpath("//*[@text='General symptoms']")).click();
	 		driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT2"));
	 		driver.findElement(By.xpath("//*[@text='Anxiety and stress']"));	
	 		driver.findElement(By.xpath("//*[@text='Dizziness']"));	
	 		driver.findElement(By.xpath("//*[@text='Eye or eyelid problems']"));	
	 		driver.findElement(By.xpath("//*[@text='Fatigue (tiredness)']"));
	 		driver.findElement(By.xpath("//*[@text='Headache']"));
	 		driver.findElement(By.xpath("//*[@text='Joint or limb pain']"));
	 		driver.findElement(By.xpath("//*[@text='Low back pain']"));
	 		driver.findElement(By.xpath("//*[@text='Minor injuries']"));
	 		driver.findElement(By.xpath("//*[@text='Sleep difficulties']"));
	 		log.info("All General Symptoms Verified");
	 		driver.navigate().back();

	 		//Genital and urinary symptoms Symptoms Symptoms
	 		driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click();
	 		driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT3"));
	 		driver.findElement(By.xpath("//*[@text='Contraception counseling']"));
	 		driver.findElement(By.xpath("//*[@text='Erectile dysfunction']"));
	 		driver.findElement(By.xpath("//*[@text='Period problems']"));
	 		driver.findElement(By.xpath("//*[@text='Sexually transmitted infections']"));
	 		driver.findElement(By.xpath("//*[@text='Urinary tract infections']"));
	 		driver.findElement(By.xpath("//*[@text='Vaginal discharge or itching']"));
	 		log.info("All Genital and urinary Symptoms Verified");
	 		driver.navigate().back();


	 		JavascriptExecutor js3 = (JavascriptExecutor) driver;
	 		HashMap<String, String> scrollObject3 = new HashMap<String, String>();
	 		scrollObject3.put("direction", "down");
	 		js3.executeScript("mobile: scroll", scrollObject3);
	 		log.info("Scolled down ");


	 		//Skin Problems symptoms Symptoms Symptoms
	 		driver.findElement(By.xpath("//*[@text='Skin problems']")).click();
	 		driver.getPageSource().contains(CONFIG.getProperty("EYADAURGENT4"));
	 		driver.findElement(By.xpath("//*[@text='Acne']"));
	 		driver.findElement(By.xpath("//*[@text='Hair problems']"));
	 		driver.findElement(By.xpath("//*[@text='Head lice']"));
	 		driver.findElement(By.xpath("//*[@text='Insect bites and stings']"));
	 		driver.findElement(By.xpath("//*[@text='Nail problems']"));
	 		driver.findElement(By.xpath("//*[@text='Rash']"));
	 		log.info("Skin Problems Symptoms Verified");
	 		driver.navigate().back();

	 		//Stomach an Bowel symptoms Symptoms Symptoms
	 		driver.findElement(By.xpath("//*[@text='Stomach and bowel symptom']")).click();
	 		driver.getPageSource().contains(CONFIG.getProperty("SIYATYURGENT5"));
	 		driver.findElement(By.xpath("//*[@text='Constipation']"));
	 		driver.findElement(By.xpath("//*[@text='Heartburn (indigestion)']"));
	 		driver.findElement(By.xpath("//*[@text='Pain (abdominal)']"));
	 		driver.findElement(By.xpath("//*[@text='Vomiting and diarrhea']"));

	 		log.info("Stomach an Bowel symptoms Verified");
	 		driver.navigate().back();


	 		//Tests and medications symptoms Symptoms

	 		driver.findElement(By.xpath("//*[@text='Tests and medications']")).click();
	 		driver.getPageSource().contains(CONFIG.getProperty("SIYATYURGENT6"));
	 		driver.findElement(By.xpath("//*[@text='Laboratory tests']"));
	 		driver.findElement(By.xpath("//*[@text='Prescription medications']"));

	 		log.info("Tests and medications symptoms Verified");
	 		driver.navigate().back();
			  log.info("-----------------------------------------END TEST -Validate Urgent Appointments Symptoms--------------------------------------------------------------");

	 			  }
	 		  }}
		            	     		    	 

	  
	        
	      
	      
	      
	      
	      
	      
	    
	    
	    
	    
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
    	      
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