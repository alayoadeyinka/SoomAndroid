package OldScreen;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import utils.log;
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


public class BookFailedSpecialistAppointment extends utility {
	 private String reportDirectory = "reports";
	    	    
	  @BeforeMethod
	    public void setUp1() throws IOException {
		   
		  log.info("----------------------START TEST -Book Failed SpecialistAppointments-----------------------------");
	    	initializes();
	    	   
}

  @SuppressWarnings("rawtypes")
@Test  

//THIS TEST VALIDATES THAT THE SYMPTOMS QUESTIONS AND ANSWERS ARE CORRECT 
  public void testBookFailedSpecialistAppointments() throws InterruptedException , IOException{
	 
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("Card Details"); 
		 XSSFSheet sheets = workbook.getSheet("Platform");
		 XSSFSheet sheetss = workbook.getSheet("Specialist Appontment");
		 
		 Row plaform = sheets.getRow(1);
		   Cell cell11 = plaform.getCell(1);
	   String Platform  = cell11.getStringCellValue();
		 
		 

		 Row cardno = sheet.getRow(1);
	   Cell cell = cardno.getCell(1);
   String CardNumber  = cell.getStringCellValue();
   
   Row cardmonth = sheet.getRow(2);
   Cell cell1 = cardmonth.getCell(1);
String CardMonth  = cell1.getStringCellValue();

Row cardyear = sheet.getRow(3);
Cell cell2 = cardyear.getCell(1);
String CardYear  = cell2.getStringCellValue();

Row cardccv = sheet.getRow(4);
Cell cell3 = cardccv.getCell(1);
String CardCCV  = cell3.getStringCellValue();
	    
Row wrongcardno = sheet.getRow(5);
Cell cell4 = wrongcardno.getCell(1);
String WrongCardNumber  = cell4.getStringCellValue();	 

Row apptreason = sheetss.getRow(8);
Cell cell9 = apptreason.getCell(1);
String Apptreason  = cell9.getStringCellValue();

Row apptsymp = sheetss.getRow(9);
Cell cell5 = apptsymp.getCell(1);
String Apptsymp  = cell5.getStringCellValue();

Row specialty = sheetss.getRow(10);
Cell cell6 = specialty.getCell(1);
String Specialty  = cell6.getStringCellValue();

Row subspecialty = sheetss.getRow(11);
Cell cell7 = subspecialty.getCell(1);
String Subspecialty  = cell7.getStringCellValue();

Row doctorname = sheetss.getRow(12);
Cell cell8 = doctorname.getCell(1);
String Doctorname  = cell8.getStringCellValue();
	    

if (Platform.equals("SIHATY")){
  driver.findElement(By.xpath(objectrepo.getProperty("BookConsultationButton"))).click();        
   driver.findElement(By.xpath(objectrepo.getProperty("PATIENTNAME"))).click();        
      Thread.sleep(2000);
	  driver.findElement(By.xpath(objectrepo.getProperty("CLOSEBUTTONS"))).click();       			      
  driver.findElement(By.xpath(objectrepo.getProperty("BookConsultationButton"))).click();        
 	    
    	 
  driver.findElement(By.xpath(objectrepo.getProperty("PATIENTNAME"))).click();        
  Thread.sleep(2000);  
 		      
      driver.findElement(By.xpath("//*[@text='Specialist appointments']")).click(); 
      log.info("Specialist appointments Button Clicked  ");
      Thread.sleep(2000);   
      
      driver.findElement(By.xpath("//*[@text='" + Apptreason + "']")).click();
      
      String symptoms= driver.findElement(By.xpath("//*[@text='" + Apptsymp + "']")).getText()  ;  
      driver.findElement(By.xpath("//*[@text='" + Apptsymp + "']")).click();
      driver.findElement(By.xpath("//*[@text='" + Specialty + "']")).click();
      String SelectedSpeciality= driver.findElement(By.xpath("//*[@text='" + Subspecialty + "']")).getText()  ;  
 
       driver.findElement(By.xpath("//*[@text='" + Subspecialty + "']")).click();
      driver.findElement(By.xpath("//*[@text='Select your Sihaty-preferred specialist']"));
 
 String SpecialistDrSpecialty= driver.findElement(By.xpath("//*[@resource-id='tsvb.sihaty.android:id/subTitle']")).getText()  ;  
 	 {
		 {
	    	  if  (SelectedSpeciality.equals (SpecialistDrSpecialty)) {
	    		  log.info("Specialty is correctly displayed");
	    		
	    	  }
	    		  else
			      {
			       
	    			  TakesScreenshot screenshot=(TakesScreenshot)driver;
			      	  // Call method to capture screenshot
			      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
			      	  // Copy files to specific location 
			      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
			      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
			      	Assert.fail("Wrong Specilaty selected was displayed`");	
			       
				  
			      }
	    	 

	    	  driver.findElement(By.xpath("//*[text()[contains(.,'"+ Doctorname +"')]]")).click();
	    		 log.info("Select First Doctor ");
	    		 driver.findElement(By.xpath("//*[@id='photo']")); 
	    		 log.info("Doctor Photo Available ");
	    		 
	    		 
String ConfirmDrname= driver.findElement(By.xpath("//*[@id='name']")).getText()  ;  
String Confirmspecialty= driver.findElement(By.xpath("//*[@resource-id='tsvb.sihaty.android:id/specialty']")).getText()  ;  

	 {
		 
		 {
			 if  (SpecialistDrSpecialty.equals (Confirmspecialty)) {
				  log.info("Specialty Is correctly displayed");
				
			  }
				  else
			      {
			       
					  TakesScreenshot screenshot=(TakesScreenshot)driver;
			      	  // Call method to capture screenshot
			      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
			      	  // Copy files to specific location 
			      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
			      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
			      	Assert.fail("Specialty is incorrect`");	
			      }
		 
		 }
		 
	 }
	 //End
		driver.findElement(By.xpath(objectrepo.getProperty("BOOKCONSULTBUTON")));        

	      
	      driver.findElement(By.xpath("//*[@text='Book consultation']"));

	      driver.findElement(By.xpath("//*[@text='Languages']"));
	      String language= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value'])[1]")).getText()  ;   
	        log.info("Language is ");
	     log.info(language);
	     Thread.sleep(2000);
	      
	      
	      driver.findElement(By.xpath("//*[@text='Experience']"));
		     log.info("Experience Available"); 
		     
		     String experience= driver.findElement(By.xpath("//*[@text and @id='value']")).getText()  ;   
		     log.info("Experience is ");
		     log.info(experience);
		     Thread.sleep(2000);
		     
		     driver.findElement(By.xpath("//*[@text='License number']"));
		     log.info("License number Available");
		     
		     String licence= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='value'])[3]")).getText()  ;   
		     log.info("Licence is ");
		     log.info(licence);
		     Thread.sleep(2000);
		      
		     JavascriptExecutor js1 = (JavascriptExecutor) driver;
		     HashMap<String, String> scrollObject1 = new HashMap<String, String>();
		     scrollObject1.put("direction", "down");
		     js1.executeScript("mobile: scroll", scrollObject1);
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
		    
		    JavascriptExecutor js2 = (JavascriptExecutor) driver;
		     HashMap<String, String> scrollObject2 = new HashMap<String, String>();
		     scrollObject2.put("direction", "Up");
		     js2.executeScript("mobile: scroll", scrollObject2);
		     log.info("Scolled Up ");
		     Thread.sleep(1000);
		     
		     
		     driver.findElement(By.xpath(objectrepo.getProperty("BOOKCONSULTBUTON"))).click();
		     log.info("Book Consultation Button Clicked  ");
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//*[@text='Cancel']")).click();
		     log.info("Cancel Button Clicked  ");
		     driver.findElement(By.xpath(objectrepo.getProperty("BOOKCONSULTBUTON"))).click();
		     log.info("Book Consultation Button Clicked again  ");
		     
	     driver.findElement(By.xpath("//*[@text='Select date and time for consultation']"));
	//     driver.findElement(By.xpath(objectrepo.getProperty("BOOKCONSULTBUTON"))).click();
	     driver.findElement(By.xpath(objectrepo.getProperty("NEXTDATE"))).click();
		   
	     
		     
		     driver.findElement(By.xpath("//*[@id='d2' and (./preceding-sibling::* | ./following-sibling::*)[@id='dotD1']]")).click();
		     Thread.sleep(2000);
		     log.info("Date Selected   ");
		     driver.findElement(By.xpath(objectrepo.getProperty("MONTH")));
		     log.info("Month Displayed");
		     driver.findElement(By.xpath("//*[@text='Choose a time']"));
		     log.info("Now Select a Slot ");
		     
 	  driver.findElement(By.xpath(objectrepo.getProperty("TIMESLOT"))).click();

		     log.info("Slot Selected ");
		   
		     driver.findElement(By.xpath(objectrepo.getProperty("CONFIRMTIME"))).click();
		     
		     log.info("Confirm Button Clicked  ");
		     
		     driver.findElement(By.xpath("//*[@text='Consultation for:']"));
		     driver.findElement(By.xpath("//*[@text='Provider:']"));
		     driver.findElement(By.xpath("//*[@text='Scheduled:']"));
		     driver.findElement(By.xpath("//*[@text='Duration:']"));
		     driver.findElement(By.xpath("//*[@text='Calling mode:']"));
		  
		     String consultfor= driver.findElement(By.xpath("//*[@id='consultationValue']")).getText()  ;   
			    log.info("Consultation For  is ");
			    log.info(consultfor);
			    Thread.sleep(2000);	  
		 
			    String provider= driver.findElement(By.xpath("//*[@id='providerValue']")).getText()  ;   
			    log.info("Provider  is ");
			    log.info(provider);
			    Thread.sleep(2000);	
		 
			    String schedule= driver.findElement(By.xpath("//*[@id='scheduleValue']")).getText()  ;   
			    log.info("Schedule is ");
			    log.info(schedule);
			    Thread.sleep(2000);	
			    
			    String callmode= driver.findElement(By.xpath("//*[@id='videoText']")).getText()  ;   
			    log.info("Calling Mode is ");
			    log.info(callmode);
			    Thread.sleep(2000);	
			    
			    {
			    	 {
						 if  (symptoms.equals (consultfor)) {
							  log.info("Symptoms  Is correctly displayed as selected ");
							
						  }
							  else
						      {
						       
								  TakesScreenshot screenshot=(TakesScreenshot)driver;
						      	  // Call method to capture screenshot
						      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
						      	  // Copy files to specific location 
						      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
						      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
						      	Assert.fail("Symtpoms selected and displayed is incorrect`");	
						      }
					 
					 }
			    	 
			    	 
			     
			    	 
			    	 {
						 if  (ConfirmDrname.equals (provider)) {
							  log.info("Doctor Provider  Is correctly displayed as selected ");
							
						  }
							  else
						      {
						       
								  TakesScreenshot screenshot=(TakesScreenshot)driver;
						      	  // Call method to capture screenshot
						      	  File src=screenshot.getScreenshotAs(OutputType.FILE);
						      	  // Copy files to specific location 
						      	  // result.getName() will return name of test case so that screenshot name will be same as test case name
						      	   FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+".jpg"));
						      	Assert.fail("Doctor Provider displayed is incorrect`");	
						      }
			   	 
			    	 
			    }
			    
			    	 driver.findElement(By.xpath("//*[@text='Payment method']")); 	 
			    	 driver.findElement(By.xpath("//*[@text='Credit card']")); 
			    	 driver.findElement(By.xpath("//*[@text='KNET']")); 
			    	  log.info("Payment Options Checked ");
			    	  driver.findElement(By.xpath("//*[@text='Credit card']")).click();
			    	  Thread.sleep(2000);	
			    	  log.info("Credit Card selected ");
			    	  driver.findElement(By.xpath("//*[@text='Continue']")).click();
			    	  Thread.sleep(7000);	
			    	 
 String consultprice= driver.findElement(By.xpath("//*[@text and @class='android.view.View' and ./parent::*[@id='main-container']]")).getText()  ;   
 log.info("Consultation Price is ");
 log.info(consultprice);
 log.info("About to enter Card Details on Payment Gateway ");
 driver.findElement(By.xpath("//*[@id='number']")).click();
 driver.findElement(By.xpath("//*[@id='number']")).sendKeys(CardNumber); 	
 Thread.sleep(2000);	
 driver.findElement(By.xpath("//*[@id='CardExpiryMonth']")).click();
 driver.findElement(By.xpath("//*[@id='CardExpiryMonth']")).sendKeys(CardMonth); 	
 Thread.sleep(2000);	
 driver.findElement(By.xpath("//*[@id='CardExpiryYear']")).click();
 driver.findElement(By.xpath("//*[@id='CardExpiryYear']")).sendKeys(CardYear); 	
 Thread.sleep(2000);	
 driver.findElement(By.xpath("//*[@id='securityCode']")).click();
 driver.findElement(By.xpath("//*[@id='securityCode']")).sendKeys(CardCCV); 
 Thread.sleep(2000);	
 driver.findElement(By.xpath("//*[@id='btn-submit']")).click();   	
 log.info("Card Details Entered and Submit Button has been Clicked");

 driver.findElement(By.xpath("//*[@text='ACS Emulator']")); 
 driver.findElement(By.xpath("//*[@id='selectAuthResult']")).click(); 
 driver.findElement(By.xpath("//*[@text='(N) Authentication Failed']")).click(); 
 driver.findElement(By.xpath("//*[@text='Submit']")).click(); 
 log.info("Payment Authentication Failed Option Selected ");
 Thread.sleep(2000);
 driver.findElement(By.xpath("//*[@text='Oops! payment failure']")); 
 log.info("Payment Failed as Expected and Failure Message Displayed ");
 driver.findElement(By.xpath("//*[@id='message']")); 
 driver.findElement(By.xpath("//*[@text='OK']")).click(); 
 driver.findElement(By.xpath("//*[@text='Payment method']")); 
 log.info("User is Navigated to the Payment Method");
 log.info("----------------------END TEST -Book Failed SpecialistAppointments-----------------------------");
 
			    }
	 
	
}
	  
	        }	
	 }
		 
	
 

	    
else if(Platform.equals("EYADA")){


	    		 		  

	    			      driver.findElement(By.xpath(objectrepo.getProperty("BookConsultationButton"))).click();        
	    			 	    
	    			    	 
	    				  driver.findElement(By.xpath(objectrepo.getProperty("PATIENTNAME"))).click();     
	    			   
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
          log.info("---------------------------END TEST -Book Failed SpecialistAppointments-----------------------------");

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