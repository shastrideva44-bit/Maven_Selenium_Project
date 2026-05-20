package com.comcast.crm.orgtestWithPOM.copy;

import java.io.FileInputStream;
import java.time.Duration;
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


public class CreateOrganizationTest {

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
			   String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
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
	
	// step 2: navigate to organization module
	driver.findElement(By.linkText("Organizations")).click();
	
	// step 3: click on "create organization" button
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	 
	 //step 4: enter all the details and create new organization
	  driver.findElement(By.xpath("//input[@Name='accountname']")).sendKeys(orgName);
	  String billipadd = "noida34"+jLib.getRandomNumber();
	     String shipadd = "noida52"+ jLib.getRandomNumber();
	     driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(billipadd);
	     driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(shipadd);
	     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	// VERIFY HEADER MSG in EXPECTED RESULT
	String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerInfo.contains(orgName)) {
		System.out.println(orgName + "header verified is created==PASS");
	}else {
		System.out.println(orgName + "header verified is not created==FAIL");
	}
	// VERIFY HEADER OrgGNAME in EXPECTED RESULT(capture the data)
	
	String actOrgName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	if(actOrgName.equals(orgName)) {
		System.out.println(orgName + "info is created==PASS");
	}else {
		System.out.println(orgName + "info is not created==FAIL");
	}
	
	
	//step 5: logout
	driver.quit();
	
	
	
	
	}
 
	
	
}
