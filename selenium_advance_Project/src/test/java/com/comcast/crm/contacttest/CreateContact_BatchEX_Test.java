package com.comcast.crm.contacttest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContact_BatchEX_Test extends BaseClass {

	@Test
	public void createContactTest() throws Throwable {

		// read testScript data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step 2: navigate to Contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		// step 3: click on "create Contact" Button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewConatctBtn().click();

		// step 4: enter all the details & create new Contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(lastName);

		// verify Header phone Number info Expected Result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " information is verified==PASS");
		} else {
			System.out.println(lastName + " information is not verified==FAIL");
		}
	}

	@Test
	public void createContactWithsupportDateTest() throws Throwable {
	    
	    // step 1: read testScript data
	    String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
	    
	    // step 2: navigate to Contact module
	    HomePage hp = new HomePage(driver);
	    hp.getContactlnk().click();
	    
	    // step 3: click on "create Contact" Button
	    ContactPage cp = new ContactPage(driver);
	    cp.getCreateNewConatctBtn().click(); 
	    
	    // step 4: prepare dates and enter details
	    String endDate = jLib.getSystemDateYYYYMMDD();
	    String startDate = jLib.getRequiredDateYYYYDDMM(30);
	    
	    CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
	    // This call will now work!
	    ccp.createContactWithSupportDate(lastName, startDate, endDate);
	    
	    // step 5: verify Header info
	    String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
	    if (actStartDate.trim().equals(startDate)) {
	        System.out.println(startDate + " information is verified == PASS");
	    } else {
	        System.out.println(startDate + " information is not verified == FAIL");
	    }
	    
	    String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
	    if (actEndDate.trim().equals(endDate)) {
	        System.out.println(endDate + " information is verified == PASS");
	    } else {
	        System.out.println(endDate + " information is not verified == FAIL");
	    }
	}
	

	@Test
	public void createContactWithOrgTest() throws Throwable {
		
	
	        // step 1: read testScript data from Excel file
	        String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
	        String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

	        // step 2: navigate to Organization module
	        HomePage hp = new HomePage(driver);
	        hp.getOrgLink().click();

	        // step 3: click on "create Organization" Button
	        OrganizationsPage op = new OrganizationsPage(driver);
	        op.getCreateNewOrgBtn().click();

	        // step 4: enter all the details & create new Organization
	        CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	        cnop.createOrg(orgName, contactLastName);

	        // verify Header orgName info Expected Result
	        String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	        if (actOrgName.trim().equals(orgName)) {
	            System.out.println(orgName + " information is created==PASS");
	        } else {
	            System.out.println(orgName + " information is not created==FAIL");
	        }

	        // step 5: navigate to Contact module
	        hp.getContactlnk().click();

	        // step 6: click on "create Contact" Button
	        ContactPage cp = new ContactPage(driver);
	        cp.getCreateNewConatctBtn().click();

	        // step 7: enter all the details & create new Contact with Organization
	        CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
	        // This method should handle clicking the '+' icon, switching windows, and selecting the org
	        ccp.createContactWithOrg(contactLastName, orgName);

	        // verify Header contact info Expected Result
	        String actHeaderName = driver.findElement(By.name("lastname")).getText();
	        if (actHeaderName.trim().equals(contactLastName)) {
	            System.out.println(contactLastName + " information is created==PASS");
	        } else {
	            System.out.println(contactLastName + " information is not created==FAIL");
	        }
	    }
	}
