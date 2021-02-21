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

public class UrgentQuestionsAnswers extends utility {
	 private String reportDirectory = "reports";
	 
	    	    
	  @BeforeMethod
	    public void setUp1() throws IOException {
		  log.info("-----------------------------------------START TEST -Validate Urgent Appointments Questions and Answers--------------------------------------------------------------");

 	    	initializes();
	    
	    	
	    		
}

  @SuppressWarnings("rawtypes")
@Test  

//THIS TEST VALIDATES THAT THE SYMPTOMS QUESTIONS AND ANSWERS ARE CORRECT 
  public void testUrgentAppointmentQuestions() throws InterruptedException , IOException{
	
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
	    
	     Row OtherTest2 = sheet.getRow(1);
		   Cell cell1 = OtherTest2.getCell(1);
	     String OtherText2 = cell1.getStringCellValue();
	    
	    
	    
	    
	    

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
	    		    	  

	    			      {
	    			    	  
	    			   	   
	    			    	   driver.findElement(By.xpath("//*[@id='tv_name']")).click();
	    			    	   Thread.sleep(3000);	 
 					 
	    					   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
	    					 
	 	   driver.findElement(By.xpath("//*[@text='Anxiety and stress']")).click();
	        driver.findElement(By.xpath("//*[@text='Eye or eyelid problems']")).click();
	        driver.findElement(By.xpath("//*[@text='Fatigue (tiredness)']")).click();
	        driver.findElement(By.xpath("//*[@text='Headache']"));
	        driver.findElement(By.xpath("//*[@text='Joint or limb pain']")).click();
	        driver.findElement(By.xpath("//*[@text='Low back pain']")).click();
	        driver.findElement(By.xpath("//*[@text='Minor injuries']")).click();
	        driver.findElement(By.xpath("//*[@text='Sleep difficulties']")).click();
	        
	        
	        
	        
	        
	      //Dizziness
			   driver.findElement(By.xpath("//*[@text='Dizziness']")).click();
			   log.info("Dizziness Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
			    driver.findElement(By.xpath("//*[@text='Next']")).click();
			   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
			  driver.findElement(By.xpath("//*[@text='Yes']"));
			   driver.findElement(By.xpath("//*[@text='No']"));
			   driver.findElement(By.xpath("//*[@text='Yes']")).click();
			    driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
			   driver.findElement(By.xpath("//*[@text='Minutes']"));
			      driver.findElement(By.xpath("//*[@text='Hours']"));
			       driver.findElement(By.xpath("//*[@text='Days']")).click();
		 	      driver.findElement(By.xpath("//*[@text='Weeks']"));
            driver.findElement(By.xpath("//*[@text='Describe your symptoms:']")).click();
		       driver.findElement(By.xpath("//*[@text='Spinning sensation']"));
			      driver.findElement(By.xpath("//*[@text='Feeling like passing out']")).click();
			      driver.findElement(By.xpath("//*[@text='Worse when standing']")).click();
			       driver.findElement(By.xpath("//*[@text='Unsteady walk']"));
			       driver.findElement(By.xpath("//*[@text='Visual changes']"));
			
			       driver.findElement(By.xpath("//*[@text='Other']"));
			    
			       driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
			       
			       driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']"));
			      driver.findElement(By.xpath("//*[@text='Headache']")).click();
			     driver.findElement(By.xpath("//*[@text='Loss of vision']")).click();
			      driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
			      driver.findElement(By.xpath("//*[@text='Chest pain']"));
			      
			      JavascriptExecutor js5 = (JavascriptExecutor) driver;
			     HashMap<String, String> scrollObject5 = new HashMap<String, String>();
			      scrollObject5.put("direction", "down");
			     js5.executeScript("mobile: scroll", scrollObject5);
			      log.info("Scolled downs ");      
			      driver.findElement(By.xpath("//*[@text='Trouble breathing']"));
			      driver.findElement(By.xpath("//*[@text='Falls']"));
			      driver.findElement(By.xpath("//*[@text='Other']"));
			      driver.findElement(By.xpath("//*[@text='None of the above']"));	      

			      driver.findElement(By.xpath("//*[@text='Next']")).click();
			 		Thread.sleep(3000); 
			 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
					driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			 	
	        
	        
  
	        
	       // driver.navigate().back();
	  driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click();   
  			      
	  driver.findElement(By.xpath("//*[@text='Allergies']")).click();
      driver.findElement(By.xpath("//*[@text='Coronavirus symptoms']")).click();
      driver.findElement(By.xpath("//*[@text='Cough']")).click();
      driver.findElement(By.xpath("//*[@text='Fever']")).click();
      driver.findElement(By.xpath("//*[@text='Flu-like symptoms']")).click();
      driver.findElement(By.xpath("//*[@text='Sore throat']")).click();
      driver.navigate().back();     
	    			      
	   driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click(); 
	   driver.findElement(By.xpath("//*[@text='Contraception counseling']")).click();
	      driver.findElement(By.xpath("//*[@text='Erectile dysfunction']")).click();
	      driver.findElement(By.xpath("//*[@text='Period problems']")).click();
	      driver.findElement(By.xpath("//*[@text='Sexually transmitted infections']")).click();
	      driver.findElement(By.xpath("//*[@text='Urinary tract infections']")).click();
	      driver.findElement(By.xpath("//*[@text='Vaginal discharge or itching']")).click();
	      
   			      
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
	    
	    

   if(Platform.equals("EYADA")){
	   
	   
	   
   driver.findElement(By.xpath("//*[@id='tv_name']")).click();
   Thread.sleep(3000);	 
   
	   
	   driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click();   
	   //Alergies 
	   {	 
		   driver.findElement(By.xpath("//*[@text='Allergies']")).click();
		   log.info("Allergies Checking  ");
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
 	//	driver.findElement(By.xpath("//*[@text='Consultation for:']"));
 	//	  driver.findElement(By.xpath("//*[@text='Scheduled:']"));
 	//	  driver.findElement(By.xpath("//*[@text='Calling mode:']"));
 		  
 	//	  driver.findElement(By.xpath("//*[@id='consultationValue']"));
 	//	  driver.findElement(By.xpath("//*[@id='scheduleValue']"));
 	//	  driver.findElement(By.xpath("//*[@id='videoText']"));
 	//	  driver.findElement(By.xpath("//*[@id='consultationValue']"));
 	//	  driver.findElement(By.xpath("//*[@text='Allergies']"));
 	//	  driver.findElement(By.xpath("//*[@text='Next available']"));
 	//	  driver.findElement(By.xpath("//*[@text='Video call']"));
 	//	 driver.findElement(By.xpath("//*[@text='Start consultation']"));
 	//	driver.findElement(By.xpath("//*[@text='Close']"));
 	 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
  	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	
	   }
	   
	   
	 
	   {
		   driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click(); 
		   //Cough
		   log.info("Cough  ");
		   driver.findElement(By.xpath("//*[@text='Cough']")).click();
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		  Thread.sleep(2000);
		  // driver.findElement(By.xpath("//*[@text='Have you been exposed to someone with a confirmed COVID-19 (coronavirus) infection in the last 14 days? ']"));
		   driver.findElement(By.xpath("//*[contains(text(), 'COVID')]"));
		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
		   driver.findElement(By.xpath("//*[@text='How long has your cough lasted?']")).click();
		   driver.findElement(By.xpath("//*[@text='Less than 24 hours']")).click();
		   driver.findElement(By.xpath("//*[@text='Days']")).click();
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		   driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
		   driver.findElement(By.xpath("//*[@text='Fatigue']"));
		   driver.findElement(By.xpath("//*[@text='Body aches']"));
		   driver.findElement(By.xpath("//*[@text='Sore throat']"));
		   driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
		   driver.findElement(By.xpath("//*[@text='Diarrhea']")).click();
		   driver.findElement(By.xpath("//*[@text='Headache']")).click();
		   driver.findElement(By.xpath("//*[@text='Blocked or runny nose']"));
		   JavascriptExecutor js2 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject2 = new HashMap<String, String>();
		      scrollObject2.put("direction", "down");
		      js2.executeScript("mobile: scroll", scrollObject2);
		      log.info("Scolled down "); 
		   
		      driver.findElement(By.xpath("//*[@text='Other']")).click();
		      driver.findElement(By.xpath("//*[@text='Briefly describe']"));
			   driver.findElement(By.xpath("//*[@id='message']")).sendKeys(OtherText2);
			   driver.findElement(By.xpath("//*[@text='Next']")).click();
		      
		   driver.findElement(By.xpath("//*[@text='None of the above']"));
		   driver.findElement(By.xpath("//*[@text='Do you have trouble breathing?']")).click();
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
		   driver.findElement(By.xpath("//*[@text='Do you have chest pain?']")).click();
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
		   driver.findElement(By.xpath("//*[@text='Do you have a fever (temperature above 38°)?']")).click();
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
	 		Thread.sleep(3000); 
	 	//	driver.findElement(By.xpath("//*[@text='Consultation for:']"));
	 	//	  driver.findElement(By.xpath("//*[@text='Scheduled:']"));
	 	//	  driver.findElement(By.xpath("//*[@text='Calling mode:']"));
	 		  
	 	//	  driver.findElement(By.xpath("//*[@id='consultationValue']"));
	 		//  driver.findElement(By.xpath("//*[@id='scheduleValue']"));
	 	//	  driver.findElement(By.xpath("//*[@id='videoText']"));
	 	//	  driver.findElement(By.xpath("//*[@id='consultationValue']"));
	 	//	  driver.findElement(By.xpath("//*[@text='Cough']"));
	 	//	  driver.findElement(By.xpath("//*[@text='Next available']"));
	 	//	  driver.findElement(By.xpath("//*[@text='Video call']"));
	 	//	 driver.findElement(By.xpath("//*[@text='Start consultation']"));
	 	//	driver.findElement(By.xpath("//*[@text='Close']"));
	 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();   
	   }
	   
	   {
		   
		   driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click(); 
		   //Fever
		   driver.findElement(By.xpath("//*[@text='Fever']")).click();
		   log.info("Fever Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		  // driver.findElement(By.xpath("//*[@text='Have you been exposed to someone with a confirmed COVID-19 (coronavirus) infection in the last 14 days? ']"));
		   driver.findElement(By.xpath("//*[contains(text(), 'COVID')]"));
		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
		   driver.findElement(By.xpath("//*[@text='How long have you had your fever?']")).click();
		   driver.findElement(By.xpath("//*[@text='Less than 24 hours']")).click();
		   driver.findElement(By.xpath("//*[@text='Days']")).click();
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		    
		   driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
		   driver.findElement(By.xpath("//*[@text='Fatigue']"));
		   driver.findElement(By.xpath("//*[@text='Body aches']"));
		   driver.findElement(By.xpath("//*[@text='Rash']"));
		   driver.findElement(By.xpath("//*[@text='Cough']"));
		   driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
		   driver.findElement(By.xpath("//*[@text='Diarrhea']")).click();
		   driver.findElement(By.xpath("//*[@text='Blocked or runny nose']"));
		 
		   JavascriptExecutor js2 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject2 = new HashMap<String, String>();
		      scrollObject2.put("direction", "down");
		      js2.executeScript("mobile: scroll", scrollObject2);
		      log.info("Scolled down "); 
		      driver.findElement(By.xpath("//*[@text='None of the above']"));
		      driver.findElement(By.xpath("//*[@text='Other']")).click();
		      driver.findElement(By.xpath("//*[@text='Briefly describe']"));
			   driver.findElement(By.xpath("//*[@id='message']")).sendKeys(OtherText2);
			   driver.findElement(By.xpath("//*[@text='Next']")).click();
 driver.findElement(By.xpath("//*[@text='Do you have pain in any of those locations?']")).click();
 driver.findElement(By.xpath("//*[@text='Head']"));
 driver.findElement(By.xpath("//*[@text='Chest']")).click();
 driver.findElement(By.xpath("//*[@text='Abdomen']")).click();
 driver.findElement(By.xpath("//*[@text='Back']"));
 driver.findElement(By.xpath("//*[@text='Bladder (urinating)']"));
 driver.findElement(By.xpath("//*[@text='Skin']")).click();
 driver.findElement(By.xpath("//*[@text='Other']"));

 driver.findElement(By.xpath("//*[@text='None of the above']"));
 
 
 driver.findElement(By.xpath("//*[@text='Next']")).click();
 
	Thread.sleep(3000); 
//	driver.findElement(By.xpath("//*[@text='Consultation for:']"));
//	  driver.findElement(By.xpath("//*[@text='Scheduled:']"));
	//  driver.findElement(By.xpath("//*[@text='Calling mode:']"));
	  
	//  driver.findElement(By.xpath("//*[@id='consultationValue']"));
	//  driver.findElement(By.xpath("//*[@id='scheduleValue']"));
	//  driver.findElement(By.xpath("//*[@id='videoText']"));
	//  driver.findElement(By.xpath("//*[@id='consultationValue']"));
	//  driver.findElement(By.xpath("//*[@text='Fever']"));
//  driver.findElement(By.xpath("//*[@text='Next available']"));
	//  driver.findElement(By.xpath("//*[@text='Video call']"));
	// driver.findElement(By.xpath("//*[@text='Start consultation']"));
	// driver.findElement(By.xpath("//*[@text='Close']"));
	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();   
	   }
	   
	   {
		   driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click(); 
		   //Flu-Like
		   driver.findElement(By.xpath("//*[@text='Flu-like symptoms']")).click();
		   log.info("Flulike Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
 		   driver.findElement(By.xpath("//*[@text='Next']")).click(); 
		 //  driver.findElement(By.xpath("//*[@text='Have you been exposed to someone with a confirmed COVID-19 (coronavirus) infection in the last 14 days? ']"));
		   
		   driver.findElement(By.xpath("//*[contains(text(), 'COVID')]"));
		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='What symptoms do you have?']")).click();
		   driver.findElement(By.xpath("//*[@text='Fatigue']"));
		   driver.findElement(By.xpath("//*[@text='Body aches']"));
		   driver.findElement(By.xpath("//*[@text='Sore throat']"));
		   driver.findElement(By.xpath("//*[@text='Cough']"));
		   driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
		   driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
		   driver.findElement(By.xpath("//*[@text='Diarrhea']")).click();
		   driver.findElement(By.xpath("//*[@text='Headache']")).click();
		   
		   JavascriptExecutor js2 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject2 = new HashMap<String, String>();
		      scrollObject2.put("direction", "down");
		      js2.executeScript("mobile: scroll", scrollObject2);
		      log.info("Scolled down ");
		   driver.findElement(By.xpath("//*[@text='Blocked or runny nose']"));
		   driver.findElement(By.xpath("//*[@text='Other']"));
		   driver.findElement(By.xpath("//*[@text='None of the above']")).click();
		   driver.findElement(By.xpath("//*[@text='How long has this lasted?']")).click();
		   driver.findElement(By.xpath("//*[@text='Less than 24 hours']"));
		   driver.findElement(By.xpath("//*[@text='Days']"));
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		   driver.findElement(By.xpath("//*[@text='Do you have trouble breathing?']")).click();
		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
			Thread.sleep(3000); 
		//	driver.findElement(By.xpath("//*[@text='Consultation for:']"));
		//	  driver.findElement(By.xpath("//*[@text='Scheduled:']"));
		//	  driver.findElement(By.xpath("//*[@text='Calling mode:']"));
			  
		//	  driver.findElement(By.xpath("//*[@id='consultationValue']"));
		//	  driver.findElement(By.xpath("//*[@id='scheduleValue']"));
		//	  driver.findElement(By.xpath("//*[@id='videoText']"));
		//	  driver.findElement(By.xpath("//*[@id='consultationValue']"));
		//	  driver.findElement(By.xpath("//*[@text='Flu-like symptoms']"));
		//	  driver.findElement(By.xpath("//*[@text='Next available']"));
		//	  driver.findElement(By.xpath("//*[@text='Video call']"));
		//	 driver.findElement(By.xpath("//*[@text='Start consultation']"));
		//	driver.findElement(By.xpath("//*[@text='Close']"));
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();  
	   }
	   
	   {
		   driver.findElement(By.xpath("//*[contains(text(), 'Cough, cold')]")).click(); 
		   //Sore throat
		   driver.findElement(By.xpath("//*[@text='Sore throat']")).click();
		   log.info("Sore Throat Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click(); 
		   driver.findElement(By.xpath("//*[contains(text(), 'COVID')]"));
		  // driver.findElement(By.xpath("//*[@text='Have you been exposed to someone with a confirmed COVID-19 (coronavirus) infection in the last 14 days? ']"));
		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
		   driver.findElement(By.xpath("//*[@text='How long have you had your sore throat?']")).click();
		   driver.findElement(By.xpath("//*[@text='Less than 24 hours']"));
		   driver.findElement(By.xpath("//*[@text='Days']"));
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		   driver.findElement(By.xpath("//*[@text='Where does it hurt?']")).click();
		   driver.findElement(By.xpath("//*[@text='Left']"));
		   driver.findElement(By.xpath("//*[@text='Right']")).click();
		   driver.findElement(By.xpath("//*[@text='Entire throat']"));
  driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
  driver.findElement(By.xpath("//*[@text='Fatigue']"));
  driver.findElement(By.xpath("//*[@text='Body aches']"));
  driver.findElement(By.xpath("//*[@text='Difficulty swallowing fluids']"));
driver.findElement(By.xpath("//*[@text='Cough']"));
  driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
  
  JavascriptExecutor js2 = (JavascriptExecutor) driver;
     HashMap<String, String> scrollObject2 = new HashMap<String, String>();
     scrollObject2.put("direction", "down");
     js2.executeScript("mobile: scroll", scrollObject2);
     log.info("Scolled down ");

  driver.findElement(By.xpath("//*[@text='Headache']")).click();
  driver.findElement(By.xpath("//*[@text='Blocked or runny nose']"));
  driver.findElement(By.xpath("//*[@text='None of the above']"));
  driver.findElement(By.xpath("//*[@text='Other']"));
 	
  driver.findElement(By.xpath("//*[@text='Next']")).click();
  
	Thread.sleep(3000); 
//	driver.findElement(By.xpath("//*[@text='Consultation for:']"));
//	  driver.findElement(By.xpath("//*[@text='Scheduled:']"));
	//  driver.findElement(By.xpath("//*[@text='Calling mode:']"));
	  
	//  driver.findElement(By.xpath("//*[@id='consultationValue']"));
	//  driver.findElement(By.xpath("//*[@id='scheduleValue']"));
	//  driver.findElement(By.xpath("//*[@id='videoText']"));
	//  driver.findElement(By.xpath("//*[@id='consultationValue']"));
	//  driver.findElement(By.xpath("//*[@text='Sore throat']"));
	//  driver.findElement(By.xpath("//*[@text='Next available']"));
	//  driver.findElement(By.xpath("//*[@text='Video call']"));
	// driver.findElement(By.xpath("//*[@text='Start consultation']"));
	// driver.findElement(By.xpath("//*[@text='Close']"));
	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click(); 
	   }
	   
	   
	   JavascriptExecutor js7 = (JavascriptExecutor) driver;
	     HashMap<String, String> scrollObject7 = new HashMap<String, String>();
	     scrollObject7.put("direction", "down");
	     js7.executeScript("mobile: scroll", scrollObject7);
	     log.info("Scolled down ");
	   
	   {
		 //General symptoms
		   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
		 //Anxiety and Stress
		   driver.findElement(By.xpath("//*[@text='Anxiety and stress']")).click();
		   log.info("Anxiety Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
		   driver.findElement(By.xpath("//*[@text='Less than 24 hours']"));
		      driver.findElement(By.xpath("//*[@text='Days']")).click();
		      driver.findElement(By.xpath("//*[@text='Weeks']"));
		      driver.findElement(By.xpath("//*[@text='Months']"));
		      
		     
		      driver.findElement(By.xpath("//*[@text='Describe your symptoms:']")).click();
		       
		      driver.findElement(By.xpath("//*[@text='Excessive worrying']"));
		      driver.findElement(By.xpath("//*[@text='Chest tightness']")).click();
		      driver.findElement(By.xpath("//*[@text='Numb lips or fingertips']")).click();
		      driver.findElement(By.xpath("//*[@text='Palpitations (noticeable or fast heartbeat)']"));
		      driver.findElement(By.xpath("//*[@text='Trouble sleeping']"));
		      
		      JavascriptExecutor js4 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject4 = new HashMap<String, String>();
		      scrollObject4.put("direction", "down");
		      js4.executeScript("mobile: scroll", scrollObject4);
		      log.info("Scolled down ");
		      
		 
		      driver.findElement(By.xpath("//*[@text='Other']"));
		      driver.findElement(By.xpath("//*[@text='None of the above']"));
  
		      driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   } 
	   
	   JavascriptExecutor js13 = (JavascriptExecutor) driver;
	      HashMap<String, String> scrollObject13 = new HashMap<String, String>();
	      scrollObject13.put("direction", "down");
	      js13.executeScript("mobile: scroll", scrollObject13);
	      log.info("Scolled down ");
	   {
			 
			   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
			 //Dizziness
			   driver.findElement(By.xpath("//*[@text='Dizziness']")).click();
			   log.info("Dizziness Checking ");
			   driver.findElement(By.xpath("//*[@text='Call 112']"));
			   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
			   driver.findElement(By.xpath("//*[@text='Next']")).click();
			   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
			   driver.findElement(By.xpath("//*[@text='Yes']"));
			   driver.findElement(By.xpath("//*[@text='No']"));
			   driver.findElement(By.xpath("//*[@text='Yes']")).click();
			   driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
			   driver.findElement(By.xpath("//*[@text='Minutes']"));
			      driver.findElement(By.xpath("//*[@text='Hours']"));
			      driver.findElement(By.xpath("//*[@text='Days']")).click();
			      driver.findElement(By.xpath("//*[@text='Weeks']"));
			      
			     
			      driver.findElement(By.xpath("//*[@text='Describe your symptoms:']")).click();
			       
			      driver.findElement(By.xpath("//*[@text='Spinning sensation']"));
			      driver.findElement(By.xpath("//*[@text='Feeling like passing out']")).click();
			      driver.findElement(By.xpath("//*[@text='Worse when standing']")).click();
			      driver.findElement(By.xpath("//*[@text='Unsteady walk']"));
			      driver.findElement(By.xpath("//*[@text='Visual changes']"));
			 
			      driver.findElement(By.xpath("//*[@text='Other']"));
			    
			      driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
			       
			      driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']"));
			      driver.findElement(By.xpath("//*[@text='Headache']")).click();
			      driver.findElement(By.xpath("//*[@text='Loss of vision']")).click();
			      driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
			      driver.findElement(By.xpath("//*[@text='Chest pain']"));
			      
			      JavascriptExecutor js5 = (JavascriptExecutor) driver;
			      HashMap<String, String> scrollObject5 = new HashMap<String, String>();
			      scrollObject5.put("direction", "down");
			      js5.executeScript("mobile: scroll", scrollObject5);
			      log.info("Scolled downs ");      
			      driver.findElement(By.xpath("//*[@text='Trouble breathing']"));
			      driver.findElement(By.xpath("//*[@text='Falls']"));
			      driver.findElement(By.xpath("//*[@text='Other']"));
			      driver.findElement(By.xpath("//*[@text='None of the above']"));	      
			      
			      			      
			      
			      
			      
			      
			      
			      
			      
			      
	  
			      driver.findElement(By.xpath("//*[@text='Next']")).click();
			 		Thread.sleep(3000); 
			 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			 		
		   } 
	   
	   JavascriptExecutor js14 = (JavascriptExecutor) driver;
	      HashMap<String, String> scrollObject14 = new HashMap<String, String>();
	      scrollObject14.put("direction", "down");
	      js14.executeScript("mobile: scroll", scrollObject14);
	      log.info("Scolled down ");
		   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
		 //Eye or eyelid problems
		   driver.findElement(By.xpath("//*[@text='Eye or eyelid problems']")).click();
		   log.info("Eyelid Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   driver.findElement(By.xpath("//*[@text='How long has this lasted?']"));
		   driver.findElement(By.xpath("//*[@text='Less than 24 hours']"));
		   driver.findElement(By.xpath("//*[@text='Days']"));
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		   driver.findElement(By.xpath("//*[@text='Describe your problem:']")).click();
		   driver.findElement(By.xpath("//*[@text='Swollen eyelid']"));
		      driver.findElement(By.xpath("//*[@text='Crusty eyelid']")).click();
		      driver.findElement(By.xpath("//*[@text='Red eye(s)']"));
		      driver.findElement(By.xpath("//*[@text='Burning eye(s)']")).click();
		      driver.findElement(By.xpath("//*[@text='Itchy eye(s)']")).click();
		      driver.findElement(By.xpath("//*[@text='Other']"));
		     
		      driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
		       
		      driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']"));
		      driver.findElement(By.xpath("//*[@text='Painful eye(s)']")).click();
		      driver.findElement(By.xpath("//*[@text='Change in vision']")).click();
		      driver.findElement(By.xpath("//*[@text='Pain with eye movements']"));
		      driver.findElement(By.xpath("//*[@text='Sensitivity to light']"));
		 
		      driver.findElement(By.xpath("//*[@text='Other']"));
		      driver.findElement(By.xpath("//*[@text='None of the above']"));
		      driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();

  
		      driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   } 
	   
	   
	   JavascriptExecutor js8 = (JavascriptExecutor) driver;
	     HashMap<String, String> scrollObject8 = new HashMap<String, String>();
	     scrollObject8.put("direction", "down");
	     js8.executeScript("mobile: scroll", scrollObject8);
	     log.info("Scolled down ");
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
		 //Fatigue
		   driver.findElement(By.xpath("//*[@text='Fatigue (tiredness)']")).click();
		   log.info("Fatique Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   driver.findElement(By.xpath("//*[@text='How long have you felt like this?']"));
		   driver.findElement(By.xpath("//*[@text='Less than 24 hours']"));
		   driver.findElement(By.xpath("//*[@text='Days']"));
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		   driver.findElement(By.xpath("//*[@text='Months']")).click();
 driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
		       
		      driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
		      driver.findElement(By.xpath("//*[@text='Trouble breathing']")).click();
		      driver.findElement(By.xpath("//*[@text='Nausea or vomiting']")).click();
		      driver.findElement(By.xpath("//*[@text='Diarrhea']"));
		      driver.findElement(By.xpath("//*[@text='Pain']"));
		 
		      driver.findElement(By.xpath("//*[@text='Frequent urination']"));
		      driver.findElement(By.xpath("//*[@text='Rash']"));
		      JavascriptExecutor js1 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject = new HashMap<String, String>();
		      scrollObject.put("direction", "down");
		      js1.executeScript("mobile: scroll", scrollObject);
		      log.info("Scolled downs ");
		      driver.findElement(By.xpath("//*[@text='Other']"));
		      driver.findElement(By.xpath("//*[@text='None of the above']"));
		      driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();

		      driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   } 
	   JavascriptExecutor js15 = (JavascriptExecutor) driver;
	      HashMap<String, String> scrollObject15 = new HashMap<String, String>();
	      scrollObject15.put("direction", "down");
	      js15.executeScript("mobile: scroll", scrollObject15);
	      log.info("Scolled downs ");
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
		 //Headache
		   driver.findElement(By.xpath("//*[@text='Headache']")).click();
		   log.info("Headache Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='How long has this pain lasted?']"));
		   driver.findElement(By.xpath("//*[@text='Less than 6 hours']"));
		   driver.findElement(By.xpath("//*[@text='More than 6 hours']"));
		   driver.findElement(By.xpath("//*[@text='Days']")).click();
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
 driver.findElement(By.xpath("//*[@text='How severe is your pain?']")).click();
		       
		      driver.findElement(By.xpath("//*[@text='Mild (1-3)']")).click();
		      driver.findElement(By.xpath("//*[@text='Moderate (4-6)']")).click();
		      driver.findElement(By.xpath("//*[@text='Severe (7-9)']")).click();
		      driver.findElement(By.xpath("//*[@text='Worst of life (10)']"));
		       
		      driver.findElement(By.xpath("//*[@text='Describe how it started:']")).click();
		      driver.findElement(By.xpath("//*[@text='Suddenly (at its worst within an hour)']")).click();
		      driver.findElement(By.xpath("//*[@text='Gradually (slowly)']")).click();
		      driver.findElement(By.xpath("//*[@text='Unknown']")).click();
		      
		      
		      driver.findElement(By.xpath("//*[@text='What other symptoms do you have?']")).click();
		      driver.findElement(By.xpath("//*[@text='Nausea or vomiting']")).click();
		      driver.findElement(By.xpath("//*[@text='Visual changes (like blurry or wavy vision)']")).click();
		      driver.findElement(By.xpath("//*[@text='Neck pain']")).click();
		      driver.findElement(By.xpath("//*[@text='Skin rash']")).click();
		      driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
		      driver.findElement(By.xpath("//*[@text='Dizziness (spinning sensation)']")).click();
		      JavascriptExecutor js1 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject = new HashMap<String, String>();
		      scrollObject.put("direction", "down");
		      js1.executeScript("mobile: scroll", scrollObject);
		      log.info("Scolled downs ");      
		      driver.findElement(By.xpath("//*[@text='Numbness']")).click();
		      driver.findElement(By.xpath("//*[@text='Other']"));
		      driver.findElement(By.xpath("//*[@text='None of the above']")).click();
		      driver.findElement(By.xpath("//*[@text='Loss of consciousness']")).click(); 
               driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   } 
	   
	   
	   JavascriptExecutor js9 = (JavascriptExecutor) driver;
	     HashMap<String, String> scrollObject9 = new HashMap<String, String>();
	     scrollObject9.put("direction", "down");
	     js9.executeScript("mobile: scroll", scrollObject9);
	     log.info("Scolled down ");
	   
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
		 //Joint or limb pain
		   driver.findElement(By.xpath("//*[@text='Joint or limb pain']")).click();
		   log.info("FJoint or Limb Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
		    
 driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
		       
		      driver.findElement(By.xpath("//*[@text='Less than 24 hours']")).click();
		      driver.findElement(By.xpath("//*[@text='Days']")).click();
		      driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		      
		      driver.findElement(By.xpath("//*[@text='Have you suffered an injury?']")).click();
		      driver.findElement(By.xpath("//*[@text='Yes']")).click();
			   driver.findElement(By.xpath("//*[@text='No']"));
			   driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
		       
			      driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
			      driver.findElement(By.xpath("//*[@text='Swollen joint']")).click();
			      driver.findElement(By.xpath("//*[@text='Red joint']")).click();
			      driver.findElement(By.xpath("//*[@text='Cannot move joint']"));
			      driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
			 
			      driver.findElement(By.xpath("//*[@text='Skin rash']"));
			    
			      
			      
			      JavascriptExecutor js1 = (JavascriptExecutor) driver;
			      HashMap<String, String> scrollObject = new HashMap<String, String>();
			      scrollObject.put("direction", "down");
			      js1.executeScript("mobile: scroll", scrollObject);
			      log.info("Scolled downs "); 
			      
			      driver.findElement(By.xpath("//*[@text='Other']"));
			      driver.findElement(By.xpath("//*[@text='None of the above']"));			   

               driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   } 
	   
	   JavascriptExecutor js10 = (JavascriptExecutor) driver;
	     HashMap<String, String> scrollObject10 = new HashMap<String, String>();
	     scrollObject10.put("direction", "down");
	     js10.executeScript("mobile: scroll", scrollObject10);
	     log.info("Scolled down ");
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
		 //Low back pain
		   driver.findElement(By.xpath("//*[@text='Low back pain']")).click();
		   log.info("Low Back Pain Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
		    
 driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
		       
		      driver.findElement(By.xpath("//*[@text='Less than 24 hours']")).click();
		      driver.findElement(By.xpath("//*[@text='Days']")).click();
		      driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		      
		      driver.findElement(By.xpath("//*[@text='Have you suffered an injury?']")).click();
		      driver.findElement(By.xpath("//*[@text='Yes']")).click();
			   driver.findElement(By.xpath("//*[@text='No']"));
			   
			   driver.findElement(By.xpath("//*[@text='How severe is your pain?']")).click();
		       
			   driver.findElement(By.xpath("//*[@text='Mild (1-3)']")).click();
			      driver.findElement(By.xpath("//*[@text='Moderate (4-6)']")).click();
			      driver.findElement(By.xpath("//*[@text='Severe (7-9)']")).click();
			      driver.findElement(By.xpath("//*[@text='Worst of life (10)']"));
			       
			      driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
			      JavascriptExecutor js1 = (JavascriptExecutor) driver;
			      HashMap<String, String> scrollObject = new HashMap<String, String>();
			      scrollObject.put("direction", "down");
			      js1.executeScript("mobile: scroll", scrollObject);
			      log.info("Scolled downs "); 
			      
			      driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
			      driver.findElement(By.xpath("//*[@text='Numb or weak leg(s)']")).click();
			      driver.findElement(By.xpath("//*[@text='Trouble urinating or defecating']")).click();
			      driver.findElement(By.xpath("//*[@text='Unable to walk']"));
			      driver.findElement(By.xpath("//*[@text='Other']"));
			      driver.findElement(By.xpath("//*[@text='None of the above']"));			   

               driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   } 
	   
	   JavascriptExecutor js11 = (JavascriptExecutor) driver;
	     HashMap<String, String> scrollObject11 = new HashMap<String, String>();
	     scrollObject11.put("direction", "down");
	     js11.executeScript("mobile: scroll", scrollObject11);
	     log.info("Scolled down ");
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
		 //Sleep difficulties
		   driver.findElement(By.xpath("//*[@text='Sleep difficulties']")).click();
		   log.info("Sleep Difficulty Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
		    
 driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
		       
		     
		      driver.findElement(By.xpath("//*[@text='Days']")).click();
		      driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		      driver.findElement(By.xpath("//*[@text='Months']")).click();
		      
		      driver.findElement(By.xpath("//*[@text='Describe your symptoms:']")).click();
		      driver.findElement(By.xpath("//*[@text='Difficulty falling asleep']")).click();
			   driver.findElement(By.xpath("//*[@text='Frequent waking during night']"));
			   driver.findElement(By.xpath("//*[@text='Excessive sleeping']"));
			   driver.findElement(By.xpath("//*[@text='Other']"));
			   
			   
			   driver.findElement(By.xpath("//*[@text='Do you have any of the following?']")).click();
		       
			   driver.findElement(By.xpath("//*[@text='Stress at work or home']")).click();
			      driver.findElement(By.xpath("//*[@text='Weight gain or loss']")).click();
			      driver.findElement(By.xpath("//*[@text='Feeling sad or depressed']")).click();
			      driver.findElement(By.xpath("//*[@text='Started new medications or supplements']"));
		      JavascriptExecutor js1 = (JavascriptExecutor) driver;
			      HashMap<String, String> scrollObject = new HashMap<String, String>();
			      scrollObject.put("direction", "down");
			      js1.executeScript("mobile: scroll", scrollObject);
			      log.info("Scolled downs "); 
			      
			      driver.findElement(By.xpath("//*[@text='Other']"));
			      driver.findElement(By.xpath("//*[@text='None of the above']"));			   

               driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   }  
	   JavascriptExecutor js12 = (JavascriptExecutor) driver;
	     HashMap<String, String> scrollObject12 = new HashMap<String, String>();
	     scrollObject12.put("direction", "down");
	     js12.executeScript("mobile: scroll", scrollObject12);
	     log.info("Scolled down ");
   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='General symptoms']")).click(); 
		 //Minor injuries
		   driver.findElement(By.xpath("//*[@text='Minor injuries']")).click();
		   log.info("Minor Injury Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Please describe your injury (e.g. cut wound, twisted ankle)']")).click();
               driver.findElement(By.xpath("//*[@text='Next']")).click();
               driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click(); 		
	   } 
	   
	   

	   {
			 
		   driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click(); 
		 //Contraception counseling
		   driver.findElement(By.xpath("//*[@text='Contraception counseling']")).click();
		   log.info("Contraception Cuncelling Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had unprotected sexual intercourse within the last 72 hours?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
		    
 driver.findElement(By.xpath("//*[@text='Are you looking for advice on ways to avoid pregnancy?']")).click();
		       
 driver.findElement(By.xpath("//*[@text='Yes']")).click();
 driver.findElement(By.xpath("//*[@text='No']"));
		       
driver.findElement(By.xpath("//*[@text='Please describe your concern']")).click();
driver.findElement(By.xpath("//*[@text='Next']")).click();
 driver.findElement(By.xpath("//*[@text='Next']")).click();
		 		Thread.sleep(3000); 
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   }  
	   
	   
	 
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click(); 
		 //Erectile dysfunction
		   driver.findElement(By.xpath("//*[@text='Erectile dysfunction']")).click();
		   log.info("Erectile Dysfunction Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Do you have any of the following medical conditions?']"));
		   driver.findElement(By.xpath("//*[@text='Diabetes']")).click();
		   driver.findElement(By.xpath("//*[@text='High blood pressure']"));
		   driver.findElement(By.xpath("//*[@text='Heart disease']"));
		   driver.findElement(By.xpath("//*[@text='Obesity']")).click();
		   driver.findElement(By.xpath("//*[@text='Multiple sclerosis']"));
		   driver.findElement(By.xpath("//*[@text='Other']"));
		   driver.findElement(By.xpath("//*[@text='None of the above']"));
		   
 driver.findElement(By.xpath("//*[@text='Do you use any of the following?']")).click();
 driver.findElement(By.xpath("//*[@text='Medications']")).click();
 driver.findElement(By.xpath("//*[@text='Illicit drugs']"));
 driver.findElement(By.xpath("//*[@text='Alcohol']"));
 driver.findElement(By.xpath("//*[@text='Tobacco']")).click();
 driver.findElement(By.xpath("//*[@text='None of the above']"));
 
		       
driver.findElement(By.xpath("//*[@text='Have you had any recent stressors at work or at home?']")).click();
driver.findElement(By.xpath("//*[@text='Yes']")).click();
 driver.findElement(By.xpath("//*[@text='No']"));
 driver.findElement(By.xpath("//*[@text='Next']")).click();
		  	Thread.sleep(3000); 
		  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		 		
	   }  
	   
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click(); 
		 //Period problems
		   driver.findElement(By.xpath("//*[@text='Period problems']")).click();
		   log.info("Period Problems Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']")).click();
		    
    
driver.findElement(By.xpath("//*[@text='Please select your symptoms:']")).click();
driver.findElement(By.xpath("//*[@text='Missed period']")).click();
 driver.findElement(By.xpath("//*[@text='Painful period']")).click();
 driver.findElement(By.xpath("//*[@text='Heavy bleeding']"));
 driver.findElement(By.xpath("//*[@text='Abnormal bleeding (after menopause or unusual timing)']"));
 driver.findElement(By.xpath("//*[@text='Other']"));
		  	Thread.sleep(3000); 
		  driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
	 driver.findElement(By.xpath("//*[@text='Dizziness with standing']")).click();
	 	driver.findElement(By.xpath("//*[@text='Fainting']")).click();
	 	driver.findElement(By.xpath("//*[@text='Palpitations or rapid heartbeat']"));
	 	driver.findElement(By.xpath("//*[@text='Trouble breathing']"));
	 	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	      HashMap<String, String> scrollObject = new HashMap<String, String>();
	      scrollObject.put("direction", "down");
	      js1.executeScript("mobile: scroll", scrollObject);
	      log.info("Scolled downs "); 
	 	driver.findElement(By.xpath("//*[@text='Other']"));
	 	driver.findElement(By.xpath("//*[@text='None of the above']"));
	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }  
	   
	   
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click(); 
		 //Sexually transmitted infections
		   driver.findElement(By.xpath("//*[@text='Sexually transmitted infections']")).click();
		   log.info("STD Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='When did you last have a sexual encounter?']"));
		   driver.findElement(By.xpath("//*[@text='Less than 24 hours']")).click();
		   driver.findElement(By.xpath("//*[@text='Less than 72 hours (3 days)']")).click();
		   driver.findElement(By.xpath("//*[@text='Weeks']"));
		   driver.findElement(By.xpath("//*[@text='Months']"));
    
