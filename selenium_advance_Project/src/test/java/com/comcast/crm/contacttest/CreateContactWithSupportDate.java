package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;


public class CreateContactWithSupportDate {

	public static void main(String[] args) throws Throwable {
		// create object for FILE_UTILITY , EXCEL_UTILITY.....NEWLY CHANGES DONE IN CODE
				FileUtility fLib = new FileUtility ();
				ExcelUtility eLib = new ExcelUtility ();
				
				JavaUtility jLib = new JavaUtility();
				
				
				
				//Read the common data from property file....NEWLY CHANGES DONE IN CODE
				String BROWSER = fLib.getDataFromPropertiesFile("browser");
				String URL = fLib.getDataFromPropertiesFile("url");
				String USERNAME = fLib.getDataFromPropertiesFile("username");
				String PASSWORD = fLib.getDataFromPropertiesFile("password");
				
				// generate the random number
				
				//Read testscript data from excel file ....NEWLY CHANGES DONE IN CODE
				String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
				
				
	
	WebDriver driver = null;
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	}else if(BROWSER.equals("fireforx")) {
			driver = new FirefoxDriver();
	}else if(BROWSER.equals("edge")) {
				driver = new EdgeDriver();
	}
	// step 1: login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	// step 2: navigate to CONTACT module
	driver.findElement(By.linkText("Contacts")).click();
	
	// step 3: click on "create organization" button
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	 
	 //step 4: enter all the details and create new organization
	String startDate = jLib.getRequiredDateYYYYDDMM(0);
	String endDate = jLib.getRequiredDateYYYYDDMM(30);

	driver.findElement(By.name("lastname")).sendKeys(lastName);
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	
	
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	// VERIFY START DATE: EXPECTED RESULT
	String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
	if(actStartDate.equals(startDate)) {
		System.out.println(startDate + "header verified is created==PASS");
	}else {
		System.out.println(startDate + "header verified is not created==FAIL");
	}
	// VERIFY END DATE: EXPECTED RESULT
		String actendDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if( actendDate.equals( endDate)) {
			System.out.println(endDate + "header verified is created==PASS");
		}else {
			System.out.println(endDate + "header verified is not created==FAIL");
		}
	
	
	//step 5: logout
	driver.quit();
	
	
	
	
	
	}
 
	
	
}
