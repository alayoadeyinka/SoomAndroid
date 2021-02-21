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
import utils.utility;
import utils.log;

 
public class Doctors extends utility {
	 private String reportDirectory = "reports";
	 
	      
	    
	    @BeforeMethod
	    public void setUp1() throws IOException, InterruptedException {
			  log.info("----------------------START TEST - Doctor Module -----------------------------");
 
		 
	    	initializes();
	    	
  }
	    
	    

	    
	    
	    
	 
	    
  @SuppressWarnings("rawtypes")
@Test  
  public void testDoctors() throws InterruptedException, IOException {
	  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
	  XSSFSheet sheets = workbook.getSheet("Platform");
	  XSSFSheet sheetss = workbook.getSheet("Doctors"); 
	  
	  
		 Row plaform = sheets.getRow(1);
		   Cell cell11 = plaform.getCell(1);
	   String Platform  = cell11.getStringCellValue();
	   
	   
	   Row doctorname = sheetss.getRow(1);
	   Cell cell8 = doctorname.getCell(1);
	   String Doctorname  = cell8.getStringCellValue();
	   
	    
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@text='Doctors']")).click(); 
	      log.info("Doctors Menu Click");
      
   // Verify user is not logged in and error message is displayed 
    		 
    		// Here we enter the user Wrong MOH PIN 
	      
