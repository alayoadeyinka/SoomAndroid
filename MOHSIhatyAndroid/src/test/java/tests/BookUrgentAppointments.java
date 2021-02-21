package tests;

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


public class BookUrgentAppointments extends utility {
	 private String reportDirectory = "reports";
	    	    
	  @BeforeMethod
	    public void setUp1() throws IOException {
		  log.info("----------------------START TEST - Book Urgent Appointments -----------------------------");

		   
	    	initializes();
	    	   
}

  @SuppressWarnings("rawtypes")
@Test  

//THIS TEST VALIDATES THAT THE SYMPTOMS QUESTIONS AND ANSWERS ARE CORRECT 
  public void testBookUrgentAppointment() throws InterruptedException , IOException{
	 
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("Urgent Questions"); 
 XSSFSheet sheets = workbook.getSheet("Platform");
		 
		 Row plaform = sheets.getRow(1);
		   Cell cell11 = plaform.getCell(1);
	   String Platform  = cell11.getStringCellValue();
		 
			 
			 Row OtherTest1 = sheet.getRow(1);
		   Cell cell = OtherTest1.getCell(1);
	     String OtherText1 = cell.getStringCellValue();
	    
	     Row OtherTest2 = sheet.getRow(2);
		   Cell cell1 = OtherTest2.getCell(1);
	     String OtherText2 = cell1.getStringCellValue();
	    

	  		 Row cardno = sheet.getRow(4);
	  	   Cell cell4 = cardno.getCell(1);
	     String CardNumber  = cell4.getStringCellValue();
	     
	     Row cardmonth = sheet.getRow(5);
	     Cell cell6 = cardmonth.getCell(1);
	  String CardMonth  = cell6.getStringCellValue();

	  Row cardyear = sheet.getRow(6);
	  Cell cell2 = cardyear.getCell(1);
	  String CardYear  = cell2.getStringCellValue();

	  Row cardccv = sheet.getRow(7);
	  Cell cell3 = cardccv.getCell(1);
	  String CardCCV  = cell3.getStringCellValue();
	    
	    

	    if (Platform.equals("SIHATY")){
	    	  
	    	driver.findElement(By.xpath(objectrepo.getProperty("UrgentAppointmentTitle"))).click();	  
	 	       
	 	      Thread.sleep(2000);
	    		    	  
	    				    
		    			 	 
	    		 	}

	    
	    		 	  else if(Platform.equals("EYADA")){

	    			    	String ConsultButton=  driver.findElement(By.xpath(objectrepo.getProperty("BookConsultationButton"))).getText()  ;        
	    			      Thread.sleep(1000); 
	    			      try {
	    			    	  if (CONFIG.getProperty("EyadaButton").equals(ConsultButton)) {
	    			    		  log.info("Consultation Button Confirmed Okay ");
	    	    			      driver.findElement(By.xpath(objectrepo.getProperty("BookConsultationButton"))).click();        

	    			    	  }
	    			        } catch (NoSuchElementException e) {
	    			        	  log.info("Consultation Button is Not accurate  ");
	    			        }	      	     		    	 

	    		 	  }  
	    
	    
	   
	 driver.findElement(By.xpath(objectrepo.getProperty("PATIENTNAME"))).click();     
   Thread.sleep(3000);	 
   
   
   if(Platform.equals("EYADA")){
	   driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click();   
	   //Alergies 
	   {	 
		   driver.findElement(By.xpath("//*[@text='Allergies']")).click();
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   driver.findElement(By.xpath("//*[@text='Describe your symptoms']"));
		   driver.findElement(By.xpath("//*[@text='Is this a known problem?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='What causes your allergies?']")).click();
		   driver.findElement(By.xpath("//*[@text='Unknown']")).click();
		   driver.findElement(By.xpath("//*[@text='Dust']"));
		   driver.findElement(By.xpath("//*[@text='Animals']")).click();
		   driver.findElement(By.xpath("//*[@text='Food']")).click();
		   driver.findElement(By.xpath("//*[@text='Medications']"));
		   driver.findElement(By.xpath("//*[@text='Other']")).click();
		   driver.findElement(By.xpath("//*[@text='Briefly describe']"));
		   driver.findElement(By.xpath("//*[@id='message']")).sendKeys(OtherText1);
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   driver.findElement(By.xpath("//*[@text='Do you have the following symptoms?']")).click();
		   driver.findElement(By.xpath("//*[@text='Other']")).click();
		   driver.findElement(By.xpath("//*[@text='Briefly describe']"));
		   driver.findElement(By.xpath("//*[@id='message']")).sendKeys(OtherText2);
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   driver.findElement(By.xpath("//*[@text='None of the above']"));
		   driver.findElement(By.xpath("//*[@text='Rash']"));
		   driver.findElement(By.xpath("//*[@text='Runny nose']")).click();
		   driver.findElement(By.xpath("//*[@text='Itchy eyes']"));
 		  log.info("All Alergies Confirmed ");
 		 driver.findElement(By.xpath("//*[@text='Next']")).click();
 		Thread.sleep(3000); 
 		
// This part was for prototype to select a doctor . I will comment out for now and add when enabled back 
  //	  driver.findElement(By.xpath("//*[@resource-id='com.sihaty.ad.s2:id/photo']")).click();
  //		 log.info("Select First Doctor ");
  		 
  	//	 driver.findElement(By.xpath("//*[@id='bookConsultation']")).click();
	//     log.info("Book Consultation Button Clicked  ");
	     
	//     driver.findElement(By.xpath("//*[@text='Select date and time for consultation']"));
	//     driver.findElement(By.xpath("//*[@id='next']")).click();
	     
	//     driver.findElement(By.xpath("//*[@id='d2' and (./preceding-sibling::* | ./following-sibling::*)[@id='dotD1']]")).click();
	//     Thread.sleep(2000);
	//     log.info("Date Selected   ");
	//     driver.findElement(By.xpath("//*[@id='monthTitle']"));
	//     log.info("Month Displayed");
	//     driver.findElement(By.xpath("//*[@text='Choose a time']"));
	 //    log.info("Now Select a Slot ");
	//     driver.findElement(By.xpath("//*[@resource-id='com.sihaty.ad.s2:id/icon']")).click();
	 //    log.info("Slot Selected ");
	     
	//     driver.findElement(By.xpath("//*[@text='Confirm']")).click();
	//     log.info("Confirm Button Clicked  ");
 		

 		
 		driver.findElement(By.xpath("//*[@text='Consultation for:']"));
 		  driver.findElement(By.xpath("//*[@text='Scheduled:']"));
 		  driver.findElement(By.xpath("//*[@text='Calling mode:']"));
 		  
 		  driver.findElement(By.xpath("//*[@id='consultationValue']"));
 		  driver.findElement(By.xpath("//*[@id='scheduleValue']"));
 		  driver.findElement(By.xpath("//*[@id='videoText']"));
 		  driver.findElement(By.xpath("//*[@id='consultationValue']"));
 	 
 		//  driver.findElement(By.xpath("//*[@text='Continue']")).click();
 		 driver.findElement(By.xpath("//*[@text='Start consultation']")).click(); 
  		Thread.sleep(1000); 
  		 
  	//	driver.findElement(By.xpath("//*[@id='subTitle']"));
  	   
  	//	driver.findElement(By.xpath("//*[@id='dateTimeValue']"));

  		driver.findElement(By.xpath("//*[@text='Thank you for your trust']"));
  		driver.findElement(By.xpath("//*[@text='Your doctor will contact you shortly']"));
  	
  		
     // String UrgentToolbarContainer= driver.findElement(By.xpath("(//*[@id='infoContainer']/*[@class='android.widget.TextView'])[4]")).getText()  ;        
   //   Thread.sleep(1000); 
      
      String UrgentToolbarContainer= driver.findElement(By.xpath("//*[@text and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@id='toolbarContainer']]")).getText()  ;        
      Thread.sleep(1000); 
      try {
    	  if (CONFIG.getProperty("UrgentToolbarContainer").equals(UrgentToolbarContainer)) {
    		  log.info("UrgentToolbarContainer Confirmed Okay ");
    		 
    	  }
        } catch (NoSuchElementException e) {
        	  log.info("UrgentToolbarContainer is Not accurate  ");
        }	      	
	   }
		  log.info("----------------------END TEST - Book Urgent Appointments -----------------------------");

   } 	   
 
   
 
    
   
	        
   else if(Platform.equals("SIHATY")){
	   
	   driver.findElement(By.xpath("//*[@text='General symptoms']")).click();   
	   //Dizziness 
	   {	 
		   driver.findElement(By.xpath("//*[@text='Dizziness']")).click();
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
 		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));  
		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
		   driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
		   driver.findElement(By.xpath("//*[@text='Minutes']"));
		   driver.findElement(By.xpath("//*[@text='Hours']"));
		   driver.findElement(By.xpath("//*[@text='Days']"));
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		   driver.findElement(By.xpath("//*[@text='Describe your symptoms:']")).click();
		   driver.findElement(By.xpath("//*[@text='Spinning sensation']"));
		   driver.findElement(By.xpath("//*[@text='Feeling like passing out']")).click();
		   driver.findElement(By.xpath("//*[@text='Worse when standing']")).click();
		   driver.findElement(By.xpath("//*[@text='Unsteady walk']"));
		   driver.findElement(By.xpath("//*[@text='Visual changes']")).click();
		   driver.findElement(By.xpath("//*[@text='Other']"));
		   driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
		   driver.findElement(By.xpath("//*[@id='answer_block' and ./*[@text='Fever (≥ 38℃)']]"));
		   driver.findElement(By.xpath("//*[@text='Numb or weak arm(s) or leg(s)']"));
		   driver.findElement(By.xpath("//*[@text='Headache']")).click();
		   driver.findElement(By.xpath("//*[@text='Loss of vision']"));
		   driver.findElement(By.xpath("//*[@text='Nausea or vomiting']")).click();
		   driver.findElement(By.xpath("//*[@text='Chest pain']"));
		   
		   JavascriptExecutor js2 = (JavascriptExecutor) driver;
	  	      HashMap<String, String> scrollObject2 = new HashMap<String, String>();
	  	      scrollObject2.put("direction", "down");
	  	      js2.executeScript("mobile: scroll", scrollObject2);
	  	      log.info("Scolled down ");
	  	      Thread.sleep(1000);
		   
		   driver.findElement(By.xpath("//*[@text='Trouble breathing']")).click();
		   driver.findElement(By.xpath("//*[@text='Falls']"));
		   driver.findElement(By.xpath("//*[@text='Other']"));
		   driver.findElement(By.xpath("//*[@text='None of the above']"));
		   
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
	 		Thread.sleep(3000); 
	driver.findElement(By.xpath("//*[@text='Almost there...']"));
	 		driver.findElement(By.xpath("//*[@text='You will be refunded if the Sihaty doctor cannot help you online']"));
	 		driver.findElement(By.xpath("//*[@text='Consultation for:']"));
	 		  driver.findElement(By.xpath("//*[@text='Scheduled:']"));
	 		  driver.findElement(By.xpath("//*[@text='Calling mode:']"));
	 		 driver.findElement(By.xpath("//*[@text='Next available']"));
	 		driver.findElement(By.xpath("//*[@text='Duration:']"));
	 		driver.findElement(By.xpath("//*[@text='Total cost:']"));
	 		driver.findElement(By.xpath("//*[@id='costValue']"));
	 		driver.findElement(By.xpath("//*[@id='durationValue']"));
	 		  driver.findElement(By.xpath("//*[@id='consultationValue']"));
	 		  driver.findElement(By.xpath("//*[@id='scheduleValue']"));
	 		 driver.findElement(By.xpath("//*[@text='Video call']"));
	 		 driver.findElement(By.xpath("//*[@text='Payment method']"));
	 		 log.info("All Consultation Details Verified");
	 		 driver.findElement(By.xpath("//*[@text='Credit card']")).click();
	 		driver.findElement(By.xpath("//*[@text='Continue']")).click();
	 		
	 		
	 		 String consultprice= driver.findElement(By.xpath("//*[@text and @class='android.view.View' and ./parent::*[@id='main-container']]")).getText()  ;   
	 		 log.info("Consultation Price is ");
	 		 log.info(consultprice);
	 		driver.findElement(By.xpath("//*[@id='number']")).click();
	 		driver.findElement(By.xpath("//*[@id='number']")).sendKeys(CardNumber); 	
	 		 Thread.sleep(2000);	
	 		 driver.findElement(By.xpath("//*[@id='CardExpiryMonth']")).sendKeys(CardMonth); 	
	 		 Thread.sleep(2000);	
	 		 driver.findElement(By.xpath("//*[@id='CardExpiryYear']")).sendKeys(CardYear); 	
	 		 Thread.sleep(2000);	
	 		 driver.findElement(By.xpath("//*[@id='securityCode']")).sendKeys(CardCCV); 
	 		 Thread.sleep(2000);	
	 		 driver.findElement(By.xpath("//*[@id='btn-submit']")).click();   	
	 		 

	 		 driver.findElement(By.xpath("//*[@text='ACS Emulator']")); 
	 		 driver.findElement(By.xpath("//*[@text='Submit']")).click(); 
	 		 Thread.sleep(3000);
	 		 
	 		 
	 		 
	 		 
	 		 String UrgentConfirmTitle= driver.findElement(By.xpath("//*[@id='title']")).getText()  ;        
	 	      Thread.sleep(1000); 
	 	      try {
	 	    	  if (CONFIG.getProperty("UrgentConfirmTitle").equals(UrgentConfirmTitle)) {
	 	    		  log.info("UrgentConfirmTitle Confirmed Okay ");
	 	    		 
	 	    	  }
	 	        } catch (NoSuchElementException e) {
	 	        	  log.info("UrgentConfirmTitle is Not accurate  ");
	 	        }	      	
	 	  		
	 	      
	 	      String SIHATYUrgentConfirmSubTitle= driver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@id='toolbarContainer']]/*[@text])[2]")).getText()  ;        
	 	      Thread.sleep(1000); 
	 	      try {
	 	    	  if (CONFIG.getProperty("SIHATYUrgentConfirmSubTitle").equals(SIHATYUrgentConfirmSubTitle)) {
	 	    		  log.info("UrgentConfirmSubTitle Confirmed Okay ");
	 	    		 
	 	    	  }
	 	        } catch (NoSuchElementException e) {
	 	        	  log.info("UrgentConfirmSubTitle is Not accurate  ");
	 	        }	      	
	 	  		
	 	      String UrgentToolbarContainer= driver.findElement(By.xpath("//*[@text and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@id='toolbarContainer']]")).getText()  ;        
	 	      Thread.sleep(1000); 
	 	      try {
	 	    	  if (CONFIG.getProperty("UrgentToolbarContainer").equals(UrgentToolbarContainer)) {
	 	    		  log.info("UrgentToolbarContainer Confirmed Okay ");
	 	    		 
	 	    	  }
	 	        } catch (NoSuchElementException e) {
	 	        	  log.info("UrgentToolbarContainer is Not accurate  ");
	 	        }	      	
	 	 	
	 		   } 
	 		 
		  log.info("----------------------END TEST - Book Urgent Appointments -----------------------------");

 
    
     
	 		 
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