driver.findElement(By.xpath("//*[@text='Was this a regular sexual partner or a casual encounter?']")).click();
driver.findElement(By.xpath("//*[@text='Regular']")).click();
 driver.findElement(By.xpath("//*[@text='Casual']")).click();
 
		  	Thread.sleep(3000); 
		  driver.findElement(By.xpath("//*[@text='With this partner, did you ever have a sexual encounter without contraception?']")).click();
		  driver.findElement(By.xpath("//*[@text='Yes']")).click();
		  driver.findElement(By.xpath("//*[@text='No']")).click();
		  
		  driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();  
		  
		  driver.findElement(By.xpath("//*[@text='Rash']")).click();
		  driver.findElement(By.xpath("//*[@text='Lump or ulcer on genitals']")).click();
		  driver.findElement(By.xpath("//*[@text='Unusual vaginal or penile discharge']"));
		  driver.findElement(By.xpath("//*[@text='Pain in the abdomen or testicles']"));
		  driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']"));
		  driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
		  
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject = new HashMap<String, String>();
		      scrollObject.put("direction", "down");
		      js1.executeScript("mobile: scroll", scrollObject);
		      log.info("Scolled downs "); 
		  
		  
		  driver.findElement(By.xpath("//*[@text='Other']"));
		  driver.findElement(By.xpath("//*[@text='None of the above']"));
  
	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }   
	   
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click(); 
		 //Urinary tract infections
		   driver.findElement(By.xpath("//*[@text='Urinary tract infections']")).click();
		   log.info("Urinary Tract Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had urinary tract (bladder) infections before?']"));

		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
    
