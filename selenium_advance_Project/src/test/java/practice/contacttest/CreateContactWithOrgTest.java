package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrgTest {


		public static void main(String[] args) throws IOException {
			FileInputStream fis = new FileInputStream("E:\\ECLIPSE\\AUTOMATION IN SELENIUM\\selenium_advance_Project\\configAppData\\commonData.properties");
			Properties pObj = new Properties();
			pObj.load(fis);
			//Read the common data from property file
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			// generate the random number
			Random random = new Random();
			int randomInt = random.nextInt(10000);
			
			//Read testscript data from excel file 
			FileInputStream fis1 = new FileInputStream("E:\\ECLIPSE\\AUTOMATION IN SELENIUM\\selenium_advance_Project\\configAppData\\VtigerTestCases.xlsx");
			Workbook wb =  WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("contact");
			Row row = sh.getRow(7);
			String orgName = row.getCell(2).toString()+ randomInt;
			String contactLastName = row.getCell(3).getStringCellValue();
			wb.close();
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
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			//driver.findElement(By.id("phone")).sendKeys(phoneNumber);
			String shipadd="noida "+randomInt ;
			WebElement ship = driver.findElement(By.name("ship_street"));
			ship.sendKeys(shipadd);
			
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click() ;
			
			// VERIFY HEADER orgName is EXPECTED RESULT(capture the data)
			
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgName)) {
				System.out.println(orgName + "header verified is created==PASS");
			}else {
				System.out.println(orgName + "header verified is not created==FAIL");
			}
			
	       // Step 5: navigate to contact module
			
			driver.findElement(By.linkText("Contacts")).click();
			
			// step 6 : click on "create organization" button
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			 
			 //step 7 : enter all the details and create new organization
			driver.findElement(By.name("lastname")).sendKeys(contactLastName);
			driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
			// -------- Switch to Child Window --------
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();

			while(it.hasNext()) {
			    String windowID = it.next();
			    driver.switchTo().window(windowID);

			    String actUrl = driver.getCurrentUrl();
			    if(actUrl.contains("module=Accounts")) {
			        break;
			    }
			}
			

			
			// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			// switch to parent window
						Set<String> set1 = driver.getWindowHandles();
						Iterator<String> it1 = set1.iterator();

						while(it1.hasNext()) {
						    String windowID = it1.next();
						    driver.switchTo().window(windowID);

						    String actUrl = driver.getCurrentUrl();
						    if(actUrl.contains("Contacts&action")) {
						        break;
						    }
						}

		
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			// verify Header phone Number info Expected Result
			// Verify Header (Contact Name)
			String headerInfo1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

			if(headerInfo1.contains(contactLastName)) {
			    System.out.println(contactLastName + " header verified==PASS");
			} else {
			    System.out.println(contactLastName + " header is verified==FAIL");
			}

			// Verify Organization Name
			String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();

			if(actOrgName.trim().equals(orgName)) {
			    System.out.println(orgName + " information is created==PASS");
			} else {
			    System.out.println(orgName + " information is not created==FAIL");
			}

			// Close Browser
			driver.quit();
			
		}
			
			}