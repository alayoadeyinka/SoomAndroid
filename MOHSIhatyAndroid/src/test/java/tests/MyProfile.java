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

public class MyProfile extends utility {
	 private String reportDirectory = "reports";
	    	    
	  @BeforeMethod
	    public void setUp1() throws IOException {
		   log.info("-----------------------------------------START TEST - My Profile --------------------------------------------------------------");

		 
	    	initializes();
	    	
}

  @SuppressWarnings("rawtypes")
@Test  
  public void testMyProfile() throws InterruptedException , IOException{
	 
	 
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    
	    
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("My Profile"); 
		  XSSFSheet sheets = workbook.getSheet("Platform");
			 
			 Row plaform = sheets.getRow(1);
			   Cell cell11 = plaform.getCell(1);
		   String Platform  = cell11.getStringCellValue();

		 Row details = sheet.getRow(1);
	   Cell cell = details.getCell(1);
    String wrongemail = cell.getStringCellValue();
    
    Row details1 = sheet.getRow(2);
	   Cell cell1 = details1.getCell(1);
    String email = cell1.getStringCellValue();  
    
    Row details2 = sheet.getRow(3);
	   Cell cell2 = details2.getCell(1);
 String homeadd= cell2.getStringCellValue();  
    
 Row details3 = sheet.getRow(4);
 Cell cell3 = details3.getCell(1);
String officeadd= cell3.getStringCellValue();  

    
 
      
   // Verify user is not logged in and error message is displayed 
    		 
    		// Here we enter the user Wrong MOH PIN 
    		  
    	       

driver.findElement(By.xpath(objectrepo.getProperty("MyProfileButton"))).click();
    	      
    	      String name= driver.findElement(By.xpath("//*[@id='name_tv']")).getText()  ;   
    	      log.info("Patient Name is ");
    	      log.info(name);
    	      Thread.sleep(1000);
    	      
    	      String Age= driver.findElement(By.xpath("//*[@id='genderAge_tv']")).getText()  ;   
    	      log.info("Patient Age and Gender is ");
    	      log.info(Age);
    	      Thread.sleep(1000); 
    	      
    	        driver.findElement(By.xpath("//*[@id='avatar']"));   
    	      log.info("Patient Avater is displayed");
    	     
    	      driver.findElement(By.xpath("//*[@text='CONTACT DETAILS']"));         
    	      log.info("Contact details check started");
    	
    	      driver.findElement(By.xpath("//*[@text='Email']"));         
    	      log.info("Email text displayed ");
    	    
    	     driver.findElement(By.xpath("//*[@id='email']")).click();   
    	      log.info("Email textbox clicked ");
    	      Thread.sleep(1000); 
    	      driver.findElement(By.xpath("//*[@text='Email']"));         
    	      log.info("Email text displayed on the dialog ");
    	      
    	      driver.findElement(By.xpath("//*[@id='message']")).clear();
    	      driver.findElement(By.xpath("//*[@id='message']")).sendKeys(wrongemail);
    	      
    	      driver.findElement(By.xpath("//*[@text='Save']")).click();
    	       	      
    	      driver.findElement(By.xpath("//*[@text='Invalid email']"));
    	      log.info("Email validation successful ");
    	      
    	      
    	      driver.findElement(By.xpath("//*[@text='OK']")).click();  
    	      Thread.sleep(1000); 
    	    
    	      driver.findElement(By.xpath("//*[@id='message']")).clear();
    	      
driver.findElement(By.xpath("//*[@id='message']")).sendKeys(email);
    	      
    	      driver.findElement(By.xpath("//*[@text='Save']")).click();
    	      Thread.sleep(2000); 
    	      
        
    
    	      
    String savedemail= driver.findElement(By.xpath("//*[@id='email']")).getText()  ;
    	      
    try {
    	 if (savedemail.equals(email)){
 			
  		   log.info("Email was saved and confirmed ");		
  		}
    } catch (Exception e) {
    	 log.info("Email was not saved successfully  ");
    } 
    
    	      driver.findElement(By.xpath("//*[@text='SAVED ADDRESS']"));
    	      log.info("Saved Addresses Section");	
    	    
    	      driver.findElement(By.xpath("//*[@text='Home']"));
    	      log.info("Home Address Section");	
    	    
    	   //   String home= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='sub_title'])[1]")).getText()  ; 
    	      String home= driver.findElement(By.xpath("(//*[@id='rv']/*/*/*[@id='sub_title'])[1]")).getText()  ; 
    	      log.info("Home Address is ");
    	      log.info(home);
    	      Thread.sleep(1000);       
    	//      driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='sub_title'])[1]")).click();
    	      driver.findElement(By.xpath("(//*[@id='rv']/*/*/*[@id='sub_title'])[1]")).click();
    	      driver.findElement(By.xpath("//*[@text='Home address']"));
    	      log.info("Home Address Dialog Opens");	
    	      
    	      driver.findElement(By.xpath("//*[@id='message']")).clear();
    	      
    	      driver.findElement(By.xpath("//*[@id='message']")).sendKeys(homeadd);
    	      
    	      driver.findElement(By.xpath("//*[@text='Save']")).click();
    	      Thread.sleep(2000); 
    	      
    	      String savedhome= driver.findElement(By.xpath("(//*[@id='rv']/*/*/*[@id='sub_title'])[1]")).getText()  ;
    	      
    	      try {
    	      	 if (savedhome.equals(homeadd)){
    	   			
    	    		   log.info("Home Address was saved and confirmed ");		
    	    		}
    	      } catch (Exception e) {
    	      	 log.info("Home Adddress was not saved successfully  ");
    	      } 
    	      
    	       
    	      driver.findElement(By.xpath("//*[@text='Office']"));
    	      log.info("Office Address Section");	
    	      
    	    //  String office= driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='sub_title'])[2]")).getText()  ; 
    	      String office= driver.findElement(By.xpath("(//*[@id='rv']/*/*/*[@id='sub_title'])[2]")).getText()  ; 
    	      log.info("Office Address is ");
    	      log.info(office);
    	      Thread.sleep(1000);       
    	//      driver.findElement(By.xpath("(//*[@id='rv']/*/*[@id='sub_title'])[2]")).click();
    	      driver.findElement(By.xpath("(//*[@id='rv']/*/*/*[@id='sub_title'])[2]")).click();
    	      driver.findElement(By.xpath("//*[@text='Office address']"));
    	      log.info("Office Address Dialog Opens");	
    	      
    	      driver.findElement(By.xpath("//*[@id='message']")).clear();
    	      
    	      driver.findElement(By.xpath("//*[@id='message']")).sendKeys(officeadd);
    	      
    	      driver.findElement(By.xpath("//*[@text='Save']")).click();
    	      Thread.sleep(2000); 
    	      
    	      
     String savedoffice= driver.findElement(By.xpath("(//*[@id='rv']/*/*/*[@id='sub_title'])[2]")).getText()  ;
    	      
    	      try {
    	      	 if (savedoffice.equals(officeadd)){
    	   			
    	    		   log.info("Office Address was saved and confirmed ");		
    	    		}
    	      } catch (Exception e) {
    	      	 log.info("Office Adddress was not saved successfully  ");
    	      } 
    	      
    	    
    	      
    	      JavascriptExecutor js = (JavascriptExecutor) driver;
    	      HashMap<String, String> scrollObject = new HashMap<String, String>();
    	      scrollObject.put("direction", "down");
    	      js.executeScript("mobile: scroll", scrollObject);
    	      log.info("Scolled down ");
    	      Thread.sleep(1000);
    	      
    	//      driver.findElement(By.xpath("//*[@text='AUTHENTICATION']"));
    	 //     driver.findElement(By.xpath("//*[@text='Biometrics']"));
    	//      log.info("Biometrics section");
    	      
    	      
    	      driver.findElement(By.xpath("//*[@text='OTHER']"));
    	      driver.findElement(By.xpath("//*[@text='Language']"));  
    	      log.info("Language Section");
    	      
    	      String language= driver.findElement(By.xpath("//*[@id='value']")).getText()  ;   
    	      log.info("language is ");
    	      log.info(language);
    	             
    	      driver.findElement(By.xpath("//*[@text='Language']")).click();
    	      driver.findElement(By.xpath("//*[@text='Language']"));  
    	      driver.findElement(By.xpath("//*[@text='English']")); 
    	      driver.findElement(By.xpath("//*[@text='اللغة العربية']")); 
    	      driver.findElement(By.xpath("//*[@text='Save']")); 
    	      driver.findElement(By.xpath("//*[@text='Cancel']")); 
    	      
    	      driver.findElement(By.xpath("//*[@text='English']")).click();
    	      driver.findElement(By.xpath("//*[@text='Save']")); 
    	      Thread.sleep(2000);
    	      log.info("language changed to English ");
    	      driver.findElement(By.xpath("//*[@text='Language']")).click();
    	      driver.findElement(By.xpath("//*[@text='اللغة العربية']")).click();
    	      driver.findElement(By.xpath("//*[@text='Cancel']")).click();
    	      log.info("language change cancelled ");
    	      driver.findElement(By.xpath("//*[@text='English']"));
    	      log.info("language is still English ");
    	//      driver.findElement(By.xpath("//*[@text='Language']")).click();
    	//      driver.findElement(By.xpath("//*[@text='اللغة العربية']")).click();
    	//      driver.findElement(By.xpath("//*[@text='Save']")).click(); 
    	      Thread.sleep(2000);
    	      
    	 //     log.info("language changed to Arabic ");
    //	      driver.findElement(By.xpath("//*[@text='اللغة العربية']"));
    //	      driver.findElement(By.xpath("//*[@text='لغة']"));
    	      
    	  //    driver.findElement(By.xpath("//*[@text='المساعدة و الدعم']"));
    	  //    driver.findElement(By.xpath("//*[@text='الأسئلة الشائعة']"));
    	  //    driver.findElement(By.xpath("//*[@text='حذف حسابك']"));
    	  //    log.info("Arabic texts found ");
    	      
    	      
    	 //     driver.findElement(By.xpath("//*[@text='لغة']")).click();
    	    
    	//      driver.findElement(By.xpath("//*[@text='English']")).click();
    	 //     driver.findElement(By.xpath("//*[@text='حفظ']"));
    	 //     driver.findElement(By.xpath("//*[@text='إلغاء']")).click();
    	 //     log.info("Arabic language change cancelled  ");
    	 //     driver.findElement(By.xpath("//*[@text='اللغة العربية']"));
    	  //    log.info("Language is still arabic  ");
    	      
    	   //   driver.findElement(By.xpath("//*[@text='اللغة العربية']")).click();
    	   //   Thread.sleep(1000);
    	      
    	  //    driver.findElement(By.xpath("//*[@text='English']")).click();
    	  //    driver.findElement(By.xpath("//*[@text='حفظ']")).click(); 
    	  //    log.info("Language changed to english   ");
    	      
    	   
    	    
    	//      driver.findElement(By.xpath("//*[@text='Help and Support']"));
    	      driver.findElement(By.xpath("//*[@text='Help and Support']"));
    	      log.info(" Customer support checked  ");
    	      driver.findElement(By.xpath("//*[@text='FAQs']"));
    	      
    	      if (Platform.equals("SIHATY")){
    	      
    	      
    	      log.info(" FAQs available ");
    	      driver.findElement(By.xpath("//*[@text='FAQs']")).click();
    	      log.info(" FAQs Clicked  ");
    	      Thread.sleep(2000);
    	      driver.findElement(By.xpath("//*[@text='What is a teleconsultation?']"));
    	       
    	      driver.findElement(By.xpath("//*[@text='How secure is the Sihaty platform?']")).click();
    	      
    	      
    	      JavascriptExecutor js1 = (JavascriptExecutor) driver;
    	      HashMap<String, String> scrollObject1 = new HashMap<String, String>();
    	      scrollObject1.put("direction", "down");
    	      js1.executeScript("mobile: scroll", scrollObject1);
    	      log.info("Scolled down ");
    	      Thread.sleep(1000);
    	      
    	      driver.findElement(By.xpath("//*[@text='Are all health conditions treated on Sihaty?']"));
    	      driver.findElement(By.xpath("//*[@text='What services does the Sihaty platform offer?']")).click(); 	      
    	      driver.findElement(By.xpath("//*[@text='Can Sihaty be used by the whole family?']")).click(); 	    
    	      driver.findElement(By.xpath("//*[@text='How does Sihaty manage prescriptions, sick leaves and tests?']")).click(); 
    	      Thread.sleep(1000);
    	      driver.findElement(By.xpath("//*[@text='Close']")).click();
    	      } 
    	      
    	      
    	      else if(Platform.equals("EYADA")){
    	      
    	    	  log.info(" FAQs available ");
        	      driver.findElement(By.xpath("//*[@text='FAQs']")).click();
        	      log.info(" FAQs Clicked  ");
        	      Thread.sleep(2000);
        	      driver.findElement(By.xpath("//*[@text='What is a teleconsultation?']"));
        	       
        	      driver.findElement(By.xpath("//*[@text='How secure is the Eyada platform?']")).click();
        	      
        	      
        	      JavascriptExecutor js1 = (JavascriptExecutor) driver;
        	      HashMap<String, String> scrollObject1 = new HashMap<String, String>();
        	      scrollObject1.put("direction", "down");
        	      js1.executeScript("mobile: scroll", scrollObject1);
        	      log.info("Scolled down ");
        	      Thread.sleep(1000);
        	      
        	      driver.findElement(By.xpath("//*[@text='Are all health conditions treated on Eyada?']"));
        	      driver.findElement(By.xpath("//*[@text='What services does the Eyada platform offer?']")).click(); 	      
        	      driver.findElement(By.xpath("//*[@text='Can Eyada be used by the whole family?']")).click(); 	    
        	      driver.findElement(By.xpath("//*[@text='How does Eyada manage prescriptions, sick leaves and tests?']")).click(); 
        	      Thread.sleep(1000);
        	      driver.findElement(By.xpath("//*[@text='Close']")).click();

    	      
    	      }
    	      
    	      
    	      driver.findElement(By.xpath("//*[@text='Help and Support']"));

    	      
    	          	      log.info(" FAQ Closed   ");
    	      
    	      driver.findElement(By.xpath("//*[@text='Terms of service']"));
    	      driver.findElement(By.xpath("//*[@text='Privacy policy']"));
    	      driver.findElement(By.xpath("//*[@text='Consent for telehealth']"));
    	      log.info("Terms , Private policy and Consent Avilable  ");
    	      driver.findElement(By.xpath("//*[@text='Terms of service']")).click();
    	      driver.findElement(By.xpath("//*[@text='Terms and Conditions']")); 
    	      log.info(" Terms and conditions page opened   ");
    	      driver.findElement(By.xpath("//*[@text='About Us']")); 
    	      log.info(" Some text verified on about us page    ");
    	      
    	      
    	      driver.findElement(By.xpath("//*[@text='Close']")).click();
    	      
    	      driver.findElement(By.xpath("//*[@text='Terms of service']"));
    	      log.info(" Terms and conditions Closed   ");
    	      driver.findElement(By.xpath("//*[@text='Privacy policy']")).click();
    	      driver.findElement(By.xpath("//*[@text='Privacy Policy']")); 
    	      driver.findElement(By.xpath("//*[@text='Collection and Use of Personal Information']")); 
    	      log.info(" Privacy policy page opened   ");
    	    
driver.findElement(By.xpath("//*[@text='Close']")).click();
    	      
    	      driver.findElement(By.xpath("//*[@text='Terms of service']"));
    	      log.info(" Privacy policy Closed   ");
    	      
    	      driver.findElement(By.xpath("//*[@text='Consent for telehealth']")).click();
    	      
    	      driver.findElement(By.xpath("//*[@text='Consent to Telehealth']")); 
    	      
    	      driver.findElement(By.xpath("//*[@text='Telehealth Providers']")); 
    	      log.info("Consent for telehealth page opened   ");
    	      driver.findElement(By.xpath("//*[@text='Close']")).click();
    	      
    	      driver.findElement(By.xpath("//*[@text='Terms of service']"));
    	      log.info(" Consent for telehealth Closed   ");
    	      
    	      JavascriptExecutor js2 = (JavascriptExecutor) driver;
    	      HashMap<String, String> scrollObject2 = new HashMap<String, String>();
    	      scrollObject2.put("direction", "down");
    	      js2.executeScript("mobile: scroll", scrollObject2);
    	      log.info("Scolled down ");
    	      Thread.sleep(1000); 
    	      
    	    
    	      
    	      String version= driver.findElement(By.xpath("//*[@id='app_version']")).getText()  ;   
    	      log.info("App Version is ");
    	      log.info(version);
    	      Thread.sleep(1000);

    	      driver.findElement(By.xpath("//*[@text='Delete your account']"));
    	      log.info(" Delete Account available     ");
    	      
    	      driver.findElement(By.xpath("//*[@text='Delete your account']")).click();
    	      log.info(" Delete Account clicked  ");
    	      
    	      driver.findElement(By.xpath("//*[@text='No']"));
    	      driver.findElement(By.xpath("//*[@text='Yes']"));
    	      log.info(" Delete Account Dialog Opened  ");
    	      driver.findElement(By.xpath("//*[@text='No']")).click();
    	      
    	      
    	      driver.findElement(By.xpath("//*[@text='Delete your account']"));
    	      log.info(" Delete Account available     ");
   		   log.info("-----------------------------------------END TEST - My Profile --------------------------------------------------------------");


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