driver.findElement(By.xpath("//*[@text='Select your symptoms:']")).click();
driver.findElement(By.xpath("//*[@text='Frequent urination']")).click();
 driver.findElement(By.xpath("//*[@text='Painful urination']")).click();
 driver.findElement(By.xpath("//*[@text='Blood in urine']"));
 driver.findElement(By.xpath("//*[@text='Bladder pain']"));
 driver.findElement(By.xpath("//*[@text='None of the above']"));
		  	Thread.sleep(3000); 
		  
		  
		  driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();  
		  
		  driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
		  driver.findElement(By.xpath("//*[@text='Back pain']")).click();
		  driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
		  driver.findElement(By.xpath("//*[@text='Dizziness']"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject = new HashMap<String, String>();
		      scrollObject.put("direction", "down");
		      js1.executeScript("mobile: scroll", scrollObject);
		      log.info("Scolled downs "); 
		  
		  
		  driver.findElement(By.xpath("//*[@text='Other']"));
		  driver.findElement(By.xpath("//*[@text='None of the above']"));
  
	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }   
	   
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='Genital and urinary symptoms']")).click(); 
		 //Vaginal discharge or itching
		   driver.findElement(By.xpath("//*[@text='Vaginal discharge or itching']")).click();
		   log.info("Vagnal Discharge Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));

		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
    
driver.findElement(By.xpath("//*[@text='Please select your symptoms:']")).click();
driver.findElement(By.xpath("//*[@text='Thick white discharge']")).click();
 driver.findElement(By.xpath("//*[@text='Green or yellow discharge']")).click();
 driver.findElement(By.xpath("//*[@text='Foul smell']"));
 driver.findElement(By.xpath("//*[@text='Itchy or burning genitals']"));
 driver.findElement(By.xpath("//*[@text='Other']"));
 driver.findElement(By.xpath("//*[@text='None of the above']"));
		  	Thread.sleep(3000); 

		  driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();  
		  
		  driver.findElement(By.xpath("//*[@text='Nausea and vomiting']")).click();
		  driver.findElement(By.xpath("//*[@text='Abdominal pain']")).click();
		  driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']"));
		  
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
		      HashMap<String, String> scrollObject = new HashMap<String, String>();
		      scrollObject.put("direction", "down");
		      js1.executeScript("mobile: scroll", scrollObject);
		      log.info("Scolled downs "); 
		  
		  
		  driver.findElement(By.xpath("//*[@text='Other']"));
		  driver.findElement(By.xpath("//*[@text='None of the above']"));
  
	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }     
	   
	   
   
	   
	   {
			 
		   driver.findElement(By.xpath("//*[@text='Skin problems']")).click(); 
		 //Acne
		   driver.findElement(By.xpath("//*[@text='Acne']")).click();
		   log.info("Acne Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));

		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
    
driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Days']"));
		  driver.findElement(By.xpath("//*[@text='Weeks']"));
		  driver.findElement(By.xpath("//*[@text='Months']")).click();
		  
	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   } 	   
	   log.info("End of Acne Checks ");
	   Thread.sleep(2000); 
	   {
			 
		   driver.findElement(By.xpath("//*[@text='Skin problems']")).click(); 
		 //Hair problems
		   driver.findElement(By.xpath("//*[@text='Hair problems']")).click();
		   log.info("Hair problems Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));

		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
    
driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Days']"));
		  driver.findElement(By.xpath("//*[@text='Weeks']"));
		  driver.findElement(By.xpath("//*[@text='Months']")).click();
		  
		  driver.findElement(By.xpath("//*[@text='Do you have a rash on your scalp?']")).click();

		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
   	  
		   driver.findElement(By.xpath("//*[@text='Have you had any recent stressors at home or at work?']"));

		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();	  

	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 //	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   } 	    
	   

	   {
		   driver.findElement(By.xpath("//*[@text='Skin problems']")).click(); 
		 //Head lice
		   driver.findElement(By.xpath("//*[@text='Head lice']")).click();
		   log.info("Head lice Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Is there an ongoing (or recent) lice outbreak at school?']"));

		   driver.findElement(By.xpath("//*[@text='Yes']"));
		   driver.findElement(By.xpath("//*[@text='No']")).click();
    
driver.findElement(By.xpath("//*[@text='Do you or your child have any of the following symptoms?']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Itchy scalp']")).click();
		  driver.findElement(By.xpath("//*[@text='Visible nits (eggs) or lice']"));
		  driver.findElement(By.xpath("//*[@text='Rash']")).click();
	 
		  driver.findElement(By.xpath("//*[@text='Other']"));
		   driver.findElement(By.xpath("//*[@text='None of the above']"));
  	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }
	   
	   
	   {
		   driver.findElement(By.xpath("//*[@text='Skin problems']")).click(); 
		 //Insect bites and stings
		   driver.findElement(By.xpath("//*[@text='Insect bites and stings']")).click();
		   log.info("Insect bites and stings Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='How long ago was the injury?']"));
		   driver.findElement(By.xpath("//*[@text='Minutes']"));
			  driver.findElement(By.xpath("//*[@text='Hours']"));
			  driver.findElement(By.xpath("//*[@text='Days']")).click();
		   driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		    
    
driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Pain']"));
		  driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
		  driver.findElement(By.xpath("//*[@text='Difficulty breathing']")).click();
		  driver.findElement(By.xpath("//*[@text='Other']")).click();
		  driver.findElement(By.xpath("//*[@text='Next']")).click();
		   driver.findElement(By.xpath("//*[@text='None of the above']"));
  	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   } 
	   

	   
	   {
		   driver.findElement(By.xpath("//*[@text='Skin problems']")).click(); 
		 //Nail problems
		   driver.findElement(By.xpath("//*[@text='Nail problems']")).click();
		   log.info("Nail problems Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
    
driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Less than 24 hours']"));
		  driver.findElement(By.xpath("//*[@text='Days']"));
		  driver.findElement(By.xpath("//*[@text='Weeks']"));
		  driver.findElement(By.xpath("//*[@text='Months']")).click();
		   
		  driver.findElement(By.xpath("//*[@text='Do you have a fever?']")).click();
		  driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
		  
  	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   } 
	     
	   {
		   driver.findElement(By.xpath("//*[@text='Skin problems']")).click(); 
		 //Rash
		   driver.findElement(By.xpath("//*[@text='Rash']")).click();
		   log.info("Rash Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this rash before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
    
driver.findElement(By.xpath("//*[@text='How long have you had the current symptoms?']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Less than 24 hours']"));
		  driver.findElement(By.xpath("//*[@text='Days']"));
		  driver.findElement(By.xpath("//*[@text='Weeks']")).click();
		  
		  driver.findElement(By.xpath("//*[@text='Where is your rash?']")).click();
		  driver.findElement(By.xpath("//*[@text='Face or head']")).click();
		   driver.findElement(By.xpath("//*[@text='Body (chest, back or belly)']"));
		   driver.findElement(By.xpath("//*[@text='Arms']")).click();
		   driver.findElement(By.xpath("//*[@text='Legs']"));
		   driver.findElement(By.xpath("//*[@text='Other']"));
		
		   driver.findElement(By.xpath("//*[@text='Describe your rash:']")).click();
			  driver.findElement(By.xpath("//*[@text='Blisters']")).click();
			   driver.findElement(By.xpath("//*[@text='Small red spots']"));
			   driver.findElement(By.xpath("//*[@text='Larger red patches']")).click();
			   driver.findElement(By.xpath("//*[@text='Ulcers']"));
			   driver.findElement(By.xpath("//*[@text='Yellow with crust or pus']"));	   
			   driver.findElement(By.xpath("//*[@text='Other']"));
			   driver.findElement(By.xpath("//*[@text='Describe your rash:']")).click();
 driver.findElement(By.xpath("//*[@text='Describe your rash:']")).click(); 
 driver.findElement(By.xpath("//*[@text='Describe how the rash feels:']")).click(); 
 driver.findElement(By.xpath("//*[@text='Itchy']")).click();
 driver.findElement(By.xpath("//*[@text='Painful']"));
 driver.findElement(By.xpath("//*[@text='Hot']")).click();
 driver.findElement(By.xpath("//*[@text='Other']"));
 driver.findElement(By.xpath("//*[@text='Describe how the rash feels:']")).click();
 driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
 JavascriptExecutor js1 = (JavascriptExecutor) driver;
 HashMap<String, String> scrollObject = new HashMap<String, String>();
 scrollObject.put("direction", "down");
 js1.executeScript("mobile: scroll", scrollObject);
 log.info("Scolled downs "); 
 
 driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
 driver.findElement(By.xpath("//*[@text='Headache']"));
 driver.findElement(By.xpath("//*[@text='Neck pain']")).click();
 driver.findElement(By.xpath("//*[@text='Swollen face or mouth']"));
 
 driver.findElement(By.xpath("//*[@text='Difficulty breathing']")).click();
 driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
 driver.findElement(By.xpath("//*[@text='Other']"));
 driver.findElement(By.xpath("//*[@text='None of the above']"));
    
  	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }   
	   
	   JavascriptExecutor js1 = (JavascriptExecutor) driver;
	   HashMap<String, String> scrollObject = new HashMap<String, String>();
	   scrollObject.put("direction", "down");
	   js1.executeScript("mobile: scroll", scrollObject);
	   log.info("Scolled downs ");  
	   
	   {
		   driver.findElement(By.xpath("//*[@text='Stomach and bowel symptoms']")).click(); 
		   driver.findElement(By.xpath("//*[@text='Constipation']")).click();
		   log.info("Constipation Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
    
driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']"));
		  driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
		  driver.findElement(By.xpath("//*[@text='Pain']"));
		  driver.findElement(By.xpath("//*[@text='None of the above']")).click();
		   driver.findElement(By.xpath("//*[@text='Other']"));
		  
  	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }    
	   
	   JavascriptExecutor js2 = (JavascriptExecutor) driver;
	   HashMap<String, String> scrollObject2 = new HashMap<String, String>();
	   scrollObject2.put("direction", "down");
	   js1.executeScript("mobile: scroll", scrollObject2);
	   log.info("Scolled downs ");    
	   
	   
	   {
		   driver.findElement(By.xpath("//*[@text='Stomach and bowel symptoms']")).click(); 
		   driver.findElement(By.xpath("//*[@text='Heartburn (indigestion)']")).click();
		   log.info("Heartburn Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
    
driver.findElement(By.xpath("//*[@text='Describe your symptoms:']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Burning or pain in chest']"));
		  driver.findElement(By.xpath("//*[@text='Burning or pain in stomach']")).click();
		  driver.findElement(By.xpath("//*[@text='Sensation of blocked food']"));
		  driver.findElement(By.xpath("//*[@text='Difficulty breathing']")).click();
		   driver.findElement(By.xpath("//*[@text='Other']"));
		   
		    
		   driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
 		  driver.findElement(By.xpath("//*[@text='Abdominal pain']"));
		   		  driver.findElement(By.xpath("//*[@text='Nausea or vomiting']")).click();
		   		  driver.findElement(By.xpath("//*[@text='Diarrhea']"));
		   		  driver.findElement(By.xpath("//*[@text='No appetite']")).click();
		   		   driver.findElement(By.xpath("//*[@text='Other']"));		   
		   		driver.findElement(By.xpath("//*[@text='None of the above']"));
		   	 driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();
		   	 driver.findElement(By.xpath("//*[@text='When is your discomfort more intense?']")).click();
		   
		   	JavascriptExecutor js = (JavascriptExecutor) driver;
			   HashMap<String, String> scrollObject3 = new HashMap<String, String>();
			   scrollObject3.put("direction", "down");
			   js.executeScript("mobile: scroll", scrollObject3);
			   log.info("Scolled downs ");    
		   
			   driver.findElement(By.xpath("//*[@text='At night']")).click();
		   		  driver.findElement(By.xpath("//*[@text='Early in the morning']"));
		   		  driver.findElement(By.xpath("//*[@text='With food']")).click();
		   		   driver.findElement(By.xpath("//*[@text='Other']"));		 
		   		driver.findElement(By.xpath("//*[@text='Nothing changes it']"));	
 
  	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }    
	   
	   JavascriptExecutor js3 = (JavascriptExecutor) driver;
	   HashMap<String, String> scrollObject3 = new HashMap<String, String>();
	   scrollObject3.put("direction", "down");
	   js3.executeScript("mobile: scroll", scrollObject3);
	   log.info("Scolled downs ");    
	   
	   {
		   driver.findElement(By.xpath("//*[@text='Stomach and bowel symptoms']")).click(); 
		   driver.findElement(By.xpath("//*[@text='Pain (abdominal)']")).click();
		   log.info("Abdominl Pain Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
    
driver.findElement(By.xpath("//*[@text='How long has this episode lasted?']")).click();
  
driver.findElement(By.xpath("//*[@text='Minutes']"));
driver.findElement(By.xpath("//*[@text='Hours']"));
driver.findElement(By.xpath("//*[@text='Days']")).click();
driver.findElement(By.xpath("//*[@text='Weeks']")).click();

driver.findElement(By.xpath("//*[@text='How severe is your pain?']")).click();

driver.findElement(By.xpath("//*[@text='Mild (1-3)']")).click();
driver.findElement(By.xpath("//*[@text='Moderate (4-6)']")).click();
driver.findElement(By.xpath("//*[@text='Severe (7-9)']")).click();
driver.findElement(By.xpath("//*[@text='Worst of life (10)']"));
 
driver.findElement(By.xpath("//*[@text='Describe the location of your pain:']")).click();

JavascriptExecutor js4 = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject4 = new HashMap<String, String>();
scrollObject4.put("direction", "down");
js4.executeScript("mobile: scroll", scrollObject4);
log.info("Scolled downs ");    

driver.findElement(By.xpath("//*[@text='Upper middle']")).click();
driver.findElement(By.xpath("//*[@text='Upper right']")).click();
driver.findElement(By.xpath("//*[@text='Upper left']")).click();
driver.findElement(By.xpath("//*[@text='Lower right']"));
driver.findElement(By.xpath("//*[@text='Lower middle']"));
driver.findElement(By.xpath("//*[@text='Lower left']"));
driver.findElement(By.xpath("//*[@text='Everywhere']"));

driver.findElement(By.xpath("//*[@text='Do you have any of the following symptoms?']")).click();

JavascriptExecutor js5 = (JavascriptExecutor) driver;
HashMap<String, String> scrollObject5 = new HashMap<String, String>();
scrollObject5.put("direction", "down");
js5.executeScript("mobile: scroll", scrollObject5);
   
		    
		   driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
 		  driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
		   		  driver.findElement(By.xpath("//*[@text='Diarrhea']")).click();
		   		  driver.findElement(By.xpath("//*[@text='Yellow skin or eyes']"));
		   		  driver.findElement(By.xpath("//*[@text='Vaginal bleeding']")).click();
		   		   driver.findElement(By.xpath("//*[@text='Painful urination']"));		   
		   		driver.findElement(By.xpath("//*[@text='None of the above']"));
		   	 driver.findElement(By.xpath("//*[@text='Painful urination']")).click();
		   	 driver.findElement(By.xpath("//*[@text='Other']"));
		    
		   	 
  	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }    
	   
	   JavascriptExecutor js5 = (JavascriptExecutor) driver;
	   HashMap<String, String> scrollObject5 = new HashMap<String, String>();
	   scrollObject5.put("direction", "down");
	   js5.executeScript("mobile: scroll", scrollObject5);   
	   
	   {
		   driver.findElement(By.xpath("//*[@text='Stomach and bowel symptoms']")).click(); 
		   driver.findElement(By.xpath("//*[@text='Vomiting and diarrhea']")).click();
		   log.info("Constipation Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Have you had this problem before?']"));
		   driver.findElement(By.xpath("//*[@text='Yes']")).click();
		   driver.findElement(By.xpath("//*[@text='No']"));
    
driver.findElement(By.xpath("//*[@text='Describe your symptoms:']")).click();
  
		  driver.findElement(By.xpath("//*[@text='Diarrhea']"));
		  driver.findElement(By.xpath("//*[@text='Nausea or vomiting']"));
		  driver.findElement(By.xpath("//*[@text='Abdominal pain']"));
		  driver.findElement(By.xpath("//*[@text='Fever (≥ 38℃)']")).click();
		  driver.findElement(By.xpath("//*[@text='Dizziness']")).click();
		   driver.findElement(By.xpath("//*[@text='Other']"));
		   
		   driver.findElement(By.xpath("//*[@text='Have you recently:']")).click();
		   
			  driver.findElement(By.xpath("//*[@text='Traveled abroad']"));
			  driver.findElement(By.xpath("//*[@text='Eaten takeout or restaurant food']"));
			  driver.findElement(By.xpath("//*[@text='Been in contact with someone ill']"));
			  driver.findElement(By.xpath("//*[@text='Been hospitalised']")).click();
			  driver.findElement(By.xpath("//*[@text='None of the above']"));
 
  	 	driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }    
	   
	   JavascriptExecutor js6 = (JavascriptExecutor) driver;
	   HashMap<String, String> scrollObject6 = new HashMap<String, String>();
	   scrollObject6.put("direction", "down");
	   js6.executeScript("mobile: scroll", scrollObject6);   
	   
	   
	   {
		   driver.findElement(By.xpath("//*[@text='Tests and medications']")).click(); 
		   driver.findElement(By.xpath("//*[@text='Laboratory tests']")).click();
		   log.info("Laboratory tests Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Please name a few tests you need to review (e.g. complete blood count, cholesterol, vitamin, etc)']")).click();
		   driver.findElement(By.xpath("//*[@id='message']"));
			driver.findElement(By.xpath("//*[@text='Next']")).click();
			driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	 
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }    
	     
	   JavascriptExecutor js17 = (JavascriptExecutor) driver;
	   HashMap<String, String> scrollObject17 = new HashMap<String, String>();
	   scrollObject17.put("direction", "down");
	   js17.executeScript("mobile: scroll", scrollObject17);   
	   
	   
	   {
		   driver.findElement(By.xpath("//*[@text='Tests and medications']")).click(); 
		   driver.findElement(By.xpath("//*[@text='Prescription medications']")).click();
		   log.info("Prescription medications test Checking ");
		   driver.findElement(By.xpath("//*[@text='Call 112']"));
		   driver.findElement(By.xpath("//*[@text='If you have any of the following, please']"));  
		   driver.findElement(By.xpath("//*[@text='Next']")).click();
		   
		   driver.findElement(By.xpath("//*[@text='Which medication(s) do you need']")).click();
		   driver.findElement(By.xpath("//*[@id='message']"));
			driver.findElement(By.xpath("//*[@text='Next']")).click();
			driver.findElement(By.xpath("//*[@text='Next']")).click();
	  	 
	  	Thread.sleep(3000); 
	  driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
 	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	   }    
	   
	   
		  log.info("-----------------------------------------END TEST -Validate Urgent Appointments Questions and Answers--------------------------------------------------------------");
   
	   
	   
	   
   }
	        
   else if(Platform.equals("SIHATY")){
		  log.info("END TEST - Validate Urgent Appointments Questions and Answers");

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