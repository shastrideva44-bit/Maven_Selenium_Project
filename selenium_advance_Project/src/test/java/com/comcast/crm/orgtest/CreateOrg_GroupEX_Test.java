package com.comcast.crm.orgtest;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerUtility.ListionerImpClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

	@Listeners(com.comcast.crm.listenerUtility.ListionerImpClass1.class)
public class CreateOrg_GroupEX_Test extends BaseClass {
	public static ExtentTest test;
	    @Test(groups = "SMOKE TEST")
	    public void createOrgTest() throws Throwable {

	    	UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
	        // read testScript data from Excel file
	        String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
	        String industry = eLib.getDataFromExcel("org", 4, 3);
	        
	        // step 2: navigate to Organization module
	        UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
	        HomePage hp = new HomePage(driver);
	        hp.getOrgLink().click();

	        // step 3: click on "create Organization" Button
	        UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
	        OrganizationsPage op = new OrganizationsPage(driver);
	        op.getCreateNewOrgBtn().click();

	        // step 4: create new Organization
	        UtilityClassObject.getTest().log(Status.INFO,"create a new org");
	        CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	        String shipAdd = null;
			
			cnop.createOrg(orgName, shipAdd, industry);
			UtilityClassObject.getTest().log(Status.INFO,orgName + "navigate to create org page");

	        // verify Header msg
	        OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	        String actOrgName = oip.getHeaderMsg().getText();

	        if (actOrgName.contains(orgName)) {
	            System.out.println(orgName + " name is verified == PASS");
	        } else {
	            System.out.println(orgName + " name is not verified == FAIL");
	        }
	    }

	    @Test(groups = "REGRESSION TEST")
	    public void createOrgWithPhoneNumberTest() throws Throwable {

	        // read data
	        String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
	        String phoneNumber = eLib.getDataFromExcel("org", 7, 3);

	        // navigate to org module
	        HomePage hp = new HomePage(driver);
	        hp.getOrgLink().click();

	        // click create org
	        OrganizationsPage cnp = new OrganizationsPage(driver);
	        cnp.getCreateNewOrgBtn().click();

	        // create org with phone number
	        CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	        cnop.createOrgPhoneNumber(orgName, phoneNumber);

	        // verify phone number
	        String actPhone = driver.findElement(By.id("dtlview_Phone")).getText();

	        if (actPhone.equals(phoneNumber)) {
	            System.out.println(phoneNumber + " information is verified == PASS");
	        } else {
	            System.out.println(phoneNumber + " information is not verified == FAIL");
	        }
	    }

	    @Test (groups = "REGRESSION TEST")
	    public void createOrgWithIndustriesTest() throws Throwable {

	        // read data
	        String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
	        String industry = eLib.getDataFromExcel("org", 4, 3);
	        String type = eLib.getDataFromExcel("org", 4, 4);

	        // navigate to org module
	        HomePage hp = new HomePage(driver);
	        hp.getOrgLink().click();

	        // click create org
	              OrganizationsPage op = new OrganizationsPage(driver);
	        op.getCreateNewOrgBtn().click();

	        // create org with industry & type
	        CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	        cnop.createOrgWithIndustry(orgName, industry, type);

	        // verification (optional)
	        System.out.println(orgName + " created with Industry: " + industry + " and Type: " + type);
	    }  }
	