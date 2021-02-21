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

public class SpecialistAppointmentSymtpoms extends utility {
	 private String reportDirectory = "reports";
	    	    
	  @BeforeMethod
	    public void setUp1() throws IOException {
 log.info("-----------------------------------------START TEST -Validate Specilaist Appointment Symptoms--------------------------------------------------------------");
	 
	    	initializes();
	    	   
}

  @SuppressWarnings("rawtypes")
@Test  

//THIS TEST VALIDATES THAT THE SYMPTOMS QUESTIONS AND ANSWERS ARE CORRECT 
  public void SpecialistAppointmentSymptoms() throws InterruptedException , IOException{
	  
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
	    		 
	    			      
	    			      driver.findElement(By.xpath("//*[@id='tv_name']")).click();
	    			      Thread.sleep(2000);
  			      
      driver.findElement(By.xpath("//*[@text='Specialist appointments']")).click(); 
      log.info("Specialist appointments Button Clicked  ");
      Thread.sleep(2000);  
      driver.findElement(By.xpath("//*[@text='Select the reason for consultation']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']"));
      driver.findElement(By.xpath("//*[@text='Chronic disease care']"));
      driver.findElement(By.xpath("//*[@text='Preventive care']"));
      driver.findElement(By.xpath("//*[@text='Other']"));
      log.info("All Specialist Categories Confirmed");
      
      JavascriptExecutor js1 = (JavascriptExecutor) driver;
      HashMap<String, String> scrollObject = new HashMap<String, String>();
      scrollObject.put("direction", "down");
      js1.executeScript("mobile: scroll", scrollObject);
      log.info("Scolled downs ");  			      
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      
      driver.findElement(By.xpath("//*[@text='Anger management']")).click();
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
    
    
      driver.findElement(By.xpath("//*[@text='Anxiety and panic attacks']")).click();
      log.info("Anxiety ");  	
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      
      driver.findElement(By.xpath("//*[@text='Primary health']")).click();
      driver.findElement(By.xpath("//*[@text='Family medicine']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      
  
      driver.findElement(By.xpath("//*[@text='Child and adolescent problems']"));
      log.info("Child ");  	
      driver.findElement(By.xpath("//*[@text='Eating disorders']")).click();
      
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      
 
      driver.findElement(By.xpath("//*[@text='Fears (phobias)']")).click();
      log.info("Fears ");  	
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      
      driver.findElement(By.xpath("//*[@text='Grief (loss of a loved one)']")).click();
      
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      
      driver.findElement(By.xpath("//*[@text='Primary health']")).click();
      driver.findElement(By.xpath("//*[@text='Family medicine']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      
      
      driver.findElement(By.xpath("//*[@text='Post-traumatic stress disorder (PTSD)']")).click();
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      JavascriptExecutor js2 = (JavascriptExecutor) driver;
      HashMap<String, String> scrollObject2 = new HashMap<String, String>();
      scrollObject2.put("direction", "down");
      js2.executeScript("mobile: scroll", scrollObject2);
      log.info("Scolled down ");  
  driver.findElement(By.xpath("//*[@text='Sadness and depressed mood']")).click();
  
  driver.findElement(By.xpath("//*[@id='title']"));
  driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
  driver.findElement(By.xpath("//*[@id='logo']"));
  driver.findElement(By.xpath("//*[@text='Close']"));
  driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
  driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
  driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
  driver.findElement(By.xpath("//*[@text='Psychology']"));
  
  driver.findElement(By.xpath("//*[@text='Primary health']")).click();
  driver.findElement(By.xpath("//*[@text='Family medicine']"));
  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
  

      driver.findElement(By.xpath("//*[@text='Sexual health']")).click();
      
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      
      driver.findElement(By.xpath("//*[@text='Sleep disorders']")).click();
      
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      
      driver.findElement(By.xpath("//*[@text='Primary health']")).click();
      driver.findElement(By.xpath("//*[@text='Family medicine']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
  
  
      driver.findElement(By.xpath("//*[@text='Substance abuse']")).click();
      
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Child & adolescent psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      driver.findElement(By.xpath("//*[@text='Work-related problems']")).click();
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
      driver.findElement(By.xpath("//*[@text='Behavioral health']")).click();
      driver.findElement(By.xpath("//*[@text='Adult psychiatry']"));
      driver.findElement(By.xpath("//*[@text='Psychology']"));
      driver.findElement(By.xpath("//*[@text='Primary health']")).click();
      driver.findElement(By.xpath("//*[@text='Family medicine']"));
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      
      JavascriptExecutor js6 = (JavascriptExecutor) driver;
      HashMap<String, String> scrollObject6 = new HashMap<String, String>();
      scrollObject6.put("direction", "down");
      js6.executeScript("mobile: scroll", scrollObject6);
      log.info("Scolled down ");  
  
      driver.findElement(By.xpath("//*[@text='Chronic disease care']")).click();   
      
      driver.findElement(By.xpath("//*[@text='Blood disorders (anemia)']"));
      driver.findElement(By.xpath("//*[@text='Cholesterol disorders']"));
      driver.findElement(By.xpath("//*[@text='Diabetes']"));
      driver.findElement(By.xpath("//*[@text='Elderly care']"));
      driver.findElement(By.xpath("//*[@text='Heart health']"));
      driver.findElement(By.xpath("//*[@text='High blood pressure']"));
      driver.findElement(By.xpath("//*[@text='Hormone problems']"));
      driver.findElement(By.xpath("//*[@text='Lung disease (asthma, COPD)']"));
      driver.findElement(By.xpath("//*[@text='Osteoporosis']"));
      
      JavascriptExecutor js4 = (JavascriptExecutor) driver;
      HashMap<String, String> scrollObject4 = new HashMap<String, String>();
      scrollObject4.put("direction", "down");
      js4.executeScript("mobile: scroll", scrollObject4);
      log.info("Scolled down ");  

      driver.findElement(By.xpath("//*[@text='Skin and hair problems']"));
      driver.findElement(By.xpath("//*[@text='Thyroid disorders']"));
      driver.findElement(By.xpath("//*[@text='Varicose veins']"));
      driver.findElement(By.xpath("//*[@text='Preventive care']")).click();   
      driver.findElement(By.xpath("//*[@text='Childhood development & milestones']"));
      driver.findElement(By.xpath("//*[@text='Lifestyle counseling']")).click(); 
      
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
  
      
      driver.findElement(By.xpath("//*[@text='Primary health']")).click();
      driver.findElement(By.xpath("//*[@text='Family medicine']"));
      
      driver.findElement(By.xpath("//*[@text='Wellness, nutrition, and rehabilitation']")).click();
      driver.findElement(By.xpath("//*[@text='Nutrition']"));
      
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      
      JavascriptExecutor js5 = (JavascriptExecutor) driver;
      HashMap<String, String> scrollObject5 = new HashMap<String, String>();
      scrollObject5.put("direction", "down");
      js5.executeScript("mobile: scroll", scrollObject5);
      log.info("Scolled down ");   
   
      driver.findElement(By.xpath("//*[@text='Medication management and safety']"));
      driver.findElement(By.xpath("//*[@text='Men’s health']"));
      driver.findElement(By.xpath("//*[@text='Quit smoking']"));
      driver.findElement(By.xpath("//*[@text='Screening recommendations']"));
      driver.findElement(By.xpath("//*[@text='Travel advice']"));
      driver.findElement(By.xpath("//*[@text='Vaccination plans']"));
      driver.findElement(By.xpath("//*[@text='Weight management']")).click();
      driver.findElement(By.xpath("//*[@id='title']"));
      driver.findElement(By.xpath("//*[@text='Select your preferred specialty']"));
      driver.findElement(By.xpath("//*[@id='logo']"));
      driver.findElement(By.xpath("//*[@text='Close']"));
  
      
      driver.findElement(By.xpath("//*[@text='Primary health']")).click();
      driver.findElement(By.xpath("//*[@text='Family medicine']"));
      
      driver.findElement(By.xpath("//*[@text='Wellness, nutrition, and rehabilitation']")).click();
      driver.findElement(By.xpath("//*[@text='Nutrition']"));
      
      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
      
      JavascriptExecutor js7 = (JavascriptExecutor) driver;
      HashMap<String, String> scrollObject7 = new HashMap<String, String>();
      scrollObject5.put("direction", "down");
      js5.executeScript("mobile: scroll", scrollObject5);
      log.info("Scolled down "); 
      
   
      driver.findElement(By.xpath("//*[@text='Women’s health']"));
      log.info("-----------------------------------------END TEST -Validate Specilaist Appointment Symptoms--------------------------------------------------------------");

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

	    			      
	    			      
	    			      driver.findElement(By.xpath("//*[@id='tv_name']")).click();
	    			      Thread.sleep(3000);	
	    			      
	    			      
	    				  {
	    					  
	    					  boolean SpecialistButtonText = driver.getPageSource().contains(CONFIG.getProperty("SpecialistButtonText"));
	    					  if (SpecialistButtonText == true)
	    				      {

	    						  TakesScreenshot screenshot=(TakesScreenshot)driver;
	    				      	  // Call method to capture screenshot
	    				      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
	    				      	  // Copy files to specific location 
	    				      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
	    				      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

	    				      	Assert.fail("Eyada Shouldnt have Specialist flow");
	    				      	 
	    				      }
	    				      else
	    				      {
	    				       
	    				      	
	    				      	 log.info("Eyada Doesnt Contain Specialist Flow ");
	    				      	 log.info("-----------------------------------------END TEST -Validate Specilaist Appointment Symptoms--------------------------------------------------------------");

	    					  
	    				      }}    
	    			      
	    			      
	    			      
	    			 
	    			      
	    			      
	    			      
	    			      
	    			      
	    			      
	    			      
	    		 	  }  
	    
	    
	   
   
   
	      
    	      
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