	    {	 
	    if (Platform.equals("SIHATY")){
    	      Thread.sleep(2000);

 
    	      
    	      driver.findElement(By.xpath("//*[@resource-id='tsvb.sihaty.android:id/logo']")); 
    	      log.info("Sihathy Logo ");
    	      
    	     
    	      
    	      boolean DoctorTitlepage = driver.getPageSource().contains(CONFIG.getProperty("DoctorTitlePage"));
    	      if (DoctorTitlepage == true)
    	      {
    	      	 log.info("DoctorTitlePage Confirmed ");
    	      }
    	      else
    	      {
    	      	TakesScreenshot screenshot=(TakesScreenshot)driver;
    	      	  // Call method to capture screenshot
    	      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
    	      	  // Copy files to specific location 
    	      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
    	      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

    	      	Assert.fail("DoctorTitlePage is not correct ");     	
    	      }
    	      
    	      
    	     
      
      driver.findElement(By.xpath(objectrepo.getProperty("DoctorSearchBox"))).sendKeys(Doctorname);
   
      driver.findElement(By.xpath(objectrepo.getProperty("DoctorSpecialty")));

      log.info("Specialty Confirmed ");
      
      driver.findElement(By.xpath(objectrepo.getProperty("DoctorImage")));
      driver.findElement(By.xpath(objectrepo.getProperty("DoctorNames")));
     
 	
      
      
     String expertise= driver.findElement(By.xpath(objectrepo.getProperty("expertise"))).getText()  ;  
     log.info(" Doctor Expertise is ");   
     log.info(expertise);       
    	        Thread.sleep(2000);
     driver.findElement(By.xpath(objectrepo.getProperty("DoctorImage"))).click();
 
        	      log.info(" Click on First Doctor "); 
        	      
        	      
        	      if(driver.getPageSource().contains("Book consultation")){
        	    		 
        	       		TakesScreenshot screenshot=(TakesScreenshot)driver;
        				  // Call method to capture screenshot
        				  File src=screenshot.getScreenshotAs(OutputType.FILE);
        				  // Copy files to specific location 
        				  // result.getName() will return name of test case so that screenshot name will be same as test case name
        				   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

        				Assert.fail("Doctors Page should not Contain Book Button");
        	       	
        		    	 }
        		          
        	      log.info("Verifying General Details ");
        		    
        		    
        		    String Drname= driver.findElement(By.xpath("//*[@id='name']")).getText()  ;   
        		    
        		    log.info("Dr Name is ");
        		    log.info(Drname);
        		    Thread.sleep(2000);

        		    driver.findElement(By.xpath("//*[@id='photo']"));
        		    log.info("Dr Photo Displayed"); 

        		    driver.findElement(By.xpath("//*[@text='Languages']"));
        		    log.info("Language Available"); 

        		     String language= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value'])[1]")).getText()  ;   
        		        log.info("Language is ");
        		     log.info(language);
        		     Thread.sleep(2000);	
        		     
        		     
        		     driver.findElement(By.xpath("//*[@text='Experience']"));
        		     log.info("Experience Available"); 
        		     
        		     String experience= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value'])[2]")).getText()  ;   
        		     log.info("Experience is ");
        		     log.info(experience);
        		     Thread.sleep(2000);
        		     
        		     driver.findElement(By.xpath("//*[@text='License number']"));
        		     log.info("License number Available");
        		     
        		     String licence= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value'])[3]")).getText()  ;   
        		     log.info("Licence is ");
        		     log.info(licence);
        		     Thread.sleep(2000);
        		     
        		     
        		     driver.findElement(By.xpath("//*[@text='Initial consultation']"));
		    	     log.info("Initial consultation");
		    			
		    	     String iniconsultation= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value'])[4]")).getText()  ;   
		    	     log.info("Initial consultation is ");
		    	     log.info(iniconsultation);
		    	     Thread.sleep(2000);  
        	      
        	      
		    	     driver.findElement(By.xpath("//*[@text='Follow-up consultation']"));
		    	     log.info("Follow Up  consultation");
		    			
		    	     String followconsultation= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value'])[5]")).getText()  ;   
		    	     log.info("Follow up  consultation is ");
		    	     log.info(followconsultation);
		    	     Thread.sleep(2000);  
        	 
        		      
        		     JavascriptExecutor js6 = (JavascriptExecutor) driver;
        		     HashMap<String, String> scrollObject6 = new HashMap<String, String>();
        		     scrollObject6.put("direction", "down");
        		     js6.executeScript("mobile: scroll", scrollObject6);
        		     log.info("Scolled down ");
        		     Thread.sleep(1000);
        		     
        		    driver.findElement(By.xpath("//*[@text='Background Information']"));
        		    log.info("Background Information Available");				    	      
        		     

        		    driver.findElement(By.xpath("//*[@text='University']"));
        		    log.info("University Available");  		    		

        		    String medical= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[4]")).getText()  ;   
        		    log.info("University is ");
        		    log.info(medical);
        		    Thread.sleep(2000);  					    	      

        		    driver.findElement(By.xpath("//*[@text='Training']"));
        		    log.info("Training Available");  

        		    String residency= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[5]")).getText()  ;   
        		    log.info("Training is ");
        		    log.info(residency);
        		    Thread.sleep(2000);  

        		    driver.findElement(By.xpath("//*[@text='Fellowship']"));
        		    log.info("Fellowship Available");    				    		

        		    String fellowship= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@text and @id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[7]")).getText()  ;   
        		    log.info("Fellowship is ");
        		    log.info(fellowship);
        		    Thread.sleep(2000);    				    				
        		    driver.findElement(By.xpath("//*[@text='Other']"));
        		    log.info("Other Available"); 
        		    	 
        		    String other= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[8]")).getText()  ;   
        		    log.info("Other is ");
        		    log.info(other);
        		    Thread.sleep(2000); 			 		    		 
        		    	      
        		    driver.findElement(By.xpath("//*[@text='Board']"));
        		    log.info("Board Available");

        		    String board= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@text and @id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[8]")).getText()  ;   
        		    log.info("Board is ");
        		    log.info(board);
        		    Thread.sleep(2000);

        		    driver.findElement(By.xpath("//*[@text='Areas of expertise']"));
        		    log.info("Area of expertise Available");

        		    String expertises= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@text and @id='value'])[10]")).getText()  ;   
        		    log.info("expertise is ");
        		    log.info(expertises);
        		    Thread.sleep(2000);	 
        		    
        		     
        	      
	      }     
    
	  
    	     
	    else if(Platform.equals("EYADA")){
Thread.sleep(2000);   
 	       driver.findElement(By.xpath("//*[@text='Explore doctors by specialties']")); 
 	       
 	      driver.findElement(By.xpath("//*[@text='Family Medicine']")).click();
 	     driver.findElement(By.xpath("//*[@text='Asthma']")); 	
 	    driver.findElement(By.xpath("//*[@text='Cholesterol']")); 	
 	   driver.findElement(By.xpath("//*[@text='Diabetes']")); 	
 	  driver.findElement(By.xpath("//*[@text='General practice']")); 	
 	 driver.findElement(By.xpath("//*[@text='High blood pressure']")); 	
 	driver.findElement(By.xpath("//*[@text='Nocturnal enuresis']")); 
 	
 	JavascriptExecutor js11 = (JavascriptExecutor) driver;
 	  HashMap<String, String> scrollObject11 = new HashMap<String, String>();
 	  scrollObject11.put("direction", "down");
 	  js11.executeScript("mobile: scroll", scrollObject11);
 	  log.info("Scolled down ");
 	  
 	driver.findElement(By.xpath("//*[@text='Thyroid']")); 
 	driver.findElement(By.xpath("//*[@text='Well baby']")); 
 	
 	JavascriptExecutor js12 = (JavascriptExecutor) driver;
	  HashMap<String, String> scrollObject12 = new HashMap<String, String>();
	  scrollObject12.put("direction", "up");
	  js12.executeScript("mobile: scroll", scrollObject12);
	  log.info("Scolled up ");
	  
 	 driver.findElement(By.xpath("//*[@text='Family Medicine']")).click();   
 	  log.info("FamilyMedicine Checked");
  driver.findElement(By.xpath("//*[@text='Internal Medicine']")).click(); 	    	
  driver.findElement(By.xpath("//*[@text='Cardiology']")); 		
  driver.findElement(By.xpath("//*[@text='Endocrinology']")); 		    	
  driver.findElement(By.xpath("//*[@text='Gastroenterology']")); 	    	
  driver.findElement(By.xpath("//*[@text='General internal medicine']")); 
  log.info("Internal Medicine Checked");
  JavascriptExecutor js5 = (JavascriptExecutor) driver;
  HashMap<String, String> scrollObject5 = new HashMap<String, String>();
  scrollObject5.put("direction", "down");
  js5.executeScript("mobile: scroll", scrollObject5);
  log.info("Scolled down ");
  driver.findElement(By.xpath("//*[@text='Nephrology']")); 
  driver.findElement(By.xpath("//*[@text='Neurology']")); 
  driver.findElement(By.xpath("//*[@text='Pulmonology']"));
  driver.findElement(By.xpath("//*[@text='Rheumatology']")); 
  Thread.sleep(1000);
  driver.findElement(By.xpath("//*[@text='Neonatology']")).click(); 
  driver.findElement(By.xpath("//*[@text='Neonatology']")); 
  log.info("Neonatology");
  Thread.sleep(1000);
  driver.findElement(By.xpath("//*[@text='Obstetrics and Gynecology']")).click(); 
  driver.findElement(By.xpath("//*[@text='Obstetrics and Gynecology']"));
  log.info("Obstetrics and Gynecology Checked");
 
  driver.findElement(By.xpath("//*[@text='Pediatrics']")).click(); 
  log.info("Pediatrics Checked");
  JavascriptExecutor js6 = (JavascriptExecutor) driver;
  HashMap<String, String> scrollObject6 = new HashMap<String, String>();
  scrollObject6.put("direction", "down");
  js5.executeScript("mobile: scroll", scrollObject6);
  log.info("Scolled down ");
  driver.findElement(By.xpath("//*[@text='Endocrinology']")); 
  driver.findElement(By.xpath("//*[@text='General pediatrics']")); 
  driver.findElement(By.xpath("//*[@text='Neurology']")); 
  driver.findElement(By.xpath("//*[@text='Pulmonology']"));
  driver.findElement(By.xpath("//*[@text='Sleep Medicine']"));
  
 // driver.findElement(By.xpath("//*[@text='Primary Care']")).click();

 // Thread.sleep(1000);
 // driver.findElement(By.xpath("//*[@text='Family medicine']"));
 // driver.findElement(By.xpath("//*[@text='General practice']"));
 // log.info("Primary Care Checked");
  driver.findElement(By.xpath("//*[@text='Surgery']")).click();
  Thread.sleep(1000);
  
  
  driver.findElement(By.xpath("//*[@text='ENT']"));
  driver.findElement(By.xpath("//*[@text='General surgery']"));
  driver.findElement(By.xpath("//*[@text='Ophthalmology']"));
  driver.findElement(By.xpath("//*[@text='Orthopedics']"));
  driver.findElement(By.xpath("//*[@text='Urology']"));
  driver.findElement(By.xpath("//*[@text='Surgery']")).click();
  log.info("Surgery Checked");  
  
  JavascriptExecutor js7 = (JavascriptExecutor) driver;
  HashMap<String, String> scrollObject7 = new HashMap<String, String>();
  scrollObject7.put("direction", "up");
  js5.executeScript("mobile: scroll", scrollObject7);
  log.info("Scolled up ");
  
   
  driver.findElement(By.xpath("//*[@text='Family Medicine']")).click();
   driver.findElement(By.xpath("//*[@text='General practice']")).click();
  
   
 driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='title' and (./preceding-sibling::* | ./following-sibling::*)[@id='photo']])[1]")).click(); 
     	      Thread.sleep(2000);
     	      log.info(" Click on First Doctor "); 
     	      
     	     JavascriptExecutor js3 = (JavascriptExecutor) driver;
   	      HashMap<String, String> scrollObject3 = new HashMap<String, String>();
   	      scrollObject3.put("direction", "down");
   	      js3.executeScript("mobile: scroll", scrollObject3);
   	      log.info("Scolled down ");
   	      Thread.sleep(1000);
        
     	     {

    	    	 if(driver.getPageSource().contains("Initial consultation")){
    	    		 
    	    		 TakesScreenshot screenshot=(TakesScreenshot)driver;
    				  // Call method to capture screenshot
    				  File src=screenshot.getScreenshotAs(OutputType.FILE);
    				  // Copy files to specific location 
    				  // result.getName() will return name of test case so that screenshot name will be same as test case name
    				   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

    				Assert.fail("Initial Consultation should not be available on Eyada");
    				
    				
    	    	 }else{
    		    	  
    		    	  log.info("Initial Consultation is not available  ");       
     	      
    		    	  {

    		    	    	 if(driver.getPageSource().contains("Follow-up consultation")){
    		    	    		 
    		    	    		 TakesScreenshot screenshot=(TakesScreenshot)driver;
    		    				  // Call method to capture screenshot
    		    				  File src=screenshot.getScreenshotAs(OutputType.FILE);
    		    				  // Copy files to specific location 
    		    				  // result.getName() will return name of test case so that screenshot name will be same as test case name
    		    				   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

    		    				Assert.fail("Initial Consultation should not be available on Eyada");
    		    				
    		    				
    		    	    	 }else{
    		    		    	  
    		    		    	  log.info("Initial Consultation is not available  ");
     	      
    		    		    	  {
    		    		    	  if(driver.getPageSource().contains("Book consultation")){
    		         	    		 
    		          	       		TakesScreenshot screenshot=(TakesScreenshot)driver;
    		          				  // Call method to capture screenshot
    		          				  File src=screenshot.getScreenshotAs(OutputType.FILE);
    		          				  // Copy files to specific location 
    		          				  // result.getName() will return name of test case so that screenshot name will be same as test case name
    		          				   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));

    		          				Assert.fail("Doctors Page should not Contain Book Button");
    		          	       	
    		          		    	 }}
  	   
    		    		    	  log.info("Verifying General Details ");
    		    	  
    		    		    	  JavascriptExecutor js4 = (JavascriptExecutor) driver;
    		    		   	      HashMap<String, String> scrollObject4 = new HashMap<String, String>();
    		    		   	      scrollObject4.put("direction", "up");
    		    		   	      js4.executeScript("mobile: scroll", scrollObject4);
    		    		   	      log.info("Scolled down ");
    		    		   	      Thread.sleep(1000);
    		          		      		          		    
    		          		    String Drname= driver.findElement(By.xpath("//*[@id='name']")).getText()  ;   
    		          		    
    		          		    log.info("Dr Name is ");
    		          		    log.info(Drname);
    		          		    Thread.sleep(2000);

    		          		    driver.findElement(By.xpath("//*[@id='photo']"));
    		          		    log.info("Dr Photo Displayed"); 

    		          		    driver.findElement(By.xpath("//*[@text='Languages']"));
    		          		    log.info("Language Available"); 

    		          		     String language= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[1]")).getText()  ;   
    		          		        log.info("Language is ");
    		          		     log.info(language);
    		          		     Thread.sleep(2000);	
    		          		     
    		          		     
    		          		     driver.findElement(By.xpath("//*[@text='Experience']"));
    		          		     log.info("Experience Available"); 
    		          		     
    		          		     String experience= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[2]")).getText()  ;   
    		          		     log.info("Experience is ");
    		          		     log.info(experience);
    		          		     Thread.sleep(2000);
    		          		     
    		          		     driver.findElement(By.xpath("//*[@text='License number']"));
    		          		     log.info("License number Available");
    		          		     
    		          		     String licence= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[3]")).getText()  ;   
    		          		     log.info("Licence is ");
    		          		     log.info(licence);
    		          		     Thread.sleep(2000);
    		          		     
    		          		     
    		          		     
    		          		      
    		          		     JavascriptExecutor js8 = (JavascriptExecutor) driver;
    		          		     HashMap<String, String> scrollObject8 = new HashMap<String, String>();
    		          		     scrollObject8.put("direction", "down");
    		          		     js8.executeScript("mobile: scroll", scrollObject8);
    		          		     log.info("Scolled down ");
    		          		     Thread.sleep(1000);
    		          		     
    		          		    driver.findElement(By.xpath("//*[@text='Background Information']"));
    		          		    log.info("Background Information Available");				    	      
    		          		     

    		          		    driver.findElement(By.xpath("//*[@text='Medical school']"));
    		          		    log.info("Medical School Available");  		    		

    		          		    String medical= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[4]")).getText()  ;   
    		          		    log.info("Medical School is ");
    		          		    log.info(medical);
    		          		    Thread.sleep(2000);  					    	      

    		          		    driver.findElement(By.xpath("//*[@text='Residency']"));
    		          		    log.info("Residency Available");  

    		          		    String residency= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[5]")).getText()  ;   
    		          		    log.info("Residency is ");
    		          		    log.info(residency);
    		          		    Thread.sleep(2000);  

    		          		    driver.findElement(By.xpath("//*[@text='Fellowship']"));
    		          		    log.info("Fellowship Available");    				    		

    		          		    String fellowship= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[6]")).getText()  ;   
    		          		    log.info("Fellowship is ");
    		          		    log.info(fellowship);
    		          		    Thread.sleep(2000);    				    				
    		          		    driver.findElement(By.xpath("//*[@text='Other']"));
    		          		    log.info("Other Available"); 
    		          		    	 
    		          		    String other= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[7]")).getText()  ;   
    		          		    log.info("Other is ");
    		          		    log.info(other);
    		          		    Thread.sleep(2000); 			 		    		 
    		          		    	      
    		          		    driver.findElement(By.xpath("//*[@text='Board']"));
    		          		    log.info("Board Available");

    		          		    String board= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value' and (./preceding-sibling::* | ./following-sibling::*)[@text]])[8]")).getText()  ;   
    		          		    log.info("Board is ");
    		          		    log.info(board);
    		          		    Thread.sleep(2000);

    		          		    driver.findElement(By.xpath("//*[@text='Areas of expertise']"));
    		          		    log.info("Area of expertise Available");

    		          		    String expertise= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value'])[9]")).getText()  ;   
    		          		    log.info("expertise is ");
    		          		    log.info(expertise);
    		          		    Thread.sleep(2000);	 	
    		          		    
    		      			  log.info("----------------------START TEST - Doctor Module -----------------------------");

    		    		     
	    }  }}}}}} 
	  	    	 
     
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