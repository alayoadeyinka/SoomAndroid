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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.utility;
import utils.log;
public class ChildPastUpcomingAppointments extends utility  {
	 private String reportDirectory = "reports";
	 
	  
	    
	    private static Workbook wb;
		  private static Sheet sh;
		  private static FileInputStream fis; 
		  private static FileOutputStream fos; 
		  private static Row row;
		  private static Cell cell;

	 
	    
	    @BeforeMethod
		public void beforeTest() throws IOException{
	 log.info("-----------------------------------------START TEST Child Past and Upcoming Appointment--------------------------------------------------------------");

			 
	    	initializes();
	    	
     
  }

  @SuppressWarnings("rawtypes")
@Test  
  public void testChildPastUpcomingAppts() throws InterruptedException , IOException{
 
	    
    
	  	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config/Testdata.xlsx");
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
			 XSSFSheet sheet = workbook.getSheet("My Health"); 
			  XSSFSheet sheets = workbook.getSheet("Platform");
			 Row alerg1 = sheet.getRow(1);
		   Cell cell = alerg1.getCell(1);
	     String alerg = cell.getStringCellValue();
	     
	     Row alerg2 = sheet.getRow(2);
		   Cell cell1 = alerg2.getCell(1);
	     String upalerg = cell1.getStringCellValue();  
	     
	     Row plaform = sheets.getRow(1);
		   Cell cell11 = plaform.getCell(1);
	   String Platform  = cell11.getStringCellValue();
	     
	     Row recre = sheet.getRow(3);
		   Cell cell2 = recre.getCell(1);
	     String recreation = cell2.getStringCellValue();  
	     
	     
 
	     
	  	     
	    
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    
	    
	    Thread.sleep(2000);
      
   // Verify user is not logged in and error message is displayed 
    		 
    		// Here we enter the user Wrong MOH PIN 
    	
     driver.findElement(By.xpath("//*[@text='My Health']")).click(); 
     Thread.sleep(2000);
	 log.info(" My Health Clicked");

     driver.findElement(By.xpath("//*[@id='iconMore']")).click();
     log.info("More Icon Selected");
     
     
     String ChildName =  driver.findElement(By.xpath("(//*[@id='list']/*/*[@id='title'])[2]")).getText();
     log.info("Child Name to be Selected is ");
     log.info(ChildName);
     
     String ChildDetails =  driver.findElement(By.xpath("(//*[@id='list']/*/*[@id='subTitle'])[2]")).getText();
     log.info("Child Age and Sex is ");
     log.info(ChildDetails);
     
     driver.findElement(By.xpath("(//*[@id='list']/*/*[@id='photo'])[2]")).click();
     log.info(" Child Profile Clicked ");
     
  
     
    	     
    	      Thread.sleep(2000);	      
    	      driver.findElement(By.xpath("//*[@text='Consultations']")).click();
    	      driver.findElement(By.xpath("//*[@id='logo']"));
    	      driver.findElement(By.xpath("//*[@text='Consultations']"));
    	  driver.findElement(By.xpath("//*[@text='Past']"));
    	  driver.findElement(By.xpath("//*[@text='Upcoming']"));
    	  
    
    		  driver.findElement(By.xpath("//*[@text='Upcoming']")).click();
    		  
    		   
    		  driver.findElement(By.xpath("//*[@text='Past']")).click();
    			 log.info("-----------------------------------------END TEST Child Past and Upcoming Appointment--------------------------------------------------------------");
	      
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